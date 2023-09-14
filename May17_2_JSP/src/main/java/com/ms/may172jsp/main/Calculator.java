package com.ms.may172jsp.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("euc-kr");
		int x=Integer.parseInt(request.getParameter("x"));
		int y=Integer.parseInt(request.getParameter("y"));
		PrintWriter pw=response.getWriter();
		pw.print("<html><head><meta charset=\"EUC-KR\">");
		pw.print("<style type=\"text/css\">");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table border=\"1\">");
		pw.print("<tr>");
		pw.printf("<td>x+y=%d</td>",x+y);
		pw.print("</tr>");
		pw.print("<tr>");
		pw.printf("<td>x-y=%d</td>",x-y);
		pw.print("</tr>");
		pw.printf("<td>x*y=%d</td>",x*y);
		pw.print("<tr>");
		pw.printf("<td>x%y=%d</td>",x%y);
		pw.print("</tr>");
		pw.print("</table>");
		pw.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
