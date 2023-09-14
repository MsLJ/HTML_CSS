package com.ms.web2.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.ms.web2.sns.SnsDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ms.ljh.db.manager.MsDBManager;

public class MemberDAO {
	private static final MemberDAO MDAO = new MemberDAO();
	private int MsgCount;

	public MemberDAO() {
		// TODO Auto-generated constructor stub
	}

	public static MemberDAO getMdao() {

		return MDAO;
	}

	public boolean isLogined(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("loginpage", "member/logined.jsp");
			return true;
			// 로그인 됐

		} else {
			request.setAttribute("loginpage", "member/login.jsp");
			return false;
		}
	}

	public int getMemberMsgCount(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			con=MsDBManager.connect("msPool");
			String sql="select count(*) from sns where sns_writer = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(MsgCount, sql);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void deleteMember(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			int msgCount=SnsDAO.getSdo().getMemberMsgCount(id);
			
			System.out.println(id);
			String sql = "delete from web2_member where webm_id= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "삭제 성공");
				String path = request.getSession().getServletContext().getRealPath("joindata");
				String photo = URLDecoder.decode(m.getPhoto(), "euc-kr");
				new File(path + "/" + photo).delete();
				System.out.println(path);
				SnsDAO.getSdo().setAllsnsCount(msgCount);

			} else {

				request.setAttribute("result", "삭제 실패(DB)");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "삭제 실패(DB)");

		}
		MsDBManager.close(con, pstmt, null);

	}

	public void snsWrite(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			String txt = request.getParameter("txt");
			String sql = "insert into sns values(sns_seq.nextval,?,sysdate,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, txt);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void login(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			request.setCharacterEncoding("euc-kr");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			System.out.println(id);
			System.out.println(pw);

			String sql = "select*from WEB2_MEMBER where webm_id=?";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbpw = rs.getString("webm_pw");
				if (pw.equals(dbpw)) {
					Member m = new Member(id, pw, rs.getString("webm_name"), rs.getInt("webm_age"),
							rs.getString("webm_adr"), rs.getDate("webm_birthday"), rs.getString("webm_photo"));

					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(10 * 6 * 30);

					request.setAttribute("result", "로그인성공");
				} else {
					request.setAttribute("result", "로그인 실패(pw불일치)");

				}
			} else {

				request.setAttribute("result", "로그인 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "로그인실패(DB)");

		}
		MsDBManager.close(con, pstmt, rs);

	}

	public void logout(HttpServletRequest request) {
		// 세션 끊기
		// 로그인 정보말고 세션에 넣어놓은 다른것들도 다 날아갈테니
		request.getSession().setAttribute("loginMember", null);
//		request.getSession().setMaxInactiveInterval(-1);

	}

	public void updateMemberInfo(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("joindata");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy()

			);

		} catch (Exception e) {
			request.setAttribute("result", "파일 업로드 실패(갱신)");
			e.printStackTrace();
			return;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		String oldImg = null;
		String newImg = null;
		// 프사 수정x
		// 프사 수정 새로운걸로 바꾸기
		try {
			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			oldImg = m.getPhoto();
			newImg = mr.getFilesystemName("img");
			if (newImg == null) {
				newImg = oldImg;

			} else {
				newImg = URLEncoder.encode(newImg, "euc-kr");
				newImg = newImg.replace("+", " ");
			}
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			int age = Integer.parseInt(mr.getParameter("age"));
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String addr123 = addr1 + "#" + addr2 + "#" + addr3;
//			String addr1234[]=addr123.split("#");
			String sql = "update web2_member " + "set webm_pw = ?, webm_name = ?, webm_adr = ?, webm_photo=? "
					+ "where webm_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, addr123);
			pstmt.setString(4, newImg);
			pstmt.setString(5, id);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
				if (!oldImg.equals(newImg)) {
					oldImg = URLDecoder.decode(oldImg, "euc-kr");
					new File(path + "/" + oldImg).delete();

				}
				// 수정된 내용들을 세션을 불러와서 수정된 값들을 새로set해주고
				// 다시 session을 불러 값들을 set해준다
				m.setPw(pw);
				m.setPhoto(newImg);
				m.setName(name);
				m.setAdr(addr123);
				request.getSession().setAttribute("loginMember", m);

			} else {
				request.setAttribute("result", "수정실패");
				if (!oldImg.equals(newImg)) {
					newImg = URLDecoder.decode(newImg, "euc-kr");
					new File(path + "/" + newImg).delete();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			if (!oldImg.equals(newImg)) {
				try {
					newImg = URLDecoder.decode(newImg, "euc-kr");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newImg).delete();

			}
		}
		MsDBManager.close(con, pstmt, null);

	}

	public void join(HttpServletRequest request) {
		MultipartRequest mr = null;
		String path = request.getSession().getServletContext().getRealPath("joindata");
		System.out.println(path);
		try {
			mr = new MultipartRequest(request, path, 10 * 1024 * 1024, "euc-kr", new DefaultFileRenamePolicy()

			);

		} catch (Exception e) {

			request.setAttribute("result", "파일업로드실패");
			return;
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			int age = Integer.parseInt(mr.getParameter("age"));
			String addr1 = mr.getParameter("addr1");
			String addr2 = mr.getParameter("addr2");
			String addr3 = mr.getParameter("addr3");
			String y = mr.getParameter("y");
			String m = mr.getParameter("m");
			String d = mr.getParameter("d");
			int yy = Integer.parseInt(y);
			int mm = Integer.parseInt(m);
			int dd = Integer.parseInt(d);
			String ymd = String.format("%04d%02d%02d", yy, mm, dd);
			String addr123 = addr1 + "#" + addr2 + "#" + addr3;
//			String addr1234[]=addr123.split("#");
			String img = mr.getFilesystemName("img");
			img = URLEncoder.encode(img, "euc-kr");
			img = img.replace("+", " ");
//			System.out.println(id);
//			System.out.println(pw);
//			System.out.println(name);
//			System.out.println(age);
//			System.out.println(addr1);
//			System.out.println(addr2);
//			System.out.println(addr3);
//			System.out.println(y);
//			System.out.println(m);
//			System.out.println(d);
//			System.out.println(img);
//			System.out.println(ymd);
//			System.out.println(addr123);
//			System.out.println(addr1234[0]);
//			System.out.println(addr1234[1]);
//			System.out.println(addr1234[2]);
			String sql = "insert into web2_member values(?, ?, ?, ?, ?, to_date(?,'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setInt(4, age);
			pstmt.setString(5, addr123);
			pstmt.setString(6, ymd);
			pstmt.setString(7, img);
//			int a = 10 / 0; 제대로 작동돼는지 확인차 일부러 에러발생시켜서 실패시켜봄

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "가입성공");

			}

		} catch (Exception e) {
			request.setAttribute("result", "가입 실패");
			new File(path + "/" + mr.getFilesystemName("img")).delete();

			// 파일은 올라가있음
		}
		MsDBManager.close(con, pstmt, null);

	}

	public void splitAddr(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String addr = m.getAdr();
		String[] addrr = addr.split("#");
		request.setAttribute("addr1", addrr[0]);
		request.setAttribute("addr2", addrr[1]);
		request.setAttribute("addr3", addrr[2]);

	}

}
