package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class RoleSelectedDoesNotMatchUserId extends Exception{
	private String message;

	  public RoleSelectedDoesNotMatchUserId (String message) {
	    this.message = "Role Selected Does Not Match UserId ";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
