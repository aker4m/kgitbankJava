<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.book.*"%>
<!-- find.jsp -->
<jsp:useBean id="bdao" class = "my.book.BookDAO" />
<%
	String search = request.getParameter("search");
	String searchString = request.getParameter("searchString");
	if (search==null || search.trim().equals("") ||
			searchString==null || searchString.trim().equals("")){
		response.sendRedirect("book.jsp");
		return;
	}
%>
<html>
<head>
	<title>도서찾기</title>
</head>
<body>
	<div align="center">
	<hr color="green" width="300">
	<h2>도 서 찾 기</h2>
	<hr color="green" width="300">
	<table border="1" width="500">
		<tr bgcolor="yellow">
			<th>도서명</th>
			<th>지은이</th>
			<th>출판사</th>
			<th>입고일</th>
		</tr>
<% 	ArrayList<BookDTO> list = bdao.findBook(search, searchString); 
	if(list == null || list.size()==0){ %>
	<tr>
		<td colspan="4"> 등록된 도서가 없습니다.</td>
	</tr>
<%  }else{ 
	for(BookDTO dto : list){%>
	<tr>
		<td><%=dto.getName() %></td>
		<td><%=dto.getWriter() %></td>
		<td><%=dto.getPublisher() %></td>
		<td><%=dto.getIndate() %></td>
	</tr>
<%  } 
}	%>	
	
	</table>
	</div>
</body>
</html>




