<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대한 고등학교 학생 세부성적</title>
<style>
div {
border:1px solid yellow;
}
table {
border: 1px solid red;
margin:0px auto;
margin-top:30px;
width : 40%;
background-color:rgba(0,10,0,0.7);

border-radius:5px; 

}
table tr th, td {
border: 1px solid green;
width:25%;
padding: 10px 0px;
color:white;
text-align:center;
outline: 0;
}
table th {
font-weight: bold;	
}
button {
display:block;
width:40%;
margin:5px auto;
padding: 1px 5px;
font-weight:bold;
border-radius: 3px;
}
button {
display:block;
width:40%;
margin:5px auto;
padding: 1px 5px;
font-weight:bold;
border-radius: 3px;
}
button:hover{
background-color:#ddd;
cursor: pointer;
}

</style>
<script>
	document.addEventListener()
</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_header.jspf"%>

<div>
	<table>
		<tr>
			<th>학번</th>
			<td>${STU.st_num}</td>
			<th>전공</th>
			<td>${STU.st_dept}</td>

		</tr>
		<tr>
			<th>이름</th>
			<td>${STU.st_name}</td>
			<th>학년</th>
			<td>${STU.st_grade}</td>
		</tr>
	</table>
	<button id="btn_stu">학생정보 수정</button>
	</div>
	<div>
	<table>
		<tr>
			<th>No.</th>
			<th>과목명</th>
			<th>점수</th>
		</tr>
		<c:forEach items="${SLIST}" var="SC">
		<tr>
			<td>${SC.sc_seq}</td>
			<td>${SC.sc_subject}</td>
			<td>${SC.sc_score}</td>
		</tr>
		</c:forEach>
		<tr>
		<td>총점</td>
		<td>${TOTAL.sc_subject}</td>
		<td>${TOTAL.sc_score}</td>
		</tr>
	</table>
	<button id="btn_score">성적추가</button>
	</div>
	
</body>
</html>