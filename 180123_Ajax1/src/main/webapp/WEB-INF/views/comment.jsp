<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript">
	$(function(){
		
		init();
		
		
		$('#formButton').on('click', function(){
			var name = $('#name').val();
			var text = $('#text').val();
			
			//값이 있는지 여부를 먼저 체크, 이미 value를 가지고 왔기 때문에 value가 생략
			if (name.length == 0 || text.length == 0) {
				alert("이름과 리플 내용을 입력하세요.");
				return;
			}
			
			$.ajax({
				url : "insert",
				type : "post",
				contentType : "application/json; charset=utf-8",
				//데이터를 JSON으로 보내준다는 뜻
				data : JSON.stringify({ //데이터를 JSON으로 변환
					name : name,
					text : text
				}),
				success : function(){
					alert("저장 되었습니다");
					//ajax는 화면이 새로고침이 되지 않는다.
					//폼 초기화!! 즉 칸에 입력된 값을 지워줘야 한다. -> 필수
					$('#name').val('');
					$('#text').val('');
					init();
				},
				error : function(e){
					alert(JSON.stringify(e)); //그냥 띄우면 오브젝트라고 나오기 때문에
				}
			});
		});
	});
	
	function init(){ //선언적 함수 -> init 가장 먼저 실행되는 함수
		$.ajax({
			url : "list",
			type : "get",
			//post -> insert, put -> update, delete -> delete, get -> select REST방식
			dataType : "json",
			success : function(obj){
				var str = '<table>';
				
				$.each(obj, function(index, item){
					str += '<tr>';
					str += '<td>'+item.num+'</td>';
					str += '<td>'+item.name+'</td>';
					str += '<td>'+item.text+'</td>';
					str += '<td><input type="button" value="삭제" class="btnDel" data-num="'+item.num+'"></td>';
					str += '</tr>';
				});
				str += '</table>';
				
				$('#listDiv').html(str);
				
				$('.btnDel').on('click', function(){
					//속성을 가져온다.
					var num = $(this).attr("data-num");
					
					$.ajax({
						url : "delete",
						type : "post",
						data : {
							num : num
						},
						success : function(){
							alert("삭제 되었습니다.");
							init(); // 이 부분 중요
						},
						error : function(err){
							console.log(err);
						}
					});
					

				});
				
			},
			error : function(err){
				console.log(err);
			}
		});
	}
	

</script>



<title>[ 리플 ]</title>
</head>
<body>
	<!-- 리플 작성 폼 영역 -->
	<div id="formDiv">
		<form id="writeForm">
			이름 <input type="text" id="name" name="name" style="width: 100px;">
			내용 <input type="text" id="text" name="text" style="width: 300px;">
			<input type="button" id="formButton" value="저장">
		</form>
	</div>
	
	<div id="listDiv">
		<!-- 화면에 출력에 될 부분 -->
		
	</div>
	
</body>
</html>