<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInput.jsp</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="memberProc.jsp" method="post">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pwd"><br>
		이름 : <input type="text" name="name"><br>
		이메일 : <input type="email" name="mail"><br>
		<input type="submit" value="회원가입">
	</form>

</body>
</html>