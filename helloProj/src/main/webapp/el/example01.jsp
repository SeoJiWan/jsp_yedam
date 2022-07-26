<%@page import="org.apache.jasper.tagplugins.jstl.core.Param"%>
<%@page import="com.tst.common.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el/example01.jsp</title>
</head>
<body>
	<%
		request.setAttribute("user_id", "Hong");
		User user = new User();
		user.setId("user1");
		user.setPwd("1111");
		user.setName("사용자1");
		request.setAttribute("user", user);
		
		//request.getParameter("id"); ${Param.id}
		//request.getParameter("pwd"); ${Param.pwd}
	%>
	Literal: ${"Literal"}
	<br> Operator: ${5 > 3}
	<br> Object: ${header.host }
	<br> IfCondition: ${5>3 ? "true" : "false"}
	<br> Context: ${pageContext.servletContext.contextPath }
	<br> UserId : ${user_id}
	<br> User : ${user.id} ${user.pwd } ${user.name }
	<br> ${empty user ? "값이 없습니다." : user }
	<!-- 파라미터 입력 ex) ?id=xx$pwd=xx -->
	<br> ID : ${param.id}, PWD : ${param.pwd }
	 

</body>
</html>