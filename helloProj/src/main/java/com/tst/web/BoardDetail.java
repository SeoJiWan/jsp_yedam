package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.Board;
import com.tst.common.BoardDAO;

@WebServlet("/jsp/boardDetail")
public class BoardDetail extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		BoardDAO d = new BoardDAO();
		Board board = d.getBoard(id);
		
	}

}
