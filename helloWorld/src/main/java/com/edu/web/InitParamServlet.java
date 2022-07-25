package com.edu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet{
	// 생성자 -> ServletConfig 생성 -> init(sc) -> service(rq, rs)
	
	/*
	 * Field
	 */
	String id;
	String pwd;

	/*
	 * Constructor
	 */
	public InitParamServlet() {
		System.out.println("생성자 호출");
	}

	/*
	 * Method
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// web.xml 에 매핑된 param name 이 "id" 인 아이를 들고옴
		id = config.getInitParameter("id");
		pwd = config.getInitParameter("pwd");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 초기변수 설정</h3>");
		out.print("<p>ID: " + id + "</p>");
		out.print("<p>PWD: " + pwd + "</p>");
		out.close();
		
	}

}
