package com.cos.blog.action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.dao.UserDao;
import com.cos.blog.model.User;
public interface Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; 
		

	
}
