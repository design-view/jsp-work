<%@page import="java.sql.ResultSet"%>
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
	<h1>데이터 한것 찾기 페이지 </h1>
	<hr/>
	<%
	
		if(request.getParameter("id") == null){
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		// http://localhost:8080/cos3/select.jsp?id=6
		String query = "SELECT * From person where id = ?";
		//선을 만든다.
		Connection conn = DBConn.getInstance(); //스트림
		//규칙이 있는 버퍼를 단다. 
		PreparedStatement pstmt = conn.prepareStatement(query); //버퍼 ?로해서 쿼리는 던지는 버퍼
		//?에 값을 넣음
		pstmt.setInt(1,id); //숫자는 물음표 순서
		//executeQuery() --> 얘는 select할때 쓰는 함수
		
		// executeQuery()를 하면  1)프러쉬(flush:비우기)
		// 결과를 rs에 넣는다.
		ResultSet rs = pstmt.executeQuery();
		//커서를 한칸내리고 데이터가 있으면 true, 없으면 false
		rs.next();
		
	%>
	<!-- 출력되는부분 -->
	<table>
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
		</tr>
		<tr>
			<td><%=rs.getInt("id") %></td>
			<td><%=rs.getString("pw") %></td>
			<td><%=rs.getString("name") %></td>
		</tr>
	</table>
</body>
</html>