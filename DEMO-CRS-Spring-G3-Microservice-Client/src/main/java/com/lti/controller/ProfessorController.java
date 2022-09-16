/**
 * 
 */
package com.lti.controller;

import java.util.HashMap;
import java.util.Scanner;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dao.ProfessorImplementation;
import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Studentalreadyregistered;
import com.lti.service.ProfessorService;
import com.lti.service.UserService;

/**
 * @author 10710198
 *
 */

@RestController
public class ProfessorController {
	@Autowired
	private ProfessorService prof;
	@Autowired
	private UserService user;
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/{profId}/selectCourse/{CourseId}")
	@ResponseBody
	public ResponseEntity selectCourse(@PathVariable int profId,@PathVariable int CourseId)throws Exception {
		if(null== prof.selectCourse(profId,CourseId)) {
			return new ResponseEntity("CourseIDdoesNotExist", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(prof.selectCourse(profId,CourseId), HttpStatus.OK);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/{profId}/addGrades/{CourseId}/{StudentId}/{Grade}")
	@ResponseBody
	public ResponseEntity addGrades(@PathVariable int profId,@PathVariable int CourseId,@PathVariable int StudentId,@PathVariable String Grade) throws Exception{
		if(null== prof.addGrade(profId,CourseId,StudentId,Grade)) {
			return new ResponseEntity("Student Not Found or Course not assigned to professor", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(prof.addGrade(profId,CourseId,StudentId,Grade), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/{profId}/viewenrolledlist")
	@ResponseBody
	public ResponseEntity viewenrolledlist(@PathVariable int profId) throws Exception{
		if(null== prof.viewenrolledlist(profId)) {
			return new ResponseEntity("Student Not Found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(prof.viewenrolledlist(profId), HttpStatus.OK);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/prof/logout")
	@ResponseBody
	public String logout() {
		return "Logged out";
		
	}
	
	
	
	
}
