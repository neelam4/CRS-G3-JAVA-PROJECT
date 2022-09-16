/**
 * 
 */
package com.lti.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Courselimitexceeded;
import com.lti.exception.Coursenotfound;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentalreadyregistered;
import com.lti.utils.DbUtils;
/**
/**
 * @author 10710198
 *
 */
/*
Calls StudentImplementation method
*/

public interface StudentDao {

	
	
	/*
	 * AddCourse method
	 * @param CourseId
	 * @param StudentId
	 * @throws CourseIDdoesNotExist,Courselimitexceeded
	 */
	public String addCourse(int id,int cid)throws CourseIDdoesNotExist,Courselimitexceeded;
	
	/*
	 * Viewing Course catalogue method
	 * @param StudentId
	 * @throws CoursenotFound
	 */
	public HashMap viewCourseCatalogue();
	/*
	 * Register course method
	 * @param StudentId
	 * @throws Coursealreadyregistered,CourseIDdoesNotExist
	 */
	public String registerforCourse(int rId,int cId) throws Studentalreadyregistered;
	/*
	 * Payfees method
	 * @param StudentId
	 * 
	 */
	public String payFees(int id) throws Studentalreadyregistered;
	/*
	 * Viewing Grade method
	 * @param StudentId
	 * @throws Gradenotadded
	 */
	public HashMap viewGrades(int id)throws Gradenotadded;
	/*
	 * Dropping course method
	 * @param StudentId
	 * @param CourseId
	 * @throws CourseIDdoesNotExist
	 */
	public String dropCourse(int id,int cid)throws CourseIDdoesNotExist; 

}
