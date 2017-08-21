<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="my.shop.*"%>
<jsp:useBean id="probean" class="my.shop.ProductBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property ="pool" name="probean" value="<%=pool %>" />
    
<%
		String pnum = request.getParameter("pnum");
		if (pnum==null || pnum.trim().equals("")){
			response.sendRedirect("prod_list.jsp");
			return;
		}
		ProductDTO dto = probean.getProduct(Integer.parseInt(pnum)); 
%>    
<%@ include file="top.jsp"%>


<form name="f" action="prod_list.jsp" method="post">
	<table class="outline" >
	<caption>상품상세보기</caption>
		<tr>
			<th width="15%" class="m2">카테고리</th>
			<td width="35%" align="center"><%=dto.getPcategory_fk()%></td>
			<th width="15%" class="m2">상품번호</th>
			<td width="35%" align="center"><%=dto.getPnum()%></td>
		</tr>
		<tr>
			<th width="15%" class="m2">상품명</th>
			<td width="35%" align="center"><%=dto.getPname()%></td>
			<th width="15%" class="m2">제조회사</th>
			<td width="35%" align="center"><%=dto.getPcompany()%></td>
		</tr>
		<tr>
			<th width="15%" class="m2">상품이미지</th>
<%	String upPath = config.getServletContext().getRealPath("/myshop/images");
		String filename = upPath + "\\" + dto.getPimage();%>			
			<td align="center" colspan="3">
				<img src="<%=filename%>" border="0" width="50" height="50">
			</td>
		</tr>
		<tr>
			<th width="15%" class="m2">상품수량</th>
			<td width="35%" align="center"><%=dto.getPqty()%></td>
			<th width="15%" class="m2">상품가격</th>
			<td width="35%" align="center"><%=dto.getPrice()%></td>
		</tr>
		<tr>
			<th width="15%" class="m2">상품스펙</th>
			<td width="35%" align="center"><%=dto.getPspec()%></td>
			<th width="15%" class="m2">상품포인트</th>
			<td width="35%" align="center"><%=dto.getPoint()%></td>
		</tr>
		<tr>
			<th width="15%" class="m2">상품소개</th>
			<td align="center" colspan="3">
				<textarea name="pcontents" rows="5" cols="50" readOnly><%=dto.getPcontents()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="m1" align="center">
				<input type="submit" value="돌아가기">
			</td>
		</tr>
	</table>
</form>	


<%@ include file="bottom.jsp"%>