<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입창</title>
</head>
<body>
<form action="${contextPath }/jpGG/member/addMember" method="POST">
	<table align="center">
		<tbody>
			<tr>
				<td>아이디</td>
				<td><input name="memberId" type="text"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input name="memberPassword" type="password"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input name="memberEmail" type="text"></td>
			</tr>
			<tr>
				<td>휴대폰번호</td>
				<td><input name="memberPhoneNumber" type="text"></td>
			</tr>		
		</tbody>
	</table>
	<br><br>
	<table align=center>
		<tr >
			<td >
				<input type="submit"  value="회원 가입">
				<input  type="reset"  value="다시입력">
			</td>
		</tr>
	</table>
</form>

</body>
</html>