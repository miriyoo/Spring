<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 방명록 글 쓰기 ]</title>
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
	<form action="insertBoard" method="post">
		<table>
			<tr>
				<td colspan="2" align="center"><h1>[ 방명록 글 쓰기 ]</h1></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="boardName" placeholder="이름 입력" autofocus required> </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="boardPassword" placeholder="비밀번호 입력"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="50" placeholder="내용 입력" name="boardContent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="저장"></td>
			</tr>
		</table>
	</form>
</body>
</html>