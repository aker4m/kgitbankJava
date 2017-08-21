<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.book.*"%>
<!-- delete.jsp -->
<jsp:useBean id="bdao" class="my.book.BookDAO" />
<%
	String name = request.getParameter("name");

	if (name==null || name.trim().equals("")){%>
	<script type="text/javascript">
		alert("도서명을 입력해 주세요")
		history.back();
	</script>		
<%	}
	int res = bdao.deleteBook(name); 
	if (res>0){%>
	<script type="text/javascript">
		alert("도서 삭제 성공!! 도서목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>
<%	}else { %>
	<script type="text/javascript">
		alert("도서 삭제 실패!! 도서삭제페이지로 이동합니다.")
		location.href="book.jsp"
	</script>
<%	} %>





	