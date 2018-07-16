<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 세션 페이지 ]</title>
</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.id == null }"> <!-- 첫번째 if 문 -->
			로그인을 하지 않음
		</c:when>
		<c:otherwise> <!-- else 문 -->
			로그인 중
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>