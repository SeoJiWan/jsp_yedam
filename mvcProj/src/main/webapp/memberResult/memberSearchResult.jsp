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
</body>
</html>