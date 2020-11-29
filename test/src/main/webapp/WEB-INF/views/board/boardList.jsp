<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>

<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
		display: block;
		width: 60%;
		margin: auto;
	}
</style>
<body>

<h2>게시판</h2>
<div id="outter">
	<table border="1">
		<tr>
			<td>No.</td>
			<td>작성자</td>
			<td>등록일</td>	
		</tr>
		<c:forEach items="${viewAll }" var="list">
			<tr>
				<td>${list.name }</td>
				<td>${list.rate }</td>
				<td>${list.review }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>