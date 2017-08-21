<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*, my.member.*"%>
<%@ include file="../top.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mbdao" class="my.member.MemberDAO"/>
<jsp:useBean id="mbdto" class="my.member.MemberDTO" />
<jsp:setProperty property="*" name = "mbdto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<%
	String search = request.getParameter("search");
	String searchString  = request.getParameter("searchString");
	/* 
	if(searchString==null || searchString.trim().equals("")){
		response.sendRedirect("memberFind.jsp");
		return;
	}
	 */
%>
<div align="center">
    <hr color="green" width="300">
	<h2>회 원 찾 기 페 이 지</h2>
	<hr color="green" width="300">
	<form name="f" action="memberFind.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="search">
						<option value="id">아이디
						<option value="name">이름
					</select>
					<input type="text" name="searchString">
					<input type="submit" value="찾기">
				</td>
			</tr>
		</table>
	</form>
	
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
<% 	List<MemberDTO> list = mbdao.findMember(search, searchString); 
	if(list == null || list.size()==0){ %>
	<tr>
		<td colspan="7"> 해당 회원이 없습니다.</td>
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