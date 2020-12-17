<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<script src="/resources/js/table_sort.js"></script>
<script type="text/javascript">

      function changeFunc() {
       var selectBox = document.getElementById("selectBox");
       var selectedValue = selectBox.options[selectBox.selectedIndex].value;
       sortTable(selectedValue);
      }

</script>
<title>요기요 정보</title>
</head>

<body>
	<div class="title">
		<h1>중식 정보</h1>
	</div>
	<nav class="header">
        <ul>
	        <li><a href="/korea/">한식</a></li>
	        <li><a href="/america/">양식</a></li>
	        <li><a href="/china/" id="blue">중식</a></li>
	        <li><a href="/board/">게시판</a></li>
        </ul>
    </nav>
	<div class="banner">
		<select id="selectBox" onchange="changeFunc();">
			<option value=""><정렬></option>
			<option value="0">가나다순</option>
		    <option value="1">별점순</option>
		    <option value="2">리뷰순</option>
		</select>
		<table id="myTable" class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">가게명</th>
					<th scope="col">별점</th>
					<th scope="col">리뷰 수</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${viewChina }" var="list">
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
</footer>
</html>