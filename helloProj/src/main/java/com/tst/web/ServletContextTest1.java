package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/context1")
public class ServletContextTest1 extends HttpServlet{
	
	/*
	 * Field
	 */
	ServletContext sc;
	

	/*
	 * Method
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		sc = config.getServletContext(); // servletConfig 객체
		System.out.println(sc);
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String loc = sc.getInitParameter("contextConfigLocation");
		resp.getWriter().println("Location : " + loc);
		
		String con = sc.getInitParameter("contextConfig");
		resp.getWriter().println("Config : " + con);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String enc = sc.getInitParameter("encoding");
		
		req.setCharacterEncoding("utf-8");
		req.setCharacterEncoding(enc);
		
		String name = req.getParameter("name");
		resp.getWriter().print("이름 : " + name);
	}

}
