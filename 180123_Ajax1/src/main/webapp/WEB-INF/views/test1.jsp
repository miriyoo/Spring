<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript">
	$(function(){
		$('#bt1').on('click', function(){
			alert("버튼 클릭");
			
			$.ajax({
				//필수 - url : 적어주는 주소로 요청이 간다.
				url : "ajaxtest1",
				type : "get",//get방식인지 post방식인지
				dataType : "text", //스프링으로부터 받을 데이터의 타입을 지정한다
				success : function(){
					//요청을 보냈다가 응답을 받았을 때 성공하면 여기로 돌아온다.
					alert("성공");
				},
				error : function(){
					alert("실패");
				}
				
			});
		});
		
		$('#bt2').on('click', function(){
			$.ajax({
				url : "ajaxtest2",
				type : "post",
				data : {
					str : "클라이언트에서 보낸 문자열"
				}, //자바스크립트에 있는 데이터를 자바로 전송할 데이터
				dataType : "text",
				success : function(data){ //서버로부터의 데이터가 파라미터로 전달
					alert("서버에서 가져온 문자열 : " + data);
				},
				error : function(e){ //에러객체가 전달
					alert(JSON.stringify(e)); //암기
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<input type="button" id="bt1" value="서버로 요청 보내기">
	<input type="button" id="bt2" value="서버로 문자열 보내기/받기">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>