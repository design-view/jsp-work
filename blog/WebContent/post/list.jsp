<%@page import="com.cos.blog.model.Post"%>
<%@ include file="/include/header.jsp"  %>
<h1>PostList.jsp</h1>
<%
	Post post = (Post)request.getAttribute("post");
%>
<%=post.getId() %><br/>
<%=post.getTitle() %><br/>
<%=post.getContent() %><br/>
<%@ include file="/include/footer.jsp"  %>