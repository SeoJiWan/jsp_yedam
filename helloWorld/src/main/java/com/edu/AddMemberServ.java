package com.edu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;

@WebServlet("/html/addMember")
public class AddMemberServ extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 user_name=user2&user_pwd=1234&role=1
		String name = req.getParameter("user_name");
		String pwd = req.getParameter("user_pwd");
		String role = req.getParameter("role");
		
		
		// DB 입력
		EmpDAO d = new EmpDAO();
		System.out.println(req.getMethod());
		
		int result = 0;
		// get : 수정, post : 입력.
		if (req.getMethod().toUpperCase().equals("GET")) {
			result = d.updateMemeber(name, pwd, role);
		}
		else {
			result = d.insertMember(name, pwd, role);
		}
		
		if (result > 0) {
			resp.getWriter().print("Completed.");
		}
		else {
			resp.getWriter().print("Failed.");
		}
	}

}
