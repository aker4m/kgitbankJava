<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="bdBean" class="my.board.BoardDataBean" />
<jsp:useBean id="dbBean" class="my.board.BoardDBBean" />
<jsp:setProperty property = "*" name = "dbBean" />

<%	
	if (dbBean.getWriter()==null || dbBean.getSubject()==null || 
		dbBean.getContent()==null || dbBean.getPasswd()==null ||
		dbBean.getWriter().trim().equals("") || dbBean.getSubject().trim().equals("") ||
		dbBean.getContent().trim().equals("") || dbBean.getPasswd().trim().equals("")){%>
		<script type="text/javascript">
			alert("이름, 제목, 내용, 비밀번호를 모두 입력하셔야 합니다.")
			history.back();
		</script>	
<%		return;
	}
	boolean isPass = bdBean.isPassword(dbBean.getNum(), dbBean.getPasswd());
	String msg= null, url=null;
	if(isPass){
		int res = bdBean.updateBoard(dbBean);
		if(res>0){
			msg="게시글 수정 성공! 글 목록 페이지로 이동합니다.";
			url="list.jsp";
		}else{
			msg="게시글 수정 실패! 글 목록 페이지로 이동합니다.";
			url="list.jsp";
		}
	}else{
		msg="비밀번호가 틀렸습니다. 다시 입력해 주세요!";
		url = "deleteForm.jsp?num="+dbBean.getNum();
	}
%>
<script type="text/javascript">
	alert("<%=msg %>")
	location.href="<%=url%>"
</script>