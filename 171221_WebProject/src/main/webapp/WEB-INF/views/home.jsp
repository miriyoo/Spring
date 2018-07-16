<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.loginId == null }">
				<li><a href="loginForm">로그인 폼 이동</a></li>
			</c:when>
			<c:otherwise>
				<p>${sessionScope.loginName }님 환영합니다.</p>
				<p>
					<c:choose>
						<c:when test="${sessionScope.cartList.size() == null}">
							나의 장바구니 상품 갯수: 0개
						</c:when>
						<c:otherwise>
							나의 장바구니 상품 갯수: ${sessionScope.cartList.size()}개
						</c:otherwise>					
					</c:choose>
				</p>
				<li><a href="logout">로그아웃</a></li>
				<li><a href="productList">상품리스트</a></li>
				<li><a href="showCartList">장바구니 확인하기</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>
