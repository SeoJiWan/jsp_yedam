<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardWriteForm.jsp</title>
</head>
<body>
	
	<%
		//String id = (String) session.getAttribute("loginId");
		//if (id == null || id.equals("")) {
			//response.sendRedirect("loginForm.jsp");
		//}
	%>
	
	<c:set var="user" value="${loginId }"></c:set>
	<c:if test="${loginId }">
		<c:redirect url="loginForm.jsp"></c:redirect>
	</c:if>
	
	<form action="boardInsert.jsp" method="post">
		글제목 : <input type="text" name="title"><br>
		글내용 : <textarea name="content" cols="30" rows="3"></textarea><br>
		작성자 : <input type="text" name="writer" value="${loginId }" readonly><br>
		<input type="submit" value="등록">
	
	</form>

</body>
</html>