package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Usernotapproved extends Exception{
	private String message;

	  public Usernotapproved (String message) {
	    this.message = "User not approved";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
