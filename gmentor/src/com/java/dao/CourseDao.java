package com.java.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.model.Course;

public class CourseDao {
	
	public int courseSave(Course course) throws ClassNotFoundException{
		
		int result=0;
		String INSERT_COURSE_SQL= "INSERT INTO coursedetails" +
		"(id , coursename, timeline, details, link, summary) VALUES" +
				"(?,?,?,?,?,?);";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mentor","root","");  
			
			PreparedStatement ps = con.prepareStatement(INSERT_COURSE_SQL);
			ps.setInt(1, 1);
			ps.setString(2, course.getCoursename());
			ps.setString(3, course.getTimeline());
			ps.setString(4, course.getDetails());
			ps.setString(5, course.getLink());
			ps.setString(6, course.getSummary());
			
			System.out.println("prepared statement: "+ps);
			result = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return result;
		
		
	
	
	}

}
