<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/style.css">
<div align="center">
	<table border="1">
		<caption><b>글 목 록</b></caption>
		<tr>
			<td colspan="7" align="right" bgcolor="yellow"><a href="writeForm.bd">[글쓰기]</a></td>
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
	int pageSize = (int)request.getAttribute("pageSize");
	int currentPage = (int)request.getAttribute("currentPage");
	int countRow = (int)request.getAttribute("countRow");
	int number = (int)request.getAttribute("number");
	
	List<BoardDTO> list = (List)request.getAttribute("list"); 
	if(list==null || list.size()==0){%>
	<tr>
		<td colspan="6" align="center"> 게시된 글이 없습니다.</td>
	</tr>
<% 	}else{
		for(BoardDTO dto : list){ %>
		<tr align="left">
			<td><%=number-- %></td>
			<td>
<%		if(dto.getRe_level()>0){ %>
			<img src="<%=request.getContextPath() %>/img/level.gif" width="<%=dto.getRe_level()*10%>">
			<img src="<%=request.getContextPath() %>/img/re.gif">
<%		} %>			
			<a href="content.bd?num=<%=dto.getNum()%>"><%=dto.getSubject() %></a></td>
<%		if(dto.getReadcount()>10){ %>
			<img src="<%=request.getContextPath() %>/img/hot.gif">
<%		} %>		
		
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getReg_date() %></td>
			<td><%=dto.getReadcount() %></td>
			<td><%=dto.getIp() %></td>
			<td align="center">
				<%if(dto.getFilename()==null){%>
					<img src="<%=request.getContextPath() %>/img/level.gif">
				<%}else{ %>
					<img src="<%=request.getContextPath() %>/img/folder.gif">
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
				[<a href="board.bd?pageNum=<%=startPage-pageBlock %>">이전</a>]
		<% 	}
			for(int i=startPage;i<=endPage;i++){ %>
				[<a href="board.bd?pageNum=<%=i %>"><%=i %></a>]
		<%	}			
			if(endPage<pageCount){%>
				[<a href="board.bd?pageNum=<%=startPage+pageBlock %>">다음</a>]
		<% 	}
		}%>
</div>

