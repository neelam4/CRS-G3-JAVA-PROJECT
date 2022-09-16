/**
 * 
 */
package com.lti.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Coursenotassignedtoprofessor;
import com.lti.exception.Coursenotfound;
import com.lti.exception.Professornotadded;
import com.lti.exception.Studentnotfound;

/**
 * @author 10710198
 *
 */
@Service
public interface ProfessorInterface {
	public String selectCourse(int id,int cid) throws CourseIDdoesNotExist, Coursealreadyregistered;
	public String addGrade(int profId, int courseId, int studentId, String grade)throws Coursenotfound,Coursenotassignedtoprofessor,Studentnotfound;
	public HashMap viewenrolledlist(int id)throws Professornotadded ;
}
