<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>쇼핑몰(관리자용)</title>
</head>
<body>
	<div align="center">
		<h2>쇼핑몰 (관리자용)</h2>
		<a href = "mall.mall">쇼핑몰홈</a> | 
		<a href = "<%=request.getContextPath() %>/index.jsp">메인홈</a>
		<table border="1" width="800" height="600">
			<tr height="8%">
				<th align = "center" width="20">
					<a href="cate_input.admin"><h4>카테고리등록</h4></a>
				</th>
				<th align = "center" width="20">
					<a href="cate_list.jsp"><h4>카테고리목록</h4></a>
				</th>
				<th align = "center" width="20">
					<a href="prod_input.jsp"><h4>상품등록</h4></a>
				</th>
				<th align = "center" width="20">
					<a href="prod_list.jsp"><h4>상품목록</h4></a>
				</th>
				<th align = "center" width="20">
					<a href = "mall.mall"><h4>쇼핑몰홈</h4></a>
				</th>
			</tr>
			<tr height="84%">
				<td colspan="5" align="center">
					
				