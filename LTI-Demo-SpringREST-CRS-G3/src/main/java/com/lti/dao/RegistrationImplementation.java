/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.Studentalreadyregistered;
import com.lti.utils.DbUtils;

/**
 * @author 10710198
 *
 */

@Repository
public class RegistrationImplementation implements RegistrationDao{
	/*
	 * Registration method
	 *
	 * @throws Studentalreadyregistered
	 */
		public String registration(int rId,String rName,String rAddress,String rContact,String rPassword)throws Studentalreadyregistered {
			// TODO Auto-generated method stub
			

			   Connection conn = null;
			   PreparedStatement stmt = null;
			   
			   try{
				   
				  
				   
				   Class.forName("com.mysql.jdbc.Driver");

				    
				   
				      System.out.println("Connecting to database...");
				      conn = DbUtils.getConnection();


				     
				      System.out.println("Creating statement...");
				      String sql="insert into registration (RegId,RegName,RegAddress,RegContact,RegPassword,Adminapproval)values(?,?,?,?,?,?)";
				      
				      stmt = conn.prepareStatement(sql);


				      String approval="Pending";
				 
				     
				      stmt.setInt(1, rId);  
				      stmt.setString(2,rName);
				      stmt.setString(3,rAddress);
				      stmt.setString(4,rContact);
				      stmt.setString(5, rPassword);
				      stmt.setString(6, approval);
				    
				      System.out.println(rId+" "+rName+" "+rAddress+" "+rContact+" "+rPassword+" "+approval);
				      stmt.executeUpdate();
				      
				      stmt.close();
				      return "Registered";
				     // conn.close();
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
					    //conn.close();
				   }
			return null;

		}
}
