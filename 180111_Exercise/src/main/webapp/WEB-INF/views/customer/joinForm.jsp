<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 회원 가입 페이지 ]</title>
<script type="text/javascript">

	<c:if test="${errorMsg != null}">
		alert('${errorMsg}')
	</c:if>

	function formCheck(){
		var password1 = document.getElementById('password');
		var password2 = document.getElementById('password2');
		var name = document.getElementById('name');
		
		
		if (password1.value == '') {
			alert('비밀번호를 입력해주세요');
			password1.focus();
			return false;
			
		} else if (password2.value == '') {
			alert('비밀번호를 입력해주세요');
			password2.focus();
			return false;
			
		} else if (password1.value != password2.value){
			alert("동일한 비밀번호를 입력해주세요");
			password1.value = '';
			passowrd2.value = '';
			password1.focus();
			return false;
			
		} else if (name.value == ''){
			alert('이름을 입력해주세요');
			name.focus();
			return false;
		}
		
		
	}
	
	
	function idCheckOpen(){
		window.open("idCheck", "newWindow", "top=200, left=400, height=300, width=400");
	}


</script>

</head>
<body>
	<form action="join" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td colspan="2" align="center">
					<h1>회원가입</h1>
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="custid" id="custid" placeholder="ID중복확인 이용"
					readonly="readonly" value="${customer.custid }">
					<input type="button" value="ID 중복 확인" onclick="idCheckOpen()">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password" placeholder="비밀번호 입력"
					value="${customer.password }"><br>
					<input type="password" id="password2" placeholder="비밀번호 다시 입력">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" placeholder="이름 입력"
					value="${customer.name }" >
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" id="email" placeholder="이메일 입력"
					value="${customer.email }">
				</td>
			</tr>
			<tr>
				<th>고객 구분</th>
				<td>
					<input type="radio" name="division" id="division" value="individual" checked="checked">개인 
					<input type="radio" name="division" id="division" value="company">기업
				</td>
			</tr>
			<tr>
				<th>식별 번호</th>
				<td>
					<input type="text" name="idno" id="idno" 
					placeholder="개인:주민번호 / 법인:사업자" value="${customer.idno }">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address" id="address" placeholder="주소 입력"
					value="${customer.address }">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입"> 
					<input type="reset" value="다시 쓰기"> 
				</td>
			</tr>
		</table>
	</form>
	
	
	


</body>
</html>