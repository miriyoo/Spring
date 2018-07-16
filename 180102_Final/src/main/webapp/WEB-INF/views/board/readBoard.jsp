<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[ 게시판 글 상세 보기 페이지 ]</title>
<script type="text/javascript">
	
	function del(boardnum){
		if (confirm("정말로 삭제하시겠습니까?")) {
			alert('삭제되었습니다');
			location.href = "deleteBoard?boardnum="+boardnum;
		} else {
			alert('삭제가 취소되었습니다. 게시판 목록으로 돌아갑니다');
			location.href = "list";
		}
	}
	
	function backToList(){
		location.href = "list";
	}
	
	function revise(boardnum){
		if (confirm("해당 게시글을 수정하시겠습니까?")) {
			location.href = "reviseBoard?boardnum="+boardnum;
		} else {
			alert('취소되었습니다. 게시판 목록으로 돌아갑니다');
			location.href = "list";
		}
	}
	
	function deleteReply(replynum, boardnum){
		if (confirm("정말로 삭제하시겠습니까?")) {
			alert('삭제되었습니다');
			location.href = "deleteReply?replynum="+replynum+"&boardnum="+boardnum;
		} else {
			alert('삭제가 취소되었습니다. 게시판 목록으로 돌아갑니다');
			location.href = "list";
		}
	}
	
	function updateReplyForm(replynum, boardnum, replytext){
		//inner HTML
		//수정이라고 눌른 부분의 div를 가져온다. -> 많이 사용된다.
		var div = document.getElementById("div" + replynum);
		
		var str = '<form id="editForm'+replynum+'" action="replyUpdate" method="post">';
		str += '<input type="hidden" name="replynum" value="'+replynum+'">';
		str += '<input type="hidden" name="boardnum" value="'+boardnum+'">';
		str += '<input type="text" name="text" value="'+replytext+'">';
		str += '<a href="javascript:replyUpdate('+replynum+')">[수정하기]</a>';
		str += '<a href="javascript:replyCancel(div'+replynum+')">[취소]</a>';
		str += '</form>';
		
		div.innerHTML = str;
	}
	
	function replyCancel(div){
		div.innerHTML = "";
	}
	
	function replyUpdate(replynum){
		var form = document.getElementById("editForm" + replynum);
		
		form.submit();
	}
	
	
</script>


</head>
<body>
	<table>
			<tr>
				<td colspan="2" align="center"><h2>[ 게시판 글 읽기 ]</h2></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${vo.id }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${vo.inputdate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${vo.hits }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${vo.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${vo.content }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<a href="download?boardnum=${vo.boardnum }">
						${vo.originalfile }
					</a>
					<c:if test="${vo.originalfile != null }"> <!-- 첨부파일이 있음 -->
						<img alt="" src="download?boardnum=${vo.boardnum }">
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<c:if test="${sessionScope.loginId == vo.id }">
						<input type="button" value="삭제" onclick="del('${vo.boardnum}')"> 
						<input type="button" value="수정" onclick="revise('${vo.boardnum}')"> 
					</c:if>
					<!-- <a href="javascript:deleteBoard()"></a> -->
				<input type="button" value="목록 보기" onclick="backToList()">
				</td>
			</tr>
		</table>
		
		<br>
		
		<form action="insertReply" method="post">
			<input type="hidden" name="boardnum" value="${vo.boardnum }">
			리플내용 <input type="text" name="text">
			<input type="submit" value="확인">
		</form>
		
		<table>
			<c:forEach var="reply" items="${replyList }">
				<tr>
					<td>${reply.id }</td>
					<td>${reply.text }</td>
					<td>
					<c:if test="${sessionScope.loginId == reply.id }">
						<a href="javascript:updateReplyForm
						('${reply.replynum }','${reply.boardnum }', '${reply.text }')">
							[수정]
						</a>
					</c:if>
					</td>
					<td>
					<c:if test="${sessionScope.loginId == reply.id }">
						<a href="javascript:deleteReply('${reply.replynum }','${reply.boardnum }')">
							[삭제]
						</a>
					</c:if>
					</td>
				</tr>
				<tr>
					<!-- 리플 수정 폼이 나타날 위치 -->
					<td colspan="4">
						<div id="div${reply.replynum }"></div>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		
		
		
		
		
		
		
</body>
</html>