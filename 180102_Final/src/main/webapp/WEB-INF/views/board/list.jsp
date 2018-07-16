<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글 목록 ]</title>
<script type="text/javascript">
	function writeForm(){
		location.href = "writeForm"; //이미 board가 붙어져있기 때문에
	}
	
	function pagingFormSubmit(currentPage){
		var form = document.getElementById('pagingForm');
		var page = document.getElementById('page');
		page.value = currentPage; //전달받은 페이지를 대입하고 서밋
		
		form.submit();
	}
</script>


</head>
<body>
	<c:if test="${sessionScope.loginId != null }">
		<input type="button" value="글 쓰기" onclick="writeForm()">
	</c:if>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.boardnum }</td>
				<td><a href="readBoard?boardnum=${board.boardnum }">${board.title }</a></td>
				<td>${board.id }</td>
				<td>${board.hits }</td>
				<td>${board.inputdate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	<div>
		<a href="javascript:pagingFormSubmit(${navi.startPageGroup })">◁◁</a>
		<a href="javascript:pagingFormSubmit(${navi.currentPage - 1 })">◀</a>
		<c:forEach var="counter" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
			<c:if test="${counter == navi.currentPage }">
				<b>
			</c:if>
				<a href="javascript:pagingFormSubmit(${counter })">${counter }</a>
			<c:if test="${counter == navi.currentPage }">
				</b>
			</c:if>
		</c:forEach>
		
		<a href="javascript:pagingFormSubmit(${navi.currentPage + 1 })">▶</a>
		<a href="javascript:pagingFormSubmit(${navi.endPageGroup })">▷▷</a>
	</div>
	
	<form action="list" method="get" id="pagingForm">
		<input type="hidden" name="page" id="page">
		<select name="searchSelect">
			<option value="title" <c:if test="${searchSelect == 'title' }" >selected</c:if> >제목</option>
			<option value="content" <c:if test="${searchSelect == 'content' }" >selected</c:if> >내용</option>
			<option value="id" <c:if test="${searchSelect == 'id' }" >selected</c:if> >작성자</option>
		</select>
		<input type="text" name="searchText" value="${searchText }">
		<input type="button" onclick="pagingFormSubmit(1)" value="검색">
	</form>
	
	
	
</body>
</html>






