<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import = "my.student.*, java.util.*" %>
<!-- list.jsp -->
<jsp:useBean id="stdao" class="my.student.StudentDAO" />
<html>
<head>
	<title>학생목록</title>
</head>
<body>
	<div align="center">
	<hr color="green" width="300">
	<h2>학 생 목 록 보 기</h2>
	<hr color="green" width="300">
	<table border="1" width="500">
		<tr bgcolor="YELLOW">
			<th>아이디</th>
			<th>학생명</th>
			<th>학급명</th>
		</tr>
<% 	ArrayList<StudentDTO> list = stdao.listStudent(); 
	if(list == null || list.size()==0){ %>
	<tr>
		<td colspan="3"> 등록된 학생이 없습니다.</td>
	</tr>
<%  }else{ 
	for(StudentDTO dto : list){%>
	<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getCname() %></td>
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