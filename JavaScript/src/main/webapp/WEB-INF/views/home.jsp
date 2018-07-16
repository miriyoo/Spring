<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="<c:url value="../resources/js/jquery-3.2.1.js" />"></script>
	<script type="text/javascript">
		
		function Product(name, weight, price){
			this.이름 = name;
			this.무게 = weight;
			this.가격 = price;
		}
		
		this.calculate = function(){
			
		}
		
		

		var product = new Product('돼지삼겹살', 100, 1670);
		
		var input = prompt('무게를 입력하세요', '무게');
		
	
		
		
	</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
	<button id="btn1" onclick="test();">click</button>
</body>
</html>
