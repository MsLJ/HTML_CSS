package com.ms.may162validcheck.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Output
 */

//서블릿:파일업로드 해야하고,계산 해야하고,...

//	잘못입력해도 일단 서블릿까지 와서 try/if
//입력 유효성 검사까지 굳이 서블릿에서?->아쉽
//	잘못입력하면 아예 서블릿까지 오지도 않게-v
//	=>입력 유효성검사를 사용자쪽에서 하자

@WebServlet("/Output")
public class Output extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Output() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
			
		
		response.setCharacterEncoding("euc-kr");

		// 파일이 업로드될 폴더 경로
		String path = request.getSession().getServletContext().getRealPath("imagee");
		System.out.println(path);
		// cos.jar의 방식으로 인코딩되어서 날아온 요청객체
		MultipartRequest mr = new MultipartRequest(request, path, 10 * 1024 * 1024, // 허용해줄 파일 최대 크기(넘어가면 Exception)
				"euc-kr", // 요청파라메터 한글처리
				new DefaultFileRenamePolicy()// 업로드한 파일명 중복되면 그냥 숫자 붙여서

		);
		String namee = mr.getParameter("namee");
		int agee = Integer.parseInt(mr.getParameter("agee"));
		String p = mr.getFilesystemName("photoo");
		String say = (agee >= 20) ? "어서옵쇼" : "나가";
		
		p = URLEncoder.encode(p, "euc-kr");

		p = p.replace("+", " ");
		

		PrintWriter pw = response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h2>이름:%s</h2>", namee);
		pw.printf("<h2>%s</h2>", say);
		pw.printf("<img src=\"imagee/%s\">", p);
		pw.print("</body></html>");
		
	}

}
