<%@page import="com.tst.common.Board" %>
	<%@page import="com.tst.common.BoardDAO" %>
		<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="UTF-8">
				<title>Insert title here</title>
			</head>

			<body>

				<% 
				int id=Integer.parseInt(request.getParameter("id")); 
				BoardDAO d=new BoardDAO(); 
				Board board=d.selectOne(id);
				%>
					<table>
						<tr>
							<td>
								<%=board.getTitle() %>
							</td>
						</tr>
						<tr>
							<td>
								<%=board.getContent() %>
							</td>
						</tr>
						<tr>
							<td>
								<%=board.getWriter() %>
							</td>
						</tr>
						<tr>
							<td>
								<%=board.getCreateDate() %>
							</td>
						</tr>
						<tr>
							<td>
								<%=board.getVisitCnt() + 1%>
							</td>
						</tr>
					</table>
					<a href="boardList.jsp"><input type="button" value="글목록"></a>
					<a href="boardWriteForm.jsp"><input type="button" value="글쓰기"></a>
					<%
						//String loginId = (String) session.getAttribute("loginId");
						//if (loginId != null && loginId.equals(board.getWriter())) {
					%>
					<a href="boardModifyForm.jsp?id=<%=board.getBoardId() %>"><input type="button" value="글수정"></a>
					<a href="boardDeleteForm.jsp?id=<%=board.getBoardId() %>" id="del"><input type="button" value="글삭제"></a>
					<%
						//}
					%>



			</body>

			</html>