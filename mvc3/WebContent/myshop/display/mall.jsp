<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.util.*, java.text.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="mall_top.jsp"%>

<jsp:useBean id="prolist" class = "my.shop.mall.ProductList" scope="session" />
<jsp:setProperty property ="pool" name="prolist" value="<%=pool %>"	/>
<h2>Welcome to My Mall</h2>
<%DecimalFormat df = new DecimalFormat("###,###"); %>

<%
	ArrayList<ProductDTO> plist = prolist.selectBySpec("hit");
	if(plist==null || plist.size()==0){
		out.println("<b>HIT상품이 없습니다.</b><br>");
	}else{%>
		<hr color="green" width="80%">
		<font color="red" size="3">HIT</font>
		<hr color="green" width="80%">
			<table width="100%" border="0" align="center">
				<tr>
<%					int count=0;
					for(ProductDTO dto : plist){
						count++;
						String pimage = dto.getPimage();
						String pnum = String.valueOf(dto.getPnum());
						String pname = dto.getPname();
						int price = dto.getPrice();
						int point = dto.getPoint();
%>
					<td align="center">
						<a href="mall_prodView.jsp?pnum=<%=pnum %>&select=hit">
							<img src="../images/<%=pimage %>" width="80"  border="0"><br>
						</a>
						<%=pname %><br>
						<fond color="red"><%=df.format(price) %></fond>원<br>
						<font color="blue">[<%=point %>]</font>point
					</td>
				<% 	if(count%3==0){ %>
					</tr><tr>
				<%	}
					}%>
				</tr>
			</table>	
<%	}  %>
<%
	ArrayList<ProductDTO> plist2 = prolist.selectBySpec("new");
	if(plist2==null || plist2.size()==0){
		out.println("<b>NEW상품이 없습니다.</b><br>");
	}else{%>
		<hr color="green" width="80%">
		<font color="red" size="3">NEW</font>
		<hr color="green" width="80%">
			<table width="100%" border="0" align="center">
				<tr>
<%					int count=0;
					for(ProductDTO dto : plist2){
						count++;
						String pimage = dto.getPimage();
						String pnum = String.valueOf(dto.getPnum());
						String pname = dto.getPname();
						int price = dto.getPrice();
						int point = dto.getPoint();
%>
					<td align="center">
						<a href="mall_prodView.jsp?pnum=<%=pnum %>&select=new">
							<img src="../images/<%=pimage %>" width="80"  border="0"><br>
						</a>
						<%=pname %><br>
						<fond color="red"><%=df.format(price) %></fond>원<br>
						<font color="blue">[<%=point %>]</font>point
					</td>
				<% 	if(count%3==0){ %>
					</tr><tr>
				<%	}
					}%>
				</tr>
			</table>	
<%	}  %>
<%
	ArrayList<ProductDTO> plist3 = prolist.selectBySpec("best");
	if(plist3==null || plist3.size()==0){
		out.println("<b>BEST상품이 없습니다.</b><br>");
	}else{%>
		<hr color="green" width="80%">
		<font color="red" size="3">BEST</font>
		<hr color="green" width="80%">
			<table width="100%" border="0" align="center">
				<tr>
<%					int count=0;
					for(ProductDTO dto : plist3){
						count++;
						String pimage = dto.getPimage();
						String pnum = String.valueOf(dto.getPnum());
						String pname = dto.getPname();
						int price = dto.getPrice();
						int point = dto.getPoint();
%>
					<td align="center">
						<a href="mall_prodView.jsp?pnum=<%=pnum %>&select=best">
							<img src="../images/<%=pimage %>" width="80"  border="0"><br>
						</a>
						<%=pname %><br>
						<fond color="red"><%=df.format(price) %></fond>원<br>
						<font color="blue">[<%=point %>]</font>point
					</td>
				<% 	if(count%3==0){ %>
					</tr><tr>
				<%	}
					}%>
				</tr>
			</table>	
<%	}  %>			
<%@ include file="mall_bottom.jsp"%>			
	