<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale:1" />
<title>나의 홈페이지</title>
<style type="text/css">
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	width: 100wv;
	height: 100vh;
	display: flex;
	flex-direction: column;
	overflow: auto;
}

header {
	background: url("${rootPath}/static/images/header_background.jpg")
		no-repeat;
	background-size: 100% 100%;
	background-position: top;
	background-attachment: fixed;
	text-align: center;
	text-shadow: 1px 1px 1px black;
	color: white;
	padding: 2rem;
}

section#main_sec {
	flex: 1;
	width: 100wv;
	display: flex;
	flex-direction: column;
	background: linear-gradient(to bottom, blue, red);
	background-size: 100% 100%;
	background-attachment: fixed;
}

h2 {
	width: 90%;
	color: white;
	padding: 1rem;
	border: 1px solid #aaa;
	margin: 10px auto 0 auto;
}

table {
	border: 0;
	width: 90%;
	border-collapse: collapse;
	border-spacing: 0;
	margin: 10px auto;
}

tr {
	border-top: 1px solid green;
}

tr:last-child {
	border-bottom: 1px solid green;
}

tr:nth-of-type(odd) {
	background-color: #eee;
}

tr:nth-of-type(even) {
	background-color: #ccc;
}

tr:hover td {
	background-color: #aaa;
	cursor: pointer;
}

td, th {
	border-right: 1px solid green;
	padding: 8px 12px;
	text-align: center;
}

td:last-child, th:last-child {
	border: none;
}

td.number {
	text-align: right;
}

div.btn_box {
	width: 90%;
	/* table의 margin 10px auto로 설정되어 있기 때문에 top margin 은 0으로 bottom margin 은 10px 좌우는 auto로 설정*/
	margin: 0px auto 10px auto;
	padding: 5px;
	text-align: right;
}

div.btn_box button {
	border: 0;
	outline: 0;
	padding: 5px 8px;
	margin-left: 10px;
	border-radius: 5px;
}

button:hover {
	box-shadow: 2px 2px 2px black;
	cursor: pointer;
}

button.save {
	background-color: blue;
	color: white;
}

button.reset {
	background-color: olive;
	color: white;
}

button.list {
	background-color: green;
	color: white;
}

button.home {
	background-color: orange;
	color: white;
	text-shadow: 1px 1px 1px black;
}

button.update {
	background-color: purple;
	color: white;
}

button.delete {
	background-color: red;
	color: yellow;
}

button.insert {
	background-color: rgba(50, 70, 200, 0.8);
	color: white;
}

button.student.list {
	background-color: rgba(200, 70, 50, 0.8);
	color: white;
	text-shadow: 1px 1px 1px black;
}

form {
	width: 90%;
	margin: 0 auto 10px auto;
}

fieldset {
	background-color: #eee;
	border: 1px solid green;
	border-radius: 10px;
	padding: 0.7rem;
}

form label, form input {
	display: inline-block;
	margin: 5px;
	padding: 8px 16px;
}

form label {
	width: 30%;
	text-align: right;
	color: blue;
	font-weight: bold;
}

form input {
	width: 60%;
	outline: 0;
	border: #aaa;
	border-radius: 50px;
}

form input:hover {
	background-color: #ddd;
}
</style>
</head>
<body>

	<header>
		<h1>대한고교 성적처리</h1>
		<p>대한고교 성적처리 시스템 2021</p>
	</header>
	<section id="main_sec">
		<c:choose>
			<c:when test="${BODY == 'SCORE_VIEW'}">
				<%@ include file="/WEB-INF/views/score/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_LIST'}">
				<%@ include file="/WEB-INF/views/student/list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_INPUT'}">
				<%@ include file="/WEB-INF/views/student/input.jsp"%>
			</c:when>
			<c:when test="${BODY == 'STUDENT_DETAIL'}">
				<%@ include file="/WEB-INF/views/student/detail.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
</body>
<script>
/*
	JS 코드에서 event를 등록할때 현재 화면에 없는 DOM 요소에 addEvent를 설정하면 없는 함수라는 오류가 발생한다.
 	그 이유는 현재 화면에 없는 DOM 요소를 querySelector하면 그 결과값이 null 이기 때문에 발생하는 문제이다.
 	
 	JS 코드를 통합하여 모음으로 관리할 때는 addEvent 를 하려고 하는 요소가 있는지를 먼저 검사한 후 addEvent를 수행해 주어야 한다.
 */
let std_list = document.querySelector("button.student.list");
let std_insert = document.querySelector("button.student.insert");
let home = document.querySelector("button.student.home")
// std_list가 있으면
if(std_list) {
	std_list.addEventListener("click", (e)=> {
		location.href="${rootPath}/student"
	})
}
if(std_insert) {
	std_insert.addEventListener("click", (e)=> {
		location.href="${rootPath}/student/insert"
	})
}
if(home) {
	home.addEventListener("click", (e)=> {
		location.href="${rootPath}/"
	})
}

let table = document.querySelector("table.detail")
if(table) {
	table.addEventListener("click", (e)=>{
		let target = e.target
		let tagName = target.tagName
		
		if(tagName === "TD") {
			let tr = target.closest("TR")
			let stNum = tr.dataset.stnum
			location.href = "${rootPath}/student/detail?st_num=" + stNum
			
			
		}
		
	})
}


</script>
</html>