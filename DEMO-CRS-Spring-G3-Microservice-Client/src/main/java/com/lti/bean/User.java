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
public class User {
	public int userId;
	public String userPassword;
	public String userName;
	public String role;
	public int IPAddress;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(int iPAddress) {
		IPAddress = iPAddress;
	}	
}
