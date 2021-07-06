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
<title>Insert title here</title>
<script>

document.addEventListener("DOMContentLoaded", ()=>{
	document.querySelector("div.msg").style.display = "${MSG}";
	document.querySelector("button.btn_join").addEventListener("click", ()=> {
		location.href="{rootPath}/join"
	})
	document.querySelector("button#btn_login").addEventListener("click",(e)=>{
		document.querySelector("form#login").submit();
	})
	document.querySelector("button#btn_logout").addEventListener("click",(e)=> {
		document.location.href="${rootPath}/logout"
	})
	
})
</script>
</head>


<body>
	<div>
		<div class="container">
			<div class="item-1">
			<c:if test="${empty MEMVO}">
				<form
					id="login"
					method="POST">
					<h2>로그인</h2>
					<div class="msg">${MSG}</div>
					<input name="us_id" /> <input
						type="password"
						name="us_pw" />
					<button id="btn_login">login</button>
					<button id="btn_join">join us</button>
				</form>
			</c:if>
			<c:if test="${not empty MEMVO}">
			<div class="log_join">
					<button class="btn_logout">logout</button>
					<button class="btn_mypage">MyPage</button>
				</div>
			</c:if>
			
				<div class="header">
					<h1 style="font-size: 90px; text-align: center">W O O</h1>
					<h4 style="font-size: 32px; text-align: center">WEATHER & OOTD</h4>
				</div>
			</div>
			<div class="item-2">
				<div
					class="w_1"
					style="border: 1px solid black;">
					<p>기온</p>
				</div>
				<div
					class="w_2"
					style="border: 1px solid black;">
					<img src="${rootPath}/static/images/1.png" />
				</div>
				<div
					class="w_3"
					style="border: 1px solid black;">위치시간</div>
				<div class="w_4">
					<div class="w_4_a">
						<div>온도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>21</div>
					</div>
					<div class="w_4_a">
						<div>온도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>21</div>
					</div>
					<div class="w_4_a">
						<div>온도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>21</div>
					</div>
					<div class="w_4_a">
						<div>온도</div>
						<div>
							<img src="${rootPath}/static/images/온도계.png" />
						</div>
						<div>21</div>
					</div>
				</div>
			</div>
			
			<c:if test="${empty MEMVO}">
			<link
	href="${rootPath}/static/css/home_B.css?ver=2021-07-05-001"
	rel="stylesheet" />
			<div class="item-3">
				<figure class="snip1200">
					<div>
						<img
							class="clothes"
							src="${rootPath}/static/images/clothes.png"
							alt="clothes"
							style="padding-top: 3%" />
						<p style="margin: 10px; font-size: 20px">OOTD 추천을 원하시면 화면에 커서를
							올려주세요</p>
					</div>
					<figcaption class="o">
						<div class="w_data_o">

							<div class="w_data_o_text">
								OOTD 추천을 원하시면<br> 로그인을 해주세요
							</div>

						</div>
						<div class="heading_o">
							<h1>
								<span> OOTD</span>
							</h1>
						</div>
					</figcaption>
				</figure>
			</div>
			</c:if>
			<c:if test="${not empty MEMVO}">
			<link
	href="${rootPath}/static/css/home_A.css?ver=2021-07-02-001"
	rel="stylesheet" />
			<div class="item-3">
				<figure class="snip1200">
					<div>
						<img
							class="clothes"
							src="${rootPath}/static/images/clothes.png"
							alt="clothes"
							style="padding-top: 3%" />
						<p style="margin: 10px; font-size: 20px">OOTD 추천을 원하시면 화면에 커서를
							올려주세요</p>
					</div>
					<figcaption class="o">
						<div class="w_data_o">
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/formal-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/male-clothes.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>
							<div class="w_data_div_o">
								<img src="${rootPath}/static/images/polo-shirt.png" />
							</div>

						</div>
						<div class="heading_o">
							<h1>
								<span> OOTD</span>
							</h1>
						</div>
					</figcaption>
				</figure>
			</div>
			</c:if>
		</div>
		<div class="item-4">3</div>
	</div>
</body>










</html>