<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
<script src="/resources/js/table_sort.js"></script>
<script type="text/javascript">

      function changeFunc() {
       var selectBox = document.getElementById("selectBox");
       var selectedValue = selectBox.options[selectBox.selectedIndex].value;
       sortTable(selectedValue);
      }

</script>
<style type="text/css">
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
</style>
<title>요기요 정보</title>
</head>
<header>
	<nav class="navbar fixed-top">
    	<h2><a color="black" href="${path}/main">CBNU GOURMET</a></h2>
    	<div class="btn-group">
    	<c:choose>
			<c:when test="${sessionScope.userId != null}">
   			<h3>${sessionScope.userName}(${sessionScope.userId})님 환영합니다.</h3>
   			</c:when>
   		</c:choose>
      	<button class="btn bmd-btn-icon dropdown-toggle" type="button" id="ex3" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <i class="material-icons icon-set1">account_circle</i>
      	</button>
      	<div class="dropdown-menu  dropdown-menu-right" aria-labelledby="ex3">
        <ul>
           <c:choose>
			    <c:when test="${sessionScope.userId == null}">
			        <li><a href="${path}/login.do">로그인</a></li>
			        <li><a href="${path}/write.do">회원가입</a></li>
			    </c:when>
			    <c:otherwise>
			        ${sessionScope.userName}님이 로그인중입니다.
			        <li><a href="${path}/logout.do">로그아웃</a></li>
			    </c:otherwise>
			</c:choose>
        </ul>
      	</div>
    	</div>
    </nav>
</header>
<body class="mybody">
	<div>
		<select id="selectBox" onchange="changeFunc();">
			<option value=""><정렬></option>
			<option value="0">가나다순</option>
		    <option value="1">별점순</option>
		    <option value="2">리뷰순</option>
		</select>
		<br>
		<br>
		<table id="myTable" class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col">가게명</th>
					<th scope="col">별점</th>
					<th scope="col">리뷰 수</th>
					<th scope="col">주소</th>		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${viewDessert }" var="list">
					<tr>
						<td class="fontbold">${list.name }</td>
						<td>★${list.rate }</td>
						<td>${list.review }</td>
						<td>${list.address }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<footer>
	<div class="footer">
	    <p><strong>개발진</strong> 김규빈, 이성규, 이진원, 장세나</p>
	    <p><strong>소속</strong> 충북대학교 소프트웨어학과</p>
	    <p><strong>주소</strong> 충청북도 청주시 서원구 충대로1</p>
	</div>
</footer>
</html>