<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	if(num==null || num.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
%> 
<div align="center">
	<form name="f" action="deletePro.bd" method="post">
	<input type="hidden" name="num" value="<%=num %>">
	<table border="1" class="outline">
		<caption><b>글삭제</b></caption>
		<tr>
			<th bgcolor="yellow">비밀번호를 입력해주세요.</th>
		</tr>
		<tr>
			<td>비밀번호 : <input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="yellow">
				<input type="submit" value="글삭제">
				<input type="button" value="목록보기" onclick="location.href='board.bd'">
			</td>
		</tr>
	</table>
	</form>
</div>
