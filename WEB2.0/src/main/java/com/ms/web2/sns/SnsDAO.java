package com.ms.web2.sns;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ms.web2.member.Member;

import ms.ljh.db.manager.MsDBManager;

public class SnsDAO {
	private int allsnsCount;
	private int snsperPage;

	public int getAllsnsCount() {
		return allsnsCount;
	}

	public void setAllsnsCount(int msgCount) {
		System.out.println(allsnsCount);
		allsnsCount -= msgCount;
		System.out.println(allsnsCount);
	}

	public SnsDAO() {
		snsperPage = 10;
	}

	private static final SnsDAO SDO = new SnsDAO();

	public static SnsDAO getSdo() {
		return SDO;
	}

	public void deleteReply(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));

			String sql = "delete from sns_re where sre_sns_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "댓글삭제");

			} else {
				request.setAttribute("result", "댓글삭제실패");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("result", "댓글삭제실패");
		}
		MsDBManager.close(con, pstmt, null);
	}

	public void setAllSNSCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select count(*)from sns";
			// 앞에 테이블을 만들때 아이디가 없으면 글이 삭제돼니
			// 갯수를 샐때는 join을 할필요가 없을것
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allsnsCount = rs.getInt("count(*)");
			System.out.println(allsnsCount);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		MsDBManager.close(con, pstmt, rs);

	}

	// 글쓰기:SNSWriteController?txt=? get방식
	// 새로고침:직전에 했던 요청 그대로 다시하기
	// 새로고침을 못하게했었는데
	// 마우스 우클릭 못하게,f5못하게
	// 글 쓸때마다 뭔가 달라질 수 있는거

	// 15:56:00에 글 씀:155600
	// 15:57:30에 글 씀:155730
	// 15:59:03에 새로고침 155730
	public void write(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = request.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			// lastToken값이 없으면 일단 아래로 진행 &&이기에 뒤에 조건식은 보지않음
			// 그 후에 lastToken값이 생기면 뒤의 조건식 검사 return; 시키면 될것
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "글 쓰기 실패(새로고침)");
				return;
			}

			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			String txt = request.getParameter("txt");
			System.out.println(id);
			System.out.println(txt);
			txt.replace(" n", "<br>");
			String sql = "insert into sns values(sns_seq.nextval, ?, ?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, txt);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "write성공");
				allsnsCount++;
				request.getSession().setAttribute("lastToken", token);

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "write실패");

		}

		MsDBManager.close(con, pstmt, null);

	}

	public void search(HttpServletRequest request) {
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
	}

	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}

	public int getSearchSnsCount(String search) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select count(*) from sns where sns_txt like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			MsDBManager.close(con, pstmt, rs);
		}

	}

	public ArrayList<Reply> getReply(int sreno) {

		// 글 번호 넣으면
		// 그 글에 달려있는 댓글들
		// ArrayList<댓글>로 리턴하는 메소드
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MsDBManager.connect("msPool");
			String sql = "select*from sns_re where sre_sns_no=? order by sre_date desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, sreno);

			rs = pstmt.executeQuery();
			ArrayList<Reply> replys = new ArrayList<>();
			while (rs.next()) {
				replys.add(new Reply(rs.getInt("sre_no"), rs.getInt("sre_sns_no"), rs.getString("sre_writer"),
						rs.getString("sre_txt"), rs.getDate("sre_date")

				));

			}

			return replys;

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			MsDBManager.close(con, pstmt, rs);
		}
	}

	public void snsReply(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			String token = request.getParameter("token");
			String lastToken = (String) request.getSession().getAttribute("lastToken");
			// 세션으로 갖고올때 앞에 (String)형 변환이유는 Object로 들어오기에 형변환을 꼭 해줘야한다.
			if (lastToken != null && token.equals(lastToken)) {
				request.setAttribute("result", "댓글쓰기 실패");
				return;

			}

			con = MsDBManager.connect("msPool");
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String id = m.getId();
			String txt = request.getParameter("txt");
			int no = Integer.parseInt(request.getParameter("re_no"));
			System.out.println(no);
			System.out.println(txt);
			System.out.println(id);
			String sql = "insert into sns_re values(sns_re_seq.nextval, ?, ?, ?,sysdate)";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			pstmt.setString(3, txt);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "댓글성공");
				request.getSession().setAttribute("lastToken", token);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			request.setAttribute("result", "댓글실패");
		}
		MsDBManager.close(con, pstmt, null);

	}

	public void update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			String txt = request.getParameter("txt");
			String sql = "update sns" + "set sns_txt=?" + "where sns_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, txt);
			pstmt.setInt(2, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "글수정성공");

			} else {
				request.setAttribute("result", "글수정실패");

			}

		} catch (Exception e) {
			request.setAttribute("result", "글 수정 실패");
		}
		MsDBManager.close(con, pstmt, null);

	}

	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MsDBManager.connect("msPool");
			int no = Integer.parseInt(request.getParameter("no"));
			String sql = "delete from sns where sns_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("result", "글 삭제 성공");
				allsnsCount--;

			} else {
				request.setAttribute("result", "글 삭제 실패");

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글 삭제 실패");
		}
	}

	public void getSns(int page, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = MsDBManager.connect("msPool");
			String search = (String) request.getSession().getAttribute("search");
			int snsCount = allsnsCount;
			if (search == null) {
				search = "";
			} else {
				snsCount = getSearchSnsCount(search);
				System.out.println(snsCount);
			}

			int pageCount = (int) Math.ceil(snsCount / (double) snsperPage);
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("page", page);
			int start = (page - 1) * snsperPage + 1;
			int end = snsperPage * page;
			System.out.println(end);
			String sql = "select sns_no, webm_id, webm_photo, sns_txt, sns_date "

					+ "		from( "

					+ "			select * "

					+ "			from ( "

					+ "					select rownum as rn, sns_no,sns_txt,sns_date,sns_writer "

					+ "					from( "

					+ "						select *"

					+ "						from sns "

					+ "						where sns_txt like '%'||?||'%' "

					+ "						order by sns_date desc "

					+ "						) "

					+ ""

					+ "			)where rn >= ? and rn<= ? "

					+ "			),"

					+ "			("

					+ "			select webm_id, webm_photo "

					+ "			from web2_member "

					+ "			where webm_id in( "

					+ "					select sns_writer "

					+ "					from ( "

					+ "						select rownum as rn, sns_no,sns_txt,sns_date, sns_writer "

					+ "						from( "

					+ "							select * "

					+ "							from sns "

					+ "							where sns_txt like '%'||?||'%' "

					+ "							order by sns_date desc "

					+ "							) "

					+ "						) "

					+ "					where rn >= ? and rn<= ? "

					+ "				) ) "

					+ "	where sns_writer = webm_id "

					+ " order by sns_date desc";
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			pstmt.setString(4, search);
			pstmt.setInt(5, start);
			pstmt.setInt(6, end);
			ArrayList<SNSMsg> smg = new ArrayList<>();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				smg.add(new SNSMsg(rs.getInt("sns_no"), rs.getString("sns_txt"), rs.getDate("sns_date"),
						rs.getString("webm_id"), rs.getString("webm_photo")));

			}
			for (SNSMsg snsMsg : smg) {
				snsMsg.setReplys(getReply(snsMsg.getNo()));
			}

			System.out.println(rs);
			request.setAttribute("smg", smg);

		} catch (Exception e) {
			e.printStackTrace();

		}

		MsDBManager.close(con, pstmt, rs);
	}

}
