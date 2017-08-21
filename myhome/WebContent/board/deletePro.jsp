<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bdBean" class="my.board.BoardDataBean" />

<%
	String num = request.getParameter("num");
	String passwd = request.getParameter("passwd");
	if(num == null || num.trim().equals("")){
		response.sendRedirect("list.jsp");
		return;
	}
	if(passwd==null || passwd.trim().equals("")){ %>
		<script type="text/javascript">
			alert("비밀번호를 입력해 주세요!")
			location.href="deleteForm.jsp?num="+num;
		</script>
<%		return;
	}
	boolean isPass = bdBean.isPassword(Integer.parseInt(num), passwd);
	String msg= null, url=null;
	if(isPass){
		int res = bdBean.deleteBoard(Integer.parseInt(num));
		if(res>0){
			msg="게시글 삭제 성공! 글 목록 페이지로 이동합니다.";
			url="list.jsp";
		}else{
			msg="게시글 삭제 실패! 글 목록 페이지로 이동합니다.";
			url="list.jsp";
		}
	}else{
		msg="비밀번호가 틀렸습니다. 다시 입력해 주세요!";
		url = "deleteForm.jsp?num="+num;
	}
%>
<script type="text/javascript">
	alert("<%=msg %>")
	location.href="<%=url%>"
</script>