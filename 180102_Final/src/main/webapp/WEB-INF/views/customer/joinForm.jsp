<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 회원 가입 폼 ]</title>
<script type="text/javascript">

	<c:if test="${errorMsg != null }">
		alert('${errorMsg }');
	</c:if>


	function idcheckOpen(){
		window.open("idCheck", "newWindow", "top=200,left=400,height=300,width=400"); 
		// 새창이 띄어짐(액션명, 띄어질 페이지의 이름, 속성)
	}
	
	function formCheck(){ // form태크
		//비밀번호 체크 -> 다른 부분은 알아서 채워넣을 것 (비밀번호 길이, 기타 사항들)
		
		var password1 = document.getElementById("password");
		var password2 = document.getElementById("password2")
		
		if (password1.value == "") {
			alert("비밀번호를 입력해주세요");
			password1.focus();
			return false; //onsubmit이기 때문에 return값이 있어야한다. return값이 true일때만 액션이 넘어감
		} else if (password1.value != password2.value){
			alert("동일한 비밀번호를 입력해주세요")
			password2.focus();
			return false;
		}
		
	}

</script>

</head>
<body>
	<form action="join" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td colspan="2" align="center"><h1>[ 회원 가입 ]</h1></td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" id="custid" name="custid" readonly="readonly" value="${customer.custid }"
					 placeholder="id중복확인 사용"> 
					<!-- name은 vo의 변수명과 같아야한다. -->
					<input type="button" value="id중복확인" onclick="idcheckOpen()">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password" id="password" 
					value="${customer.password}" placeholder="비밀번호 입력"><br>
					<input type="password" id="password2" placeholder="비밀번호 다시 입력">
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" id="name" value="${customer.name }"
					placeholder="이름 입력">
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="email" id="email" value="${customer.email }"
					placeholder="이메일 입력">
				</td>
			</tr>
			<tr>
				<th>고객 구분</th>
				<td>
					<input type="radio" name="division" value="personal" checked="checked">개인
					<input type="radio" name="division" value="company">기업
				</td>
			</tr>
			<tr>
				<th>식별 번호</th>
				<td>
					<input type="text" name="idno" id="idno" value="${customer.idno }"
					placeholder="개인:주민번호 / 법인:사업자">
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" name="address" id="address" value="${customer.address }"
					placeholder="주소 입력">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="가입"><input type="button" value="다시 쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>