<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Blog</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/post/saveForm.do">로그인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/post/detail.do">게시판 글자세히보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/post/updateForm.do">게시판 글수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/post/list.do">게시판 글목록</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/loginForm.do">로그인</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/joinForm.do">회원가입</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/updateForm.do">회원수정</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/user/detail.do">회원자세히보기</a>
      </li>
    </ul>
  </div>
</nav>


