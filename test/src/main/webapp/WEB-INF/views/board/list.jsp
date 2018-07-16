<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 게시판 ]</title>
<script type="text/javascript">
	function writeForm(){
		location.href = "writeForm";
	}

</script>
</head>
<body>
	<h2>게시판</h2>
	
	<c:if test="${sessionScope.loginId != null }">
		<input type="button" value="글 쓰기" onclick="writeForm()">
	</c:if>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.boardnum }</td>
				<td>
					<a href="readBoard?boardnum=${board.boardnum }">${board.title }</a>
				</td>
				<td>${board.id }</td>
				<td>${board.hits }</td>
				<td>${board.inputdate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>