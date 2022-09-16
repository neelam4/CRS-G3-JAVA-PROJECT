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

import com.lti.dao.RegistrationDao;
import com.lti.dao.UserImplementation;
import com.lti.exception.Studentalreadyregistered;
import com.lti.service.UserInterface;
import com.lti.service.UserService;
import java.lang.*;

/**
 * @author 10710198
 *
 */
@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.GET, value="/login/{userId}/{password}")
	@ResponseBody
	public ResponseEntity login(@PathVariable int userId,@PathVariable String password)throws Exception{
	//	System.out.println(userId+" "+password);
		//return userservice.login(userId,password);
		if (null == userservice.login(userId,password)) {
            return new ResponseEntity("No User found ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(userservice.login(userId,password), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/updatePassword/{id}/{old}/{newpass}")
	@ResponseBody
	public ResponseEntity updatePassword(@PathVariable int id,@PathVariable String old,@PathVariable String newpass)throws Exception {
		//System.out.println(id+" "+old+" "+newpass);
		if(null== userservice.updatePassword(id,old,newpass)) {
			return new ResponseEntity("No User found ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(userservice.updatePassword(id,old,newpass), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.PUT, value="/registration/{id}/{name}/{Address}/{contact}/{pass}")
	@ResponseBody
	public ResponseEntity registration(@PathVariable int id,@PathVariable String name,@PathVariable String Address,@PathVariable String contact,@PathVariable String pass) throws Exception {
	//	System.out.println(id+" "+ name+" "+ Address+" "+ contact+" "+ pass);
		if(null== userservice.registration(id, name, Address, contact, pass)) {
			return new ResponseEntity("Student Already Registered", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(userservice.registration(id, name, Address, contact, pass), HttpStatus.OK);
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON, method=RequestMethod.POST, value="/exit")
	@ResponseBody
	public String exit() {
		return "application exited";
	}



}
