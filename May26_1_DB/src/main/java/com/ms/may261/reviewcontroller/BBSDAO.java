package com.ms.may261.reviewcontroller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import ms.ljh.db.manager.MsDBManager;

//지금:static 
public class BBSDAO {

	private int allMsgCount;
	private int msgPerPage;

	private static final BBSDAO BDAO = new BBSDAO();

	public BBSDAO() {
		msgPerPage = 10;
	}

	public static BBSDAO getBdao() {
		return BDAO;

	}

	public void setAllMsgCount() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select count(*) from may26_bbs";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allMsgCount = rs.getInt("count(*)");
			System.out.println("전체:" + allMsgCount);
		} catch (Exception e) {
		}
		MsDBManager.close(con, pstmt, rs);
	}

	public void get(int page, HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");

			int pageCount = (int) Math.ceil(allMsgCount / (double) msgPerPage);
			request.setAttribute("pageCount", pageCount);

			int start = (page - 1) * msgPerPage + 1;
			int end = msgPerPage * page;

			String sql = "select * " + "from ( " + "	select rownum as rn, b_no, b_title, b_date " + "	from ( "
					+ "		select b_no, b_title, b_date  " + "		from may26_bbs " + "		order by b_date desc "
					+ "	) " + ") " + "where rn >= ? and rn <= ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<BBSMsg> msgs = new ArrayList<>();
			BBSMsg bm = null;
			while (rs.next()) {
				bm = new BBSMsg();
				bm.setNo(rs.getInt("b_no"));
				bm.setTitle(rs.getString("b_title"));
				// bm.setTxt(rs.getString("b_txt"));
				bm.setDate(rs.getDate("b_date"));
				msgs.add(bm);
			}

			request.setAttribute("msgs", msgs);// EL+JSTL

		} catch (Exception e) {
		}
		MsDBManager.close(con, pstmt, rs);
	}

	public void delete(HttpServletRequest request) {
		// 사용완료후 닫기위해 겍체를 위에생성
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			request.setCharacterEncoding("euc-kr");

			String sql = "delete from may26_bbs where b_no=?";

			// 총괄 매니저객체
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);

			// ?채우기
			// 실행
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "글삭제 성공");
				allMsgCount--;

			} else {
				request.setAttribute("result", "글삭제 실패");
			}
		} catch (Exception e) {
			request.setAttribute("result", "글삭제 실패");
		}
		MsDBManager.close(con, pstmt, null);

	}

	public boolean modify(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			request.setCharacterEncoding("euc-kr");
			int no = Integer.parseInt(request.getParameter("modifyN"));
			String title = request.getParameter("modifyT");
			String txt = request.getParameter("modifyTX");
			String sql = "update may26_bbs " + "set b_title = ?, b_txt = ? " + "where b_no =?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			pstmt.setInt(3, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "수정 성공");
				return true;

			} else {
				request.setAttribute("result", "수정 실패");
				return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "수정 실패");
			
			return false;
			
		}
		finally {
			MsDBManager.close(con, pstmt, null);
			
		}

	}

	public boolean getDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(no);

			String sql = "select * from may26_bbs where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				BBSMsg bm = new BBSMsg();
				bm.setNo(rs.getInt("b_no"));
				bm.setTitle(rs.getString("b_title"));
				bm.setTxt(rs.getString("b_txt"));
				bm.setDate(rs.getDate("b_date"));
				request.setAttribute("bm", bm);

				return true;
			} else {
				System.out.println("없음");
				return false;
			}

		} catch (Exception e) {
			return false;
		} finally {
			// finally 를 넣어 앞에 리턴값들 주기전에 close해주는것
			MsDBManager.close(con, pstmt, rs);
		}

	}

	public void write(HttpServletRequest request) {
		// 사용완료후 닫기위해 겍체를 위에생성
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 연결
			con = MsDBManager.connect("msPool");

			// post방식으로 인코딩 위해추가
			request.setCharacterEncoding("euc-kr");

			String title = request.getParameter("writeT");
			String txt = request.getParameter("writeTX");
			// textarea에서 엔터:
			// 웹에서 줄바꿈:<br>
			// 웹에서 쓸꺼면 -><br>
			// java/textarea에서 쓸꺼면 그대로

			// sql(미완성:값 들어갈 자리에?,;뺴고)
			String sql = "insert into MAY26_BBS " + "values(may26_BBS_seq.nextval,?,?,sysdate)";

			// 총괄 매니저객체
			pstmt = con.prepareStatement(sql);
			// ?채우기
			pstmt.setString(1, title);
			pstmt.setString(2, txt);
			// 실행
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "글쓰기 성공");
				allMsgCount++;
				System.out.println("쓰고나면:" + allMsgCount);

			}
		} catch (Exception e) {
			request.setAttribute("result", "글쓰기 실패");
		}
		MsDBManager.close(con, pstmt, null);

	}

}
