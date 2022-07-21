package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청정보 : 질의문자열 (키=값) url -> third?key=Neena
		String value = req.getParameter("key");
		
		resp.setContentType("text/html;charset=UTF-8");
		
		EmpDAO d = new EmpDAO();
		List<Employee> list = d.getEmpInfo(value);
		list.forEach(System.out::println);
		
		
		PrintWriter pw = resp.getWriter(); // 출력 스트림
		pw.print("<table border = '1'>");
		pw.print("<thead><tr><th>employeeI</th><th>firstName</th><th>lastName</th><th>email</th><th>salary</th></tr></thead>");
		pw.print("<tbody");
		for (Employee emp : list) {
			pw.print("<tr>"
					+ "<td>" + emp.getEmployeeId() + "</td>"
					+ "<td>" + emp.getFirstName() + "</td>"
					+ "<td>" + emp.getLastName() + "</td>"
					+ "<td>" + emp.getEmail() + "</td>"
					+ "<td>" + emp.getSalary() + "</td>"
					+ "</tr>");
		}
		pw.print("</tbody");
		pw.print("</table>");
		
		
		
	}

}
