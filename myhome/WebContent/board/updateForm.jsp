<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.board.*"%>
<%@ include file="../../top.jsp"%>
<jsp:useBean id="bdBean" class="my.board.BoardDataBean" />

<%
	String num = request.getParameter("num");
	if(num==null || num.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
	BoardDBBean bean = bdBean.getBoard(Integer.parseInt(num), "update");
%>

<div align="center">
	<table width="600" border="1" class="outline">
		<form name = "f" method="post" action="updatePro.jsp" onsubmit="return check()">
		<input type="hidden" name="num" value="<%=num%>">
			<tr>
				<td colspan="2" align="center" bgcolor="yellow"><b>글쓰기</b></td>
			</tr>
			<tr>
				<th width="15%" bgcolor="yellow">이 름</th>
				<td><input type="text" name="writer" value="<%=bean.getWriter()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">제 목</th>
				<td><input type="text" size="70" name="subject" value="<%=bean.getSubject()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">Email</th>
				<td><input type="text" size="70" name="email" value="<%=bean.getEmail()%>"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">내 용</th>
				<td><textarea name="content" cols="70" rows="13"><%=bean.getContent()%></textarea></td>
			</tr>
			<tr>
				<th bgcolor="yellow">비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="yellow">
					<input type="submit" value="글수정">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</form>
	</table>
</div>
<%@ include file="../../bottom.jsp"%>