<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="catebean" class="my.shop.CategoryBean" />
<jsp:useBean id="catedto" class="my.shop.CategoryDTO" />
<jsp:setProperty property = "*" name="catedto" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="catebean" value="<%=pool %>" />

<%
	if(catedto.getCode() ==null || catedto.getCname()==null ||
		catedto.getCode().trim().equals("") || catedto.getCname().trim().equals("")){ %>
	<script type="text/javascript">
		alert("모든 값을 입력하세요.")
		history.back();
	</script>	
		
<%	return;
	}
	int res = catebean.insertCate(catedto);
	if(res>0){%>
	<script type="text/javascript">
		alert("카테고리 등록 성공!! 카테고리 목록페이지로 이동합니다.")
		location.href="cate_list.jsp"
	</script>
<% 	}else{%>
	<script type="text/javascript">
		alert("카테고리 등록 실패 !! 카테고리 등록페이지로 이동합니다.")
		location.href="cate_input.jsp"
	</script>
<% 	}%>
	