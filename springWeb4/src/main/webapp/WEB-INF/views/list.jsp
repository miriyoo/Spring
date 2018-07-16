<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link href="./resources/web4.css" rel="stylesheet" type="text/css" />

<script>
function del(num) {
	var form = document.getElementById('delForm');
	var pwcheck = document.getElementById('pwcheck' + num);
	var boardnum = document.getElementById('boardnum');
	var password = document.getElementById('password');

	if (pwcheck.value == '') {
		alert('작성 시 지정한 비밀번호를 입력하세요.');
		return;
	}
	
	if (confirm('삭제하시겠습니까?')) {
		boardnum.value = num;
		password.value = pwcheck.value;
		form.submit();
	}
}
</script>

</head>
<body>
<h1>[ 방명록 ]</h1>

<input type="button" value="글쓰기" onclick="location.href='write';" />
<br><br>

<!-- 전체 글 출력 -->
<table>
<c:forEach var="board" items="${list}">
<tr>
	<td class="list">
		<p>작성자 : ${board.name}</p>
		<p>작성일 : ${board.inputdate}</p>
		<pre>${board.content }</pre>
		
		비밀번호 <input type="password" id="pwcheck${board.boardnum}" />
		<input type="button" onclick="del(${board.boardnum})" value="삭제">
	</td>
</tr>
</c:forEach>
</table>

<!-- 삭제를 위한 hidden Form -->
<form id="delForm" action="delete" method="post">
<!-- <form id="delForm" action="delete2" method="post"> -->
<!-- <form id="delForm" action="delete3" method="post"> -->
	<input type="hidden" name="boardnum" id="boardnum">
	<input type="hidden" name="password" id="password">
</form>

</body>
</html>
