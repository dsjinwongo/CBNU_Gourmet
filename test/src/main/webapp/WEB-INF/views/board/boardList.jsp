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
			display: block;
			width: 60%;
			margin: auto;
		}
	</style>
</head>

<body>
	<div class="title">
		<h1>게시판</h1>
	</div>
		<nav class="header">
	        <ul>
	            <li><a href="/korea/">한식</a></li>
	            <li><a href="/america/">양식</a></li>
	            <li><a href="/china/">중식</a></li>
	            <li><a href="/board/" id="blue">게시판</a></li>
	          </ul>
	    </nav>
	<div id="outter">
	 	<input type="text" id="myInput" onkeyup="Function()" placeholder="Search retaurant" title="Type in a name">
		<table id="myTable" border="1">
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
		<input type="button" value="글쓰기" style="float: right;" onclick="location.href='/write'">
	</div>
</body>
</html>