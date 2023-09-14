package com.ms.may261.dataroom;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ms.ljh.db.manager.MsDBManager;

public class DataDao {

	private int allFilecount;
	private int fileperpage;

	public DataDao() {
		fileperpage = 10;
	}

	private static final DataDao DTO = new DataDao();

	public static DataDao getDto() {
		return DTO;
	}

	public void setAllFileCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select count(*)from may30_dataroom";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allFilecount = rs.getInt("count(*)");
			System.out.println(allFilecount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		MsDBManager.close(con, pstmt, rs);
	}

	public String getFileName(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select d_file from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			rs.next();
			return URLDecoder.decode(rs.getString("d_file"), "euc-kr");
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		} finally {

			MsDBManager.close(con, pstmt, rs);
		}
	}

	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			String fileName = getFileName(no);
			String sql = "delete from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제성공");
				allFilecount--;
				String folder = request.getSession().getServletContext().getRealPath("file");
				File f = new File(folder + "/" + fileName);
				f.delete();

			} else {
				request.setAttribute("result", "삭ㅈ실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		MsDBManager.close(con, pstmt, null);

	}

	public boolean getdetail(int no,HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select * from may30_dataroom where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Datas f = new Datas(rs.getInt("d_no"), rs.getString("d_title"), rs.getString("d_file"),
						rs.getDate("d_date"));
				request.setAttribute("f", f);
				return true;

			}

			else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		} finally {
			MsDBManager.close(con, pstmt, rs);
		}
	}

	// 파일 용량문제로 업로드 실패
	// DB서버문제로 실패
	public void get(int page, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
//		d_no number(3)primary key,
//		d_title varchar2(100 char)not null,
//		d_file varchar2(200 char)not null,
//		d_date date not null
		try {
			con = MsDBManager.connect("msPool");
			int pageCount = (int) Math.ceil(allFilecount / (double) fileperpage);
			request.setAttribute("pageCount", pageCount);
			int start = (page - 1) * fileperpage + 1;
			int end = fileperpage * page;

			String sql = "select*from( " + "select rownum as rn, d_no, d_title, d_date " + "from( "
					+ "select d_no, d_title, d_date " + "from may30_dataroom " + "order by d_date desc " + ") " + ") "
					+ "where rn>=? and rn<=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<Datas> files = new ArrayList<>();

			while (rs.next()) {
				files.add(new Datas(rs.getInt("d_no"), rs.getString("d_title"), null, rs.getDate("d_date")

				));

			}
			request.setAttribute("files", files);

		} catch (Exception e) {
			e.printStackTrace();
		}
		MsDBManager.close(con, pstmt, rs);
	}

	// 파일 수정하는 사람:새 파일이 용량이 커
	// 파일 수정 안하는 사람

	public boolean update(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("file");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, // 허용해줄 파일 최대 크기(넘어가면 Exception)
					"euc-kr", // 요청파라메터 한글처리
					new DefaultFileRenamePolicy()// 업로드한 파일명 중복되면 그냥 숫자 붙여서

			);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정실패(파일)");
			return false;
		}
		// 파일 수정 하는 사람(파일 업로드 끝난상태)
		// 파일 수정 안하는사람
		Connection con = null;
		PreparedStatement pstmt = null;
		String oldFile = null;
		String newFile = null;
		try {
			con = MsDBManager.connect("msPool");
			String title = mr.getParameter("title");
			int no = Integer.parseInt(mr.getParameter("no"));
			oldFile = URLEncoder.encode(getFileName(no), "euc-kr").replace("+", " ");
			newFile = mr.getFilesystemName("file");

			if (newFile == null) {
				newFile = oldFile;
			} else {
				newFile = URLEncoder.encode(mr.getFilesystemName("file"), "euc-kr").replace("+", " ");

			}
			System.out.println(no);
			System.out.println(title);
			System.out.println(newFile);
			System.out.println(oldFile);

			String sql = "update may30_dataroom set d_title=? ,d_file=? where d_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, newFile);
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "euc-kr");
					new File(path + "/" + oldFile).delete();

				}
				return true;
				getdetail(no, request);
				// 파일 바꾸는 사람: 옛날 파일 지워야
			} else {
				request.setAttribute("result", "수정실패");
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "euc-kr");
					new File(path + "/" + newFile).delete();

				}
				// 새파일 지우기
			}
			return false;

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "euc-kr");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();

			}
			return false;
		} finally {
			MsDBManager.close(con, pstmt, null);
		}
	}

	public void getData(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("file");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, // 허용해줄 파일 최대 크기(넘어가면 Exception)
					"euc-kr", // 요청파라메터 한글처리
					new DefaultFileRenamePolicy()// 업로드한 파일명 중복되면 그냥 숫자 붙여서

			);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "업로드 실패");
			return;
		}
		// db작업
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			String title = mr.getParameter("title");
			String file = URLEncoder.encode(mr.getFilesystemName("file"), "euc-kr");
			file = file.replace("+", " ");
			String sql = "insert into may30_dataroom values(may30_dataroom_seq.nextval,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, file);
			if (pstmt.executeUpdate() == 1) {
				// 이미 파일이 업로드 되어있음->파일지우기
				File f = new File(path + "/" + mr.getFilesystemName("file"));

				allFilecount++;
				request.setAttribute("result", "업로드 성공");

			}

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("result", "업로드 실패(db)");
		}
		MsDBManager.close(con, pstmt, null);
	}

}
