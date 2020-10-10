package com.cos.blog.action.post;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dao.PostDao;

public class PostDeleteProcAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
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
		//PostDao 연결
		PostDao postDao =  new PostDao();
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
