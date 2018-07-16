<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	
	<body>
		<h1>Hello world!</h1>
		
		<form action="login" method="post">
			아이디 <input type="text" id="loginId" name="loginId" autocomplete="off">
			<input type="submit" value="로그인">
		</form>

	</body>
</html>
