<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.book.*"%>
<!-- insert.jsp -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bdao" class="my.book.BookDAO" />
<jsp:useBean id="bdto" class="my.book.BookDTO" />
<jsp:setProperty property = "*" name="bdto" />
<!-- bdto.setId(request.getParameter("id")); --> 
<%
	/* String name = request.getParameter("name");
	String writer = request.getParameter("writer");
	String publisher = request.getParameter("publisher"); */
	
	if (bdto.getName()==null || bdto.getWriter()==null || bdto.getPublisher()==null ||
			bdto.getName().trim().equals("") || bdto.getWriter().trim().equals("") ||
			bdto.getPublisher().trim().equals("")){%>
		<script type="text/javascript">
			alert("도서명, 지은이, 출판사를 모두 입력하셔야 합니다.")
			history.back();
		</script>	
<%		return;
	}
	
	int res = bdao.insertBook(bdto.getName(), bdto.getWriter(), bdto.getPublisher());
	if (res>0){%>
	<script type="text/javascript">
		alert("도서 등록 성공!! 도서목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>
<%	}else if(res == 0 ) { %>
	<script type="text/javascript">
		alert("도서 등록 실패!! 도서등록페이지로 이동합니다.")
		location.href="book.jsp"
	</script>
<%	} else { %>
	<script type="text/javascript">
		alert("도서명이 존재합니다. 도서등록페이지로 이동합니다.")
		location.href="book.jsp"
	</script>
<%	}%>	
<!-- 
	1. 넘어온 데이타를 받아온다
	2. 받은 데이타의 유효성을 검사한다
	3. 드라이버를 검색한다
	4. DB와 연결하여 쿼리문을 전송
	5. 결과에 따라 성공하면 list.jsp로 이동
	   실패를 하면 student.jsp로 이동을 시킨다
 -->
 
 
 
 
 
 
 
 
 