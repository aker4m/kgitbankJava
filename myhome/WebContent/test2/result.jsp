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
			out.println("["+id+"]��, ȯ���մϴ�.");
			out.println("</font>");
			out.println("<a href = 'sessionTest2.jsp'>��������</a>");
		}else{
			out.println("<font color = red>");
			out.println("["+id+"]�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			out.println("</font>");
			out.println("<a href = 'sessionTest1.jsp'>�ٽ��Է�</a>");
		}
	}else{
		out.println("<font color = red>");
		out.println("["+id+"]�� �������� �ʽ��ϴ�.");
		out.println("</font>");
		out.println("<a href = 'sessionTest1.jsp'>�ٽ��Է�</a>");
	}
	
%>