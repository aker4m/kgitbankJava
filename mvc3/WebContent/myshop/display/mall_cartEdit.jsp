<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id ="cart" class = "my.shop.mall.CartBean" scope="session" />
<%
	String pnum = request.getParameter("pnum");
	String pqty = request.getParameter("pqty");
	if (pnum == null || pnum.trim().equals("")){
		response.sendRedirect("mall_cartList.jsp");
		return;
	} 
			
	cart.editCart(pnum, pqty); 
%>
<script type="text/javascript">
	alert("상품의 주문 수량을 수정하였습니다.");
	location.href="mall_cartList.jsp";
</script>