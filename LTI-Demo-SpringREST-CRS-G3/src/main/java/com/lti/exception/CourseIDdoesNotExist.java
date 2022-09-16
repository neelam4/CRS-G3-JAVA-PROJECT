/**
 * 
 */
package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import java.lang.String;
/**
 * @author 10710249
 *
 */

public class CourseIDdoesNotExist extends Exception{
	private String message;

	  public CourseIDdoesNotExist (String message) {
	    this.message = "Course ID does Not Exist";
	  }

	  public String getMessage() {
	    return this.message;
	  }
	

}
