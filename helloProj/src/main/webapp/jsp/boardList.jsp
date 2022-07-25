<%@page import="com.tst.common.Board" %>
<%@page import="java.util.List" %>
<%@page import="com.tst.common.BoardDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
	</style>
</head>

<body>

	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>title</th>
				<th>writer</th>
				<th>date</th>
				<th>visited</th>
			</tr>
		</thead>
		<tbody>
			<% BoardDAO d=new BoardDAO(); List<Board> list = d.boardList();
				for (Board board : list) {
				%>
				<tr>
					<td> <a href="boardDetail.jsp?id=<%=board.getBoardId()%>">
						<%=board.getBoardId()%>
						</a>
					</td>
					<td>
						<%=board.getTitle()%>
					</td>
					<td>
						<%=board.getWriter()%>
					</td>
					<td>
						<%=board.getCreateDate()%>
					</td>
					<td>
						<%=board.getVisitCnt()%>
					</td>
				</tr>
				<% } %>
		</tbody>
	</table>
</body>

<script>

</script>

</html>