package com.ms.may161fileinput.main;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		String title=request.getParameter("tittttle");
		
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h2>제목:%s</h2>",title);
		
		
		
		
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("euc-kr");
		response.setCharacterEncoding("euc-kr");
		
		//파일이 업로드될 폴더 경로
		String path=request.getSession().getServletContext().getRealPath("imagee");
		System.out.println(path);
		//cos.jar의 방식으로 인코딩되어서 날아온 요청객체
		MultipartRequest mr
		 =new MultipartRequest(request, path,
				 10*1024*1024,//허용해줄 파일 최대 크기(넘어가면 Exception)
				 "euc-kr",	  //요청파라메터 한글처리
				 new DefaultFileRenamePolicy()//업로드한 파일명 중복되면 그냥 숫자 붙여서
				 
				 );
	
		
		//request.getparameter(..):TOmcat방식으로 인코딩되어서 값 올때
		String title=mr.getParameter("tittttle");
		
		//중복처리 당해있을 파일명
		String p=mr.getFilesystemName("photoo");//a10.png
		
		String d=mr.getFilesystemName("downn");
		//Tomcat이 한글로 된 파일명 인식 불가
		//		ㅋ->%2A
		p=URLEncoder.encode(p, "euc-kr");
		d=URLEncoder.encode(d, "euc-kr");
		//Tomcat에서 띄어쓰기가+로 인식
		//하지만 Tomcat은 띄어쓰기 그대로 띄어쓰기로
		//그래서 p=p.replace("+","")가 아닌
		p=p.replace("+"," ");
		d=d.replace("+"," ");
		//사용자 입장에서 ㅋ ㅋ.png를 업로드:파일명이 2자
		//최종적으로는 encoding 변환 %2A %2A10.png:13자
		
		
		
		
		PrintWriter pw = response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.printf("<h2>제목:%s</h2>",title);
		pw.printf("<h2>파일명:%s</h2>", p);
		pw.printf("<img src=\"imagee/%s\">", p);
		pw.printf("<a href=\"imagee/%s\"><h1>다운로드</h1></a>",d);
		pw.print("</body></html>");
		
		
		
	}

}
