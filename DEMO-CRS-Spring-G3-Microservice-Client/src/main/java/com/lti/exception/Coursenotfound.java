package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Coursenotfound extends Exception{
	private String message;

	  public Coursenotfound (String message) {
	    this.message = "Course not Found ";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
