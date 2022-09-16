/**
 * 
 */
package com.lti.service;

import org.springframework.stereotype.Repository;

import com.lti.exception.Studentalreadyregistered;
import com.lti.exception.Useridnotfound;

/**
 * @author 10710198
 *
 */
@Repository
public interface UserInterface {
	public String login(int id,String old)throws Useridnotfound; 
	public String checkrole(int role,int id);
	public String updatePassword(int id,String old,String newpass)throws Useridnotfound;
	public String registration(int id,String name,String Address,String contact,String pass)throws Studentalreadyregistered;
	public String logout(int id);
}
