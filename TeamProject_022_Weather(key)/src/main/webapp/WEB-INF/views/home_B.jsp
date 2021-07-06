<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/core"
	prefix="c"%>
<c:set
	var="rootPath"
	value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 홈페이지</title>
<script>

document.addEventListener("DOMContentLoaded", ()=>{
	document.querySelector("div.log_join").addEventListener("click", (e)=> {
		let tagName = e.target.tagName;
		//alert(tagName)
		
		if(tagName === "BUTTON") {
			let menuText = e.target.textContent;
			if (menuText === "login") {
				document.location.href="${rootPath}/login";
			} else if (menuText === "Join") {
				document.location.href="${rootPath}/join"
			}  else if (menuText === "logout") {
				document.location.href="${rootPath}/logout"
			}
		}
	})
	/*
	document.querySelector("li#li_log").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/login"
	})
	document.querySelector("li#li_join").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/join"
	})
	document.querySelector("li#li_logout").addEventListener("click",(e)=>{
		document.location.href="${rootPath}/logout"
	})
	*/
})
</script>
</head>


<script>
	/*
	 let logout = document.querySelector("button.logout")
	 let mypage = document.querySelector("button.mypage")

	 if(logout){
	 logout.addEventListener("click", (e) =>{
	 location.href = "${rootPath}"
	 })
	 }
	 */
</script>
</html>