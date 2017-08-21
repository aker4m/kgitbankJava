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
		out.println("업로드 성공!!"); //파일 전송 성공
	}catch(IOException e){
		out.println("업로드 실패"); //파일 전송 실패시 IOException 발생
		e.printStackTrace();
	}
%>
<hr color="red">
<ul>
	<li>올린이 : <%=mr.getParameter("name") %>
	<li>파일명 : <%=mr.getFilesystemName("filename") %>
	<li>컨텐트타입 : <%=mr.getContentType("filename") %>
	<li>파일 크기 : 
		<% File file = mr.getFile("filename");
			if(file != null){
				long size = file.length();
				out.println(size);
				}%> Bytes
</ul>