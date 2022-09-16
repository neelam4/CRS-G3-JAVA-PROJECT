/**
 * 
 */
package com.lti.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.Studentalreadyregistered;
import com.lti.exception.Useridnotfound;
/**
 * @author 10710198
 *
 */

//calls UserImplementation methods

public interface UserDao {

	
	/*
	 * Userlogin method
	 * @param UserId
	 * @throws Useridnotfound
	 */
	public String login(int id,String pass) throws Useridnotfound;
	/*
	 * Password updation method
	 * @param UserId
	 * @throws Useridnotfound
	 */
	public String updatePassword(int id,String oldpass,String newpass)throws Useridnotfound;


}
