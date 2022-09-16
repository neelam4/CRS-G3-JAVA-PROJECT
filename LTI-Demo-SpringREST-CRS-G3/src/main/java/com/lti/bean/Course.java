/**
 * 
 */
package com.lti.bean;

import java.util.HashMap;

import org.springframework.context.annotation.Configuration;

/**
 * @author 10710198
 *
 */
@Configuration
public class Course {
	public int courseID;
	public String courseName;
	public int instructorID;
	public HashMap<Student, String> grades = new HashMap<Student, String>();
	
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getInstructorID() {
		return instructorID;
	}
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
	public HashMap<Student, String> getGrades() {
		return grades;
	}
	public void setGrades(HashMap<Student, String> grades) {
		this.grades = grades;
	}
}
