<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% session.setAttribute("isLogOn", true); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
<p>로그인성공</p>

<p>${isLogOn} ${memberVO.getMemberId() }   ${memberVO.getMemberPassword() }</p>
</body>
</html>