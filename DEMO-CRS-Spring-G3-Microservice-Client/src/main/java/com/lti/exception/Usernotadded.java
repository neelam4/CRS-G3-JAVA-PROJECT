package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Usernotadded extends Exception{
	private String message;

	  public Usernotadded(String message) {
	    this.message = "User not added";
	  }

	  public String getMessage() {
	    return this.message;
	  }
}
