/**
 * 
 */
package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.stereotype.Repository;

import com.lti.exception.CourseIDdoesNotExist;
import com.lti.exception.Gradenotadded;
import com.lti.exception.Studentnotfoundforapproval;
import com.lti.service.UserService;
import com.lti.utils.DbUtils;

/**
 * @author 10710198
 *
 */
@Repository
public class AdminImplementation implements AdminDao{
	   
	/*Approve the students registration request
	@param Course ID and student ID
	@ throws studentnotregistered
	*/
	@Override
	

	public String approveregistration(int AdminId,int StudentId) throws Studentnotfoundforapproval{
		// TODO Auto-generated method stub
		 Connection conn = null;
         PreparedStatement stmt = null;



       try {
            Class.forName("com.mysql.jdbc.Driver");



           System.out.println("Connecting to database...");
            conn = DbUtils.getConnection();
            
          String sql = "UPDATE registration set Adminapproval = ? where RegId= ?";
      	  PreparedStatement prepstmt = conn.prepareStatement(sql);
      	  prepstmt .setString(1, "Approved");
      	  prepstmt .setInt(2, StudentId);
      	  prepstmt .executeUpdate();

           //String sql="insert into registration values(?,?,?,?,?,?)";
           
         sql = "SELECT * FROM registration";
        stmt = conn.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()) {
        	   int rId=rs.getInt("RegId");
        	   String rName=rs.getString("RegName");
        	   String rContact=rs.getString("RegContact");
        	   String rAddress=rs.getString("RegAddress");
        	   String rpass=rs.getString("RegPassword");
        	   if(rId==StudentId)
        	   { 
                       sql="insert into user(UserId,UserName,Contact,Address,UserPassword) values(?,?,?,?,?)";
                	   stmt = conn.prepareStatement(sql);
                	   stmt.setInt(1, rId);  // This would set age
                       stmt.setString(2,rName);
                       stmt.setString(3,rContact);
                       stmt.setString(4,rAddress);
                       stmt.setString(5, rpass);
                       stmt.executeUpdate();
                       sql="insert into student(StudentId,StudentName,Contact,Address,isApproved,PaymentId) values(?,?,?,?,?,?)";
                	   stmt = conn.prepareStatement(sql);
                	   stmt.setInt(1, rId);  // This would set age
                       stmt.setString(2,rName);
                       stmt.setString(3,rContact);
                       stmt.setString(4,rAddress);
                       stmt.setString(5, "0");
                       stmt.setString(6, null);
                       stmt.executeUpdate();
                   }}
        	   
        	   
        	stmt.close(); 
           return "Student registration approved";

           
          //  conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            if (conn != null){}
        }

return null;

        }
	
	
	/*Compelling the courses adding by the professor
	@param Course ID and student ID
	@ throws nogradeadded
	 */
	public String generateReportCard(int AdminId)throws Gradenotadded {
		// TODO Auto-generated method stub
		return null;
		
	}
	
	public String addCourse(int adminId,int cId,String cName) {
		// TODO Auto-generated method stub
		
		
		  Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			  
			   
			   Class.forName("com.mysql.jdbc.Driver");

			    
			   
			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();


			     
			      System.out.println("Creating statement...");
			      String sql="insert into coursecatalog(CourseId,CourseName)values(?,?)";
			      
			      stmt = conn.prepareStatement(sql);
			   
			      // Hard coded data 
			     
			      
			      stmt.setInt(1, cId);  // This would set age
			      stmt.setString(2,cName);
			      
			      //stmt.setString(6, approval);
			    
			     // System.out.println("Working till here2");
			      stmt.executeUpdate();
		   
			      sql="insert into course(CourseId,CourseName)values(?,?)";
			      
			      stmt = conn.prepareStatement(sql);
			   
			      
			      stmt.setInt(1, cId);  // This would set age
			      stmt.setString(2,cName);
			      
			      //stmt.setString(6, approval);
			    
			     // System.out.println("Working till here2");
			      stmt.executeUpdate();
		   
			    
			 stmt.close();  return "Courses added!";
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
	
	/*
		Compelling the courses adding by the professor
	@param professorID
	@ throws professornotfound
	 */
	public String addProfessor(int adminId,int rId,String rName,String rAddress,String rContact,String rPassword,String dept) {
		// TODO Auto-generated method stub

		   Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			  
			   
			   Class.forName("com.mysql.jdbc.Driver");

			    
			   
			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();


			     
			      System.out.println("Creating statement...");
			      String sql="insert into user(UserId,UserName,Address,Contact,UserPassword)values(?,?,?,?,?)";
			      
			      stmt = conn.prepareStatement(sql);
			   
			      		
					
			      
			      //String approval="Pending";
			 
			    //  System.out.println("Working till here");
			      stmt.setInt(1, rId);  // This would set age
			      stmt.setString(2,rName);
			      stmt.setString(3,rAddress);
			      stmt.setString(4,rContact);
			      stmt.setString(5, rPassword);
			      //stmt.setString(6, approval);
			    
			     // System.out.println("Working till here2");
			      stmt.executeUpdate();
		   
			      sql="insert into professor(ProfessorId,ProfessorName,Address,Contact,Department)values(?,?,?,?,?)";
			      
			      stmt = conn.prepareStatement(sql);
			      stmt.setInt(1, rId);  // This would set age
			      stmt.setString(2,rName);
			      stmt.setString(3,rAddress);
			      stmt.setString(4,rContact);
			      stmt.setString(5, dept);
			      stmt.executeUpdate();
			      
			 stmt.close();return "Professor added!";
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
	
	/*Removing course from the course catalogue
    //@param Course ID
    //@ throws cousreidnotfound
     * 
     */
	public String removeCourse(int adminId,int cId)throws CourseIDdoesNotExist {
		// TODO Auto-generated method stub

		  Connection conn = null;
		   PreparedStatement stmt = null;
		   
		   try{
			   
			  
			   
			   Class.forName("com.mysql.jdbc.Driver");

			    
			   
			      System.out.println("Connecting to database...");
			      conn = DbUtils.getConnection();


			     
			      System.out.println("Creating statement...");
			      
			      String sql="delete from coursecatalog where CourseId=?";
			      
			      stmt = conn.prepareStatement(sql);
			        
	                stmt.setInt(1, cId);
	               stmt.execute();
	               
	               sql="delete from course where CourseId=?";
				 stmt = conn.prepareStatement(sql);
				 
				        stmt.setInt(1, cId);
	               stmt.execute();
	               
			      // Hard coded data 
			      
			 stmt.close();
			 return "Course Dropped!" ;
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
				   // conn.close();
			   }
		return null;
	}
	
	

}
