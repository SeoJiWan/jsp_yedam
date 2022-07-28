<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원수정</h3>
	<form action="../memberUpdate.do" method="post">
		아이디 : <input type="text" name="id" value="${param.id }" readonly="readonly"><br>
		비밀번호 : <input type="password" name="pwd" value="${param.pwd }"><br>
		이름 : <input type="text" name="name" value="${param.name }"><br>
		이메일 : <input type="email" name="mail" value="${param.mail }"><br>
		<input type="submit" value="수정완료">
	</form>

</body>
</html>