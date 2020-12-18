<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
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
</head>
<body>
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

<div class="container-custom">
    <div class="image-slide">
        <div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel">
          <div class="carousel-inner">
            <div id="fisrtim" class="carousel-item active">
              <img class="d-block w-100" src="https://github.com/senajang/naverplacecrawler/blob/master/KakaoTalk_20201217_033909696.jpg?raw=true" alt="First slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
          </div>
        </div>
    </div>
    <div class="item-list item-list01 row">
    <c:choose>
    <c:when test="${sessionScope.userId == null}">
    	<div class="item item01" onclick="location.href='${path}/login.do';" style="cursor:pointer;">
    </c:when>
    <c:otherwise>
        <div class="item item01" onclick="location.href='${path}/board';" style="cursor:pointer;">
    </c:otherwise>
	</c:choose>
            <p class="item-maintext">CBNU 미식가 게시판</p>
            <p class="item-subtext">CBNU  gourmet  board</p>
            <div class="item-image item-image-set1">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/chef.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item02"onclick="location.href='${path}/korea';" style="cursor:pointer;">
            <p class="item-maintext">한식</p>
            <p class="item-subtext">Korean Food</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/rice.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item03"onclick="location.href='${path}/snack';" style="cursor:pointer;">
            <p class="item-maintext">분식</p>
            <p class="item-subtext">Snack Menu</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/dduk.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item04"onclick="location.href='${path}/japan';" style="cursor:pointer;">
            <p class="item-maintext">일식</p>
            <p class="item-subtext">Japanese Food</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/sushi.jpg?raw=true" width="150">
            </div>
        </div>
    	<div class="item-list item-list05 row" onclick="location.href='${path}/chicken';" style="cursor:pointer;">
            <p class="item-maintext">치킨</p>
            <p class="item-subtext">Chicken</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/chicken.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item06" onclick="location.href='${path}/america';" style="cursor:pointer;">
            <p class="item-maintext">피자/양식</p>
            <p class="item-subtext">Pizza/Western Food</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/pizza.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item07" onclick="location.href='${path}/china';" style="cursor:pointer;">
            <p class="item-maintext">중국집</p>
            <p class="item-subtext">Chinese Food</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/zzazang.jpg?raw=true" width="150">
            </div>
        </div>
        <div class="item item-set item08" onclick="location.href='${path}/dessert';" style="cursor:pointer;">
            <p class="item-maintext">디저트</p>
            <p class="item-subtext">Dessert</p>
            <div class="item-image">
                <img src="https://github.com/dsjinwongo/Java_Project/blob/seongkyu/cake.jpg?raw=true" width="150">
            </div>
        </div>
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