<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="mall_top.jsp"%>
<jsp:useBean id="prolist" class = "my.shop.mall.ProductList" scope="session"/>

<script type="text/javascript">
	function goCart(){
		document.f.action="<%=request.getContextPath() %>/myshop/display/mall_cartAdd.jsp";
		document.f.submit();
	}
	function goOrder(){
		document.f.action="<%=request.getContextPath() %>/myshop/display/mall_order.jsp";
		document.f.submit();
	}
</script>
<%
	String pnum = request.getParameter("pnum");
	String select = request.getParameter("select");
	if(pnum==null || pnum.trim().equals("")){
		response.sendRedirect("mall.jsp");
		return;
	}
	
	ProductDTO pdto = prolist.viewBySpec(select, Integer.parseInt(pnum));
	if(pdto == null) {
		response.sendRedirect("mall.jsp");
		return;
	}
%>

<table width="100%" height="90%" class="outline">
	<form name="f" method="post">
		<tr class="m1">
			<td colspan="2" bgcolor="grey" align="center">
			<font size="3" color="green"><b>[<%=pdto.getPname() %>]상품정보</b></font>
		</td></tr>
			<input type="hidden" name = "pnum" value="<%=pnum %>">
			<input type="hidden" name = "select" value="<%=select %>">
		<tr>
			<td rowspan="6"><img src="../images/<%=pdto.getPimage() %>" width="200"  border="0"></td>
			<td>상품번호 : <%=pdto.getPnum() %></td></tr>
		<tr><td>상품이름 : <%=pdto.getPname() %></td></tr>
		<tr><td>상품가격 : <font color="red"><%=pdto.getPrice() %></fond>원</td></tr>
		<tr><td>상품포인트 : <%=pdto.getPoint() %></td></tr>
		<tr><td>상품갯수 : <input type="text" name="qty" size="3" value="<%=pdto.getPqty() %>">개</td></tr>
		<tr><td><a href="javascript:goCart()">장바구니</a>
				<a href="javascript:goOrder()">즉시구매</a></td></tr>
		<tr><td height="40%">상품 상세 설명<br>
			<%=pdto.getPcontents() %>
		</td></tr>
	</form>
</table>

<%@ include file="mall_bottom.jsp"%>
