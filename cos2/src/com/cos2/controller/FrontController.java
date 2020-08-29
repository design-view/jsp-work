package com.cos2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FrontController extends HttpServlet {
	
	
	// 데이터를 줘 get방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset=utf-8");
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();
		if(uri.equals("/join.do")) {
			resp.sendRedirect("join.jsp");
		}else if(uri.equals("/login.do")) {
			resp.sendRedirect("login.jsp");
		}else if(uri.equals("/info.do")) {
			resp.sendRedirect("info.jsp");
		}else if(uri.equals("/index.do")) {
			resp.sendRedirect("index.jsp");
		}else if(uri.equals("/logout.do")) {
			
			
			out.print("<script>alert('logout')</script>");
			out.print("<script>location.href='index.do';</script>");
			session.invalidate();
		}else if(uri.equals("/.do")) {
			resp.sendRedirect("index.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri2 = req.getRequestURI();
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		System.out.println(uri2);
		HttpSession session = req.getSession();
		if(uri2.equals("/loginPro.do")) {
			
			String username  = req.getParameter("username");
			String password = req.getParameter("password");
			
			if(username.equals("pink")&&password.equals("1234")){
				System.out.println("안녕");
				out.print("<script>alert('로그인 되었습니다.');");
				out.print("location.href='index.do';");
				out.print("</script>");
				session.setAttribute("auth", true);
			}
			
			
		}
		
	}
	
}
