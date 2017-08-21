<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, my.shop.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="catebean" class="my.shop.CategoryBean" />
<jsp:useBean id="pool" class="my.db.ConnectionPoolBean" scope="application" />
<jsp:setProperty property="pool" name="catebean" value="<%=pool %>" />
<%@ include file="top.jsp"%>
<%
	List<CategoryDTO> list = catebean.listCate();
	if(list == null || list.size()==0){ %>
						<script type="text/javascript">
							alert("카테고리를 먼저 등록해 주세요.")
							location.href="cate_input.jsp"
						</script>
<% 	return ;
	}else{	%>

<div align="center">
	<form name="f" action = "prod_input_ok.jsp" method="post" enctype="multipart/form-data">
		<table width="600" class="outline">
			<caption>상품등록카테고리</caption>
			<tr>
				<th bgcolor="orange">카테고리	</th>
				<td>
					<select name="pcategory_fk">
<%	for(CategoryDTO dto : list){%>
						<option value="<%=dto.getCode() %>">
							<%=dto.getCname() %>[<%=dto.getCode() %>]
						</option>
<% 		}
	}%>
					</select>
				</td>
			</tr>
			<tr>
				<th bgcolor="orange">상품명</th>
				<td><input type="text" name ="pname"></td>
			</tr>
			<tr>
				<th bgcolor="orange">상품코드</th>
				<td><input type="text" name="pcode"></td>
			</tr>
			<tr>			
				<th bgcolor="orange">제조회사</th>
				<td><input type="text" name="pcompany"></td>
			</tr>
			<tr>				
				<th bgcolor="orange">상품이미지</th>
				<td><input type="file" name="pimage"></td>
			</tr>
			<tr>
				<th bgcolor="orange">상품수량</th>
				<td><input type="text" name="pqty"></td>
			</tr>
			<tr>				
				<th bgcolor="orange">상품가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>				
				<th bgcolor="orange">상품스펙</th>
				<td>
					<select name="pspec">
						<option value="none" selected>::NORMAL::</option>
						<option value="hit">HIT</option>
						<option value="best">BEST</option>
						<option value="new">NEW</option>
					</select>
				</td>
			</tr>
			<tr>				
				<th bgcolor="orange">상품소개</th>
				<td>
					<textarea name = "pcontents" rows="5" cols="60"></textarea>
				</td>
			</tr>
			<tr>				
				<th bgcolor="orange">상품포인트</th>
				<td><input type="text" name="point"></td>
			</tr>
			<tr>				
				<td  colspan="2" align="center" bgcolor="grey">
					<input type="submit" value="상품등록">
					<input type="reset" value="취소"> 
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="bottom.jsp"%>