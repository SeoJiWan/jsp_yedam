package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.common.EmpDAO;
import com.edu.common.Employee;

@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		EmpDAO d = new EmpDAO();
		List<Employee> empList = d.selectAllEmp();
		
		PrintWriter pw = resp.getWriter(); // 출력 스트림
		pw.print("<table border = '1'>");
		pw.print("<thead><tr><th>employeeId</th><th>firstName</th><th>lastName</th><th>email</th><th>salary</th></tr></thead>");
		pw.print("<tbody");
		for (Employee emp : empList) {
			pw.print("<tr>"
					+ "<td>" + emp.getEmployeeId() + "</td>"
					+ "<td>" + emp.getFirstName() + "</td>"
					+ "<td>" + emp.getLastName() + "</td>"
					+ "<td>" + emp.getEmail() + "</td>"
					+ "<td>" + emp.getHireDate() + "</td>"
					+ "<td>" + emp.getSalary() + "</td>"
					+ "<td>" + emp.getJobId() + "</td>"
					+ "</tr>");
		}
		pw.print("</tbody");
		pw.print("</table>");
		
	}

}
