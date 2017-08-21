<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>회원관리</title>
</head>
<body>
	<table border="1" width="500">
		<tr>
			<th><a href="memberSsn.mem">회원가입</a></th>
			<th><a href="memberAll.mem">회원보기</a></th>
			<th><a href="memberAll.mem?mode=find">회원찾기</a></th>
		</tr>
		<tr>
			<td colspan="3" align="center"><img src="<%=request.getContextPath() %>/hadoop.png"></td>
		</tr>
		<tr>
			<td colspan="3" align="center">회원관리프로그램</td>
		</tr>
	</table>
</body>
</html>