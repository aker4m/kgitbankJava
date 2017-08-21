<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bdBean" class="my.board.BoardDataBean" />

<%@ page import="com.oreilly.servlet.*, java.io.*, com.oreilly.servlet.multipart.*" %>
<%	
	MultipartRequest mr = null;
	String upPath = config.getServletContext().getRealPath("/board/files");
	int len = 1024 *1024 *1024;
	try{
		mr = new MultipartRequest(request, upPath, len, "UTF-8");
	}catch(IOException e){
		e.printStackTrace();
	}
	String writer = mr.getParameter("writer");
	if(writer==null || writer.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
	String ip = request.getRemoteAddr();
	int res = bdBean.writeBoard(mr, ip);
	if(res>0){%>
	<script type="text/javascript">
		alert("게시글 등록 성공!! 게시판으로 이동합니다.")
		location.href="list.jsp"
	</script>
<%	}else { %>
	<script type="text/javascript">
		alert("게시글 등록 실패!! 게시판으로 이동합니다.")
		location.href="list.jsp"
	</script>
<%	} %>	