<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cart" class="my.shop.mall.CartBean" scope="session"/>
<%
		String pnum = request.getParameter("pnum");
		if (pnum == null || pnum.trim().equals("")){
			response.sendRedirect("mall_cartList.jsp");
			return;
		}  
				
		cart.deleteCart(pnum); 
%>
<script type="text/javascript">
	alert("선택하신 상품을 장바구니에서 삭제하였습니다.");
	location.href="mall_cartList.jsp";
</script>