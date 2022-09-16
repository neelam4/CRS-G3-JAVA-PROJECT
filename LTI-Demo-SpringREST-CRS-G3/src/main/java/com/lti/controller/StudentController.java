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

import com.lti.bean.Course;
import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Studentalreadyregistered;
import com.lti.service.StudentService;
import com.lti.service.UserService;


/**
 * @author 10710198
 *
 */

@RestController
public class StudentController {
	@Autowired
	private StudentService student;
	@Autowired
	private UserService user;
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/registerforCourse/{studentId}/")
	@ResponseBody
	public ResponseEntity registerforCourse(@PathVariable int studentId)throws Exception {
		if(null== student.registerforCourse(studentId)) {
			return new ResponseEntity("Already registered", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.registerforCourse(studentId), HttpStatus.OK);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/{studentId}/addCourse/{courseId}")
	@ResponseBody
	public ResponseEntity addCourse(@PathVariable int studentId,@PathVariable int courseId) throws Exception {

		if(null==student.addCourse(studentId,courseId)) {
			return new ResponseEntity("Course limit exceeded", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.addCourse(studentId,courseId), HttpStatus.OK);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.DELETE, value="/{studentId}/dropCourse/{courseId}")
	@ResponseBody
	public ResponseEntity dropCourse(@PathVariable int studentId,@PathVariable int courseId) throws Exception {

		if(null==student.dropCourse(studentId,courseId)) {
			return new ResponseEntity("No courses found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.dropCourse(studentId,courseId), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/viewCourseCatalogue")
	@ResponseBody
	public ResponseEntity viewCourseCatalogue()throws Exception{
		
		if(null== student.viewCourseCatalogue()) {
			return new ResponseEntity("No courses found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.viewCourseCatalogue(), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/{studentId}/payFees")
	@ResponseBody
	public ResponseEntity payFees(@PathVariable int studentId) throws Exception {
		if(null== student.payFees(studentId)) {
			return new ResponseEntity("Payment failed", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.payFees(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/{studentId}/viewGrades")
	@ResponseBody
	public ResponseEntity viewGrades(@PathVariable int studentId) throws Exception{
		if(null== student.viewGrades(studentId)) {
			return new ResponseEntity("Grades not added", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(student.viewGrades(studentId), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/student/logout")
	@ResponseBody
	public String logout() {
		return "Logged out";
	}
	
	
	
}
