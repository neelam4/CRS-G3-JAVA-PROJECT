package com.lti.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class OptionSelectedDoesNotExist extends Exception{
	private String message;

	  public OptionSelectedDoesNotExist (String message) {
	    this.message = "Option Selected Does Not Exist ";
	  }

	  public String getMessage() {
	    return this.message;
	  }

}
