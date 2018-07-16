<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 아이디 중복 검사 폼 ]</title>
<script type="text/javascript">

	function formCheck(){
		
	}
	
	function useId(searchId){
		opener.document.getElementById("custid").value = searchId;
		this.close();
	}
	//opener를 통해 나를 불러준 쪽을 호출(즉 joinForm.jsp)
	
	
	
</script>
</head>
<body>
	<h2>[ ID 중복 확인 ]</h2>
	
	<form action="idSearch" method="post" onsubmit="return formCheck();">
		<input type="text" name="searchId" id="searchId" value="${searchId }">
		<input type="submit" value="검색">
	</form>
	
	<!-- 검색 후에만 출력 -->
	<c:if test="${search }">
		<!-- 검색 결과가 없는 경우(사용가능) -->
		<c:if test="${searchResult == null }">
			<p>
				${searchId } : 사용할 수 있는 ID입니다.
			</p>
			<p>
				<input type="button" value="ID사용하기" onclick="useId('${searchId}')">
			</p>
		</c:if>
		
		<!-- 검색 결과가 있는 경우(사용불가능) -->
		<c:if test="${searchResult != null }">
			<p>
				${searchId } : 이미 사용 중인 ID입니다.
			</p>
		</c:if>
	</c:if>

</body>
</html>