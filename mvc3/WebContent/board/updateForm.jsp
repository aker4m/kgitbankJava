<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*"%>

<%
	BoardDTO bean = (BoardDTO)request.getAttribute("dto");
%>

<div align="center">
	<table width="600" border="1" class="outline">
		<form name = "f" method="post" action="updatePro.bd" onsubmit="return check()">
		<input type="hidden" name="num" value="<%=bean.getNum()%>">
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
					<input type="button" value="목록보기" onclick="location.href='board.bd'">
				</td>
			</tr>
		</form>
	</table>
</div>
