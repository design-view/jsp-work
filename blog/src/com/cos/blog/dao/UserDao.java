package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.User;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class UserDao {
	private static UserDao instance = new UserDao();
	private UserDao() {}
	
	public static UserDao getInstance() {
		return instance;
	}
	
	public User 로그인(User user)	{
		String sql = "SELECT id,username,email,address From users Where username=? And password=?";
		Connection conn = DBConn.getInstance();
		try {
			//prepareStatement를 사용하는 이유 ?공격을 막아줌 
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				/*
				User userEntity = new User(
						rs.getInt("id"),
						rs.getString("username"),
						rs.getString("email"),
						rs.getString("address")
				);*/
				User userEntity = User.builder()
						.id(rs.getInt("id"))
						.username(rs.getString("username"))
						.email(rs.getString("email"))
						.address(rs.getString("address"))
						.build();
				return userEntity;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public int 회원가입(User user) {
		String sql = "INSERT INTO users(username, password, email, address, createDate) values(?,?,?,?,now())";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			//후처리를 위해 받음 -1오류
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public int 회원수정(User user) {
		String sql = "update users set username=?, password=?,email=?,address=?,createDate = now() where id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setInt(5, user.getId());
			//후처리를 위해 받음 -1오류
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
}
