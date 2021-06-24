<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<style>
	button.score.insert {
		background-color:  rgba(50,70,200,0.8);
		color:white;
	}
		button.score.student {
		background-color:  rgba(200,70,50,0.8);
		color:white;
	}
</style>
</head>
<body>

	<table>
		<tr>
			<th>seq</th>
			<th>학번</th>
			<th>이름</th>
			<th>과목코드</th>
			<th>과목명</th>
			<th>점수</th>
		</tr>
		<c:choose>
			<c:when test="'${empty LIST}">
				<tr><td colspan="5">데이터가 없음</td></tr>
			</c:when>
			<c:otherwise>
		<c:forEach items="${LIST}" var="SC">
			<tr>
				<td>${SC.sc_seq}</td>
				<td>${SC.sc_stnum}</td>
				<td>${SC.sc_stname}</td>
				<td>${SC.sc_sbcode}</td>
				<td>${SC.sc_sbname}</td>
				<td class="number" >${SC.sc_sbscore}</td>
			</tr>
		</c:forEach>
		</c:otherwise>
</c:choose>
	</table>
	<div class="btn_box">
	<button class="score insert">성적등록</button>
	<button class="score student list">학생정보 바로가기</button>
	</div>







</body>
</html>