<%@page import="com.tst.common.User"%>
<%@page import="com.tst.common.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	// 로그인 시도 시 에러메세지 전달
	RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
	
	BoardDAO d = new BoardDAO();
	User user = d.checkLogin(id, pwd);
	if (user == null) {
		// 요청정보에 메세지 세팅
		request.setAttribute("msg", "아이디와 비밀번호를 확인하세요.");
		// requst 와 response 를 "loginForm.jsp 페이지로 포워딩"
		rd.forward(request, response);
		
		//response.sendRedirect("loginForm.jsp");
	}
	else {
		// 로그인 성공시 세션 생성
		session.setAttribute("loginId", id);
		response.sendRedirect("boardList.jsp");
	}
		
	
	
%>

</body>
</html>