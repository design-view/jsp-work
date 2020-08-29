<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FrontController 웹 애플리케이션 </title>
<style>
	* { padding:0; margin:0; box-sizing: border-box;}
	body { font-family:"맑은고딕"; font-size: 14px; line-height:1.5; color:#3d3d3d; letter-spacing:-2px; }
	header {
		width: 100%;
		height: 60px;
		background: #fff;
		position:fixed;
		padding: 0 30px; 
		line-height:60px;
		z-index:100;
	}
	header h1 { font-weight:normal;  font-size: 26px; float: left; }
	header ul { float: right; padding-right: 30px;}
	header li { float: left; padding-left: 40px; position: relative;}
	a { text-decoration:none; color: #3d3d3d; }
	header li:not(:last-child)::after {
		content:"";
		display: block;
		width:1px;
		height:16px; 
		background:#ddd;
		position: absolute;
		top:22px;
		right:-18px;
	}
	li { list-style:none; }
	section { width:100%; height:100vh; background-image: linear-gradient(to bottom right, #ff9a9e 0%, #fecfef 99%, #fecfef 100%);
	text-align:center;
	}
	section h1 { font-size: 4vw; color:#fff; padding-top:46vh; font-weight:normal; }
	section h2 { font-size: 3vw; color:#fff; padding-top:15vh; font-weight:normal; padding-bottom: 10vh; position: relative;}
	section h2::after {
		content:"";
		display: block;
		position: absolute;
		width: 80px;
		height:2px;
		background:#fff;
		top: 14vh;
		left: 50%;
		transform: translateX(-50%);

	}
	section p { padding:10px 0; }
	section input { width:200px; height:40px; border:none; background: #fff; }
    section button { width: 200px; height:40px; background:#fecfef; border:none; color:#fff; }	
</style>
</head>
<body>
<header>
	<h1>pinkBlog</h1>
	<ul>
		<li><a href="/index.do">메인</a></li>
		<li><a href="/info.do">회원정보</a></li>
		<li><a href="/join.do">회원가입</a></li>
		<li><a href="/login.do">로그인</a></li>
		<li><a href="/logout.do">로그아웃</a></li>
	</ul>
</header>