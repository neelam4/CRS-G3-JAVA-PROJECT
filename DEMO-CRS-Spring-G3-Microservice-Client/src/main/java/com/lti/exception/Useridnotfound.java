package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Useridnotfound extends Exception{
	private String message;

	  public Useridnotfound (String message) {
	    this.message = "User ID not found";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
