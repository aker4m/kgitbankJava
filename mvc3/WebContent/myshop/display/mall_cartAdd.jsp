<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "cart" class="my.shop.mall.CartBean" scope="session" />
<%
	String pnum = request.getParameter("pnum");
	String qty = request.getParameter("qty");
	String select = request.getParameter("select");
	if(pnum == null || pnum.trim().equals("")){
		response.sendRedirect("mall.jsp");
		return;
	}
	if(Integer.parseInt(qty)<1){
		response.sendRedirect("mall.jsp");
		return;
	}
	boolean isAdd = cart.addCart(select, pnum, qty);
	if(isAdd){ %>
		<script type="text/javascript">
			location.href = "mall_cartList.jsp";
		</script>
<%	}else{ %>
		<script type="text/javascript">
			alert("죄송합니다. 관리자에게 문의하세요!");
			location.href="mall.jsp";
		</script>
<% 	}%>