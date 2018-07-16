<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ TEST ]</title>
</head>
<body>
	<form action="strTest" method="post"> <!-- 리퀘스트맵핑의 value가 strTest 메소드가 포스트 -->
		Text: <input type="text" name="text"> <br>
		Password: <input type="password" name="password"> <br>
		Radio: <input type="radio" name="radio" value="r1"> Radio1
			   <input type="radio" name="radio" value="r2"> Radio2
			   <input type="radio" name="radio" value="r3"> Radio3
		CheckBox: <input type="checkbox" name="checkbox" value="c1"> check1
				  <input type="checkbox" name="checkbox" value="c2"> check2
				  <input type="checkbox" name="checkbox" value="c3"> check3
		Hidden: <input type="hidden" name="hidden" value="hiddenValue"> <br>
		<input type="submit" value="전송">
	</form>

</body>
</html>