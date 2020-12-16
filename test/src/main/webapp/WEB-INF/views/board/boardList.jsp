<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
  <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
  <script type="text/javascript" src="jquery.tablesorter.min.js"></script>



<title>요기요 정보</title>
</head>
  <script type="text/javascript">


   $(document).ready(function(){ 
      $("#gcTable").table();
   });
</script>



<body>
	<div class="title">
		<h2>요기요 정보</h2>
	</div>
	<div class="banner">
      <table id="gcTable" class="table">

			<thead class="thead-dark">
				<tr>
					<th scope="col">가게명</th>
					<th scope="col">별점</th>
					<th scope="col">리뷰 수</th>	
				</tr>
			</thead>
			<tbody>
              <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-alarm" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M6.5 0a.5.5 0 0 0 0 1H7v1.07a7.001 7.001 0 0 0-3.273 12.474l-.602.602a.5.5 0 0 0 .707.708l.746-.746A6.97 6.97 0 0 0 8 16a6.97 6.97 0 0 0 3.422-.892l.746.746a.5.5 0 0 0 .707-.708l-.601-.602A7.001 7.001 0 0 0 9 2.07V1h.5a.5.5 0 0 0 0-1h-3zm1.038 3.018a6.093 6.093 0 0 1 .924 0 6 6 0 1 1-.924 0zM8.5 5.5a.5.5 0 0 0-1 0v3.362l-1.429 2.38a.5.5 0 1 0 .858.515l1.5-2.5A.5.5 0 0 0 8.5 9V5.5zM0 3.5c0 .753.333 1.429.86 1.887A8.035 8.035 0 0 1 4.387 1.86 2.5 2.5 0 0 0 0 3.5zM13.5 1c-.753 0-1.429.333-1.887.86a8.035 8.035 0 0 1 3.527 3.527A2.5 2.5 0 0 0 13.5 1z"/>
</svg>
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
<footer>
    <p>개발진: 이진원, 이성규, 김규빈, 장세나</p>
    <p>소속: 충북대학교</p>
    <p>충청북도 청주시 서원구 충대로 1</p>
    <p>Update: 11am, 6pm</p>
</footer>
</html>