package com.cos3.config;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn {
	public static Connection getInstance() {
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			//DB에 연결된 선이다
			Connection conn = ds.getConnection();
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			System.out.println("DB 연결시 오류가 났습니다."+e.getMessage());
		}
		//오류가 나면 null값을 리턴한다.
		return null;
	}

}
