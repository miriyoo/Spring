<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 파라메터 페이지 ]</title>
</head>
<body>
	<a href="paramGet?str=getTest&num=10">Get Parameter Test</a>
	
	<form action="paramPost" method="post">
		이름: <input type="text" name="name"> <br>
		나이: <input type="text" name="age"> <br>
		전화번호: <input type="text" name="phone"> <br>
		기타: <input type="text" name="etc">
		<input type="submit" value="전송">
		
	
	</form>






</body>
</html>