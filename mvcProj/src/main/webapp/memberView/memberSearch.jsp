<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색 페이지</title>
</head>
<body>
	
	<h3>회원검색</h3>
	${error }
	<form action="../../mvcProj/memberSearch.do" method="get">
		아이디 : <input type="text" name="id"><br>
		<input type="submit" value="검색">
	</form>
	

</body>
</html>