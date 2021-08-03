<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>소환사의 정보는</h1>
<p>${summonerVO.getName() }의 ${leagueEntryDTO.getQueueType() }랭크는 ${leagueEntryDTO.getTier() } ${leagueEntryDTO.getRank() }이고 점수는 ${leagueEntryDTO.getLeaguePoints() }입니다.</p>

</body>
</html>