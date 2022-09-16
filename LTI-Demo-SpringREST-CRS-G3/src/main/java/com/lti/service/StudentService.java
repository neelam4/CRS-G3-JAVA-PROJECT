/**
 * 
 */
package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.controller.StudentController;
import com.lti.dao.StudentImplementation;
import com.lti.dao.StudentImplementation;
import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Courselimitexceeded;
import com.lti.exception.Coursenotfound;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentalreadyregistered;

import java.util.HashMap;
import java.util.Scanner;
/**
 * @author 10710198
 *
 */
@Repository
public class StudentService implements StudentInterface{
	
	/*Viewing the list of course from course catalogue
    //@param Course ID
    //@ throws nocourseadded
     * 
     */
	@Autowired
	private StudentImplementation stud;
	public HashMap viewCourseCatalogue() {		
		 if (stud.viewCourseCatalogue().size()==0) {
	            System.out.println("->Course Catalogue is empty<-");
	            return null;
	        }
	        return stud.viewCourseCatalogue();
	
	}
	
	
	
	/*paying the fees for the registered semester
    //@param studentID
    //@ throws studentidnotfound
      */
    
	public String payFees(int id) throws Studentalreadyregistered {
       return stud.payFees(id);
        //return "Fee paid";
    }

	
	public String registerforCourse(int id) throws Studentalreadyregistered{

		return stud.registerforCourse(id);
		//return "semester registration done";
	}
	
	/*Adding course to the course catalogue
    @param Course ID
    @ throws courseidnotfound
    */
	public String addCourse(int id,int cid)throws CourseIDdoesNotExist,Courselimitexceeded{
		
		
		return stud.addCourse(id,cid);

	 //       return "Course added";
	}

	
	/*Removing course to the course catalogue
    @param Course ID
    @ throws cousreidnotfound
    */
	public String dropCourse(int id,int cid) throws CourseIDdoesNotExist{

		return stud.dropCourse(id,cid);
		// return "Course dropped";
	        
	}

	/*viewing the grade added to the courseID
    //@param CourseID
    //@ throws cousreidnotfound
	//@ throws gradenotadded
	*/
	public HashMap viewGrades(int id) throws Gradenotadded {
		        if (stud.viewGrades(id).size()== 0) {
		            System.out.println("->No Grades added<-");
		            return null;
		        }
		       return stud.viewGrades(id);
		 
	}



	
}
