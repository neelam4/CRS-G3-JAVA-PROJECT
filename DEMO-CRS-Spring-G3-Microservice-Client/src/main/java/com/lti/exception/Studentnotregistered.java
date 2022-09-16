package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Studentnotregistered extends Exception{
	private String message;

	  public Studentnotregistered (String message) {
	    this.message = "Student not registered";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
