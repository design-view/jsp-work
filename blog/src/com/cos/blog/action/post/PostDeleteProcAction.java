package com.cos.blog.action.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;
import com.cos.blog.model.Post;
import com.cos.blog.model.User;

public class PostDeleteProcAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PostDao 연결
		PostDao postDao = PostDao.getInstance(); 
		HttpSession session = request.getSession();
		if(session.getAttribute("prinsipal")==null) {
			return;
		}
		User user =(User)session.getAttribute("principal");
		int id = Integer.parseInt(request.getParameter("id"));
		Post post = postDao.상세보기(id);
		if(user.getId()!=post.getUserId()) {
			return;
		}
		
		
		//3초기다리기 그냥 실습용이니깐 숨기기
				/*
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		System.out.println("PostDeletProcAction 호출됨");
		//mime타입을 utf-8로 보내라 
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		//int result = 삭제하기(id);
		int result = postDao.삭제하기(id);
		if(result==1) {
			pw.print("ok");
		}else {
			pw.print("fail");
		}
		
		pw.flush();
	}
}
