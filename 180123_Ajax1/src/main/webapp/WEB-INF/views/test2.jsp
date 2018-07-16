<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ Ajax Test2 ]</title>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript">
	$(function(){
		$('#formButton1').on('click', function(){
			var name = $('#name').val();
			var age = $('#age').val();
			
			//정규 표현식
			var numReg = /^[0-9]+$/;
			
			if(!numReg.test(age)){
				alert("숫자만 입력하세요");
			}
			
			var phone = $('#phone').val();
			
			//정규 표현식
			var phoneReg = /^\d{3}-\d{4}-\d{4}$/;
			
			$.ajax({
				url : "insert1",
				type : "post", //get으로 가면 주소표시창에 다 노출이 되기때문에 포스트가 안전
				data : {
					name : name, //왼쪽은 컨트롤러 쪽과 연결, 오른쪽에 변수의 값이 들어가 있음
					age : age,
					phone : phone
				},
				success : function(){
					alert("성공");
				},
				error : function(){
					alert(JSON.stringify(e));
				}
			});
		});
		
		$('#formButton2').on('click', function(){
			var name = $('#name2').val();
			var age = $('#age2').val();
			var phone = $('#phone2').val();
			
			$.ajax({
				url : "insert2",
				type : "post",
				contentType : "application/json; charset=utf-8", 
				//우리가 보낼 데이터의 타입, dataType는 받는 데이터의 타입으로 반대이다.
				data : JSON.stringify({ 
					//JSON의 형태인 문자열로 전달을 해야 자바스크립트가 인식할 수 있다.
					name : name,
					age : age,
					phone : phone
				}),
				success : function(){
					alert("성공");
				},
				error : function(){
					alert(JSON.stringify(e));
				}
			});
		});
		
		
		$('#formButton3').on('click', function(){
			
			$.ajax({
				url : "insert3",
				type : "post",
				data : $('#writeForm3').serialize(), //폼으로 보낸다.
				success : function(){
					alert("성공");
				},
				error : function(){
					alert(JSON.stringify(e));
				}
			});
		});
		
		
		$('#btn1').on('click',function(){
			
			$.ajax({
				url : "jsontest",
				type : "get",
				dataType : "json",
				success : function(obj){
					var str = '받은 값: '+obj+'<br>';
					str += '이름: '+obj.name + '<br>';
					str += '나이: '+obj.age + '<br>';
					str += '전화: '+obj.phone + '<br>';
					
					$('#outputDiv').html(str);
					
				},
				error : function(err){ //에러 정보를 가지고 있는 자바스크립트 객체
					alert("실패: " + err);
				}
			});
		});
		
		
		
		
		
	});
</script>
</head>
<body>
	<form id="writeForm1">
		이름: <input type="text" id="name"><br>
		나이: <input type="text" id="age"><br>
		전화: <input type="text" id="phone"><br>
		<input type="button" id="formButton1" value="저장">
	</form>
	
	<form id="writeForm2">
		이름: <input type="text" id="name2"><br>
		나이: <input type="text" id="age2"><br>
		전화: <input type="text" id="phone2"><br>
		<input type="button" id="formButton2" value="저장">
	</form>
	
	<form id="writeForm3">
		이름: <input type="text" name="name"><br>
		나이: <input type="text" name="age"><br>
		전화: <input type="text" name="phone"><br>
		<input type="button" id="formButton3" value="저장">
	</form>
	
	<p>
		<input type="button" id="btn1" value="서버에서 객체 받기">
	</p>
	
	<div id="outputDiv">
	
	</div>
	
	
</body>
</html>