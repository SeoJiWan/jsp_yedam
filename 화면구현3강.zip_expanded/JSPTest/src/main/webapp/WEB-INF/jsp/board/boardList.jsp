<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style>
	.center {
	  text-align: center;
	}
	
	.pagination {
	  display: inline-block;
	}
	
	.pagination a {
	  color: black;
	  float: left;
	  padding: 8px 16px;
	  text-decoration: none;
	  transition: background-color .3s;
	  border: 1px solid #ddd;
	  margin: 0 4px;
	}
	
	.pagination a.active {
	  background-color: #4CAF50;
	  color: white;
	  border: 1px solid #4CAF50;
	}
	
	.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
</head>
<body>
  <div align="center">
	<table>
		<thead>
			<tr>
				<th>Board.NO</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>등록날짜</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${list }">
				<tr>
					<td>${board.boardId }</td>
					<td>${board.title }</td>
					<td>${board.content }</td>
					<td>${board.writer }</td>
					<td>${board.write_date }</td>
					<td>${board.visit_cnt }</td>
				</tr>
			</c:forEach>
		</thead>
	</table>
	
	<div class="center">
	  <div class="pagination">
	 	<c:if test="${pageInfo.prev }"> 	
			<a href="boardListPaging.do?pageNum=${pageInfo.startPage - 1}&amount=${pageInfo.cri.amount}">prev</a>
		</c:if>
		<c:forEach var="num" begin="${pageInfo.startPage }" end="${pageInfo.endPage }">
			<a href="boardListPaging.do?pageNum=${num}&amount=${pageInfo.cri.amount}">${num}</a>
		</c:forEach>
		<c:if test="${pageInfo.next }">
			<a href="boardListPaging.do?pageNum=${pageInfo.endPage + 1}&amount=${pageInfo.cri.amount}">next</a>
	  	</c:if>
	  
	</div>
</div>
	
	
</div>
  
</body>
</html>


