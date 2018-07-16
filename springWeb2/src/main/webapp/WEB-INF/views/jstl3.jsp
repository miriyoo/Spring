<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 3</title>
</head>
<body>
<h1>[ JSTL - 함수 라이브러리 사용 ]</h1>

<h2>* 문자열 관련 함수</h2>

원본 문자열 : 		${str }<br>
substring : 	${fn:substring(str, 2, 5) }<br>
toUpperCase : 	${fn:toUpperCase(str) }<br>
toLowerCase : 	${fn:toLowerCase(str) }<br>
length :		${fn:length(str) }<br>
split:
	<c:set var="ar" value="${fn:split(str, ' ')}" />
	<c:forEach var="item" items="${ar}">
		${item}<br>
	</c:forEach>
	
</body>
</html>