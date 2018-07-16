<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 개인 정보 수정 ]</title>
<script type="text/javascript">

	<c:if test ="${errorMsg != null}">
		alert("${errorMsg}")
	</c:if>
	
	function formCheck(){
		var id = document.getElementById('id');
		var password1 = document.getElementById('password');
		var password2 = document.getElementById('password2');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		
		if (password1.value == '') {
			alert("비밀번호를 입력해주세요");
			return false;
			
		} else if (password2.value == '') {
			alert("비밀번호를 입력해주세요");
			return false;
			
		} else if (password1.value != password2.value) {
			alert("동일한 비밀번호를 입력해주세요");
			password1.value = '';
			password2.value = '';
			password1.focus();
			return false;
			
		} else if (name.value == '') {
			alert("이름을 입력해주세요");
			return false;
			
		} else if (email.value == '') {
			alert("이메일을 입력해주세요");
			return false;
		
		} else if (id == '') {
			alert("아이디를 입력해주세요");
			return false;
			
		} 
		
	}

</script>

</head>
<body>

 	<form action="updateInfo" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td colspan="2" align="center"><h1>[ 개인 정보 수정 ]</h1></td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					${member.id }
					<input type="hidden" id="id" name="id" value="${member.id }"> 
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password" placeholder="비밀번호 입력"><br>
					<input type="password" id="password2" placeholder="비밀번호 다시 입력">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" value="${member.name }">
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="male"
						<c:if test="${member.gender == 'male'}">
							checked
						</c:if>	
					>남자 
					<input type="radio" name="gender" value="female"
						<c:if test="${member.gender == 'female'}">
							checked
						</c:if>	
					>여자
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" id="email" value="${member.email }"
					placeholder="이메일 입력">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="phone" id="phone" value="${member.phone }"
					placeholder="전화번호 입력">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정">
				<input type="reset" value="다시 쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>