package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reqInfo")
public class RequestInfoServ extends HttpServlet{
	// init() -> request, response 객체 생성 -> service() ->
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		// 네트워크정보
		PrintWriter pw = resp.getWriter();
		pw.print("<h3>네트워크정보</h3>");
		pw.print("<p>Request Schema : " + req.getScheme() + "</p>");
		pw.print("<p>Server Name : " + req.getServerName() + "</p>");
		pw.print("<p>Server Address : " + req.getLocalAddr() + "</p>");
		pw.print("<p>Server Port : " + req.getServerPort() + "</p>");
		pw.print("<p>Client Address : " + req.getRemoteAddr() + "</p>");
		pw.print("<p>Client Host : " + req.getRemoteHost() + "</p>");
		
		String str = "<h3>URL정보</h3>";
		str += "<p>Request URI: " + req.getRequestURI() + "</p>"
			+ "<p>Request URL: " + req.getRequestURL() + "</p>" 
			+ "<p>Context Path: " + req.getContextPath() + "</p>"
			+ "<p>Request Protocol: " + req.getProtocol() + "</p>"
			+ "<p>Servlet Path: " + req.getServletPath() + "</p>";
		
		str += "<h3>요청헤더 정보</h3>";
		// 헤더 정보 불러오기 --> enum 타입으로
		Enumeration<String> en = req.getHeaderNames();
		while(en.hasMoreElements()) {
			// enum 타입을 하나씩 가져와서
			String elem = en.nextElement();
			// 헤더정보를 불러옴
			String headVal = req.getHeader(elem);
			
			str += "<p>" + elem + ", " + headVal + "</p>";
		}
				
		pw.print(str);
		pw.close();
	}
}
