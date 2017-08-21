<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "my.member.*, java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<%@ include file="../top.jsp"%>

<%
	String mode = request.getParameter("mode");
	if(mode==null){
		mode="all";
	}
	String search=null, searchString=null;
%>

	<div align="center">
	<hr color="green" width="300">
	<% if(mode.equals("all")){ %>
	<h2>회 원 목 록 보 기</h2>
	<% }else{ %>
	<h2>회 원 찾 기</h2>
	<form name ="f" method="post"> <!-- action의 값이 없으면 자신한테 보냄 -->
		<select name = "search">
			<option value="id">아이디
			<option value="name">이름
		</select>
		<input type="text" name="searchString">
		<input type="submit" value="찾기">
	</form>
	<%
		search = request.getParameter("search");
		searchString = request.getParameter("searchString");
		} %>
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
<% 	List<MemberDTO> list = null;
	if(mode.equals("all")) list = mbdao.listMember();
	else list = mbdao.findMember(search, searchString);
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
		<th><a href="memberEdit.jsp?no=<%=dto.getNo()%>">수정</a> |
		<a href="memberDelete.jsp?no=<%=dto.getNo()%>">삭제</a> </th>
	</tr>
<%  } 
}	%>		
	</table>
	</div>
<%@ include file="../bottom.jsp"%>