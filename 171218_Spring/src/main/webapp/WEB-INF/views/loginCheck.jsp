<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 로그인 체크 페이지 ]</title>
</head>
<body>
	<c:if test="${sessionScope.id == null }">
		<script type="text/javascript">
			/* 자바스크립트 내장객체 중 location을 사용 */
			location.href = "login"; // 로그인 페이지로 보낸다.
		</script>
	</c:if>

</body>
</html>