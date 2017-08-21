<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application"/>
<jsp:setProperty property="pool" name="mbdao" value="<%=pool %>" />
<%
	String no = request.getParameter("no");
	if(no==null || no.trim().equals("")){
		response.sendRedirect("memberAll.jsp");
		return;
	}
	
	int res = mbdao.deleteMember(Integer.parseInt(no));
	if (res>0){%>
	<script type="text/javascript">
		alert("회원 삭제 성공!! 회원목록페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>
<%	}else { %>
	<script type="text/javascript">
		alert("회원 삭제 실패!! 회원목록페이지로 이동합니다.")
		location.href="memberAll.jsp"
	</script>
<%	} %>





