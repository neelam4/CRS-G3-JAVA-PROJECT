package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Coursealreadyregistered extends Exception {
	private String message;

	  public Coursealreadyregistered (String message) {
	    this.message = "Course already registered";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
