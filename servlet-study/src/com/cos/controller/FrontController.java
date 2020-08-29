package com.cos.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	@Override
	//데이터줘!! -> 어떤 데이터줘? (SELECT -> 쿼리스트링:?키="키값");
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("goGet() 요청");
		System.out.println(req.getRequestURI());
		String uri = req.getRequestURI();
		
		if(uri.equals("/user.do")) {
			System.out.println("/user접근");
			System.out.println();
			resp.sendRedirect("user.jsp");
		}else if(uri.equals("/profile.do")) {
			System.out.println("/profile접근");
			System.out.println();
			resp.sendRedirect("profile.jsp");
		}else if(uri.equals("/.do")) {
			System.out.println("/접근");
			System.out.println();
			resp.sendRedirect("index.jsp");
		}
		//else {
			//System.out.println("아무주소로 접근");
			//resp.sendRedirect("index.jsp");
		//}
		// super.doGet(req, resp);
	}
	@Override
	//데이터 줄께 -> 어떤 데이터 (INSERT,DELETE,UPDATE -> Http Body-MIME타입)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()"); 
		super.doPost(req, resp);
	}
}

