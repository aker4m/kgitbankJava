<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="catebean" class="my.shop.CategoryBean" />
<jsp:useBean id="catedto" class="my.shop.CategoryDTO" />
<jsp:setProperty property = "*" name="catedto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="catebean" value="<%=pool %>" />
<%
	
	if(catedto.getCnum()==0){
		response.sendRedirect("main.jsp");
		return;
	}

	int res = catebean.deleteCate(catedto); 
	if(res>0){ %>
	<script type="text/javascript">
			alert("카페고리삭제성공!! 카테고리목록페이지로 이동합니다.")
			location.href="cate_list.jsp"
	</script>	
<%	}else { %>
	<script type="text/javascript">
			alert("카테고리삭제실패!! 카테고리목록페이지로 이동합니다.")
			location.href="cate_list.jsp"
		</script>	
<%	} %>