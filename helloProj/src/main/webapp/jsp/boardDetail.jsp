<%@page import="com.tst.common.Board"%>
<%@page import="com.tst.common.BoardDAO"%>
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
		int id = Integer.parseInt(request.getParameter("id")); 
		BoardDAO d = new BoardDAO();
		Board board = d.getBoard(id);
		//board.setVisitCnt(board.getVisitCnt() + 1);
		
	%>
	<table>
		<tr>
			<td><%=board.getTitle() %></td>
		</tr>
		<tr>
			<td><%=board.getContent() %></td>
		</tr>
		<tr>
			<td><%=board.getWriter() %></td>
		</tr>
		<tr>
			<td><%=board.getCreateDate() %></td>
		</tr>
		<tr>
			<td><%=board.getVisitCnt() %></td>
		</tr>
	</table>
	<a href="boardList.jsp"><input type="button" value="뒤로가기"></a>

</body>
</html>