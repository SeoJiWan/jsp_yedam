<%@page import="com.tst.common.Board" %>
<%@page import="java.util.List" %>
<%@page import="com.tst.common.BoardDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	
	</style>
</head>

<body>
	<%
		//String id = (String) session.getAttribute("loginId");
		//if (id != null) {
			//out.print("<h3>" + id + " 님 입장</h3>");
			//out.print("<a href='logout.jsp'>로그아웃</a>");
		//}
		//else {
			//out.print("<h3>손님 입장</h3>");
			//out.print("<a href='loginForm.jsp'>로그인</a>");
		//}
	%>
	
	<c:choose>
		<c:when test="${!empty loginId }">
			<h3><c:out value="${loginId}"></c:out> 님 입장</h3>
		</c:when>
		<c:otherwise><h3>손님 입장</h3></c:otherwise>
	</c:choose>
	

	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>title</th>
				<th>writer</th>
				<th>date</th>
				<th>visited</th>
			</tr>
		</thead>
		<tbody>
			<%
			BoardDAO d=new BoardDAO(); 
			List<Board> list = d.selectAll();
				//for (Board board : list) {
				
			%>
				<c:set var="boards" value="<%=list %>"></c:set>
				<c:forEach var="board" items="${boards }">
				<tr>
					<td> <a href="boardDetail.jsp?id=${board.boardId }">
						${board.boardId }
						</a>
					</td>
					<td>
						${board.title }
					</td>
					<td>
						${board.writer }
					</td>
					<td>
						${board.createDate }
					</td>
					<td>
						${board.visitCnt }
					</td>
				</tr>
				</c:forEach>
				
		</tbody>
	</table>
</body>
<a href="boardWriteForm.jsp"><input type="button" value="글쓰기"></a>

</html>