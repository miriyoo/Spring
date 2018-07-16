<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link href="<c:url value="/resources/css/main.css" />" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/caption.css" />" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/caption.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script type="text/javascript">

	function writeForm(){
		location.href = "board/writeForm";
	}
	
	function pagingFormSubmit(){
		var form = document.getElementById('pagingForm');
		form.submit();
	}
	
	function goHome(){
		location.href = "/project2";
	}
	
	function pagingFormSubmit(currentPage){
		var form = document.getElementById('pagingForm');
		var page = document.getElementById('page');
		page.value = currentPage; //전달받은 페이지를 대입하고 서밋
		
		form.submit();
	}

</script>
</head>
<body>
	<div class="nav">
		<div class="top">
			<div class="wrap">
				<div class="left logo menu-text">
					<span class="s1" onclick="goHome()">Hello World </span>블로그 
					<form action="" method="get" id="pagingForm">
						<select class="pagingForm1" name="searchSelect">
							<option value="title" <c:if test="${searchSelect == 'title' }" >selected</c:if> >제목</option>
							<option value="id" <c:if test="${searchSelect == 'id' }" >selected</c:if>>작성자</option>
							<option value="content" <c:if test="${searchSelect == 'content' }" >selected</c:if>>글</option>
						</select>
						<input type="hidden" name="page" id="page">
						<input type="text" 	name="searchText" class="searchText" value="${searchSelect }"> 
						<input type="button" value="검색" class="btn1" onclick="pagingFormSubmit(1)">
					</form>
				</div>
				
				<div class="right">
					<c:choose>
						<c:when test="${sessionScope.loginId == null }">
							<div class="left sub menu-text">
								<a href="member/loginPage" class="a1">로그인</a>
							</div>
							<div class="left sub menu-text">
								<a href="member/joinForm" class="a1">회원가입</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="left sub menu-text">
								<a href="member/logout" class="a1">로그아웃</a>
							</div>
							<div class="left sub menu-text">
								<a href="member/update?loginId=${sessionScope.loginId }" class="a1">내 정보 수정</a>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	
	<div class="hotTopic">
		<div class="wrap">
			<h3 class="hotTopic1">핫토픽 ></h3>
			<ul class="img">
				<c:forEach var="topic" items="${hotTopic }">
					<li class="boxgrid">
	      				 <img src="board/download?boardnum=${topic.boardnum }" alt="" />
	      				  <dl class="boxcaption">
	           				 <dt>${topic.title }</dt>
	          				 <dd>작성자: ${topic.id }
	          				 <br>작성일자: ${topic.inputdate }
	            			 <br/><a href="board/readBoard?boardnum=${topic.boardnum }">View More</a>
	           				 </dd>
	       				 </dl>
	   				</li>
				</c:forEach>
			</ul>
		</div>
	</div>


	<div class="status">
		<div class="wrap">
			<div class="status1">
				<c:choose>
					<c:when test="${sessionScope.loginId == null }">
						<h3 class="s2">로그아웃 상태입니다.</h3><br>
						<h3 class="s2">로그인하여 새 글을 작성해보세요.</h3><br>
					</c:when>
					<c:otherwise>
						<h3 class="s2">${sessionScope.loginName }님 환영합니다. </h3><br>
						<h3 class="s2">새 글을 작성해보세요.</h3><br>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<div class="title">
		<div class="wrap">
			<div class="totalNum">
				<h4>전체 게시글 수: ${total }</h4>
			</div>
			<div class="write">
				<c:if test="${sessionScope.loginId != null }">
					<input type="button" value="글 쓰기" class="btnW" onclick="writeForm()">
				</c:if>
			</div>
		</div>
	</div>
	
	<div class="list">
		<div class="wrap">
			<c:forEach var="board" items="${list }">
				<div class="content">
					<div class="content1">
						<h3 class="content2 c3">작성자 ID: ${board.ID }</h3>
						<h3 class="content2 c3">
							<a href="board/readBoard?boardnum=${board.BOARDNUM }">제목: ${board.TITLE }</a>
						</h3>
						<p class="c3 c4">${board.CONTENT }</p>
						<h5 class="c5">조회 수: ${board.HITS }</h5> <h5 class="c5 c6">댓글 수: ${board.TOTALREPLY }</h5>
					</div>
					<div class="contentImg">
						<c:if test="${board.ORIGINALFILE != null }">
							<img alt="" class="img2" src="board/download?boardnum=${board.BOARDNUM }">
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<br>
	<br>
	
	<div class="wrap">
		<div style="text-align: center;">
			<a href="javascript:pagingFormSubmit(${navi.startPageGroup })">◁◁</a>
			<a href="javascript:pagingFormSubmit(${navi.currentPage - 1 })">◀</a>
			<c:forEach var="counter" begin="${navi.startPageGroup }" end="${navi.endPageGroup }">
				<c:if test="${counter == navi.currentPage }">
					<b>
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter })">${counter }</a>
				<c:if test="${counter == navi.currentPage }">
					</b>
				</c:if>
			</c:forEach>
			
			<a href="javascript:pagingFormSubmit(${navi.currentPage + 1 })">▶</a>
			<a href="javascript:pagingFormSubmit(${navi.endPageGroup })">▷▷</a>
		</div>
	</div>
	
	<br>
	<br>
	<br>
	<br>







</body>
</html>
