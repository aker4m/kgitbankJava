<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.book.*"%>
<!-- list.jsp -->
<jsp:useBean id="bdao" class="my.book.BookDAO" />
<html>
<head>
	<title>도서목록</title>
</head>
<body>
	<div align="center">
	<hr color="green" width="300">
	<h2>도 서 목 록 보 기</h2>
	<hr color="green" width="300">
	<table border="1" width="500">
		<tr bgcolor="yellow">
			<th>도서명</th>
			<th>지은이</th>
			<th>출판사</th>
			<th>입고일</th>
		</tr>
<% 	ArrayList<BookDTO> list = bdao.listBook();  
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
<!-- 
	1. 기본 화면 모습 출력
	2. 드라이버 검색
	3. DB와 연결하여 쿼리문을 전송하고
	4. 결과를 받아서
	5. 있으면 출력, 없으면 없다라고 출력
 -->
 
 
 
 
 