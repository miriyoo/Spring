<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ ID 중복 검사 ]</title>
<script type="text/javascript">
	
	function formCheck(){
		var id = document.getElementById('searchId');
		
		if (id.value == '') {
			alert("검색할 ID를 입력해주세요")
			id.focus();
			return false;
		}
	}
	
	function useId(searchId){
		opener.document.getElementById("custid").value = searchId;
		this.close();
	}
	
	
</script>
</head>
<body>
	<form action="idSearch" method="post" onsubmit="return formCheck();">
		<h1>ID 중복 확인</h1>
		<input type="text" name="searchId" id="searchId" value="${searchId }" > 
		<input type="submit" value="검색">
		
		<br>
		<br>
		<c:if test="${search }">
			<c:if test="${searchResult == null }">
				<p>
					${searchId } : 사용할 수 있는 ID입니다.
				</p>
				<p>
					<input type="button" value="ID 사용하기" onclick="useId('${searchId}')">
				</p>
			</c:if>
			
			<c:if test="${searchResult != null }">
				<p>
					${searchId } : 이미 사용중인 ID입니다.<br>
				</p>
			</c:if>
		</c:if>
		
	</form>
	
	
	
	
	
	
	
</body>
</html>