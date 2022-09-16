/**
 * 
 */
package com.lti.bean;

import org.springframework.context.annotation.Configuration;

/**
 * @author 10710198
 *
 */
@Configuration
public class Admin extends User{
	User details;
	CourseCatalogue courses;
	
	
	public CourseCatalogue getCourses() {
		return courses;
	}	
	public void setCourses(CourseCatalogue courses) {
		this.courses = courses;
	}
	
	public User getDetails() {
		return details;
	}
	public void setDetails(User details) {
		this.details = details;
	}
}
