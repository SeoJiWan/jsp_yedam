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
	%>
	<form action="boardDelete.jsp">
		<input type="hidden" name="id" value="<%=id %>">
		<h3><%=id %>번 글 삭제?</h3>
		<input type="submit" value="삭제">
		<a href="boardDetail.jsp?id=<%=id %>"><input type="button" value="취소"></a>
	</form>

</body>
</html>