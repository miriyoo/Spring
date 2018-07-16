<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 1</title>
</head>
<body>
<h1>[ JSTL - 코어 라이브러리 사용 ]</h1>

<h2>* set - attribute 저장</h2>
<c:set var="n" value="100" />
<%-- <%=n %> 는 에러. set 태그는 Java의 변수가 아니라 page 등의 attribute로 저장됨. --%>
n = ${n}<br>
<br>

<h2>* remove - attribute 삭제</h2>
<c:remove var="n" />
n = ${n}<br>
<br>

<h2>* if - 조건 검사</h2>

<c:if test="${str == 'abc'}">
	str의 값은 'abc'이다.<br>
</c:if>

<c:if test="${num > 0 }">
	num은 0보다 크다.<br>
</c:if>
<br>

<h2>* choose - 분기</h2>

<c:choose>
	<c:when test="${number == 1}">
		number의 값은 1이다.<br>
	</c:when>
	<c:when test="${number == 2}">
		number의 값은 2이다.<br>
	</c:when>
	<c:otherwise>
		number은 그 외의 값 이다.<br>
	</c:otherwise>
</c:choose>
<br>

<h2>* forEach - 반복</h2>
<c:forEach var="cnt" begin="1" end="5">
	반복${cnt}
</c:forEach>
<br>

<c:forEach var="i" begin="0" end="${list.size() - 1}">
	${list.get(i)}
</c:forEach>
<br>

<c:forEach var="i" begin="0" end="${list.size() - 1}">
	${list[i]}
</c:forEach>
<br>

<c:forEach var="value" items="${list }">
	${value}
</c:forEach>
<br>

<h2>* forTokens - 문자열 분리, 반복</h2>

<c:forTokens var="token" items="${phone}" delims="-">
	${token}<br>
</c:forTokens>
<br>

<h2>* out - 데이터 출력 (특수문자 포함)</h2>
EL로 출력 : ${data}<br>
<c:out value="${data}" /><br>

</body>
</html>