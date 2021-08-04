
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page session="false" %>
<!Doctype html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css?after">
	<title>jpGG에 오신걸 환영합니다.</title>
</head>
<body>

  		<form  action="/jpGG/a/result" method="GET">
  			<input type="text" placeholder="롤 아이디를 검색하세요!" name="summonerName">
   			<button type="submit" >검색!</button>
		</form>
		
		<form action="/jpGG/member/login" method="post">
			<input type="text" placeholder="아이디를 입력하세요" name="memberId">
			<input type="password" name="memberPassword">
			<button type="submit">로그인!</button>
		</form>
</body>
</html>