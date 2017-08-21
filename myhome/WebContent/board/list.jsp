<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.board.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bdBean" class = "my.board.BoardDataBean" />

<%@ include file="../top.jsp"%>
<div align="center">
	<table border="1">
		<caption><b>글 목 록</b></caption>
		<tr>
			<td colspan="7" align="right" bgcolor="yellow"><a href="writeForm.jsp">[글쓰기]</a></td>
		</tr>
		<tr bgcolor="green">
			<th width="10%">번호</th>
			<th width="30%">제목</th>
			<th width="10%">작성자</th>
			<th width="15%">작성일</th>
			<th width="7%">조회</th>
			<th width="20%">IP</th>
			<th width="8%">파일</th>
		</tr>
<% 	
	int pageSize = 5;
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null){
		pageNum="1";
	}
	int currentPage = Integer.parseInt(pageNum);
	//int startRow = currentPage * pageSize - (pageSize - 1);
	int startRow = (currentPage-1)*pageSize +1;
	int endRow = startRow + pageSize -1;
	int countRow = bdBean.getCount();
	if(endRow>countRow) endRow = countRow;
	int number = countRow - (currentPage-1)*pageSize;
	
	List<BoardDBBean> list = bdBean.listBoard(startRow, endRow); 
	if(list==null || list.size()==0){%>
	<tr>
		<td colspan="6" align="center"> 게시된 글이 없습니다.</td>
	</tr>
<% 	}else{
		for(BoardDBBean bean : list){
		//for(int i=startRow-1;i<endRow;i++){
		//	BoardDBBean bean = list.get(i);
		%>
		<tr align="left">
			<td><%=number-- %></td>
			<td>
<%		if(bean.getRe_level()>0){ %>
			<img src="../img/level.gif" width="<%=bean.getRe_level()*10%>">
			<img src="../img/re.gif">
<%		} %>			
			<a href="content.jsp?num=<%=bean.getNum()%>"><%=bean.getSubject() %></a></td>
<%		if(bean.getReadcount()>10){ %>
			<img src="../img/hot.gif">
<%		} %>		
		
			<td><%=bean.getWriter() %></td>
			<td><%=bean.getReg_date() %></td>
			<td><%=bean.getReadcount() %></td>
			<td><%=bean.getIp() %></td>
			<td align="center">
				<%if(bean.getFilename()==null){%>
					<img src="../img/level.gif">
				<%}else{ %>
					<img src="../img/folder.gif">
				<%} %>				
				
			</td>
		</tr>
		
<%	} 
}%>
		
	</table>
	<%
		if(countRow>0){
			int pageCount=(countRow-1)/pageSize +1;
			int pageBlock=3;
			int startPage=(currentPage-1)/pageBlock *pageBlock +1;
			int endPage = startPage+pageBlock -1;
			if(endPage>pageCount) endPage = pageCount;
			if(startPage>pageBlock){%>
				[<a href="list.jsp?pageNum=<%=startPage-pageBlock %>">이전</a>]
		<% 	}
			for(int i=startPage;i<=endPage;i++){ %>
				[<a href="list.jsp?pageNum=<%=i %>"><%=i %></a>]
		<%	}			
			if(endPage<pageCount){%>
				[<a href="list.jsp?pageNum=<%=startPage+pageBlock %>">다음</a>]
		<% 	}
		}%>
</div>

<%@ include file="../bottom.jsp"%>