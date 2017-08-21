<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%/* if (!isLogin) {%>
		<script type="text/javascript">
			alert("로그인을 하셔야 글을 쓸 수 있습니다.")
			location.href="<%=request.getContextPath()%>/login/login.jsp"
		</script>			
<%		return;
		} */%>
<script type="text/javascript">
	function check(){
		if(f.writer.value==""){
			alert("이름을 입력해 주세요!");
			f.writer.focus();
			return false;
		}
		if(f.subject.value==""){
			alert("제목을 입력해 주세요!");
			f.subject.focus();
			return false;
		}
		if(f.content.value==""){
			alert("내용을 입력해 주세요!");
			f.content.focus();
			return false;
		}
		if(f.passwd.value==""){
			alert("비밀번호를 입력해 주세요!");
			f.passwd.focus();
			return false;
		}
		return true;
	}
</script>
<%
	int num=0, re_step=0, re_level=0;
	String snum = request.getParameter("num");
	if(snum != null){
		num = Integer.parseInt(snum);
		re_step = Integer.parseInt(request.getParameter("re_step"));
		re_level = Integer.parseInt(request.getParameter("re_level"));
	}
%>
<div align="center">
	<table width="600" border="1" class="outline">
		<form name = "f" method="post" action="writePro.bd" enctype="multipart/form-data" onsubmit="return check()">
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="re_step" value="<%=re_step%>">
			<input type="hidden" name="re_level" value="<%=re_level%>">
			<tr>
				<th colspan="2" align="center" bgcolor="yellow">글쓰기</th>
			</tr>
			<tr>
				<th width="15%" bgcolor="yellow">이 름</th>
				<td><input type="text" name="writer" ></td>
			</tr>
			<tr>
				<th bgcolor="yellow">제 목</th>
				<td><input type="text" size="70" name="subject"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">Email</th>
				<td><input type="text" size="70" name="email"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">내 용</th>
				<td><textarea name="content" cols="70" rows="13"></textarea></td>
			</tr>
			<tr>
				<th bgcolor="yellow">파일명</th>
				<td><input type="file" size="55" name="filename"></td>
			</tr>
			<tr>
				<th bgcolor="yellow">비밀번호</th>
				<td><input type="password" name="passwd"></td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="yellow">
					<input type="submit" value="글쓰기">
					<input type="reset" value="다시작성">
					<input type="button" value="목록보기" onclick="location.href='board.bd'">
				</td>
			</tr>
		</form>
	</table>
</div>
