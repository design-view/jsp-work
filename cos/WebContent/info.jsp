<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>
<% 
	if(session.getAttribute("auth") == null){
    out.print("<script>alert('인증되지 않았습니다.')</script>");
		//response.sendRedirect("login.jsp");
		return;
		//아래코드를 실행하지 않도록....
	}

	boolean isLogin = (boolean) session.getAttribute("auth");
	//어떤값이 들어올지 몰라서 오브젝트 타입으로 받은 뒤 블린형으로 변경해줘야함.--> 다운케스팅
	
	if(isLogin){
		%>
		인증된 사용자 입니다.
		<% 
	}
%>


	<h1>회원정보페이지</h1>
	
<%@ include file="layout/footer.jsp" %>	
	