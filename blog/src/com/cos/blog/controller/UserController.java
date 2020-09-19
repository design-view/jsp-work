package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.UserJoinProcAction;
import com.cos.blog.action.UserLoginProcAction;
import com.cos.blog.action.UserLogoutAction;

//http://localhost:8080/blog/post/list.do
//모든 /user 요청은 UserController를 탄다.
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
    public UserController() {
        super();
    }
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("/user요청됨/");
    	String cmd  = request.getParameter("cmd");
    	System.out.println(cmd);
    	
    	Action action = route(cmd);
    	if(action != null) action.execute(request, response);
    }
    private Action route(String cmd) {
    	if(cmd.equals("joinForm")) {
    		//회원가입 페이지로 이동 Redirect
    		//response.sendRedirect("/user/joinForm.jsp");
    	}else if(cmd.equals("loginForm")) {
    		//로그인 페이지로 이동 Redirect
    		//response.sendRedirect("/user/loginForm.jsp");
    	}else if(cmd.equals("updateForm")) {
    		//회원수정 페이지로 이동 Model로 이동 후 RequestDispatcher
    	}else if(cmd.equals("joinProc")) {
    		return new UserJoinProcAction();
    	}else if(cmd.equals("loginProc")) {
    		return new UserLoginProcAction(); 
    	}else if(cmd.equals("logoutProc")) {
    		
    		return new UserLogoutAction();
    		//action.execute(request,response);
    	}
    	return null;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request,response);
	}

}
