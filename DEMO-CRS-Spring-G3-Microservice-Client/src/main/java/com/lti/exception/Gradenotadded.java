package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Gradenotadded extends Exception{
	private String message;

	  public Gradenotadded (String message) {
	    this.message = "Grade not added";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
