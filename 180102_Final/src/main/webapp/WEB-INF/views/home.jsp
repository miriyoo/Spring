<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>[ Index Page ]</title>
</head>
<body>
	<ul>
		<c:choose>
			<c:when test="${sessionScope.loginId == null }">
				<li><a href="customer/joinForm">회원가입</a></li>
				<li><a href="customer/loginPage">로그인</a></li>
				<li><a href="board/list">게시판</a></li>
			</c:when>
			<c:otherwise>
				<p>${sessionScope.loginName }(${sessionScope.loginId })님 로그인 중</p>
				<li><a href="customer/logout">로그아웃</a></li>
				<li><a href="customer/update?loginId=${sessionScope.loginId }">개인정보 수정</a></li>
				<li><a href="board/list">게시판</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>
