<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" />
<jsp:useBean id="mbdto" class="my.member.MemberDTO" />
<jsp:setProperty property = "*" name="mbdto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<!-- bdto.setId(request.getParameter("id")); --> 
<%
	
	if (mbdto.getName()==null || mbdto.getName().trim().equals("")){
		%>
		<script type="text/javascript">
			alert("비정상적 접근입니다.")
			history.back();
		</script>	
<%		return;
	} 
	
	int res = mbdao.insertMember(mbdto); 
	if (res>0){%>
	<script type="text/javascript">
		alert("회원 가입 성공!!")
		self.close()
	</script>
<%	}else { %>
	<script type="text/javascript">
		alert("회원 가입  실패!! 회원가입페이지로 이동합니다.")
		location.href="memberSsn.jsp"
	</script>
<%	} %>	