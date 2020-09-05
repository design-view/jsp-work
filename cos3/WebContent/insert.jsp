<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.cos3.config.DBConn"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 입력</title>
</head>
<body>
	<h1>데이터 입력 페이지</h1>
	<hr/>
	<%
	
		if(request.getParameter("pw") == null || request.getParameter("name") == null){
			return;
		}
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String query = "INSERT INTO person(pw, name) VALUES(?,?)";
		Connection conn = DBConn.getInstance();
		//규칙이 있는 버퍼를 단다. 
		//플러시와 똑같은데 commit을 같이 날린다.
		//executeQuery() --> 얘는 select할때 쓰는 함수
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1,pw);
		pstmt.setString(2,name);
		
		//변경된 행을 리턴하고 실패하면0 오류가 나면 -1
		int result = pstmt.executeUpdate();
		
	%>
	수정된 행의 갯수 : <%=result%>
</body>
</html>