<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
	
	<script type="text/javascript">
		$(function(){
			$('button').click(function(){
				$('.page').hide('slow');
			})
		});
	</script> 
	<style type="text/css">
		.reverse{
			background: black;
			color: white;
		}
	</style>
</head>
<body>
	<button>Toggle show</button>
	<div class="page">
		<h1>aaaaaaaaaaaaaaaaaaaaaaaaaaa</h1>
		<p>bbbbbbbbbbbbbbbbbbbbbbbb</p>
	</div>

</body>
</html>
