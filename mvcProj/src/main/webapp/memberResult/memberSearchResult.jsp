<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원검색 결과 페이지</title>
</head>
<body>
	<h3>회원검색 결과</h3>
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
		</tr>
		<tr>
			<td>${findMember.id }</td>
			<td>${findMember.pwd }</td>
			<td>${findMember.name }</td>
			<td>${findMember.mail }</td>
		</tr>
	</table>
	<form action="${pageContext.request.contextPath }/memberView/memberUpdate.jsp" method="post">
		<input type="hidden" name="id" value="${findMember.id }">
		<input type="hidden" name="pwd" value="${findMember.pwd }">
		<input type="hidden" name="name" value="${findMember.name }">
		<input type="hidden" name="mail" value="${findMember.mail }">
		<input type="submit" value="수정">
	</form>
	<form action="${pageContext.request.contextPath }/memberView/memberDelete.jsp" method="post">
		<input type="hidden" name="id" value="${findMember.id }">
		<input type="submit" value="삭제">
	</form>
	
</body>
</html>