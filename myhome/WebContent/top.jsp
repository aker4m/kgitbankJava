<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>홈페이지</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
	<script type="text/javascript">
		function openMember(){
			window.open('<%=request.getContextPath() %>/member/memberSsn.jsp' , "check", "width=650, height=400")
		}
		function openNotice(){
			window.open('<%=request.getContextPath() %>/notice/alim_read.jsp' , "alim", "width=400, height=300")
		}
	</script>
</head>
<%
	boolean isLogin = false;
	String mbid=(String)session.getAttribute("mbid");
	String mbName = (String)session.getAttribute("mbName");
	if(mbid !=null && mbName != null){
		isLogin = true;
	}
%>
<body>
	<div align="center">
		<table border="1" width="800" height="600">
			<tr height="10%">
				<td colspan="2" align = "center">
					<a href="<%=request.getContextPath() %>/index.jsp">main</a> | 
<%	if(isLogin){ %>
					<a href="<%=request.getContextPath() %>/login/logout.jsp">로그아웃</a> |
<%	}else { %>
					<a href="<%=request.getContextPath() %>/login/login.jsp">로그인</a> |
<%	} %>
					<a href="javascript:openMember()">회원가입</a> |
					<a href="<%=request.getContextPath() %>/member/memberAll.jsp">회원보기</a> |  
					<a href="<%=request.getContextPath() %>/member/memberAll.jsp?mode=find">회원찾기</a> |
					<a href="<%=request.getContextPath()%>/notice/alim.jsp">공지쓰기</a> |
					<a href="javascript:openNotice()">공지읽기</a> |
					<a href="<%=request.getContextPath()%>/board/list.jsp">게시판</a> |
					<a href="<%=request.getContextPath()%>/myshop/display/mall.jsp">쇼핑몰홈</a> |
					<a href="<%=request.getContextPath() %>/company.jsp">회사소개</a>
				</td>
			</tr>
			<tr>
				<td width="20%" valign="top" align="center">
			<jsp:include page ="/count/count.jsp" /><br> 				
<%	if(isLogin){ %>
				<b>[<%=mbid %>]님 환영합니다.</b>
<%	}else { %>
				로그인을 해 주세요.
<%	} %>
				
				</td>
				<td width="80%">
			
				
				
				
				
				
				
				
				
				
				
				