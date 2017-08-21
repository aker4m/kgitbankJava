<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.shop.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="catebean" class="my.shop.CategoryBean" />
<jsp:useBean id="catedto" class="my.shop.CategoryDTO" />
<jsp:setProperty property = "*" name="catedto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="catebean" value="<%=pool %>" />
<%@ include file="top.jsp"%>

<div align="center">
	<h4>카테고리 목록</h4>
	<table border="1" width="500" class="outline">
		<tr bgcolor="yellow">
			<th>번호</th>
			<th>카테고리 코드</th>
			<th>카테고리명</th>
			<th>삭제</th>
		</tr>
<%
	List<CategoryDTO> list = catebean.listCate();
	if(list == null || list.size()==0){ %>
	
<% 	}else{	
		for(CategoryDTO dto : list){%>
		<tr>
			<td><%=dto.getCnum() %></td>
			<td><%=dto.getCode() %></td>
			<td><%=dto.getCname() %></td>
			<td><a href="cate_delete.jsp?cnum=<%=dto.getCnum()%>">삭제</a></td>
		</tr>
<% 		}
	}%>
	</table>
</div>

<%@ include file="bottom.jsp"%>