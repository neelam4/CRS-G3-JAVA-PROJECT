/**
 * 
 */
package com.lti.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Coursealreadyregistered;
import com.lti.exception.Courselimitexceeded;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentalreadyregistered;
import com.lti.utils.DbUtils;
/**
 * @author 10710198
 *
 */
@Repository
public class StudentImplementation implements StudentDao {

	/*
	 @param args
	 */
	 
	   
    
	   public HashMap viewCourseCatalogue() {
			 

		   HashMap hm = new HashMap<>();
	        Connection conn = null;
	         PreparedStatement stmt = null;
	         
	         try{
	         	 Class.forName("com.mysql.jdbc.Driver");

				      System.out.println("Connecting to database...");
				      conn = DbUtils.getConnection();
	             
	              
	                
	              
	                String sql="insert into coursecatalog values(?,?)";
	        
	                stmt = conn.prepareStatement(sql);
	                  
	               
	                sql = "SELECT CourseName,CourseId FROM coursecatalog";
	                
	                ResultSet rs = stmt.executeQuery(sql);
	                
	                
	                
	                while(rs.next()){
	                	hm.put(rs.getInt("CourseId"),rs.getString("CourseName"));
	                                     
	                }
	               
	                System.out.println(hm);
	                stmt.close();
	           //     conn.close();
	             }catch(SQLException se){
	                 
	                se.printStackTrace();
	             }catch(Exception e){
	                 
	                e.printStackTrace();
	             }finally {
	                 
	                try{
	                   if(stmt!=null)
	                      stmt.close();
	                }catch(SQLException se2){
	                }
	                if(conn!=null){}
	             }
	             return hm;
			
		}


	public String addCourse(int id,int cid)throws CourseIDdoesNotExist,Courselimitexceeded{
		// TODO Auto-generated method stub
		 Connection conn = null;
         PreparedStatement stmt = null;
         
         try{
             
             
             Class.forName("com.mysql.jdbc.Driver");



               System.out.println("Connecting to database...");
                conn = DbUtils.getConnection();
             
                
                String sql = "INSERT INTO semregistration(CourseId,StudentId, Approval) VALUES (?,?,?)";
                stmt = conn.prepareStatement(sql);
		      
                
                stmt.setInt(1, cid);
                stmt.setInt(2, id);
              stmt.setInt(3, 0);
             
               stmt.execute();
              
                stmt.close();
                return "Course Added!" ; 
           //     conn.close();
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

	


	public String registerforCourse(int rId,int cId)throws Studentalreadyregistered {
		 
		
		
		//invoke admin to approve courses
		  Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			  
			   
			   Class.forName("com.mysql.jdbc.Driver");

			    
			   
			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();


			     
			      System.out.println("Creating statement...");
			      String sql="insert into semregistration(StudentId,CourseId,Approval)values(?,?,?)";
			      
			      stmt = conn.prepareStatement(sql);
			   
			      
			      int approval=1;
			 
			   
			      stmt.setInt(1, rId);   
			      stmt.setInt(2,cId);
			      stmt.setInt(3, approval);
			    
			    
			      stmt.executeUpdate();
			         stmt.close();
			         return "Semester registration done";
			 
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
			      if(conn!=null){}
			   }
		return null;
		
	}
	
	
	public String payFees(int id)  throws Studentalreadyregistered{
		// TODO Auto-generated method stub
		return null;
	}
	


	
	public HashMap viewGrades(int id)throws Gradenotadded {
		 HashMap hm = new HashMap<>();
		Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            
            
            Class.forName("com.mysql.jdbc.Driver");



              System.out.println("Connecting to database...");
               conn = DbUtils.getConnection();
            
               System.out.println("Creating statement...");
			      String sql="insert into grade values(?,?,?)";
			      stmt = conn.prepareStatement(sql);
			        
			      
			      sql = "SELECT StudentId,CourseId,GradeType FROM grade";
			      
			      ResultSet rs = stmt.executeQuery(sql);
			      
			      //STEP 5: Extract data from result set
			      while(rs.next()){
			        
			         int sId  = rs.getInt("StudentId");
			         int cId = rs.getInt("CourseId");
			        String grade= rs.getString("GradeType");
			      
			        //Change here as per role
			         if(sId==id)
		        	 {

		                	hm.put(rs.getInt("CourseId"),rs.getString("GradeType"));
		                	
		        	 }
			         
			      }//System.out.println(hm);
			      //System.out.println("Result displayed");
			      
               stmt.close();return hm;
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
               if(conn!=null){}
            }
            
     return hm;
		 
	}


	public String dropCourse(int id, int cid) {
		// TODO Auto-generated method stub
		 Connection conn = null;
         PreparedStatement stmt = null;
         
         try{
             
             
             Class.forName("com.mysql.jdbc.Driver");



               System.out.println("Connecting to database...");
                conn = DbUtils.getConnection();
             
               // String sql="insert into user values(?,?)";
              //  stmt = conn.prepareStatement(sql);
                  
                
                String sql = "delete from semregistration where CourseId=? and StudentId=? and Approval=?";
                stmt = conn.prepareStatement(sql);
		        
                
                stmt.setInt(1, cid);
                stmt.setInt(2, id);
              stmt.setInt(3, 0);
            
               stmt.execute();
               System.out.println("Course Dropped!");
                stmt.close();
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

	
	}


