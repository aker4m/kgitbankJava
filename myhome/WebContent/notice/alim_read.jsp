<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.io.*"%>
<!-- alim_read.jsp -->
<%
	String filename = null;
	/* 
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	filename = sdf.format(date)+".html";
	 */
	Calendar cal = Calendar.getInstance();
	int yy = cal.get(Calendar.YEAR);
	int mm = cal.get(Calendar.MONTH)+1;
	int dd = cal.get(Calendar.DAY_OF_MONTH);
	filename = String.valueOf(yy);
	if(mm<10) filename += "0"+mm;
	else filename +=mm;
	if(dd<10) filename += "0"+dd;
	else filename +=dd;
	filename += ".html";
	
	String upPath = config.getServletContext().getRealPath("/notice/notice");
	File file = new File(upPath, filename);
	
	FileReader fr = null;
	BufferedReader br = null;
	try{
		fr = new FileReader(file);
		br = new BufferedReader(fr);
		String content="";
		while(true){
			content = br.readLine();
			if(content == null) break;
			out.println(content+"<br>");
		}
		br.close();
		fr.close();
	}catch(FileNotFoundException e){
		out.println("<h2>오늘은 공지사항이 없습니다.</h2>");
		out.println("<a href = 'javascript:self.close()'>닫기</a>");
	}catch(IOException e){
		e.printStackTrace();
	}
%>