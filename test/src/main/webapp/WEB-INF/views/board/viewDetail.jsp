<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
    <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <style type="text/css">
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
	</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세보기</title>
</head>
<style>
	h2 { text-align: center;}
  table { width: 100%;}
  textarea { width: 100%;}
 	#outter {
		display: block;
		width: 30%;
		margin: auto;
		padding-bottom: 5%;
	}
</style>

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

<h2>게시판</h2>
<br><br>
<div id="outter">
	<table bordercolor=#FFAA28 border="1">
		<tr>
			<td>제목: ${board.title }</td>
		</tr>
		<tr>
			<td>
				작성자: ${board.writer }
				<span style="float: right;"><fmt:formatDate value="${board.regdate }" pattern="yyyy.MM.dd"/></span>
			</td>
		</tr>
		<tr>
			<td><div style="height: 300px; margin: 10px; display: inline-block">${board.review }</div></td>
		</tr>
	</table>
	<br>
	<input type="button" value="글 목록" style="float: right;" onclick="location.href='board';"> 
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