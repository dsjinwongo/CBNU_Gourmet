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
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link href="<c:url value="/resources/css/mystyle.css" />" rel="stylesheet">
	<title>게시판 목록</title>
	<script>
        function Function() {
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}
    </script>
	<style>
		h2 {
			text-align: center;
		}
		table {
			width: 100%;
		}
		#outter {
			padding-top:3%;
			padding-bottom:3%;
			display: block;
			width: 60%;
			margin: auto;
		}
	</style>
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
<body>
	<div id="outter">
	 	<input type="text" id="myInput" onkeyup="Function()" placeholder="Search retaurant" title="Type in a name" >
	 	<br><br>
		<table id="myTable" border="1" >
			<tr>
				<td>No.</td>
				<td width="50%">음식점</td>
				<td>작성자</td>
				<td>등록일</td>
				<td>조회수</td>		
			</tr>
			<c:forEach items="${viewAll }" var="list">
				<tr>
				  <td>${list.seq }</td>
				  <td><a href="/detail?seq=${list.seq }">${list.title }</a></td>
				  <td>${list.writer }</td>
				  <td><fmt:formatDate value="${list.regdate }" pattern="yyyy.MM.dd"/> </td>
				  <td>${list.cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<input type="button" value="글쓰기" style="float: right;" onclick="location.href='/write'">
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