<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.student.*, java.util.*" %>
<!-- find.jsp -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="stdao" class="my.student.StudentDAO"/>
<!-- StudentDAO stdao = new StudentDAO(); -->
<jsp:useBean id="stdto" class="my.student.StudentDTO" />
<jsp:setProperty property="*" name = "stdto" />
<%
	/* String name = request.getParameter("name"); */
	
	if(stdto.getName()==null || stdto.getName().trim().equals("")){
		response.sendRedirect("student.jsp");
		return;
	}
	%>
<html>
<head>
	<title>학생찾기</title>
</head>
<body>
	<div align="center">
		<hr color="green" width="300">
		<h2><%=stdto.getName() %>학 생 찾 기</h2>
		<hr color="green" width="300">
		<table border="1" width="500">
			<tr bgcolor="YELLOW">
				<th>아이디</th>
				<th>학생명</th>
				<th>학급명</th>
			</tr>
<%	
	ArrayList<StudentDTO> find = stdao.findStudent(stdto.getName());
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
			<%=stdto.getName() %> 학생은 총 <%=find.size() %>명 있습니다.
	</tr>
<% }	%>
	
	</table>
	</div>
</body>
</html>