package com.cos.blog.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;

public class UserUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 회원수정 진행(update) Model로 이동
		//2. 메인페이지 이동 redirect
		HttpSession session = request.getSession();
		//1.세션확인
		if(session.getAttribute("principal")==null) {
			return;
		}
		//2.공백,null확인
//		if(request.getParameter("id")==null || request.getParameter("id").equals("")) {
//			return;
//		}
		//3.데이터 검증 
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		System.out.println("id:"+id);
		System.out.println("username:"+username);
		System.out.println("password:"+password);
		System.out.println("email:"+email);
		System.out.println("address:"+address);
		
		
		User user = new User(
				id,username,password,email,address,null
		);
		UserDao userDao = new UserDao();
		int result = userDao.회원수정(user);
		
		//회원수정이 성공했을때
		if(result==1) {
			
			session.setAttribute("principal", user);
		}
		
		response.sendRedirect("index.jsp");
//		BufferedReader br = request.getReader();
//		StringBuilder sb = new StringBuilder(); 
//		String input ="";
//		while((input = br.readLine())!=null) {
//			sb.append(input);
//		}
//		System.out.println(sb.toString());
	}

}
