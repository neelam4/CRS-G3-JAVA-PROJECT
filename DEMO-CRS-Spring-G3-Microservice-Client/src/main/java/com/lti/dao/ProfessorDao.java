/**
 * 
 */
package com.lti.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

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
//implementing StudentImplementation method


public interface ProfessorDao {

	/*
	 * Selecting Course method
	 * @param ProfessorId
	 * @throws CourseIDdoesNotExist,Coursealreadyregistered
	 */
	public String selectCourse(int id,int cid)throws CourseIDdoesNotExist,Coursealreadyregistered;
	/*
	 * Adding grade method
	 * @param ProfessorId
	 * @throws CourseIDdoesNotExist,Coursenotassignedtoprofessor
	 */
	public String addGrade(int id, int courseId, int studentId, String grade)throws Coursenotfound,Coursenotassignedtoprofessor,Studentnotfound;
	/*
	 * Viewing enrolled student list method
	 * @param ProfessorId
	 * @throws CourseIDdoesNotExist
	 */
	public HashMap viewenrolledlist(int id)throws CourseIDdoesNotExist, Professornotadded; 
}
