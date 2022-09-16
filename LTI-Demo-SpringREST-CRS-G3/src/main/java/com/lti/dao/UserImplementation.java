/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.controller.UserController;
import com.lti.exception.Studentalreadyregistered;
import com.lti.exception.Useridnotfound;
import com.lti.service.UserService;
import com.lti.utils.DbUtils;

/**
 * @author 10710198
 *
 */
@Repository
public class UserImplementation implements UserDao  {

	/*
 	@param args
	 */
	
	
		public String login(int uid,String password) throws Useridnotfound {
			// TODO Auto-generated method stub
		
			  Connection conn = null;
			   PreparedStatement stmt = null;
			   
			   try{
				   
				   
				   Class.forName("com.mysql.jdbc.Driver");

				      System.out.println("Connecting to database...");
				      conn = DbUtils.getConnection();
				   
				    
				        
				      
				     String sql = "SELECT UserId,UserName,UserPassword FROM user";
				      stmt = conn.prepareStatement(sql);
				      int id = 0,role=0;
				      ResultSet rs = stmt.executeQuery(sql);
				       boolean flag=false;


				      while(rs.next()){
				        
				         int userId  = rs.getInt("UserId");
				         String userName = rs.getString("UserName");
				        String userPassword= rs.getString("UserPassword");
				      
				        //Change here as per role
				         if(userId==uid && userPassword.equals(password))
			        	 {flag=true;


			        	System.out.println("Login Successful!");
			        	
			        	 id=uid;


			        	 }
				         
				      }
				    if(flag==true)
				      sql="select RoleId,UserId from role";
				      rs = stmt.executeQuery(sql);
				      while(rs.next()) {
				    	  int sid=rs.getInt("UserId");
				    	  int rid=rs.getInt("RoleId");
				    	  if(sid==id)
				    		  role=rid;
				    		  
				      }
				      
				      UserService a=new UserService();
					      a.checkrole(role,id);
				      
				      stmt.close();
				     //conn.close();
				      return "logged"; 
				      
				   }catch(SQLException se){
				       
				      se.printStackTrace();
				   }catch(Exception e){
				       
				      e.printStackTrace();
				   }finally{
				       
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      } 
				      if(conn!=null)
					 {
					 }
          
				   }
			
			   return null;
		}

		public String updatePassword(int uid,String password,String newpassword)throws Useridnotfound {
			// TODO Auto-generated method stub
			 Connection conn = null;
			   PreparedStatement stmt = null;
			   
			   try{
				   
				   
				   Class.forName("com.mysql.jdbc.Driver");

				      System.out.println("Connecting to database...");
				      conn = DbUtils.getConnection();
				   
				   
				     
						
				      String sql="insert into user values(?,?)";
				      stmt = conn.prepareStatement(sql);
				        
				      
				      sql = "SELECT UserId,UserPassword FROM user";
				      
				      ResultSet rs = stmt.executeQuery(sql);
				       
				     
				      while(rs.next()){
				        
				         int userId  = rs.getInt("UserId");
				        // String userName = rs.getString("UserName");
				        String userPassword= rs.getString("UserPassword");
				      
				        //Change here as per role
				         if(userId==uid && userPassword.equals(password))
			        	 {
				        	 sql = "UPDATE user set UserPassword = ? where UserId= ?";
		                	  PreparedStatement prepstmt = conn.prepareStatement(sql);
		                	  prepstmt .setString(1,newpassword);
		                	  prepstmt .setInt(2, uid);
		                	  prepstmt .executeUpdate();
				        	 System.out.println("Password updated!");
				        	 System.out.println("Logged out Successfully!");
				        	 
			        	 }
				          return "Password Updated";
				      }
				     
				      stmt.close();
				    //  conn.close();
				   }catch(SQLException se){
				       
				      se.printStackTrace();
				   }catch(Exception e){
				       
				      e.printStackTrace();
				   }finally{
				       
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      } 
				      if(conn!=null) {}
					  //  conn.close(); 
				   } 
			  //return "updated password";
			return null;
		}
		

		
		
		
}
