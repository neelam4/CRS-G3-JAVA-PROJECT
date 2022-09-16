/**
 * 
 */
package com.lti.bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Configuration;
@Configuration
public class Student extends User{
	
	User details = new User(); 
	public ArrayList<Course> primary = new ArrayList<Course>();
	public ArrayList<Course> secondary = new ArrayList<Course>();
	
	public User getDetails() {
		return details;
	}
	public void setDetails(User details) {
		this.details = details;
	}
	public ArrayList<Course> getPrimary() {
		return primary;
	}
	public void setPrimary(ArrayList<Course> primary) {
		this.primary = primary;
	}
	public ArrayList<Course> getSecondary() {
		return secondary;
	}
	public void setSecondary(ArrayList<Course> secondary) {
		this.secondary = secondary;
	}
	
	
}
