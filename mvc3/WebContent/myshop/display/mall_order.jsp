<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.text.*, java.util.*, my.shop.mall.*"%>
<%@ include file="mall_top.jsp" %>
<jsp:useBean id="cart" class="my.shop.mall.CartBean" scope="session"/>
<jsp:useBean id="prolist" class="my.shop.mall.ProductList" scope="session"/>
<table width="99%" border="1" align="center">
	<tr class="m2"> 
		<td colspan="6" align="center">
			<h4>결제 내역서 보기</h4>
		</td>
	</tr>
	<tr class="m1">
		<th width="40%">상품명</th>
		<th width="20%">수량</th>
		<th width="20%">단가</th>
		<th width="20%">금액</th>
	</tr>	
<%
		DecimalFormat df = new DecimalFormat("###,###");
		int cartTotalPrice = 0;
		int cartTotalPoint = 0;
		
		Hashtable<String, Cart> hlist = cart.listCart(); 
		if (hlist == null || hlist.size()==0){%>
	<tr>
		<td colspan="4">장바구니가 비었습니다.</td>
	</tr>	
<%		}else {
			Enumeration<String> enu = hlist.keys();
			while(enu.hasMoreElements()){
				String pnum = enu.nextElement();
				Cart clist = hlist.get(pnum);
				ProductDTO dto = prolist.viewBySpec(clist.getSelect(), Integer.parseInt(pnum)); 
				int qty = clist.getQty();%>
	<tr>
		<td align="center">
			<%=dto.getPname()%>
		</td>
		<td align="center">
			<%=qty %>개
		</td>
		<td align="right">
			<%=df.format(dto.getPrice())%>원<br>
		</td>	
		<td align="right">
			<font color="red">
				<%=df.format(dto.getPrice()*qty)%>원<br>
			</font>
		</td>
	</tr>
<%		cartTotalPrice += dto.getPrice()*qty;
			} %>		
	<tr class="m1">
		<td colspan="4"><b>결제하실 총액은 : </b> : 
			<font color="red"><%=df.format(cartTotalPrice)%>원<br></font>
		</td>
	</tr>			
<%	}%>
</table>	

<%@ include file="mall_bottom.jsp"%>
    
