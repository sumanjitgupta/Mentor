package com.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.dao.CourseDao;
import com.java.model.Course;

/**
 * Servlet implementation class CourseServlet
 */
//@WebServlet("/entercourse")
@WebServlet(name="entercourse",urlPatterns={"/entercourse"})
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CourseDao coursedao = new CourseDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/course.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String coursename = request.getParameter("coursename");
		String timeline = request.getParameter("timeline");
		String details = request.getParameter("details");
		String link = request.getParameter("link");
		String summary = request.getParameter("summary");
		
		Course course = new Course();
		course.setCoursename(coursename);
		course.setTimeline(timeline);
		course.setDetails(details);
		course.setLink(link);
		course.setSummary(summary);
		
		try {
			coursedao.courseSave(course);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/message.jsp");
		rd.forward(request, response);
	}

}
