<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<a href="test1">링크</a>
<form action="test1" method="post">
	<input type="submit" value="redirect">
</form>

<br>
<a href="exchangeRateForm">환율 계산하기</a>




</body>
</html>
