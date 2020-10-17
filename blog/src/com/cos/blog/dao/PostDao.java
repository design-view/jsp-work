package com.cos.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.model.Post;

public class PostDao{
	private static PostDao instance = new PostDao();
	private PostDao() {}
	
	public static PostDao getInstance() {
		return instance;
	}
	
	public int 글수정하기(Post post) {
		
		String sql = "UPDATE post SET title = ?,content=? where id= ?";
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
	public List<Post> 글목록(int page){
		List<Post> posts = new ArrayList<>();
		
		//SELECT count(*) FROM post;
		//int count = postDao.글개수();
		//int lastPage = 연산;
		//0 시작하는 값 3은 갯수 
		int lastpage=0;
		
		
		String sql = "SELECT * FROM post ORDER BY id DESC limit ?, 3";  
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,page);
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
	public int 조회수증가(int id) {
		String sql = "UPDATE post SET readCount = readCount+1 WHERE id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			//후처리를 위해 받음 -1오류
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public int 삭제하기(int id) {
		String sql = "DELETE FROM post WHERE id = ?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			//후처리를 위해 받음 -1오류
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	public Post 상세보기(int id) {
		String sql = "SELECT * From post Where id=?";
		Connection conn = DBConn.getInstance();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);	
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Post userEntity = new Post(
						rs.getInt("id"),
						rs.getString("title"),
						rs.getString("content"),
						rs.getInt("readCount"),
						rs.getTimestamp("createDate"),
						rs.getInt("userId")
					);
				return userEntity;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

	
	

