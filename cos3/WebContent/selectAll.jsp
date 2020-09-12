
<%@page import="com.cos3.model.Person"%>
<%@page import="java.util.ArrayList"%>
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
<title>데이터 전체 찾기 입력</title>
</head>
<body>
	<h1>데이터 한것 찾기 페이지 </h1>
	<hr/>
	<%	
		// http://localhost:8080/cos3/select.jsp?id=6
		String query = "SELECT * From person";
		//선만들기
		Connection conn = DBConn.getInstance(); //스트림
		//쿼리를 버퍼에 넣어줌
		PreparedStatement pstmt = conn.prepareStatement(query); //버퍼 ?로해서 쿼리는 던지는 버퍼
		//행의 갯수를 리턴
		ResultSet rs = pstmt.executeQuery();
		//리스트를 만듬
		ArrayList<Person> persons =  new ArrayList<>();
		//커서를 한칸내리고 데이터가 있으면 true, 없으면 false
		while(rs.next()){ //커서 한칸 내리기 반복 5번돈다.
			Person person = new Person(
				rs.getInt("id"),
				rs.getString("pw"),
				rs.getString("name")
			);
			persons.add(person);
		};
		for(Person person : persons){
			System.out.println(""+person.getId());
			System.out.println(""+person.getPw());
			System.out.println(""+person.getName());
			System.out.println("==============================");
		}
		
	%>
	<!-- 출력되는부분 -->
	<table cellspacing="0" cellpadding="0" border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
		</tr>
		<% for(Person person : persons){ %>
			<tr>
				<td><%=person.getId() %></td>
				<td><%=person.getPw() %></td>
				<td><%=person.getName() %></td>
			</tr>
		<% } %>
	</table>
</body>
</html>