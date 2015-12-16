package com.xch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AbsDao {

	
	static{
		ResourceBundle rb = ResourceBundle.getBundle("xch");
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public Connection getConn() throws SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("xch");
		String url = rb.getString("url");
		String uname = rb.getString("uname");
		String pwd = rb.getString("pwd");
		Connection conn = 
				DriverManager.getConnection(url, uname, pwd);
		
		return conn;
		
	}
	
	public void closeConn(Connection conn){
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}







