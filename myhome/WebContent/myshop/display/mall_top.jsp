<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*, my.shop.*" %>
<jsp:useBean id="catebean" class = "my.shop.CategoryBean" />
<jsp:useBean id="pool" class = "my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property ="pool" name="catebean" value="<%=pool %>" />

<%
	List<CategoryDTO> list = catebean.listCate();
	if(list == null || list.size()==0){ %>
		<script type="text/javascript">
			alert("카테고리를 먼저 등록해 주세요.")
			location.href = "<%=request.getContextPath() %>/index.jsp"
		</script>	
<%		return;
	} %>
	
<html>
<head>
	<title>쇼핑몰홈</title>
	<link rel="stylesheet" type="text/css" href="../../style.css">
</head>
<body>
	<div align="center">
		<table border="1" class="outline" width="800" height="600">
			<tr height="7%"><td align="center" colspan="2">
				<a href="<%=request.getContextPath() %>/index.jsp">HOME</a> | 
				<a href="<%=request.getContextPath() %>/myshop/admin/main.jsp">관리자홈</a> | 
				<a href="<%=request.getContextPath() %>/myshop/display/mall.jsp">쇼핑몰홈</a> | 
				<a href="<%=request.getContextPath() %>/myshop/display/mall_cartList.jsp">장바구니</a> | 
				<a href="<%=request.getContextPath() %>/company.jsp">회사소개</a></td></tr>
			<tr height="86%"><td valign="top" align = "center" width="20%">
				tree/view
				<table border="1" class="outline" >
<% 			for(CategoryDTO dto : list){%>
				<tr>
					<td>
						<a href="mall_cgProdList.jsp?code=<%=dto.getCode() %>">
						<%=dto.getCname() %>[<%=dto.getCode() %>]</a>
					</td>
				</tr>
<% 			}%>
				</table>
			</td><td valign="top" align="center">
			
			
			
			