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

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentalreadyregistered;
import com.lti.exception.Studentnotfoundforapproval;
/**
 * @author 10710198
 *
 */
//interface for Admin operations


public interface AdminDao {
	/*
	 * Approve registration method
	 * @param StudentId
	 * @throws Studentalreadyregistered,Studentnotfoundforapproval
	 */
	public String approveregistration(int AdminId,int StudentId)throws Studentnotfoundforapproval;
	/*
	 * Generating report card method
	 * @throws Gradenotadded
	 */
	public String generateReportCard(int AdminId)throws Gradenotadded; 
	/*
	 * Adding course method
	 * @throws Coursealreadyregistered
	 */
	public String addCourse(int adminId,int cId,String cName)throws Coursealreadyregistered; 
	/*
	 * Adding professor method
	 */
	public String addProfessor(int adminId,int rId,String rName,String rAddress,String rContact,String rPassword,String dept); 
	/*
	 * Removing course method
	 * @param CourseId
	 * @throws CourseIDdoesNotExist
	 */
	public String removeCourse(int adminId,int cId)throws CourseIDdoesNotExist; 
	    
}
