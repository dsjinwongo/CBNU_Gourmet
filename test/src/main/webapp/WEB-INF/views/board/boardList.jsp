<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="../../../resource/css/style1.css">
<title>요기요 정보</title>
</head>

<body>
	<div class="title">
		<h2>요기요 정보</h2>
	</div>
	<div id="banner">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>가게명</td>
					<td>별점</td>
					<td>리뷰 수</td>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${viewAll }" var="list">
					<tr>
						<td>${list.name }</td>
						<td>${list.rate }</td>
						<td>${list.review }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>