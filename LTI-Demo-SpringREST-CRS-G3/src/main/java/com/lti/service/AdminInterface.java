/**
 * 
 */
package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentnotfoundforapproval;

/**
 * @author 10710198
 *
 */


public interface AdminInterface {
	 public String addCourse(int adminId,int cId,String cName)throws Coursealreadyregistered;
	 public String removeCourse(int adminId,int cId)throws CourseIDdoesNotExist;
	 public String generateReportCard(int adminId) throws Gradenotadded;
	 public String approveregistration(int AdminId,int StudentId) throws Studentnotfoundforapproval;
	 public String addProfessor(int adminId,int rId,String rName,String rAddress,String rContact,String rPassword,String dept);
}
