/**
 * 
 */
package com.lti.dao;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Coursenotassignedtoprofessor;
import com.lti.exception.Coursenotfound;
import com.lti.exception.Professornotadded;
import com.lti.exception.Studentnotfound;
import com.lti.utils.*;
/**
 * @author 10710198
 *
 */

@Repository
public class ProfessorImplementation implements ProfessorDao{

	/*
	 @param args
	 */
	
	
	public String addGrade(int id, int cId, int rId, String grad)throws Coursenotfound,Coursenotassignedtoprofessor,Studentnotfound{
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   
			   
			   Class.forName("com.mysql.jdbc.Driver");

			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();
			      String sql = "UPDATE grade set GradeType = ? where StudentId= ? and CourseId=?";
            	  stmt = conn.prepareStatement(sql);
            	  stmt .setString(1, grad);
            	  stmt .setInt(2, rId);
            	  stmt .setInt(3, cId);
            	  stmt .executeUpdate();
			  
			 
			       
			      stmt.close();
			      return "Grade added";
			      //conn.close();
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
				   // conn.close(); 
			   } 
		   return null;
	}
	
	
	public HashMap viewenrolledlist(int id)throws Professornotadded  {
		 HashMap arr = new HashMap<>();
		 Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   
			   
			   Class.forName("com.mysql.jdbc.Driver");

			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();
			   
			      


			    //  String sql="insert into course values(?,?,?)";
			      
			        int cId=0;
			      
			    String  sql = "SELECT CourseId FROM course where ProfessorId=?";
			    stmt = conn.prepareStatement(sql);
			    stmt.setInt(1,id);
			    //  int id = 0,role=0;
			      
			      ResultSet rs = stmt.executeQuery();
			       
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			    	  cId  = rs.getInt("CourseId");
			         
			      }
			       
			      sql="select distinct StudentId,StudentName from student where StudentId=(select StudentId from semregistration where CourseId=?)";
			      PreparedStatement prep= conn.prepareStatement(sql);
			      prep.setInt(1,cId);
			      ResultSet rn=prep.executeQuery();
			      //rs = stmt.executeQuery(sql);
			      while(rn.next()) {
			    	  
			    	  { arr.put(rn.getInt("StudentId"),rn.getString("StudentName"));
			    	  }
			    	  
			      }
			    
			      stmt.close();
			      return arr;
			      //conn.close();
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
			      if(conn!=null){} 
			   } 
			   return null;
	}
	@Override
	public String selectCourse(int id, int courseId) throws CourseIDdoesNotExist, Coursealreadyregistered {
		// TODO Auto-generated method stub
		Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   
			   
			   Class.forName("com.mysql.jdbc.Driver");

			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();
			      String sql = "UPDATE course set ProfessorId = ? where CourseId=?";
         	  stmt = conn.prepareStatement(sql);
         	  stmt .setInt(1, id);
         	  stmt .setInt(2, courseId);
         	  stmt .executeUpdate();
			 
			       
			      stmt.close();
			      return "Course Selected";
			      //conn.close();
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
				   // conn.close(); 
			   } 
		
		return null;
	}
}
