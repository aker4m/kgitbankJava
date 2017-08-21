<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	session.invalidate(); //세션의 저장된 값을 모두 지워주세요
	//session.removeAttribute("id");
	//session.removeAttribute("pwd");
%>
<h2>로그 아웃 되었습니다.</h2>
<a href="sessionTest1.jsp">로그인</a>