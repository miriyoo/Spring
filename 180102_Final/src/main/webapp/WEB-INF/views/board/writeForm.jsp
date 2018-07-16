<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 글 쓰기 폼 ]</title>
<script type="text/javascript">

	function formCheck(){
		
	}
	
	
</script>
</head>
<body>
	<form action="insertBoard" method="post" onsubmit="return formCheck();"
	enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2" align="center"><h2>[ 글쓰기 ]</h2></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" size="39"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="20" cols="40" name="content" id="content"></textarea> </td>
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