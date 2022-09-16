/**
 * 
 */
package com.lti.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.controller.AdminController;
import com.lti.controller.ProfessorController;
import com.lti.controller.StudentController;
import com.lti.dao.RegistrationImplementation;
import com.lti.dao.UserImplementation;
import com.lti.exception.Studentalreadyregistered;
import com.lti.exception.Useridnotfound;

/**
 * @author 10710198
 *
 */
@Repository
public class UserService {
	/*Check the role of the user that is student , admin  or professor
    // @param  userid , role
     * 
     */
	@Autowired
	private UserImplementation user;
	@Autowired
	private RegistrationImplementation reg;
	
	public String login(int id,String password)throws Useridnotfound {
		return user.login(id,password);
		//return "Logged in!";
	}
	public void checkrole(int role,int id) throws Studentalreadyregistered {
		
		switch(role) {
			case 1:
				StudentController menuS;
				break;
			case 2:
				ProfessorController menuP;
				break;
			case 3:
				
				AdminController menuA;
				break;			
			default:
				System.out.println("Select valid role!");
		}
		
        return;
	}
	
	public String updatePassword(int id,String old,String newpass)throws Useridnotfound {
		return user.updatePassword(id,old,newpass);
	//	return "Password updated";
	}
	public String registration(int id,String name,String Address,String contact,String pass)throws Studentalreadyregistered {
		   if (reg.registration(id,name,Address,contact,pass)==null) {
	            System.out.println("-Already added student-");
	            return null;
	        }
	        return reg.registration(id,name,Address,contact,pass);
	    
	}
	public String logout(int id) {
		return "Logged out";
	}
	
}
