<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.book.*"%>
<!-- edit_ok.jsp -->
<jsp:useBean id="bdao" class = "my.book.BookDAO" />
<%
		String name = request.getParameter("name");
		String writer = request.getParameter("writer");
		String publisher = request.getParameter("publisher");
		
		if (name==null || writer==null || publisher==null ||
				name.trim().equals("") || writer.trim().equals("") ||
				publisher.trim().equals("")){
			response.sendRedirect("book.jsp");
			return;
		}
		int res = bdao.editBook(writer, publisher, name);
		if (res>0){%>
		<script type="text/javascript">
			alert("도서 수정 성공!! 도서목록페이지로 이동합니다.")
			location.href="list.jsp"
		</script>
	<%	}else { %>
		<script type="text/javascript">
			alert("도서 수정 실패!! 도서페이지로 이동합니다.")
			location.href="book.jsp"
		</script>
	<%	} %>