<%@page import="co.edu.common.MemberService"%>
<%@page import="co.edu.common.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// 컨트롤러
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	String mail = request.getParameter("mail");
	
	Member member = new Member();
	member.setId(id);
	member.setPwd(pwd);
	member.setName(name);
	member.setMail(mail);
	
	MemberService memberService = MemberService.getMemberService();
	memberService.joinMember(member);
	
	request.setAttribute("member", member);
	
	// 처리결과 : memberOutput.jsp
	RequestDispatcher rd = request.getRequestDispatcher("memberOutput.jsp");
	rd.forward(request, response);
	
	
	
	
%>