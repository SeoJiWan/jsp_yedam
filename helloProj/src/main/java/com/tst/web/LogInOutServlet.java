package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/html/logProc")
public class LogInOutServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("아이디와 비밀번호를 입력해주세요");
			return;
		}
		HttpSession ss = req.getSession();
		if(ss.isNew() || ss.getAttribute("id") == null) {
			ss.setAttribute("id", id);
			out.print("로그인 완료");
		}
		else {
			out.print("현재 로그인 중입니다.");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		HttpSession ss = req.getSession(false);
		if (ss != null && ss.getAttribute("id") != null) {
			ss.invalidate();
			out.print("로그아웃 완료");
		}
		else {
			out.print("현재 로그인 상태가 아닙니다.");
		}
	}
}
