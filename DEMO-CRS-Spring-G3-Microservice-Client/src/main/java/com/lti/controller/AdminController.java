/**
 * 
 */
package com.lti.controller;

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

import com.lti.exception.Studentalreadyregistered;
import com.lti.service.AdminService;
import com.lti.service.UserService;

/**
 * @author 10710198
 *
 */
@RestController
public class AdminController {
	@Autowired
	private AdminService admin;
	@Autowired
	private UserService user;
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/approveregistration/{AdminId}/{StudentId}")
	@ResponseBody
	public ResponseEntity approveregistration(@PathVariable int AdminId,@PathVariable int StudentId)throws Exception {
		   if(admin.approveregistration(AdminId,StudentId)==null) { 
		   return new ResponseEntity ("Student already registered", HttpStatus.NOT_FOUND);
	}
			   return new ResponseEntity (admin.approveregistration(AdminId,StudentId),HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/generateReportCard/{AdminId}")
	@ResponseBody
	public ResponseEntity generateReportCard(@PathVariable int AdminId)throws Exception {
		if(generateReportCard(AdminId)==null) 
			return new ResponseEntity ("Grade not added", HttpStatus.NOT_FOUND);
		{
			return new ResponseEntity (admin.generateReportCard(AdminId),HttpStatus.OK);
	}
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/{adminId}/addProfessor/{rId}/{rName}/{rAddress}/{rContact}/{rPassword}/{dept}")
	@ResponseBody
	public ResponseEntity addProfessor(@PathVariable int adminId,@PathVariable int rId,@PathVariable String rName,@PathVariable String rAddress,@PathVariable String rContact,@PathVariable String rPassword,@PathVariable String dept)throws Exception{
		if(admin.addProfessor(adminId,rId,rName,rAddress,rContact,rPassword,dept)==null) {
			return new ResponseEntity ("Professor not added", HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity (admin.addProfessor(adminId,rId,rName,rAddress,rContact,rPassword,dept),HttpStatus.OK);
	}
	
	
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/{adminId}/addCourse/{cId}/{cName}")
	@ResponseBody
	public ResponseEntity addCourse(@PathVariable int adminId,@PathVariable int cId,@PathVariable String cName)throws Exception {
		if(admin.addCourse(adminId,cId,cName)==null) {
			return new ResponseEntity ("Course Not Found", HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity (admin.addCourse(adminId,cId,cName),HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.DELETE, value="/{adminId}/removeCourse/{cId}")
	@ResponseBody
	public ResponseEntity removeCourse(@PathVariable int adminId,@PathVariable int cId)throws Exception {
		if (null ==admin.removeCourse(adminId,cId)) {
			return new ResponseEntity("Course Not Found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(admin.removeCourse(adminId,cId), HttpStatus.OK);
	}
	
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/admin/logout")
	@ResponseBody
	public String logout() {
		return "Logged out";
	}
	
	
	

}
