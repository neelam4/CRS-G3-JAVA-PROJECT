/**
 * 
 */
package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author 10710249
 *
 */


public class StudentIdDoesNotExist extends Exception{
	private String message;

	  public StudentIdDoesNotExist (String message) {
	    this.message = "Student Id Does Not Exist";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
