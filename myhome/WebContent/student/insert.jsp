<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.student.*" %>
<!-- insert.jsp -->
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="stdao" class="my.student.StudentDAO"/>
<!-- StudentDAO stdao = new StudentDAO(); -->
<jsp:useBean id="stdto" class="my.student.StudentDTO" />
<jsp:setProperty property="*" name = "stdto" />

<% 
	/* String id = request.getParameter("id");
	String name = request.getParameter("name");
	String cname = request.getParameter("cname"); */
	
	if(stdto.getId()==null || stdto.getName()==null || stdto.getCname()==null ||
			stdto.getId().trim().equals("") || stdto.getName().trim().equals("") || 
			stdto.getCname().trim().equals("")){ %>
	<script type="text/javascript">
		alert("아이디, 이름, 학급명을 모두 입력하셔야 합니다.")
		history.back(); //뒤로가기
	</script>
<%	return;
	}
	int res = stdao.insertStudent(stdto.getId(), stdto.getName(), stdto.getCname());
	if(res>0){ %>
	<script type="text/javascript">
		alert("학생 등록 성공!! 학생목록페이지로 이동합니다.")
		location.href="list.jsp"
	</script>
<%  } else {%>	
	<script type="text/javascript">
		alert("학생 등록 실패!! 학생등록페이지로 이동합니다.")
		location.href="student.jsp"
	</script>
<%  } %>
<!-- 
1. 넘어온 데이터를 받아온다
2. 받은 데이터의 유효성을 검사한다.
3. 드라이버를 검색한다.
4. DB와 연결하여 쿼리문을 전송
5. 결과에 따라 성공하면 list.jsp로 이동
     실패를 하면 student.jsp로 이동을 시킨다. 
-->

