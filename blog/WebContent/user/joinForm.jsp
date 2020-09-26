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
			<button type="button" class="btn btn-warning float-right">주소검색</button> <input type="text" class="form-control" placeholder="Enter address" id="address" name="address">
		</div>

		<div class="form-group form-check">
			<label class="form-check-label"> <input class="form-check-input" type="checkbox"> Remember me
			</label>
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button> <button type="reset" class="btn btn-primary">취소</button>
	</form>

</div>

<%@ include file="/include/footer.jsp"%>