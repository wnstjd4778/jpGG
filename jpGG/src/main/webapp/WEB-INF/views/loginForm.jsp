<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session.setAttribute("isLogOn", true);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
	<p>로그인창</p>
	<form action="/jpGG/member/login" method="post">
		ID <input type="text" placeholder="아이디를 입력하세요" name="memberId"><br>
		PW <input type="password" name="memberPassword"><br> <a
			href="${contextPath }/jpGG/a/memberForm">회원가입</a>
		<button type="submit">로그인!</button>
	</form>
</body>
</html>