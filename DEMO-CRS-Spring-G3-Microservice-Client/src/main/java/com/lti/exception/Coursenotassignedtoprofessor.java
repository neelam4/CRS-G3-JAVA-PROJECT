package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class Coursenotassignedtoprofessor extends Exception{
	private String message;

	  public Coursenotassignedtoprofessor (String message) {
	    this.message = "Course not assigned to professor";
	  }

	  public String getMessage() {
	    return this.message;
	  }


}
