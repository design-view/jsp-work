package com.cos.blog.action.post;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.dao.UserDao;
import com.cos.blog.model.Post;

public class PostSaveProcAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션확인
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) return;
		
		// 2.공백확인
		String title = request.getParameter("title");
		title = title.replaceAll("<", "&lt;");
		title = title.replaceAll(">", "&gt;");
		String content =request.getParameter("content");
		int userId = Integer.parseInt(request.getParameter("userid"));
		System.out.println("title은" + title);
		System.out.println("content은" + content);
		Post post = new Post(
				title,content,0,userId
		);
		PostDao postDao = PostDao.getInstance(); 
		postDao.글쓰기(post);
		response.sendRedirect("/index.jsp");
	}
}
