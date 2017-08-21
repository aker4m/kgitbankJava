<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.book.*"%>
<!-- edit.jsp -->
<jsp:useBean id="bdao" class="my.book.BookDAO" />
<%
		String name = request.getParameter("name");
		if (name==null || name.trim().equals("")){
			response.sendRedirect("book.jsp");
			return;
		}
		BookDTO dto = bdao.getBook(name); 
		if(dto == null){ %>
		<script type="text/javascript">
			alert("도서명이 일치하지 않습니다.")
			history.back();
		</script>	
<%		return; 
		} %>
	<div align="center">
	<hr color="green" width="300">
	<h2>도 서 수 정 페 이 지</h2>
	<hr color="green" width="300">
	<form name="f" action="edit_ok.jsp" method="post">
		<table border="1">
			<tr>
				<td>
					도서명 : <input type="text" name="name" 
					value="<%=dto.getName()%>" readOnly><br>
					지은이 : <input type="text" name="writer" 
					value="<%=dto.getWriter()%>"><br>
					출판사 : <input type="text" name="publisher" 
					value="<%=dto.getPublisher()%>"><br>
					<input type="submit" value="입력">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>			
















