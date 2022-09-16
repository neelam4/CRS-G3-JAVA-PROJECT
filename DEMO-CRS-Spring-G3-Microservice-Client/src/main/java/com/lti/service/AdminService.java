/**
 * 
 */
package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.lti.dao.AdminImplementation;
import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentnotfoundforapproval;

/**
 * @author 10710198
 *
 */
@Repository
public class AdminService implements AdminInterface {
	@Autowired
	private AdminImplementation a;

	/*
	 * Adding course to the course catalogue
	 * 
	 * @param Course ID
	 * 
	 * @ throws courseidnotfound
	 */
	public String addCourse(int adminId,int cId,String cName)throws Coursealreadyregistered {
		a.addCourse(adminId,cId,cName);
		return "Course added";
	}

	/*
	 * Removing course to the course catalogue
	 * 
	 * @param Course ID
	 * 
	 * @ throws cousreidnotfound
	 */
	public String removeCourse(int adminId,int cId) throws CourseIDdoesNotExist{
		return a.removeCourse(adminId,cId);
		//return "Course removed";
	}

	public String generateReportCard(int adminId) throws Gradenotadded {
		if (a.generateReportCard(adminId)==null) {
            System.out.println("->No Grades added<-");
            return null;
        }
         return "Report card generated";
	}

	/*
	 * Approving student registration
	 * 
	 * @param Course ID,StudentID
	 * 
	 * @ throws courseidnotfound
	 */
	public String approveregistration(int AdminId,int StudentId)throws Studentnotfoundforapproval {
		a.approveregistration(AdminId,StudentId);
		return "Registration approved";
	}

	/*
	 * Adding professor
	 * 
	 * @param UserID,department
	 * 
	 * @ throws professornotadded
	 */
	public String addProfessor(int adminId,int rId,String rName,String rAddress,String rContact,String rPassword,String dept) {

		//System.out.println("Enter the details of Professor.");

		return a.addProfessor(adminId,rId,rName,rAddress,rContact,rPassword,dept);
		//return "Professor added";
	}
	// public void add
}
