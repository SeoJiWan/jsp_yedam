package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second.do") // url 입력시 SecondServlet 클래스 실행
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		// html 파일 charset 설정
		resp.setContentType("text/html;charset=UTF-8");
		
		// HttpServletResponse 응답 정보 객체
		PrintWriter out = resp.getWriter(); // 출력 스트림
		out.print("<h1>안녕하세요. 서블릿입니다.</h1>");
		out.print("<h3>안녕하세요. 서블릿입니다.</h3>");
	}
}
