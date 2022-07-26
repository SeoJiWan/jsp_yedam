<%@page import="com.tst.common.Board"%>
<%@page import="com.tst.common.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		BoardDAO d = new BoardDAO();
		
		Board board = d.selectOne(id);
	%>
	
	<form action="boardModify.jsp">
		<table border="1">
			<tr>
				<th>글번호</th><td><input type="text" name="b_id" value="<%=board.getBoardId() %>" readonly></td>
			</tr>
			<tr>
				<th>글제목</th><td><input type="text" name="b_title" value="<%=board.getTitle() %>"></td>
			</tr>
			<tr>
				<th>글내용</th><td><input type="text" name="b_content" value="<%=board.getContent() %>"></td>
			</tr>
		</table>
		
		<a href="boardList.jsp"><input type="submit" value="수정완료"></a>
		<a href="boardList.jsp"><input type="button" value="취소"></a>
	</form>
	
	<script>
		<%
			String loginId = (String) session.getAttribute("loginId");
			if (!(loginId != null && loginId.equals(board.getWriter()))) {
		%>
		
		document.querySelector("input[type='submit']").disabled=true;
		<%
			}
		%>
		
	</script>

</body>
</html>