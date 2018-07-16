<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 리소스 페이지 ]</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css" >
<script type="text/javascript" src="../resources/js/res.js"></script>
</head>
<body>
	<a href="javascript:test()"> JavaScript 적용 </a>

	<p class="blue"> Style 적용 p Tag </p>
	<img alt="그림에 대한 설명" src="../resources/image/${value }.jpg"> <!-- 상대경로 -->
	<img alt="그림에 대한 설명" src="<c:url value="/resources/image/${value }.jpg"/>"> <!-- 절대경로 -->
	
</body>
</html>