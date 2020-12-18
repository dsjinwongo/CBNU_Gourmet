<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
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
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <style type="text/css">
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
	</style>

    <title>CBNU GOURMET</title>
    
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script>
    $(document).ready(function(){
        $("#btnLogin").click(function(){
            // 태크.val() : 태그에 입력된 값
            // 태크.val("값") : 태그의 값을 변경 
            var userId = $("#userId").val();
            var userPw = $("#userPw").val();
            if(userId == ""){
                alert("아이디를 입력하세요.");
                $("#userId").focus(); // 입력포커스 이동
                return; // 함수 종료
            }
            if(userPw == ""){
                alert("아이디를 입력하세요.");
                $("#userPw").focus();
                return;
            }
            // 폼 내부의 데이터를 전송할 주소
            document.form1.action="${path}/loginCheck.do"
            // 제출
            document.form1.submit();
        });
    });
</script>
<style type="text/css">
	 a:link { color: red; text-decoration: none;}
	 a:visited { color: black; text-decoration: none;}
	 a:hover { color: blue; text-decoration: underline;}
</style>
</head>
<header>
<nav class="navbar fixed-top">
    <h2><a color="black" href="${path}/main">CBNU GOURMET</a></h2>
</nav>
</header>
<body>
	<div class="main-container">
		<div class="main-wrap">
		<header>
			<div class="logo-wrap">
				<img src="https://github.com/senajang/naverplacecrawler/blob/master/KakaoTalk_20201217_033909696.jpg?raw=true">
			</div>
		</header>
			<section class="login-input-section-wrap">
			<form name="form1" method="post">
				<div class="login-input-wrap">	
					<input name="userId" id="userId">
				</div>
				<div class="login-input-wrap password-wrap">	
					<input type="password" name="userPw" id="userPw">
				</div>
				<div class="login-button-wrap">
					<button type="button" id="btnLogin">로그인</button>
					<c:if test="${msg == 'failure'}">
                    <div style="color: red">
                        아이디 또는 비밀번호가 일치하지 않습니다.
                    </div>
	                </c:if>
	                <c:if test="${msg == 'logout'}">
	                    <div style="color: red">
	                        로그아웃되었습니다.
	                    </div>
	                </c:if>
	        	</div>
	        	</form>
			</section>
		</div>
	</div>
</body>
<footer>
	<div class="copyright-wrap">
		<span>Copyright ©JAVAGETTI. All Rights Reserved.</span>
		<p><strong>개발진</strong> 김규빈, 이성규, 이진원, 장세나</p>
	    <p><strong>소속</strong> 충북대학교 소프트웨어학과</p>
	 	<p><strong>주소</strong> 충청북도 청주시 서원구 충대로1</p>
	  	<p><strong>UPDATE</strong> 11a.m, 6p.m
	</div>
</footer>
</html>
