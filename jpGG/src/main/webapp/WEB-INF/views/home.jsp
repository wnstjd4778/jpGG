
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!Doctype html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<title>jpGG에 오신걸 환영합니다.</title>
</head>
<body>
	<div style="text-align:right; background-color:green;">
	<c:choose>
	<c:when test="${isLogOn == true }">
	<a href="${contextPath }/jpGG/mypage/home">마이페이지</a>
	<a href="${contextPath }/jpGG/member/logout">로그아웃</a></c:when>
	<c:otherwise>
	<form action="/jpGG/member/login" method="post">
		ID <input type="text" placeholder="아이디를 입력하세요" name="memberId"><br>
		PW <input type="password" name="memberPassword"><br>
		<a href="${contextPath }/jpGG/a/memberForm">회원가입</a>
		<button type="submit">로그인!</button>
		
	</form>
	</c:otherwise>
	</c:choose>
	</div>
	<div style="background-color:yellow;">
		<table style="text-align:center; border-spacing:30px; margin-left:auto;margin-right:auto">
			<tr>
				<th><a href="">챔피언분석</a></th>
				<th><a href="">통계</a></th>
				<th><a href="">랭킹</a></th>
				<th><a href="">멀티서치</a></th>
			</tr>
		</table>
	</div>
	
	<div style="padding-top: 20px; text-align: center; font-size: 80px;">jpGG</div>
	<div style="text-align: center;font-size:30px;">
		<form action="/jpGG/a/result" method="GET">
			<input type="text" placeholder="롤 아이디를 검색하세요!" name="summonerName">
			<button type="submit">검색!</button>
		</form>
	</div>
</body>
</html>