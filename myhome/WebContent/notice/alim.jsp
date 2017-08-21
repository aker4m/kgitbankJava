<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, java.text.*"%>
<!-- notice/alim.jsp -->
<%@ include file="../top.jsp"%>
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
%>
<div align="center">
	<h3>오늘의 공지사항</h3>
	<form name="f" action="alim_save.jsp" method="post">
		<table border="1" width="500">
			<tr><th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr><th>공지사항</th>
				<td><textarea name="info" rows="5" cols="50"></textarea></td>
			</tr>
			<tr><th>파일명</th>
				<td><input type="text" name="filename" value="<%=filename%>" readOnly></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="쓰기">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../bottom.jsp"%>