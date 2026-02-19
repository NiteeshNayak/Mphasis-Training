package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		try {
			Connection con = DBDemo.getConnection();
			Statement stmt = con.createStatement();
			
			
			//Create Query
//			String sql = "create table Student(usn varchar(50), name varchar(50))";
//			
//			stmt.execute(sql);
//			
//			System.out.println("Student table created");
			
			//insert Query
//			String sql1 = "insert into student values('108','Anush')";
//			
//			int affected = stmt.executeUpdate(sql1);
//			if(affected > 0) {
//				System.out.println("Inserted Successfully..");
//			}else {
//				System.out.println("Insertion failed.");
//			}
			
			//Reading Data from Table
			String sql2 = "select * from student";
			
			ResultSet rs = stmt.executeQuery(sql2);
			
			while(rs.next()) {
				System.out.println("USN : "+rs.getString(1)+" Name : "+rs.getString(2));
			}
			
			//Deleting table Entries
			
//			String sql = "delete from student where usn = '108'";
//			int up = stmt.executeUpdate(sql);
//			
//			if(up > 0) {
//				System.out.println("Delete Successfull");
//			}else {
//				System.out.println("Delete Failed");
//			}
			con.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
