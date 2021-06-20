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


table {
	border: 1px solid red;
	width: 70%;
	padding: 10px 40px;
	margin:10px auto;
	background-color: rgba(0,10,0,0.7);
	border-radius: 10px;
}

table tr {
	border: 1px solid yellow;
}

table tr th {
	border: 1px solid green;
}

table tr td {
	border-bottom: 1px solid silver;
	color: white;
	text-align: center;
}

table tr#trlist:hover {
	background-color: #aaa;
	
	border-bottom: 3px solid rgba(70, 80, 200, 0.7);
}
</style>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include_header.jspf"%>
		<table id="tblist">
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