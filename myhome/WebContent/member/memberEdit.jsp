<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "my.member.*" %>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<%@ include file="../top.jsp"%>
<%
	String no = request.getParameter("no");
	if(no==null || no.trim().equals("")){
		response.sendRedirect("memberAll.jsp");
		return;
	}
	MemberDTO dto = mbdao.getMember(Integer.parseInt(no));
%>	
	<div align="center">
	<hr color="green" width="300">
	<h2>회 원 수 정 페 이 지</h2>
	<hr color="green" width="300">
	<form name="f" action="memberEdit_ok.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					<input type="hidden" name = "no" value="<%=no %>">
					이름 : <input type="text" name="name" value="<%=dto.getName()%>"><br>
					비밀번호 : <input type="password" name="passwd" ><br>
					이메일 : <input type="text" name="email" value="<%=dto.getEmail()%>"><br>
					연락처 : <input type="text" name="hp1" value="<%=dto.getHp1()%>" size ="3" maxlength="3"> -
					<input type="text" name="hp2" value="<%=dto.getHp2()%>" size ="4" maxlength="4"> -
					<input type="text" name="hp3" value="<%=dto.getHp3()%>" size ="4" maxlength="4">
					<br>
					<input type="submit" value="입력">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>			
<%@ include file="../bottom.jsp"%>