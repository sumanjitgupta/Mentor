package com.java.dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.model.Course;

public class CourseDao {
	
	public int courseSave(Course course) throws ClassNotFoundException{
		
		int result=0;
		String INSERT_COURSE_SQL= "INSERT INTO coursedetails" +
		"(coursename, timeline, details, link, summary) VALUES" +
				"(?,?,?,?,?);";
		System.out.println("Inside DAO");
		Connection con=null;
		
		try{
			 Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mentor","root",""); 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try{
			System.out.println(con);
			
			PreparedStatement ps = con.prepareStatement(INSERT_COURSE_SQL);
			ps.setString(1, course.getCoursename());
			ps.setString(2, course.getTimeline());
			ps.setString(3, course.getDetails());
			ps.setString(4, course.getLink());
			ps.setString(5, course.getSummary());
			
			System.out.println("prepared statement: "+ps);
			result = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result;
		
		
	
	
	}

}
