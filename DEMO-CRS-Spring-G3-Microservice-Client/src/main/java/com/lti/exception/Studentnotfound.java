package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Studentnotfound extends Exception{
	private String message;

	  public Studentnotfound (String message) {
	    this.message = "Student not found ";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
