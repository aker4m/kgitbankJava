<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="mbdao" class="my.member.MemberDAO" /> 
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" /> 
<jsp:setProperty property="pool" name="mbdao" value="<%=pool%>" />  
<% 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String ssn1 = request.getParameter("ssn1");
		String ssn2 = request.getParameter("ssn2");
		String id = request.getParameter("id");
		
		if (name==null || name.trim().equals("")){
			response.sendRedirect("login.jsp");
		 	return;
		}
		String dbMsg = null;
		if (id==null || id.trim().equals("")){
			dbMsg = mbdao.searchId(name, ssn1, ssn2); %>
		<script type="text/javascript">
			alert("당신의 아이디는 <%=dbMsg%> 입니다")
			self.close()
		</script>
<%		if (dbMsg==null) dbMsg="아이디가 존재하지 않습니다.";
		}else {
			dbMsg = mbdao.searchPw(name, id, ssn1, ssn2); %>
		<script type="text/javascript">
			alert("당신의 비밀번호는 <%=dbMsg%> 입니다")
			self.close()
		</script>
<%			if (dbMsg==null) dbMsg="해당정보가 일치하지 않습니다.";
		}
%>








