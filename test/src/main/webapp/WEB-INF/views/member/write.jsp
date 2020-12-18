<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
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
    <title>CBNU GOURMET</title>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="./header.jsp" %>
</head>
<header>
<nav class="navbar fixed-top">
    <h2><a color="black" href="${path}/main">CBNU GOURMET</a></h2>
</nav>
</header>
<body class="mypadding">
    <form name="form1" method="post" action="${path}/insert.do">
        <table class="writetable" border="1" width="30%">
            <tr>
                <td>아이디</td>
                <td><input style='width:100%' name="userId"></td>
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input style='width:100%' type="password" name="userPw"></td>
            </tr>
            <tr>
                <td>이름</td>
                <td><input style='width:100%' name="userName"></td>
            </tr>
            <tr>
                <td>이메일주소</td>
                <td><input style='width:100%' name="userEmail"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="확인">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
</body>
<footer>
	<div class="footer">
	    <p><strong>개발진</strong> 김규빈, 이성규, 이진원, 장세나</p>
	    <p><strong>소속</strong> 충북대학교 소프트웨어학과</p>
	    <p><strong>주소</strong> 충청북도 청주시 서원구 충대로1</p>
	</div>
</footer>
</html>
