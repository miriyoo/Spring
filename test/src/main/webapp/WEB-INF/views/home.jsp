<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
	<c:if test="${sessionScope.loginId == null }">
		<ul>
			<li>
				<a href="customer/join">회원가입</a>
			</li>
			<li>
				<a href="customer/login">로그인</a>
			</li>
		</ul>
	</c:if>
	<c:if test="${sessionScope.loginId != null }">
		<p>${sessionScope.loginName }님 (${sessionScope.loginId }) 로그인 중</p>
		<ul>
			<li>
				<a href="customer/logout">로그아웃</a>
			</li>
			<li>
				<a href="customer/update">내정보 수정</a>
			</li>
		</ul>
	</c:if>
	<ul>
		<li>
			<a href="board/list">게시판</a>
		</li>
	</ul>
</body>
</html>
