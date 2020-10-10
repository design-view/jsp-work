<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"  %>
<div class="container">
	
	<h1>상세보기</h1>
	<br/>
	<h6 class="m-2">
		작성자 : <i> ${post.userId}  </i> 조회수 : <i>${post.readCount} </i>
	<c:if test="${sessionScope.principal.id == post.userId }">	
	<a href="/post?cmd=updateForm&id=${post.id}" class="btn btn-warning">수정</a>
	<button onclick="postDelete(${post.id})" class="btn btn-danger">삭제</button>
	</c:if>
	</h6>
	<br />
	<h3 class="m-2">
		<b>${post.title}</b>
	</h3>
	<hr />
	<div class="form-group">
		<div class="m-2">${post.content}</div>
	</div>

	<hr />
</div>
<script>

	
    //var postDelete = (id)=> {}
	function postDelete(id){

		//펜딩 - 포스트로 보내기.. 펜딩은 두가지 파라메타를 받음 
		//get은 하이퍼링크로
		//Delete, Put, Post는 fetch()로 
		fetch("http://localhost:8080/post?cmd=deleteProc&id="+id,{
				method: "post"
			}) //pending(램)
		.then(function(res){ //다운로드 완료시 실행(파싱:다운로드받은 데이터를 분석)
			//3초뒤 실행
			// res => Promise객체(다운받은 데이터)
			// res.text();  -> 문자로 파싱
 			// res.json();  -> json으로 파싱
 			return res.text();
			console.log("")
		}).
		//위에서 res리턴을 아래에서 받는다.
		then(function(res){
			console.log(res);
			if(res=="ok"){
				alert("삭제성공");
				//경로이동
				location.href = "/";
			}else{
				alert("삭제실패");
				//되돌아가라
				history.back();
			}
		});
		
		console.log("1");
		console.log("2");
		console.log("3");
		console.log("4");
	}
</script>

<%@ include file="/include/footer.jsp"  %>