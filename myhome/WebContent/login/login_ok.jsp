<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.login.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id = "check" class = "my.login.LoginCheck" />
<jsp:setProperty property="*" name="check" />
<jsp:useBean id = "pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property = "pool" name="check" value="<%=pool %>" />
<jsp:useBean id = "loginOk" class="my.login.LoginOkBean" scope="session" />
<jsp:setProperty property = "pool" name="loginOk" value="<%=pool %>" />

<%
	String saveId = request.getParameter("saveId");
	if(check.getId() == null || check.getId().trim().equals("")){
		response.sendRedirect("login.jsp");
		return;
	}
	int res = check.memberCheck();
	String msg = null, url="login.jsp";
	switch(res){
	case LoginCheck.OK :
		loginOk.setId(check.getId());
		loginOk.infoSetting();
		session.setAttribute("mbid", loginOk.getId());
		session.setAttribute("mbName", loginOk.getName());
		
		Cookie ck = new Cookie("id", loginOk.getId());
		if(saveId!=null){
			ck.setMaxAge(24*60*60);
		}else{
			ck.setMaxAge(0);
		}
		response.addCookie(ck);
		
		msg = loginOk.getName()+"님, 환영합니다.";
		url = request.getContextPath()+"/index.jsp";
		break;
	case LoginCheck.NOT_ID :
		msg = check.getId()+"는 없는 아이디 입니다.";
		break;
	case LoginCheck.NOT_PWD :
		msg = check.getId()+"님의 패스워드가 틀렸습니다.";
		break;
	case LoginCheck.ERROR :
		msg = "서버 오류 발생!! 관리자에게 문의하세요";
		break;
	}
%>
<script type="text/javascript">
	alert("<%=msg%>")
	location.href="<%=url%>"	
</script>