package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserLoginFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인 페이지로 이동 redirect
		//이코드는 안쓸거임 원리를이해
		//원리이해 --> String myCookie = request.getHeader("Cookie");
		//el 표현식 cookie검색해서 확인
		response.sendRedirect("/user/loginForm.jsp");
	}
}
