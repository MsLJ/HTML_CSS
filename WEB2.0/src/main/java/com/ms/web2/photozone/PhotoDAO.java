package com.ms.web2.photozone;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.management.MBeanServerDelegateMBean;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.File;

import com.ms.web2.member.Member;
import com.ms.web2.member.MemberDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ms.ljh.db.manager.MsDBManager;
import oracle.jdbc.proxy.annotation.Pre;

public class PhotoDAO {
	private int allPhotoCount;
	private int photoPerPage;

	public PhotoDAO() {
		photoPerPage = 10;
		// TODO Auto-generated constructor stub
	}

	public void setAllPhotoCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select count(*) from photozone";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allPhotoCount = rs.getInt("count(*)");
			System.out.println("전체:" + allPhotoCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		MsDBManager.close(con, pstmt, rs);
	}

	public static final PhotoDAO PHOTODAO = new PhotoDAO();

	public static PhotoDAO getPhotodao() {
		return PHOTODAO;
	}

	public void deletePhotoZone(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			String sql = "delete from photozone where pz_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "댓글삭제");
			} else {
				request.setAttribute("result", "댓글삭제실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "댓글삭제실패");

			e.printStackTrace();
		}
		MsDBManager.close(con, pstmt, null);
	}

	public void getPhotoZone(int page, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			int pageCount = (int) Math.ceil(allPhotoCount / (double) photoPerPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("page", page);
			int Start = (page - 1) * photoPerPage + 1;
			int end = photoPerPage * page;
			String sql = "SELECT * " + "FROM ( " + "SELECT rownum AS rn, pz_no, pz_writer, pz_photo, pz_date "
					+ "FROM ( " + "SELECT * " + "FROM photozone " + "ORDER BY pz_date DESC " + ") " + ") "
					+ "WHERE rn >= ? AND rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			ArrayList<PhotoZone> ptz = new ArrayList<>();
			while (rs.next()) {
				ptz.add(new PhotoZone(rs.getInt("pz_no"), rs.getString("pz_writer"), rs.getString("pz_photo"),
						rs.getDate("pz_date")));

			}

			request.setAttribute("ptz", ptz);

		} catch (Exception e) {
			e.printStackTrace();
		}

		MsDBManager.close(con, pstmt, rs);

	}

//	public void insertLike(HttpServletRequest request) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = MsDBManager.connect("msPool");
//			int no = Integer.parseInt(request.getSession().getAttribute("no"));
//
//			String sql = "insert into PHOTOZONE_like values(seq.naextval,?,?)";
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			// TODO: handle exception
//		}
//
//	}

	public void insertPhoto(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("photozone");
		System.out.println(path);

		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy());

		} catch (Exception e) {
			request.setAttribute("result", "photo insert 실패");
			return;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = mr.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "사진 올리기 실패(새로고침)");
				return;
			}
			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			System.out.println(id);
			String photo = mr.getFilesystemName("photo");
			System.out.println(photo);
			photo = URLEncoder.encode(photo, "euc-kr");
			photo = photo.replace("+", " ");
			String sql = "insert into photozone values(photozone_seq.nextval, ?, ?, sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, photo);

			if (pstmt.executeUpdate() == 1) {

				request.setAttribute("result", "사진 올리기 성공");
				allPhotoCount++;
				request.getSession().setAttribute("lastToken", token);

			}
		} catch (Exception e) {
			request.setAttribute("reusult", "사진 올리기 실패");

			e.printStackTrace();
		}

		MsDBManager.close(con, pstmt, null);

	}

}
