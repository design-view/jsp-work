package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;

public class PostDao {
	
	public List<Post> 글목록(){
		List<Post> posts = new ArrayList<>();
		String sql = "SELECT * FROM post ORDER BY id DESC";  
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Post post = new Post(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getString("content"),
					rs.getInt("readCount"),
					rs.getTimestamp("createDate"),
					rs.getInt("userId")
				);
				posts.add(post);
				System.out.println("글목록");
			}
			return posts;
			
		} catch (Exception e) {
			e.printStackTrace(); //피범벅 뿌려주는애 윗부분을 보면됨
		}
		return null;
	}
	public int 글쓰기(Post post) {
		String sql = "INSERT INTO post(id, userId, title, content, readCount, createDate) values(?,?,?,?,0,now())";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, post.getId());
			pstmt.setInt(2, post.getUserId());
			pstmt.setString(3, post.getTitle());
			pstmt.setString(4, post.getContent());
			//후처리를 위해 받음 -1오류
			return pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
}
