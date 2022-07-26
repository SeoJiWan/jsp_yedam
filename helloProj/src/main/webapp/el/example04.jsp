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
	<c:set var="num" value="${80 }"></c:set>
	
	점수<c:out value="${num })"> </c:out> 은
	<c:if test="${num > 60 }">
	합격
	</c:if>
	<c:if test="${num lt 60 }">
	불합격
	</c:if>

</body>
</html>