package com.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBDemo {

	public static Connection getConnection(){
		Connection con = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mlafeb";
			String username = "root";
			String password = "root@39";
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}

