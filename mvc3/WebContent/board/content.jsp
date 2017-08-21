<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.*"%>

<%
	String num = request.getParameter("num");
	if(num==null || num.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
	BoardDTO bean = (BoardDTO)request.getAttribute("dto");
%>
<%/*if (!isLogin) {%>
		<script type="text/javascript">
			alert("로그인을 하셔야 글을 볼 수 있습니다.")
			location.href="<%=request.getContextPath()%>/login/login.jsp"
		</script>			
<%		return;
		} */%>
<div align="center">
	<table width="600" border="1" class="outline">
		<caption><b>글 내용 보기</b></caption>
		<form name = "f" method="post">
			<tr>
				<th width = "25%" bgcolor="yellow">글번호</th>
				<td width = "25%"><%=bean.getNum() %></td>
				<th  width = "25%" bgcolor="yellow">조회수</th>
				<td width = "25%"><%=bean.getReadcount() %></td>
			</tr>
			<tr>
				<th bgcolor="yellow">작성자</th>
				<td><%=bean.getWriter() %></td>
				<th bgcolor="yellow">작성일</th>
				<td><%=bean.getReg_date() %></td>
			</tr>
			<tr>
				<th bgcolor="yellow">글제목</th>
				<td colspan="3"><%=bean.getSubject() %></td>
			</tr>
			<tr>
				<th bgcolor="yellow">글내용</th>
				<td colspan="3"><%=bean.getContent() %></td>
			</tr>
<%			if(bean.getFilesize()>0){
			String upPath = application.getRealPath("/board/files");%>
			<tr>
				<th bgcolor="yellow" >파일명</th>
				<td align="center" colspan="3">
					<a href="<%=upPath %>/<%=bean.getFilename() %>">
						<%=bean.getFilename() %>
					</a>
				</td>
			</tr>			
<% 			}%>
			<tr>
				<td colspan="4" align="center" bgcolor="yellow">
					<input type="button" value="답글쓰기" onclick="window.location='writeForm.bd?num=<%=bean.getNum()%>&re_step=<%=bean.getRe_step()%>&re_level=<%=bean.getRe_level()%>'">
					<input type="button" value="글수정" onclick="window.location='updateForm.bd?num=<%=bean.getNum()%>'">
					<input type="button" value="글삭제" onclick="window.location='deleteForm.bd?num=<%=bean.getNum()%>'">
					<input type="button" value="목록보기" onclick="location.href='board.bd'">
				</td>
			</tr>
		</form>
	</table>
</div>
