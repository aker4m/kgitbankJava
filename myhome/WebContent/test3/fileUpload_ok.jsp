<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.oreilly.servlet.*, java.io.*, com.oreilly.servlet.multipart.*" %>
<!-- fileUpload_ok.jsp -->
<%
	MultipartRequest mr = null;
	DefaultFileRenamePolicy dp;
	String upPath=config.getServletContext().getRealPath("/test3");
	int len = 30*1024*1024;
	try{
		dp = new DefaultFileRenamePolicy();
		mr = new MultipartRequest(request, upPath, len, "utf-8", dp);
		out.println("���ε� ����!!"); //���� ���� ����
	}catch(IOException e){
		out.println("���ε� ����"); //���� ���� ���н� IOException �߻�
		e.printStackTrace();
	}
%>
<hr color="red">
<ul>
	<li>�ø��� : <%=mr.getParameter("name") %>
	<li>���ϸ� : <%=mr.getFilesystemName("filename") %>
	<li>����ƮŸ�� : <%=mr.getContentType("filename") %>
	<li>���� ũ�� : 
		<% File file = mr.getFile("filename");
			if(file != null){
				long size = file.length();
				out.println(size);
				}%> Bytes
</ul>