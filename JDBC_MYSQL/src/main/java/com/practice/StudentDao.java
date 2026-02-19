package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.test.EmpDao;

public class StudentDao {
	public static Connection getCon() {
		Connection con = null;
		
		String driver = "com.mysql.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/mlafeb";
		
		String user = "root";
		
		String pas = "root@39";
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url,user,pas);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return con;
	}
	
	public void saveStudent(Student s) {
		try {
			String sql = "insert into Student values(?,?,?)";
			
			Connection con = StudentDao.getCon();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, s.getUsn());
			pst.setString(2, s.getName());
			pst.setString(3, s.getClg());
			
			pst.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents(){
		List<Student> sList = new ArrayList<>();
		try {
			String sql = "select * from Student";
			
			Connection con = StudentDao.getCon();
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Student s = new Student();
				s.setUsn(rs.getString(1));
				s.setName(rs.getString(2));
				s.setClg(rs.getString(3));
				sList.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sList;
	}
	
	public void updateStudent(Student s) {
		try {
			String sql = "update student set name = ?, clg = ? where usn = ?";
			
			PreparedStatement pst = EmpDao.getCon().prepareStatement(sql);
			
			pst.setString(1, s.getName());
			pst.setString(2, s.getClg());
			pst.setString(3, s.getUsn());
			
			pst.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(String usn) {
		try {
			String sql = "delete from student where usn = ?";
			
			PreparedStatement pst = EmpDao.getCon().prepareStatement(sql);
			
			pst.setString(1, usn);
			
			pst.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
