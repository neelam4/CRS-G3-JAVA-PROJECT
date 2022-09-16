/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.Studentalreadyregistered;
import com.lti.utils.DbUtils;

/**
 * @author 10710198
 *
 */
//Registering student method


public interface RegistrationDao {

	/* 
	 @param args
	 */
	
	public String registration(int rId,String rName,String rAddress,String rContact,String rPassword)throws Studentalreadyregistered; 

	}
	
