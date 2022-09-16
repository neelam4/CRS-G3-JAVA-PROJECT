package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Studentalreadyregistered extends Exception{
	private String message;

	  public Studentalreadyregistered (String message) {
	    this.message = "Student already registered";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
