package com.cos.blog.action.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostListAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PostListAction");
		int page;
		
		if(request.getParameter("page")==null) {
			page=0;
		}else {
			page=Integer.parseInt(request.getParameter("page"));
		}
		PostDao postDao = PostDao.getInstance(); 
		List<Post> posts = postDao.글목록(page);
		
		request.setAttribute("posts", posts);
		RequestDispatcher dis = request.getRequestDispatcher("/post/list.jsp");
		dis.forward(request, response);
	}
}
