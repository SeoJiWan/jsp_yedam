<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${param.id } 님 정말 삭제하시겠습니까?</h3>
	<form action="../memberDelete.do" method="post">
		<input type="hidden" name="id" value="${param.id }" >
		<input type="submit" value="네">
		<a href="${pageContext.request.contextPath }/index.jsp"><input type="button" value="아니요"></a>
	</form>

</body>
</html>