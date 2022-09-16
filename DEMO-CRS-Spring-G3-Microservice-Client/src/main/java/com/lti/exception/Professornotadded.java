package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Professornotadded extends Exception{
	private String message;

	  public Professornotadded  (String message) {
	    this.message = "Professor not added";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
