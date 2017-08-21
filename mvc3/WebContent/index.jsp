<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>관리프로그램</title>
</head>
<body>
	<h1>MVC로 해보는 DB예제 프로그램</h1>
	<ul>
	<%	if(session.getAttribute("mbid")==null){ %>
		<li><a href="login.app">로그인</a>
	<%	}else{ %>
		<li><a href ="logout.login">로그아웃</a>
	<%	} %>
		<li><a href="student.app">학생관리프로그램</a>
		<li><a href="member.app">회원관리프로그램</a>
		<li><a href="board.app">게시판관리프로그램</a>
	<%	if(session.getAttribute("mbid")!=null && session.getAttribute("mbid").equals("admin")){ %>	
		<li><a href="shopAdmin.app">쇼핑몰(관리자)페이지</a>
	<%	} %>	
		<li><a href="shop.app">쇼핑몰프로그램</a>
	</ul>
</body>
</html>