<%@page import="com.tst.common.BoardDAO"%>
<%@page import="com.tst.common.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%
		int id = Integer.parseInt(request.getParameter("b_id"));
		String title = request.getParameter("b_title");
		String content = request.getParameter("b_content");
		
		Board board = new Board();
		board.setBoardId(id);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDAO d = new BoardDAO();
		d.update(board);
		
		response.sendRedirect("boardList.jsp");
	%>

</body>
</html>