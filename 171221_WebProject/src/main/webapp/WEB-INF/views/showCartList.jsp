<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 나의 장바구니 정보 ]</title>
<style type="text/css">
	img{
		width: 50px;
	}

</style>
</head>
<body>
	<h3>나의 장바구니 정보</h3>
	<br>
	<form action="calcTotal" method="post">
	<table>
		<thead>
			<tr>
				<th>제품번호</th>
				<th>이미지</th>
				<th>상품명</th>
				<th>가격</th>
				<th>수량</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${showCartList1 }">
				<tr>
					<td>${list.productNo}</td>
					<td><img src="<c:url value="${list.productImgPath }"/>"> </td>
					<td>${list.productName }</td>
					<td>${list.productPrice }</td>
					<td>
						<select name="count">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">
					<input type="submit" value="확정">
				</td>
			</tr><tr>
				<td colspan="4">
					총 가격 : 
				</td>
			</tr>
			
		
		
		</tbody>
	</table>
	</form>

</body>
</html>