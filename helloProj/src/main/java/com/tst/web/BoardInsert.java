package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.Board;
import com.tst.common.BoardDAO;

@WebServlet("/jsp/boardInsert")
public class BoardInsert extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		
		BoardDAO d = new BoardDAO();
		d.insertBoard(board);
		
		resp.sendRedirect("boardList.jsp");
	}

}
