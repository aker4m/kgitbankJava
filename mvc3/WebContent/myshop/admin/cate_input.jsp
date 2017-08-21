<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp"%>
<div align="center">
	<h4>카테고리 등록</h4>
	<form name="f" action = "cate_input_ok.admin" method="post">
		<table border="1" class="outline">
			<tr>
				<td height="40" width="100" align="center" bgcolor="yellow">
					<b>카테고리 코드
				</td>
				<td>
					<input type="text" name="code">
				</td>
			</tr>
			<tr>
				<td height="40" width="100" align="center" bgcolor="yellow">
					<b>카테고리 이름
				</td>
				<td>
					<input type="text" name="cname">
				</td>
			</tr>
			<tr>
				<td  height="40"colspan="2" align="center" bgcolor=#F6BF08>
				<input type="submit" value="등록">
				<input type="reset" value="취소"> 
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>