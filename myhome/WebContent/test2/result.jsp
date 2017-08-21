<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	if(id.equals("admin")){
		if(pwd.equals("1234")){
			session.setAttribute("id", "admin");
			session.setAttribute("pwd", "1234");
			out.println("<font color = red>");
			out.println("["+id+"]님, 환영합니다.");
			out.println("</font>");
			out.println("<a href = 'sessionTest2.jsp'>다음으로</a>");
		}else{
			out.println("<font color = red>");
			out.println("["+id+"]의 비밀번호가 틀렸습니다.");
			out.println("</font>");
			out.println("<a href = 'sessionTest1.jsp'>다시입력</a>");
		}
	}else{
		out.println("<font color = red>");
		out.println("["+id+"]는 존재하지 않습니다.");
		out.println("</font>");
		out.println("<a href = 'sessionTest1.jsp'>다시입력</a>");
	}
	
%>