<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<c:forEach items="${MOVIES}" var="MOVIE">
	<div class="content">
		<img src="${MOVIE.image}">
		<div>
			<p class="title">
				<a href="${MOVIE.link}" target="_NEW">${MOVIE.title}</a>
			</p>
			<p class="subtitle">${MOVIE.subtitle}</p>
			<p class="date">${MOVIE.pubDate}</p>
			<p class="director">
				<strong>감독 : </strong>${MOVIE.director}</p>
			<p class="actor">
				<strong>배우 : </strong>${MOVIE.actor}</p>
			<p class="userRating">
				<strong>관객 : </strong>${MOVIE.userRating}</p>
			<button class="insert">내 관심목록 등록</button>
		</div>
	</div>
</c:forEach>