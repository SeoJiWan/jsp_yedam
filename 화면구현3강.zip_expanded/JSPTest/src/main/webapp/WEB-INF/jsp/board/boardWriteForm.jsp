<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBoard.do" method="get">
	    <table>
	       <tr>
	            <td>title</td>
	            <td><input type="text" id="title" name="title"></td>
	        </tr>
	        <tr>
	            <td>content</td>
	            <td><textarea id="content" name="content" cols="40" rows="5"></textarea></td>
	        </tr>
	        <tr>
	        	<td><input type="submit" value="작성"></td>
	        </tr>
	    </table>
    </form>
</body>
</html>