<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<title>[ 글 쓰기 폼 ]</title>
<script type="text/javascript">

	<c:if test="${errorMsg != null}">
		alert("${errorMsg}");
	</c:if>
	
	$(function(){
		
		$('#ib1').on('submit', function(){
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
	<form action="uploadImage" method="post" id="ib1"
	enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2" align="center"><h2>[ 글쓰기 ]</h2></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" size="90"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="91" name="content" id="content"></textarea> </td>
			</tr>
			<tr>
				<th>파일첨부</th>
				<td>
					<input type="file" name="upload">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
</body>
</html>