<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"  %>
<div class="container">
	<h1>글쓰기 페이지</h1>
	<form action="/post?cmd=saveProc" method="post">
        <input type="hidden" value="${sessionScope.principal.id}" name="userid">
		<div class="form-group">
			<label for="username">제목 :</label> <input type="text" class="form-control" placeholder="Enter title"  name="title" required="required"/>
		</div>

		<div class="form-group">
			 <textarea id="summernote" class="form-control" name="content"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">글쓰기완료</button> <button type="reset" class="btn btn-primary">취소</button>
	</form>

</div>
    <script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 300
      });
    </script>
<%@ include file="/include/footer.jsp"  %>