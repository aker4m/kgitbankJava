<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "member.*, java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String mode = request.getParameter("mode");
	if(mode==null){
		mode="all";
	}
	String search=null, searchString=null;
%>
	<link rel="stylesheet" type="text/css" href="style.css">
	<div align="center">
	<hr color="green" width="300">
	<% if(mode.equals("all")){ %>
	<h2>회 원 목 록 보 기</h2>
	<% }else{ %>
	<h2>회 원 찾 기</h2>
	<form name ="f" method="post" action="memberAll.mem?mode=find"> <!-- action의 값이 없으면 자신한테 보냄 -->
		<select name = "search">
			<option value="id">아이디
			<option value="name">이름
		</select>
		<input type="text" name="searchString">
		<input type="submit" value="찾기">
	</form>
<%	} %>	
	<hr color="green" width="300">
	<table border="1" width="600" class="outline">
		<tr bgcolor="yellow">
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>가입일</th>
			<th>수정|삭제</th>
		</tr>
<% 	
	List<MemberDTO> list = (List)request.getAttribute("list");
	if(list == null || list.size()==0){ %>
	<tr>
		<td colspan="7"> 등록된 회원이 없습니다.</td>
	</tr>
<%  }else{ 
		for(MemberDTO dto : list){%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getId() %></td>
			<td><%=dto.getEmail() %></td>
			<td><%=dto.getAllHp() %></td>
			<td><%=dto.getJoindate() %></td>
			<th>
				<a href="member_update.mem?no=<%=dto.getNo()%>">수정</a> |
				<a href="member_delete.mem?no=<%=dto.getNo()%>">삭제</a> 
			</th>
		</tr>
<% 		} 
	}	%>		
	</table>
	</div>
