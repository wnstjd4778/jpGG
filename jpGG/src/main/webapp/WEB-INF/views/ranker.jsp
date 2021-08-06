<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>랭커 순위</title>
</head>
<body>
<h1>랭커순위 페이지</h1>
<table border="1">
	<thead>
		<tr>
			<th>순위</th>
			<th>닉네임</th>
			<th>포인트</th>
			<th>승리</th>
			<th>패배</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i" begin="0" end="99" step="1">
			<tr>
				<td>${i+1}</td>
				<td width="200">${list.get(i).getSummonerName() }</td>
				<td width="100">${list.get(i).getLeaguePoints() }</td>
				<td width="100">${list.get(i).getWins() }</td>
				<td width="100">${list.get(i).getLosses() }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>