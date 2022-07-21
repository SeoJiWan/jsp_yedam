package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddInfoServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.print("<h3>추가적인 정보</h3>");
		pw.print("<p>Request Method : " + req.getMethod() + "</p>");
		pw.print("<p>Path Info : " + req.getPathInfo() + "</p>");
		pw.print("<p>Path Translated : " + req.getPathTranslated() + "</p>");
		pw.print("<p>Query String : " + req.getQueryString() + "</p>");
		pw.print("<p>Content Length : " + req.getContentLength() + "</p>");
		pw.print("<p>Content Type : " + req.getContentType() + "</p>");
		pw.close();
	}

}
