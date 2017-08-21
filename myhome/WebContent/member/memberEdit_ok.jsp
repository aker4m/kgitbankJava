<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" />
<jsp:useBean id="mbdto" class="my.member.MemberDTO" />
<jsp:setProperty property = "*" name="mbdto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<!-- bdto.setId(request.getParameter("id")); --> 

<%
	if (mbdto.getName()==null || mbdto.getName().trim().equals("") || 
		mbdto.getPasswd() == null || mbdto.getPasswd().trim().equals("")){	%>
		<script type="text/javascript">
			alert("이름과 비밀번호를 입력하세요.")
			history.back();
		</script>	
<%		return;
	} 
	
	int res = mbdao.editMember(mbdto);  
	if (res>0){%>
		<script type="text/javascript">
			alert("회원정보 수정 성공!! 회원목록페이지로 이동합니다.")
			location.href="memberAll.jsp"
		</script>
<%	}else { %>
		<script type="text/javascript">
			alert("회원정보 수정 실패!! 회원목록페이지로 이동합니다.")
			location.href="memberAll.jsp"
		</script>
<%	} %>
