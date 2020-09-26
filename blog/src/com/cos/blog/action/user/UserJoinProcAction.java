package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserJoinProcAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.회원가입 진행(insert) -> Model로 이동
		System.out.println("UserController: joinProc:");

		User user = new User(request.getParameter("username"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("address"));
		// 자바가 toString()이 자동으로 되도록 해놓음~
		System.out.println(user.toString());
		UserDao userDao = new UserDao();
		userDao.회원가입(user);
		// 2.로그인페이지로 이동
		response.sendRedirect("/user/loginForm.jsp");

	}
}
