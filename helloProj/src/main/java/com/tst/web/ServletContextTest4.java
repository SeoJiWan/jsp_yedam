package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		ServletContext sc = this.getServletContext();
		
		// 강제 캐스팅
		// servletContext 에서 "data" 를 가져옴
		ShareObject obj1 = (ShareObject) sc.getAttribute("data");
		resp.getWriter().println("cnt : " + obj1.getCnt() + ", str : " + obj1.getStr());
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
		resp.getWriter().println("cnt : " + obj2.getCnt() + ", str : " + obj2.getStr());
	}
}
