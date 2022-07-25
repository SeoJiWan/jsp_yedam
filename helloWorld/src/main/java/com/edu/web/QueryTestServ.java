package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/queryTest")
public class QueryTestServ extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String[] hobby = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		
		System.out.println("id = " + id);
		System.out.println("pwd = " + pwd);
		System.out.println("hobby = " + hobby);
		System.out.println("gender = " + gender);
		System.out.println("religion = " + religion);
		System.out.println("introduction = " + introduction);
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h3>입력받은 값</h3>");
		pw.print("<p>ID: " + id + "</p>");
		pw.print("<p>PWD: " + pwd + "</p>");
		pw.print("HOBBY<br><ul>");
		for (int i = 0; i < hobby.length; i++) {
			pw.print("<li>" + hobby[i] + "</li>");
		}
		pw.print("</ul>");
		pw.print("<p>GENDER: " + gender+ "</p>");
		pw.print("<p>RELIGION: " + religion + "</p>");
		pw.print("<p>INTRODUCE: " + introduction + "</p>");
		pw.print("질의문자열 : " + req.getQueryString());
		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
//		String id = req.getParameter("id");
//		String pwd = req.getParameter("pwd");
//		String name = req.getParameter("name");
//		String[] hobby = req.getParameterValues("hobby");
//		String gender = req.getParameter("gender");
//		String religion = req.getParameter("religion");
//		String introduction = req.getParameter("introduction");
//		
//		System.out.println("id = " + id);
//		System.out.println("pwd = " + pwd);
//		System.out.println("hobby = " + hobby);
//		System.out.println("gender = " + gender);
//		System.out.println("religion = " + religion);
//		System.out.println("introduction = " + introduction);
//		
		PrintWriter pw = resp.getWriter();
//		pw.print("<h3>입력받은 값</h3>");
//		pw.print("<p>ID: " + id + "</p>");
//		pw.print("<p>PWD: " + pwd + "</p>");
//		pw.print("<p>NAME: " + name + "</p>");
//		pw.print("HOBBY<br><ul>");
//		for (int i = 0; i < hobby.length; i++) {
//			pw.print("<li>" + hobby[i] + "</li>");
//		}
//		pw.print("</ul>");
//		pw.print("<p>GENDER: " + gender+ "</p>");
//		pw.print("<p>RELIGION: " + religion + "</p>");
//		pw.print("<p>INTRODUCE: " + introduction + "</p>");
		
		ServletInputStream sis = req.getInputStream(); // post : 입력스트림.
		int len = req.getContentLength(); // 데이터 크기
		byte[] buf = new byte[len];
		sis.readLine(buf, 0, len);
		String queryString = new String(buf);
		
		pw.print("<p id='querystring'>질의문자열 : " + queryString + "</p>");
		sis.close();
		pw.close();
	}
	
	

}
