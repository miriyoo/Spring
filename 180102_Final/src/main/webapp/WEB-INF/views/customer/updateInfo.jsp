<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 개인 정보 수정 ]</title>
<script type="text/javascript">
	
	function formCheck(){
		var password1 = document.getElementById('password');
		var password2 = document.getElementById('password2');
		var name = document.getElementById('name');
		var email = document.getElementById('email');
		var idno = document.getElementById('idno');
		var address = document.getElementById('address');
		
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
		
		} else if (idno.value == '') {
			alert("식별번호을 입력해주세요");
			return false;
			
		} else if (address.value == '') {
			alert("주소을 입력해주세요");
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
					${customer.custid }
					<input type="hidden" id="custid" name="custid" value="${customer.custid }"> 
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
					<input type="text" name="name" id="name" value="${customer.name }">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" id="email" value="${customer.email }">
				</td>
			</tr>
			<tr>
				<th>고객 구분</th>
				<td>
					<input type="radio" name="division" value="personal"
						<c:if test="${customer.division == 'personal'}">
							checked
						</c:if>	
					>개인
					
					<input type="radio" name="division" value="company"
						<c:if test="${customer.division == 'company'}">
							checked
						</c:if>	
					>기업
				</td>
			</tr>
			<tr>
				<th>식별 번호</th>
				<td>
					<input type="text" name="idno" id="idno" value="${customer.idno }">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address" id="address" value="${customer.address }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="수정">
				<input type="button" value="다시 쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>