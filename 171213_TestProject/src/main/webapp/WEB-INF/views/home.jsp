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
<a href="test2">링크</a>

<h1>연산처리</h1>
<form action="test" method="post"> 
	숫자1: <input type="number" name="num1" id="num1">
	<select name="calc">
		<option value="1">+</option>
		<option value="2">-</option>
		<option value="3">*</option>
		<option value="4">/</option>
	</select>
	숫자2: <input type="number" name="num2" id="num2">
	<br>
	<br>
	<input type="submit" value="전송">
</form>









</body>
</html>
