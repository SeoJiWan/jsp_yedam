package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession ss = null;
		String param = req.getParameter("p");
		String msg = null;
		
		// 생성
		if (param.equals("create")) {
			// 생성된 세션값이 있으면 session id 를 반환
			//, 없으면 새로 생성
			ss = req.getSession(true);
			// 세션이 새로 생성했으면
			if (ss.isNew()) {
				msg = "새로운 세션 객체";
			}
			else {
				msg = "기존의 세션 객체";
			}
		}
		// 삭제
		else if (param.equals("delete")) {
			// 생성된 세션이 있으면 session id 반환
			// , 없으면null 반환
			ss = req.getSession(false);
			if (ss != null) {
				ss.invalidate(); // 세션 삭제
				msg = "세션 삭제";
			}
			else {
				msg = "삭제할 세션 없음";
			}
		}
		// 추가
		else if (param.equals("add")) {
			ss = req.getSession(true);
			ss.setAttribute("ssInfo", "메세지 추가함");
			msg = "세션 객체에 속성 지정함";
		}
		// get --> 크롬과 엣지는 세션이 다름
		else if (param.equals("get")) {
			ss = req.getSession(false); // 세션 객체 없으면 null
			if (ss != null) {
				String str = (String) ss.getAttribute("ssInfo");
				msg = str;
			}
			else {
				msg = "데이터를 추출할 세션 없음";
			}
		}
		// 세션 속성 삭제
		else if (param.equals("remove")) {
			ss = req.getSession(false);
			if (ss != null) {
				ss.removeAttribute("ssInfo");
				msg = "세션 객체의 속성을 삭제";
			}
			else {
				msg = "속성을 제거할 세션객체 없음";
			}
		}
		resp.getWriter().print("처리결과 : " + msg);
	}
	
}
