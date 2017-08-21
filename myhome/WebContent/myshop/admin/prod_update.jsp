<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "my.shop.*"%>

<jsp:useBean id="probean" class="my.shop.ProductBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property ="pool" name="probean" value="<%=pool %>"	/>
<%@ include file="top.jsp" %>

<%
	String pnum = request.getParameter("pnum");
	if(pnum==null || pnum.trim().equals("")){
		response.sendRedirect("prod_list.jsp");
		return;
	}
	ProductDTO dto = probean.getProduct(Integer.parseInt(pnum));
%>
	<div align="center">
	<form name="f" action = "prod_update_ok.jsp" method="post" enctype="multipart/form-data">
		<table width="600" class="outline">
			<caption>상품수정카테고리</caption>
			<tr>
				<th class="m2">카테고리</th>
				<td>
					<input type="text" name="pcategory_fk" value="<%= dto.getPcategory_fk()%>" disabled>
				</td>
			</tr>
			<tr>
				<th class="m2">상품번호</th>
				<td><%=dto.getPnum() %><input type="hidden" name="pnum" value="<%=dto.getPnum()%>"></td>
			</tr>
			<tr>
				<th class="m2">상품명</th>
				<td><input type="text" name ="pname" value="<%=dto.getPname() %>"></td>
			</tr>
			<tr>			
				<th class="m2">제조회사</th>
				<td><input type="text" name="pcompany" value="<%=dto.getPcompany() %>"></td>
			</tr>
			<tr>				
				<th class="m2">상품이미지</th>
<% String upPath = config.getServletContext().getRealPath("/myshop/images");
	String filename = upPath+"\\"+dto.getPimage();%>
				<td><image src=<%=filename %> width="50"><input type="file" name="pimage">
				<input type="hidden" name="pimage2" value="<%=dto.getPimage() %>"></td>
			</tr>
			<tr>
				<th class="m2">상품수량</th>
				<td><input type="text" name="pqty" value="<%=dto.getPqty() %>"></td>
			</tr>
			<tr>				
				<th class="m2">상품가격</th>
				<td><input type="text" name="price" value="<%=dto.getPrice() %>"></td>
			</tr>
			<tr>				
				<th class="m2">상품스펙</th>
				<td>
					<select name="pspec">
<% String spec = dto.getPspec(); %>					
						<option value="none" <%if(spec.equals("none")){%>selected<%} %>>::NORMAL::</option>
						<option value="hit" <%if(spec.equals("hit")){%>selected<%} %>>HIT</option>
						<option value="best" <%if(spec.equals("best")){%>selected<%} %>>BEST</option>
						<option value="new" <%if(spec.equals("new")){%>selected<%} %>>NEW</option>
					</select>
				</td>
			</tr>
			<tr>				
				<th class="m2">상품소개</th>
				<td>
					<textarea name = "pcontents" rows="5" cols="60"><%=dto.getPcontents() %>"</textarea>
				</td>
			</tr>
			<tr>				
				<th class="m2">상품포인트</th>
				<td><input type="text" name="point" value="<%=dto.getPoint() %>"></td>
			</tr>
			<tr>				
				<td  colspan="2" align="center" bgcolor="grey">
					<input type="submit" value="상품수정">
					<input type="reset" value="취소"> 
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp" %>