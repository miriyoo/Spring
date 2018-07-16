<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 로그인 페이지 ]</title>
<script type="text/javascript">

	<c:if test="${errorMsg1 != null }">
		alert('${errorMsg1 }');
	</c:if>
		
	<c:if test="${errorMsg2 != null }">
		alert('${errorMsg2 }');
	</c:if>
	
	function formCheck(){
		var id = document.getElementById('custid');
		var password = document.getElementById('password');
		
		if (id.value == "") {
			alert("아이디를 입력해주세요");
			return false;
		} else if (password.value == ""){
			alert("비밀번호를 입력해주세요");
			return false;
		}
	}
</script>

</head>
<body>
	<form action="login" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td colspan="2" align="center"><h2>[ 로그인 ]</h2></td>
			</tr>
			<tr>
				<th>ID</th>
				<td><input type="text" name="custid" id="custid" value="${custid }"></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>













</html>