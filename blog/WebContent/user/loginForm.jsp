<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"  %>

<div class="container">
	<h1>로그인 페이지</h1>
	<form action="/user?cmd=loginProc" method="post">

		<div class="form-group">
			<label for="username">유저네임 :</label> <input type="text" class="form-control" placeholder="Enter username" id="email" name="username" />
		</div>

		<div class="form-group">
			<label for="pwd">패스워드 : </label> <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="password" />
		</div>

		<button type="submit" class="btn btn-primary">로그인</button> <button type="reset" class="btn btn-primary">취소</button>
	</form>

</div>

<%@ include file="/include/footer.jsp"%>
<%@ include file="/include/footer.jsp"  %>