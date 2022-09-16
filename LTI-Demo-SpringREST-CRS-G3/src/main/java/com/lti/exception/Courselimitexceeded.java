package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Courselimitexceeded extends Exception{
	private String message;

	  public Courselimitexceeded (String message) {
	    this.message = "course limit exceeded ";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
