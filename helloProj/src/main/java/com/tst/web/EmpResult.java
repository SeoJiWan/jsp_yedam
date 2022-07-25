package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.Employee;

@WebServlet("/html/empResult")
public class EmpResult extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Employee> list = (List<Employee>) req.getAttribute("data");
		
		PrintWriter out = resp.getWriter();
		for(Employee emp : list) {
			out.print(emp);
		}
		out.close();
	}

}
