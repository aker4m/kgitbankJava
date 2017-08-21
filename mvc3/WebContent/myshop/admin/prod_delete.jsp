<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*"%>
<jsp:useBean id="probean" class = "my.shop.ProductBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="probean" value="<%=pool %>" />
<%
	String pnum = request.getParameter("pnum");
	String pimage = request.getParameter("pimage");
	if(pnum==null || pnum.trim().equals("")){
		response.sendRedirect("prod_list.jsp");
		return;
	}
	
	int res = probean.deleteProduct(Integer.parseInt(pnum));
	
	if(res >0){%>
	<script type="text/javascript">
		alert("상품 삭제 성공!! 상품목록 페이지로 이동합니다.")
		
<%		String delPath= application.getRealPath("/myshop/images");
		File file = new File(delPath, pimage);		
		if(file.exists()) file.delete(); %>
		location.href="prod_list.jsp"
	</script>	
<% 	}else {%>
	<script type="text/javascript">
		alert("상품 삭제 실패!! 상품목록 페이지로 이동합니다.")
		location.href="prod_list.jsp"
	</script>
<% 	}%>