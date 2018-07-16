<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 데이터 목록 ]</title>
</head>
<body>
	<h1>서버에 저장된 데이터 목록</h1><br>
	
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
			</tr>	
		</thead>
		<tbody>
			<c:forEach var="items" items="${list }">
				<tr>
					<td>${items.id }</td>
					<td>${items.name }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>