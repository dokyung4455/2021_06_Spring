<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한 고등학교 성적처리시스템</title>
<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

h1 {
	text-align: center;
	color: white;
}

body {
	background-color: rgba(150, 30, 200, 0.7);
}

form {
	display: inline-flex;
	border: 1px solid yellow;
	justify-content: center;
	width: 100%;
}

nav {
	border: 1px solid blue;
	background-color: rgba(0, 10, 0, 0.7);
	width: 30%;
	border-radius: 15px;
	margin: 0px 10px;
}

nav ul {
	list-style: none;
	display: flex;
	justify-content: center;
	border: 1px solid red;
	padding: 15px;
}

nav ul#menu_ul {
	list-style: none;
}

nav ul#member_ul {
	list_style: none;
}

nav ul li {
	border: 1px solid green;
	flex: 1;
	color: white;
	font-size: 18px;
	padding: 0px 30px;
	text-align: center;
}

nav ul li:hover {
	background-color: white;
	color: rgba(0, 10, 0, 0.7);
	border-radius: 5px;
	font-weight: bold;
	cursor: pointer;
}

table {
	border: 1px solid red;
	width: 100%;
	padding: 10px 40px;
}

table tr {
	border: 1px solid yellow;
}

table tr th {
	border: 1px solid green;
}

table tr td {
	border-bottom: 1px solid rgba(70, 80, 200, 0.7);
	color: white;
	text-align: center;
}

table tr#trlist:hover {
	background-color: #aaa;
}
</style>
<script>
	var rootPath = "${rootPath}";
	
	document.addEventListener("DOMContentLoaded", ()=>{
		document.querySelector("tr#trlist").addEventListener("click", (e)=> {
			alert("클릭")	
			let tagName = e.target.tagName
			if(tagName == "TD") {
				
				let tag_name = e.target.tagName;
				if (tag_name = "TD") {
					let seq = e.target
							.closest("TR").dataset.seq
					document.location.href = "${rootPath}/student/score?st_num="
							+ seq
				}
			}
			
			
		})
	})
</script>
<script src="${rootPath}/static/js/main_nav.js?ver=2021-06-18-003"></script>
</head>
<body>

	<header>
		<h1>대한 고교 성적처리 2021.v1</h1>
	</header>
	<form>
		<nav id="main_nav">
			<ul id="menu_ul">
				<li>HOME</li>
				<li>학생정보</li>
				<li>성적일람표</li>
			</ul>
			<ul id="member_ul">
				<li>로그인</li>
				<li>회원가입</li>
			</ul>
		</nav>
	</form>
	<table>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>전공</th>
			<th>학년</th>
			<th>응시과목</th>
			<th>총점</th>
			<th>평균</th>
		</tr>

		<c:forEach items="${LIST}" var="VW">
			<tr id="trlist" data-seq="${VW.st_num}">
				<td>${VW.st_num}</td>
				<td>${VW.st_name}</td>
				<td>${VW.st_dept}</td>
				<td>${VW.st_grade}</td>
				<td>${VW.sc_subject}</td>
				<td>${VW.sc_score}</td>
				<td>${VW.sc_avg}</td>
			</tr>
		</c:forEach>
	</table>


</body>

</html>