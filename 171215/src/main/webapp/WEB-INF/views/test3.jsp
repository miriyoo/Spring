<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 환산 결과창 ]</title>
</head>
<body>
	<h1>환산 결과</h1>
	
	<c:if test="${country == '1'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>USD입니다.
	</c:if>
	<c:if test="${country == '2'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>YEN입니다.
	</c:if>
	<c:if test="${country == '3'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>CNY입니다.
	</c:if>
	<c:if test="${country == '4'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>AUD입니다.
	</c:if>
	<c:if test="${country == '5'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>NZD입니다.
	</c:if>
	<c:if test="${country == '6'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>HKD입니다.
	</c:if>
	<c:if test="${country == '7'}">
		원화 <fmt:formatNumber value="${won }" pattern="#,###.##"/>원 환전시 환전 금액은 <fmt:formatNumber value="${result }" pattern="#,###.00"/>GBP입니다.
	</c:if>
	
	<a href="/">목록으로</a>
	
	
</body>
</html>