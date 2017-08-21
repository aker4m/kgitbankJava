<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>회원관리프로그램</title>
	<script type="text/javascript">
		function openMember(){
			window.open('<%=request.getContextPath() %>/member/memberSsn.jsp' , "check", "width=650, height=400")
		}
	</script>
</head>
<body>
<table>
	<div align="center">
		<h2>
			<a href="javascript:openMember()">회원가입</a> |
			<a href="<%=request.getContextPath() %>/member.do?command=list">회원보기</a> |  
			<a href="<%=request.getContextPath() %>/member.do?command=find">회원찾기</a>
		</h2>
	</div>
</table>
</body>
</html>