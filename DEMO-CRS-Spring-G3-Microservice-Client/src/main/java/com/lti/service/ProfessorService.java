/**
 * 
 */
package com.lti.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.dao.ProfessorImplementation;
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
@Repository
public class ProfessorService implements ProfessorInterface {
	/*Adding course to teach
    @param Course ID
    @ throws cousreidnotfound
	 */
	@Autowired
	ProfessorImplementation prof;
	public String selectCourse(int profId, int courseId)throws CourseIDdoesNotExist, Coursealreadyregistered{
		return prof.selectCourse(profId,courseId);
		
	}
	
	/*Adding grade to courseid
    //@param Course ID and grade
    //@ throws cousreidnotfound
     * */
	public String addGrade(int profId, int courseId, int studentId, String grade)throws Coursenotfound,Coursenotassignedtoprofessor,Studentnotfound {
		return prof.addGrade(profId,courseId,studentId, grade);
			
	}
	
	/*Viewing the list of enrolled students
    //@param Course ID and Student Id
    //@ throws cousreidnotfound
	*/
	public HashMap viewenrolledlist(int id)throws Professornotadded {
		if(prof.viewenrolledlist(id).size()==0)
			return null;
		return prof.viewenrolledlist(id);
		
	}

	

	


	
}
