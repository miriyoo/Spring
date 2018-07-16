<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 환율 계산하기 ]</title>
</head>
<body>
	<form action="calcRate" method="post">
		<input type="hidden" name="hidden">
		원화 입력: <input type="number" name="won">
		환전하실 국가 선택
		<select name="country">
			<option value="1">미국</option>
			<option value="2">일본</option>
			<option value="3">중국</option>
			<option value="4">호주</option>
			<option value="5">뉴질랜드</option>
			<option value="6">홍콩</option>
			<option value="7">영국</option>
		</select>
		<input type="submit" value="전송">
	</form>
</body>
</html>