<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h3>안녕하세요.</h3>
	<!-- 파일안에 다른 파일 포함 -->
	스크립트릿 : <%@ include file="footer.jsp" %>
	xml : <jsp:include page="footer.jsp"></jsp:include>
	<c:import url="footer.jsp" var="foot"></c:import>
	jstl : ${foot }
</body>
</html>