<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="probean" class="my.shop.ProductBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="probean" value="<%=pool %>" />
<%@ page import="com.oreilly.servlet.*, java.io.*, com.oreilly.servlet.multipart.*" %>

<%
	MultipartRequest mr = null;
	String upPath= config.getServletContext().getRealPath("/myshop/images");
	int len = 1024 *1024 *1024;
	try{
		mr = new MultipartRequest(request, upPath, len, "UTF-8");
	}catch(IOException e){
		e.printStackTrace();
	}
	int res = probean.insertProduct(mr); 
	if(res>0){%>
	<script type="text/javascript">
		alert("상품 등록 성공!! 상품 목록페이지로 이동합니다.")
		location.href="prod_list.jsp"
	</script>	
<%	}else{ %>
	<script type="text/javascript">
		alert("상품 등록 실패 !! 상품 등록페이지로 이동합니다.")
		location.href="prod_input.jsp"
	</script>
<%	} %>