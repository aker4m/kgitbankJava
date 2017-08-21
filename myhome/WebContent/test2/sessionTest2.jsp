<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = (String)session.getAttribute("id"); //오브젝트 타입
	String pwd = (String)session.getAttribute("pwd");
	if(id==null || pwd==null){ %>
		<script type="text/javascript">
			alert("먼저 로그인 해 주세요!")
			location.href="sessionTest1.jsp"
		</script>
<%	return; 	
	} %>
<h2>회 원 인 증 페 이 지</h2>
<font color="red">
	<b>회원들만 볼 수 있는 페이지 입니다.</b><br>
	<b>로그인이 안되어 있으면 들어 올 수 없는 페이지 입니다.</b><br>
	<b>소정아 언제 노래 할꺼니?</b><br>
</font>
<br>
<a href ="sessionTest3.jsp">로그아웃</a>