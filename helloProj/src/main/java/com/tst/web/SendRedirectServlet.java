package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/sendRedirect")
public class SendRedirectServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String param = req.getParameter("site");
		
		if (param.equals("naver")) {
			// HttpServletResponse 객체에서 요청 재지정
			resp.sendRedirect("https://www.naver.com");
		}
		else if (param.equals("google")) {
			resp.sendRedirect("https://www.google.com");
		}
		else if (param.equals("daum")) {
			resp.sendRedirect("https://www.daum.net");
		}
	}

}
