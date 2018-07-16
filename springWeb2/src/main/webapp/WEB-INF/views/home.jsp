<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<title>springWeb2</title>
</head>
<body>
<h1>[ springWeb2 ]</h1>

<ul>
<li><p>JSP 연습</p></li>
	<ol>
		<li><a href="res">리소스 사용</a></li>
		<li><a href="jstl1">JSTL 사용 - 코어 라이브러리</a></li>
		<li><a href="jstl2">JSTL 사용 - 포매팅 라이브러리 사용</a></li>
		<li><a href="jstl3">JSTL 사용 - 함수 라이브러리 사용</a></li>
	</ol>
<br>

<li><p>Parameter 전달</p></li>
	<ol>
		<li><a href="param1?str=abcd&num=100">GET method로 parameter</a></li>
		<li><a href="param2">POST method로 parameter</a></li>
		<li><a href="param3">VO객체로 전달</a></li>
	</ol>

<li><p>세션 테스트</p></li>
	<ol>
		<li><a href="test1">세션 테스트 1 - 세션에 값 저장</a></li>
		<li><a href="test2">세션 테스트 1 - 세션에서 값 삭제</a></li>
		<p>SessionController에서 저장한 세션값 value : ${value}</p>
		<br>

		<li><a href="step1">세션 테스트 2 - annotation 사용</a></li>
	</ol>
<br>

<li><p>쿠키 테스트</p></li>
	<ol>
		<li><a href="cookie1">쿠키 저장</a></li>
		<li><a href="cookie2">쿠키 삭제</a></li>
		<li><a href="cookie3">모든 쿠키 읽기</a></li>
		<li><a href="cookie4">특정 쿠키 읽기</a></li>
	</ol>
</ul>
</body>
</html>
