<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<style type="text/css">
	span{
		font-weight: bold;
	}
</style>

	<title>Home</title>
	
	<script type="text/javascript">
		function writeBoard(){
			location.href = "writeBoard";
		}
		
		function del(num){
			
			var form = document.getElementById('delForm');
			var pwcheck = document.getElementById('pwcheck' + num);
			var boardNo = document.getElementById('boardNo');
			var boardPassword = document.getElementById('boardPassword');
			
			if (pwcheck.value == '') {
				alert('작성 시 지정한 비밀번호를 입력하세요.');
				return;
			}
			
			if (confirm('삭제하시겠습니까?')) {
				boardNo.value = num;
				boardPassword.value = pwcheck.value;
				form.submit();
			}
		}
		
		function update(num){
			location.href = "updateBoard?boardNo="+num;
		}
	
		
		
	</script>
</head>
<body>
	<h1>[ 방명록 ]</h1>
	<input type="button" value="글쓰기" onclick="writeBoard()"><br>
	<br>
	
	<c:forEach var="items" items="${list }">
	--------------------------------------------------------------------------------<br>
		<span>작성자 : </span>${items.boardName }<br>
		<span>작성일 : </span>${items.boardDate }<br>
		${items.boardContent }<br>
		<span>비밀번호 : </span><input type="password" id="pwcheck${items.boardNo }">
		<input type="button" value="삭제" onclick="del(${items.boardNo })">
		<input type="button" value="수정" onclick="update(${items.boardNo })"><br>
		
	--------------------------------------------------------------------------------<br>	
	</c:forEach>
	
	<!-- 삭제를 위한 hidden Form -->
	<form id="delForm" action="deleteBoard" method="post">
		<input type="hidden" name="boardNo" id="boardNo">
		<input type="hidden" name="boardPassword" id="boardPassword">
	</form>
	

	


</body>
</html>
