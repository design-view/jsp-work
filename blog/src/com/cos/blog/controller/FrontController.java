package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.model.Post;

//http://localhost:8080/blog/post/list.do
//모든 .do 요청은 FrontController를 탄다.
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
    public FrontController() {
        super();
    }
    void route(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//요청주소를 변수 uri에 담아라
    	String uri = request.getRequestURI();
    	//context값을 받아와서 변수 contextPath에 담아라 
		//uri에 담긴 값에서 contextpath를 찾아서 비워라.
		//uri = uri.replace(contextPath, "");
		System.out.println("uri : " + uri);
		
		if(uri.equals("/post/list.do")){
			//모델(DB연결 - 데이터가져와서 )
			Post post = new Post(1,"제목1","내용1",1,null,2);
			request.setAttribute("post", post);;
			//페이지 이동시 request, response가 새로 만들어 지는데 
			//RequestDispatcher는 request, response를 유지시킨다.
			RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
			
			dis.forward(request, response);
			
			//response.sendRedirect("/post/list.jsp"); //메인페이지
		}else if(uri.equals("/post/detail.do")) {
			response.sendRedirect("/post/detail.jsp");
		}else if(uri.equals("/post/saveForm.do")) {
			response.sendRedirect("/post/saveForm.jsp");
		}else if(uri.equals("/post/updateForm.do")) {
			response.sendRedirect("/post/updateForm.jsp");
		}else if(uri.equals("/user/joinForm.do")) {
			response.sendRedirect("/user/joinForm.jsp");
		}else if(uri.equals("/user/loginForm.do")) {
			response.sendRedirect("/user/loginForm.jsp");
		}else if(uri.equals("/user/updateForm.do")) {
			response.sendRedirect("/user/updateForm.jsp");
		}else if(uri.equals("/user/detail.do")) {
			response.sendRedirect("/user/detail.jsp");
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		route(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		route(request,response);
	}

}
