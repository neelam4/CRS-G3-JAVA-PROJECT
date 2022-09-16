/**
 * 
 */
package com.lti.bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;

/**
 * @author 10710198
 *
 */
@Configuration
public class Professor extends User{
	User details;
	ArrayList<Course> courses = new ArrayList<Course>();	
	
	public User getDetails() {
		return details;
	}
	public void setDetails(User details) {
		this.details = details;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
}
