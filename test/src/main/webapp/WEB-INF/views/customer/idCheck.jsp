<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ ID 중복 검사 창 ]</title>
<script type="text/javascript">
	function formCheck(){
		var id = document.getElementById('searchId');
		
		if (id.value.length < 3) {
			alert('검색할 ID를 3자 이상 입력하세요.');
			return false;
		}
		
		return true;
	}
	
	function idSelect(searchId){
		opener.document.getElementById('custid').value = searchId;
		this.close();
	}

</script>

</head>
<body>
	<h2>ID 중복 검사</h2><br>
	<form action="idCheckForm" method="post" onsubmit="return formCheck();">
	<input type="text" name="searchId" id="searchId" value="${searchId }" placeholder="검색할 ID 입력">
	<input type="submit" value="검색">
	</form>
	
	<br>
	<br>
	<c:if test="${search }">
		<c:if test="${searchResult == null }">
			${searchId }: 사용할 수 있는 ID입니다.<br>
			<input type="button" value="ID 사용하기" onclick="idSelect('${searchId}')">
		</c:if>
		<c:if test="${searchResult != null}">
		<p>${searchId} : 이미 사용중인 ID입니다.</p>
	</c:if>
	</c:if>
	
	
</body>
</html>