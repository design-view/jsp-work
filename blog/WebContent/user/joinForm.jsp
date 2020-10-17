<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>

<div class="container">
	<h1>회원가입 페이지</h1>
	<form action="/user?cmd=joinProc" method="post">

		<div class="form-group">
			<label for="username">유저네임 :</label> <input type="text" class="form-control" placeholder="Enter username" id="email" name="username" />
		</div>

		<div class="form-group">
			<label for="pwd">패스워드 : </label> <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password" />
		</div>

		<div class="form-group">
			<label for="email">이메일 : </label> <input type="email" class="form-control" placeholder="Enter email" id="email" name="email" />
		</div>

		<div class="form-group">
			<label for="address">주소 : </label>
			<button type="button" class="btn btn-warning float-right" onClick="goPopup();" value="팝업_domainChk">주소검색</button> 
			<input type="text" class="form-control" placeholder="Enter address" id="address" name="address" readonly="readonly">
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button> <button type="reset" class="btn btn-primary">취소</button>
	</form>

</div>
<script>

function goPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("/juso/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		//document.form.roadFullAddr.value = roadFullAddr;
		document.querySelector("#address").value=roadFullAddr;
		
}
</script>
<%@ include file="/include/footer.jsp"%>