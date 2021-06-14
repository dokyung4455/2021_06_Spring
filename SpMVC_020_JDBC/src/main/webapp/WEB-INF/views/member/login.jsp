<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<%@ include file="/WEB-INF/views/include/include_head.jspf" %>
	<style>
	form#login_form {
		width:400px;
		height:400px;
		padding: 40px;
		background-color: olive;
		text-align: center;
		margin:60px auto;
		box-shadow: 0px 0px 100px black;	
		border-radius: 50%;	
	}
	form#login_form:hover {
		box-shadow: 0px 0px 2000px red;
	}
	form#login_form h2 {
		color: white;
		font-weight: 500;
	}
	form#login_form input#input1 {
		margin-top:80px;
	}
	form#login_form input {
		border: 0;
		outline: 0;
		direction: block;
		width: 200px;
		height: 40px;
		margin: 10px 20px;
		
		padding: 14px 10px;
		
		color: white;
		border-radius: 25px;
		border:2px solid black;
		
		text-align: center;
		transition:0.3s;
		
	}
	form#login_form input:focus {
		width: 280px;
		border-color: red;
	}
	form#login_form button {
		border:0;
		outline:none;
		background: none;
		display: block;
		margin: 20px auto;
		width:200px;
		text-align: center;
		border:1px solid silver;
		color:white;
		border: 25px;
		cursor: pointer;
	}
	
	</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
	<form id="login_form" method="POST">
	<input id="input1" name="m_username" placeholder="ID"/>
	<input type="password" name="m_password" placeholder="PW"/>
	<button>로그인</button>
	</form>




	<%@include file="/WEB-INF/views/include/include_footer.jspf"%>
</body>
<script type="text/javascript">
	document.querySelector("button.btn_book_insert").addEventListener("click", ()=> {
		location.href = "${rootPath}/books/insert";
	});
</script>
</html>