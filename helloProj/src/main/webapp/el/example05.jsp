<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
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
	
	<%
		for (int i = 1; i < 10; i++) {
			out.print(i);
		}
		
		String[] str = {"가가가", "나나나", "다다다"};
		for (String name : str) {
			System.out.println(name);
		}
		
		String fruits = "사과, 바나나, 포도";
	%>
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i }"></c:out><br>
	</c:forEach>
	
	
	<c:set var="names" value="<%=str %>"></c:set>
	<ul>
		<c:forEach var="name" items="${names }">
			<li>${name }</li>
		</c:forEach>
	</ul>
	
	
	<c:set var="fruits2" value="<%=fruits %>"></c:set>
	<ul>
		<c:forTokens items="${fruits2 }" delims="," var="fruit">
			<li>${fruit }</li>
		</c:forTokens>
	</ul>

</body>
</html>