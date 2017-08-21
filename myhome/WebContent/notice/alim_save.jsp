<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String info = request.getParameter("info");
	String filename = request.getParameter("filename");
	
	if(filename == null || filename.trim().equals("")){
		response.sendRedirect("alim.jsp");
		return;
	}
	if(title==null || info == null || title.trim().equals("") || info.trim().equals("")){%>
	
	<script type="text/javascript">
		alert("제목과 내용을 모두 입력해 주세요!")
		location.href = "alim.jsp"
	</script>
<%		return;
	}
	String upPath = config.getServletContext().getRealPath("/notice/notice");
	File file = new File(upPath, filename);
	FileWriter fw = null;
	BufferedWriter bw = null;
	PrintWriter pw = null;
	try{
		fw = new FileWriter(file);
		bw = new BufferedWriter(fw);
		pw = new PrintWriter(bw);
		pw.println("<body bgcolor='pink'>");
		pw.println("<h2>"+title+"</h2>");
		pw.println("<p>");
		pw.println("내용 : <br>");
		pw.println(info);
		pw.println("</body>");
		pw.close();
	}catch(IOException e){
		e.printStackTrace();
		return;
	}
%>
<script type="text/javascript">
	alert("파일쓰기 완료!");
	location.href="<%=request.getContextPath()%>/index.jsp"
</script>		
		
		
		
		
		
		
		
		