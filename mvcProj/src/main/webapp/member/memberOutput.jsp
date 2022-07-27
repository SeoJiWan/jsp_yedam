<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberOutput.jsp</title>
</head>
<body>
	<!-- memberProc.jsp 에서 setAttribute("member", member); 으로 세팅해둔 member 를 들고옴-->
	<c:set var="member" value="${member }"></c:set>
	<p><c:out value="${member.name }"></c:out>님 가입완료</p>

</body>
</html>