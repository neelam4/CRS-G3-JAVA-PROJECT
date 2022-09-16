package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;



public class Studentnotfoundforapproval extends Exception{
	private String message;

	  public Studentnotfoundforapproval (String message) {
	    this.message = "Student not found for approval";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
