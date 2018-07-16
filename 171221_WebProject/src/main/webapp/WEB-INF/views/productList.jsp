<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 상품 리스트 ]</title>
<style type="text/css">
	img{
		width:  50px;
	}
</style>


</head>
<body>
	<form action="cart" method="post">
		<table>
		<thead>
			<tr>
				<th>선택</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${productList }">
				<tr>
					<td><input type="checkbox" name="prdCheck" value="${product.productNo }"></td>
					<td><img src="<c:url value="${product.productImgPath }"/>"> </td>
					<td>${product.productName}</td>
					<td>${product.productPrice}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">
					<input type="submit" value="담기">
				</td>
			</tr>
		</tbody>
		</table>
	</form>

</body>
</html>