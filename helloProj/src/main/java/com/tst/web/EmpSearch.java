package com.tst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.EmpDAO;
import com.tst.common.Employee;

@WebServlet("/html/empSearch")
public class EmpSearch extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fName = req.getParameter("first_name");
		
		EmpDAO d = new EmpDAO();
		List<Employee> list = d.getEmpInfo(fName);
		req.setAttribute("data", list);
		
		// empResult 서블릿으로 req, resp 를 넘김
		RequestDispatcher rd = req.getRequestDispatcher("/html/empResult");
		rd.forward(req, resp);
	}
}
