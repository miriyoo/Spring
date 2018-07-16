<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 결과 페이지 ]</title>
</head>
<body>
	문자열 : ${str } <br>
	숫자 : ${number} <br>
	날짜 기본 : ${today } <br>
	날짜 : <fmt:formatDate value="${today }" type="date" pattern="yyyy년 MM월 dd일"/>
	시간 : <fmt:formatDate value="${today }" type="time" pattern="hh시 mm분 ss초"/> <br>
	
	vo객체 이름 : ${person.name } <br>
	vo객체 나이 : ${person.age } <br>
	vo객체 전화번호 : ${person.phone } <br>
	
	ArrayList 출력 <br>
	
	<c:forEach var="item" items="${list }">
		반복문 출력 : ${item } <br>
	
	</c:forEach>
	
	<br>
	해쉬맵 출력 <br>
	전체 : ${map } <br>
	
	날짜 : ${map.date }<br>
	이름 : ${map.name }<br>
	나이 : ${map.age } <br>
	전화번호 : ${map.phone } <br>
	
	<!-- ArrayList출력 -->
	<c:forEach var="value" items="${map.list }">
		${value }
	</c:forEach>
	

</body>
</html>