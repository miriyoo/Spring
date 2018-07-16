<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 회원 가입 창 ]</title>
<script type="text/javascript">
	function formCheck(){
		var id = document.getElementById('custid');
		var pw = document.getElementById('password');
		var pw2 = document.getElementById('password2');
		var name = document.getElementById('name');
		
		if (id.value.length < 3 || id.value.length > 10) {
			alert("ID는 3~10자로 입력하세요.");
			id.focus();
			id.select();
			return false;
		}
		if (pw.value.length < 3 || pw.value.length > 10) {
			alert("비밀번호는 3~10자로 입력하세요.");
			pw.focus();
			pw.select();
			return false;
		}
		if (pw.value != pw2.value) {
			alert("비밀번호를 정확하게 입력하세요.");
			pw.focus();
			pw.select();
			return false;
		}
		if (name.value == '') {
			alert("이름을 입력하세요.");
			name.focus();
			name.select();
			return false;
		}
		return true;
	}
	
	function idCheckOpen(){
		window.open("idCheck", "newWindow", "top=200, left=400, width=400, height=300");
	}
		
		
	

</script>

</head>
<body>
	<h2>회원가입</h2>
	<form action="join" method="post" onsubmit="return formCheck();">
	<table>
		<tr>
			<th>
				ID
			</th>
			<td>
				<input type="text" name="custid" id="custid" value="${customer.custid }"
				readonly="readonly" placeholder="ID중복체크 사용">
				<input type="button" value="ID 중복확인" onclick="idCheckOpen()">
			</td>
		</tr>
		<tr>
			<th>
				비밀번호
			</th>
			<td>
				<input type="password" name="password" id="password" value="${customer.password }"
				placeholder="비밀번호 입력">
				<br>
				<input type="password" id="password2" placeholder="비밀번호 다시 입력">
			</td>
		</tr>
		<tr>
			<th>
				이름
			</th>
			<td>
				<input type="text" name="name" id="name" value="${customer.name }"
				placeholder="이름 입력">
			</td>
		</tr>
		<tr>
			<th>
				이메일
			</th>
			<td>
				<input type="text" name="email" id="email" value="${customer.email }"
				placeholder="이메일 입력">
			</td>
		</tr>
		<tr>
			<th>
				고객 구분
			</th>
			<td>
				<input type="radio" name="division" id="division" value="individual"
				checked="checked">개인 
				<input type="radio" name="division" id="division" value="company">기업
			</td>
		</tr>
		<tr>
			<th>
				식별번호
			</th>
			<td>
				<input type="text" name="idno" id="idno" value="${customer.idno }"
				placeholder="개인:주민번호/법인:사업자">
			</td>
		</tr>
		<tr>
			<th>
				주소
			</th>
			<td>
				<input type="text" name="address" id="address" value="${customer.address }"
				placeholder="주소 입력">
			</td>
		</tr>
	</table>
	<br>
	
	<input type="submit" value="가입" /> 
	<input type="reset" value="다시 쓰기" />
	
	
	
	</form>
</body>
</html>