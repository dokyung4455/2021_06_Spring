<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="${rootPath}/static/css/join.css?ver=2021-07-04-001"
	rel="stylesheet" />
<body>
	<h1>Sign Up</h1>
	<h4>WEATHER & OOTD</h4>
	<section id="join_wrap">
		<form class="mem_join" method="POST">
			<fieldset>
				<table class="joinTable">
					<tr>
						<th class="first"><label for="us_id">ID</label></th>

						<td><input type="text" id="us_id" name="us_id"
							class="textForm" placeholder="ID를 입력...">
							<button id="id_check" type="button">중복확인</button></td>
					</tr>
					<tr>
						<th><label for="user_pwd">PW</label></th>
						<td><input type="password" id="us_pw" name="us_pw"
							class="textForm" placeholder="비밀번호를 입력..."></td>
					</tr>
					<tr>
						<th><label for="user_pwd_check">PW(check)</label></th>
						<td><input type="password" id="us_pw_ch" class="textForm"
							placeholder="비밀번호를 재확인..."></td>
					</tr>
					<tr>
						<th><label for="us_name">이름</label></th>
						<td><input type="text" name="us_name" class="textForm"
							placeholder="이름을 입력...">
					</tr>
					<tr>
						<th>지역선택</th>
						<td><select name="us_city" class="textForm">
								<option>선택</option>
								<option>서울</option>
								<option>대전</option>
								<option>대구</option>
								<option>부산</option>
								<option>광주</option>
								<option>경기도</option>
								<option>강원도</option>
								<option>충청북도</option>
								<option>충청남도</option>
								<option>전라북도</option>
								<option>전라남도</option>
								<option>경상북도</option>
								<option>경상남도</option>
						</select></td>
					</tr>
					<tr>
						<th>상세주소</th>
						<td><input name="us_dist" class="textForm"></td>
					</tr>
				</table>
				<button type="button" class="btn">가입하기</button>
			</fieldset>
		</form>
	</section>
</body>
<script>
// document.querySelector("table.joinTable").addEventListener("click", (e)=>{
	

	  let objId = document.querySelector("td input#us_id");
	  let objPw1 = document.querySelector("td input#us_pw");
	  let objPw2 = document.querySelector("td input#us_pw_ch");
	  
	  
	  document.querySelector("button#id_check").addEventListener("click", ()=> {
		  let json = { objId };
		  let jsonString = JSON.stringify(json);
		  fetch("${rootPath}/idcheck/" + objId.value)
		  .then(res=>res.text())
		  .then(result=>{
			  if(result == "1") {
				  alert("이미 사용중인 아이디 입니다.")
				  objId.focus();
				  objId.value = ""
				  return false;
			  } else {
				  alert("사용할 수 있는 아이디 입니다.")
			  }
			  
			  
		  })
		  		// , {
			  	// method:"POST",
				// body : jsonString,
				// headers : {
				// 	"content-Type" : "applications/json"	
				// }
		  // })
		  
	  })
	  
	  
	  
	  
	  document.querySelector("button.btn").addEventListener("click", ()=> {
		  
	  if((objId.value) == "") {
		  alert("ID를 입력하세요")
		  objId.focus();
		  return false;
	  }
	  if ((objPw1.value) == ""){
          alert("비밀번호를 입력해 주세요");
          objPw1.focus();
          return false;
      }
      if ((objPw2.value)==""){
          alert("비밀번호를 입력해 주세요");
          objPw2.focus();
          return false;
      }
      if((objPw1.value) !== (objPw2.value)) {
    	 alert("비밀번호가 일치하지 않습니다.")
    	 objPw1.focus();
    	 return false;
      }
      document.querySelector("form.mem_join").submit();
	  })
// })
  </script>
</html>