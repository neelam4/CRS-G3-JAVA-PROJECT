/**
 * 
 */
package com.lti.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Courselimitexceeded;
import com.lti.exception.Coursenotfound;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentalreadyregistered;

/**
 * @author 10710198
 *
 */
@Service
public interface StudentInterface {
	public HashMap viewCourseCatalogue();
	public String addCourse(int id,int cid) throws CourseIDdoesNotExist,Courselimitexceeded;
	public String dropCourse(int id,int cid) throws CourseIDdoesNotExist;
	public String registerforCourse(int id,int cid) throws Studentalreadyregistered;
	public HashMap viewGrades(int id) throws Gradenotadded;
	public String payFees(int id) throws Studentalreadyregistered;
}
