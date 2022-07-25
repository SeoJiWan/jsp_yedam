<%@page import="com.tst.common.Board"%>
<%@page import="com.tst.common.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String writer = request.getParameter("writer");
	
	Board board = new Board();
	board.setTitle(title);
	board.setContent(content);
	board.setWriter(writer);
	
	BoardDAO d = new BoardDAO();
	d.insertBoard(board);
	
	out.print("completed.");
	response.sendRedirect("boardList.jsp");
%>