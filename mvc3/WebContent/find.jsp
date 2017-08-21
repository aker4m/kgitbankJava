<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="student.*, java.util.*" %>
<!-- find.jsp -->

<html>
<head>
	<title>학생찾기</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2>학 생 찾 기</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr bgcolor="YELLOW">
				<th>아이디</th>
				<th>학생명</th>
				<th>학급명</th>
			</tr>
<%	
	ArrayList<StudentDTO> find = (ArrayList)request.getAttribute("find");
	if(find == null || find.size()==0){ %>
	<tr>
		<td colspan="3"> 등록된 학생이 없습니다.</td>
	</tr>
<%  }else{ 
	for(StudentDTO dto : find){ %>
	<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getCname() %></td>
	</tr>
<% 	} %>
	<tr>
		<td colspan="3">
			학생은 총 <%=find.size() %>명 있습니다.
	</tr>
<% }	%>
	
	</table>
	</div>
</body>
</html>