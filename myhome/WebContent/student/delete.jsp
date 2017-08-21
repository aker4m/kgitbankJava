<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.student.*, java.util.*" %>
<!-- delete.jsp -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="stdao" class="my.student.StudentDAO"/>
<!-- StudentDAO stdao = new StudentDAO(); -->
<jsp:useBean id="stdto" class="my.student.StudentDTO" />
<jsp:setProperty property="*" name = "stdto" />

<%
	/* String id = request.getParameter("id"); */
	
	if(stdto.getId()==null || stdto.getId().trim().equals("")){%>
	<script type="text/javascript">
		alert("아이디를 입력해 주세요")
		history.back();
	</script>
<% 	}	
	int res = stdao.deleteStudent(stdto.getId());
	if(res>0){ %>
	<script type="text/javascript">
		alert("학생 삭제 성공!! 학생등록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>
<%  } else { %>	
	<script type="text/javascript">
		alert("학생 삭제 실패!! 학생등록페이지로 이동합니다.")
		location.href="student.jsp"
	</script>
<%  } %>