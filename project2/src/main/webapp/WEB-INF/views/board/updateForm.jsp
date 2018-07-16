<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글 수정 폼 ]</title>
<script type="text/javascript">
	
	<c:if test="${errorMsg != null}">
		alert("${errorMsg}");
	</c:if>
	
	$(function(){
	
		$('#upd1').on('submit', function(){
			var title = $('#title').val();
			var content = $('#content').val();
		
			if (title.length == 0) {
				alert('제목을 입력해주세요.');
				return;
			
			} else if (content.length == 0) {
				alert('내용을 입력해주세요.');
				return;
			}
		});
		
	});
	
</script>
</head>
<body>

	<form action="update" class="readBoard" method="post" id="upd1">
		<input type="hidden" name="boardnum" value="${board.boardnum }">
		<table>
			<tr>
				<td colspan="2" align="center"><h2>[ 글쓰기 ]</h2></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" size="90"
					value="${board.title }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="91" name="content" id="content">${board.content }</textarea>
				</td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>선택된 파일 없음</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
























</body>
</html>