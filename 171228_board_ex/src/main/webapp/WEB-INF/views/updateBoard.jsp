<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 방명록 수정하기 ]</title>
<style type="text/css">
	span{
		font-weight: bold;
	}
	
	form{
		line-height: 2.0;
	}
</style>
</head>
<body>
	<form action="updateComplete" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><h1>[ 방명록 수정하기 ]</h1></td>
			</tr>
			<tr>
				<th>이름</th>
				<td>${vo.boardName }</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${vo.boardPassword }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" placeholder="내용 입력" name="boardContent">${vo.boardContent }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
		<input type="hidden" value="${vo.boardNo}" name="boardNo">
	</form>
</body>
</html>