<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<jsp:useBean id="probean" class="my.shop.ProductBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="probean" value="<%=pool %>" />
<%@ page import="my.shop.*, java.util.*" %>
<%@ include file="top.jsp"%>
<script type="text/javascript">
	function checkDel(pnum, pimage){
		var isDel = window.confirm("정말로 삭제하시겠습니까?")
		if(isDel){
			location.href="prod_delete.jsp?pnum="+pnum+"&pimage="+pimage
		}
	}
</script>	
<%
	List<ProductDTO> list = probean.listProduct();
	if(list == null || list.size()==0){%>
	<script type="text/javascript">
		alert("상품을 먼저 등록하세요.")
		location.href="prod_input.jsp"
	</script>
<%	return;
	}else{	%>
<div align="center">
	<form name="f" method="post">
		<table width="600" class="outline">
		<caption>상품목록</caption>
			<tr class="m2">
				<th>번호</th>
				<th>상품코드</th>
				<th>상품명</th>
				<th>이미지</th>
				<th>가격</th>
				<th>제조사</th>
				<th>수량</th>
				<th>수정|삭제</th>
			</tr>
<%	for(ProductDTO dto : list){%>
			<tr>
				<td><%=dto.getPnum() %></td>
				<td><%=dto.getPcategory_fk() %></td>
				<td><%=dto.getPname() %></td>
<% String upPath = config.getServletContext().getRealPath("/myshop/images");
	String filename = upPath+"\\"+dto.getPimage();%>				
				<td><a href = "prod_view.jsp?pnum=<%=dto.getPnum()%>">
				<image src=<%=filename %> width="50"></a></td>
				<td><%=dto.getPrice() %></td>
				<td><%=dto.getPcompany() %></td>
				<td><%=dto.getPqty() %></td>
				<td> <a href="prod_update.jsp?pnum=<%=dto.getPnum() %>">수정</a> | 
				<a href = "javascript:checkDel('<%=dto.getPnum() %>','<%=dto.getPimage()%>')">삭제</a></td>
			</tr>
<% }	
} %>			
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>