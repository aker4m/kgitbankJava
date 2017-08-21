<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.*" %>
<%@ include file="mall_top.jsp" %>
<jsp:useBean id = "prolist" class = "my.shop.mall.ProductList" scope="session" />
<jsp:setProperty property="pool" name = "prolist" value="<%= pool %>" />
<h3> Welcome to My Mall</h3>
<%
	String code = request.getParameter("code");
	DecimalFormat df = new DecimalFormat("###,###");
%>
<%ArrayList<ProductDTO> plist = prolist.selectByCode(code);
	if (plist==null || plist.size()==0){
		out.println("<b>상품이 없습니다</b><br>");
	}else {
			String cname = plist.get(0).getPname();%>
		<hr color="green" width="80%">
		<font color="red" size="3"><%=cname%></font>
		<hr color="green" width="80%">
		<br>
		<table width="100%" border="0" align="center">
			<tr>
<%			int count = 0;
				for(ProductDTO pdto : plist){
					count++;
					String pimage = pdto.getPimage();
					String pnum = String.valueOf(pdto.getPnum());
					String pname = pdto.getPname();
					int price = pdto.getPrice();
					int point = pdto.getPoint();%>
				<td align="center">
					<a href="mall_prodView.jsp?pnum=<%=pnum%>&select=<%=code%>">
						<img src="../images/<%=pimage%>" width="80" height="60" border="0"><br>
					</a>
					<%=pname%><br>
					<font color="red"><%=df.format(price)%></font>원<br>
					<font color="blue">[<%=point%>]</font>point
				</td>
<%				if (count%3==0){ %>
					</tr><tr>
<%				}%>
<%			}%>
			</tr>
		</table>
<%}%>
<%@ include file="mall_bottom.jsp"%>