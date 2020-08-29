<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<section>
	<h2>Login</h2>
	<div>
	<form action="/loginPro.do" method="POST">
		<p><span>아이디 </span><input type="text" name="username" placeholder="username"/></p>
		<p><span>아이디 </span><input type="password" name="password" placeholder="Password"></p>
		<p><button>로그인</button></p>
	</form>
	</div>
</section>
<footer></footer>
</body>
</html>