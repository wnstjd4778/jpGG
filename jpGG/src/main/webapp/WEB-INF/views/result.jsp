<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${summonerVO.getName() }의전적</title>
</head>
<body>
	<div style="background-color: green; color =white; font-weight: bold;">소환사
		정보는</div>
	<div align="center">
		<h1>${summonerVO.getName()}</h1>
	</div>
	<c:choose>
		<c:when test="${ leagueEntryDTOList.size() == 1}">
			<c:set var="size" value="0" />
		</c:when>
		<c:when test="${ leagueEntryDTOList.size() == 2}">
			<c:set var="size" value="1" />
		</c:when>
	</c:choose>
	<c:forEach var="i" begin="0" end="${size }" step="1">
		<table border="1" align="center">
			<thead>
				<tr>
					<th colspan="2">
						<c:choose>
							<c:when
								test="${leagueEntryDTOList.get(i).getQueueType() == 'RANKED_SOLO_5x5' }">솔로랭크</c:when>
							<c:when
								test="${leagueEntryDTOList.get(i).getQueueType() == 'RANKED_FLEX_SR' }">자유 랭크</c:when>
						</c:choose>
					</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><img alt="랭크 엠블램"
						src="C:\Users\wnstj\git\jpGG\jpGG\src\main\webapp\img\emblems/Emblem_${leagueEntryDTOList.get(i).getTier()}.png"
						width="200" height="200"></td>
					<td width="700">
						<h2>${leagueEntryDTOList.get(i).getTier() }
							${leagueEntryDTOList.get(i).getRank() }<br>
							${leagueEntryDTOList.get(i).getLeaguePoints() }LP /
							${leagueEntryDTOList.get(i).getWins() }승 ${leagueEntryDTOList.get(i).getLosses() }패<br>
							승률
							<fmt:formatNumber
								value="${leagueEntryDTOList.get(i).getWins() *100 / (leagueEntryDTOList.get(i).getWins()+leagueEntryDTOList.get(i).getLosses()) }"
								pattern="#.0" />
							%
						</h2>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		<br>
	</c:forEach>
</body>
</html>