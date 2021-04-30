package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.javaproject.myclass.MyClassBean;

public class DbAction {

	// Field
	String tName;
	String tNickName;
	String tEmail;
	String tTelNo;
	String tPassword;
	
	
	// Constructor
	public DbAction() {
	}
	
	public DbAction(String tEmail) {
		super();
		this.tEmail = tEmail;
	}
	
	public DbAction(String tName, String tNickName, String tEmail, String tTelNo) {
		super();
		this.tName = tName;
		this.tNickName = tNickName;
		this.tEmail = tEmail;
		this.tTelNo = tTelNo;
	}
	
	// 마이페이지(선생님) 정보 수정+삭제용
	public DbAction(String tName, String tNickName, String tEmail, String tTelNo, String tPassword) {
		super();
		this.tName = tName;
		this.tNickName = tNickName;
		this.tEmail = tEmail;
		this.tTelNo = tTelNo;
		this.tPassword = tPassword;
	}

	// Constructor * * * * * * * * * * * * * * * * * * 
	public Bean_TeacherClass DBtoMypage(){
	
		Bean_TeacherClass bean = null;
		
		String Query00 = "select tName, tNickName, tEmail, tTelNo from Teacher where tEmail = ";
		String Query01 = ShareVar.currentuser;
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       														// url 지금 주석처리되어있어서 그럼!!
		
		       ResultSet rs = stmt_mysql.executeQuery(Query00+Query01);
		       
		       if(rs.next()) {
		    	   
		    	   String wktName = rs.getString(1);
		    	   String wktNickName = rs.getString(2);
		    	   String wktEmail = rs.getString(3);
		    	   String wktTelNo = rs.getString(4);
		    	   
		    	   bean = new Bean_TeacherClass(wktName, wktNickName, wktEmail, wktTelNo);
		       }//if
		       conn_mysql.close();
		    } // try 
			catch (Exception e){
			e.printStackTrace();
			}//catch
			return bean;
		}
	
	// (TeacherMypage) 마이페이지에서 정보 수정하기 * * * * * * * * * * * * * * [2021.04.28, 00:55]
	public boolean UpdateAction() {
		
		PreparedStatement ps = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		    Statement stmt_mysql = conn_mysql.createStatement();
		    
		    String Query00 = "UPDATE Teacher set tName = ?, tNickName = ?, tTelNo = ?, tPassword = ? ";
		    String Query01 = "WHERE tEmail = " + ShareVar.currentuser;
		    
		    ps = conn_mysql.prepareStatement(Query00+Query01);
		    
		    ps.setString(1, tName.trim());
		    ps.setString(2, tNickName.trim());
		    ps.setString(3, tTelNo.trim());
		    ps.setString(4, tPassword.trim());
		    ps.executeUpdate();
		    
		    
		    conn_mysql.close();
		    
		    
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}//
	
	public Bean_TeacherClass AverageScore(){
		
		Bean_TeacherClass bean = null;
		
		String Query00 = "SELECT avg(cScore) FROM Attend, Class, Register, Teacher ";
		String Query01 = "WHERE Attend.cId = Class.cId and Class.cId = Register.cId and Register.tEmail = Teacher.tEmail ";
		String Query02 = "And Register.tEmail = " + ShareVar.currentuser;
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       														// url 지금 주석처리되어있어서 그럼!!
		
		       ResultSet rs = stmt_mysql.executeQuery(Query00+Query01+Query02);
		       
		       if(rs.next()) {
		    	   
		    	   int wkScore = rs.getInt(1);
		    
		    	   bean = new Bean_TeacherClass(wkScore);
		       }//if
		       conn_mysql.close();
		    } // try 
			catch (Exception e){
			e.printStackTrace();
			}//catch
			return bean;
		}	
	
	
	// Mypage 내 강의 수량 버튼
	public Bean_TeacherClass CountOfClass(){
			
			Bean_TeacherClass bean = null;
			
			String Query00 = "SELECT count(Class.cId) FROM Class, Register ";
			String Query01 = "WHERE Register.cId = Class.cId AND Register.tEmail = " + ShareVar.currentuser;
			try{
			       Class.forName("com.mysql.cj.jdbc.Driver");
			       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
			       Statement stmt_mysql = conn_mysql.createStatement();
			       														// url 지금 주석처리되어있어서 그럼!!
			
			       ResultSet rs = stmt_mysql.executeQuery(Query00+Query01);
			       
			       if(rs.next()) {
			    	   
			    	   int wkScore = rs.getInt(1);
			    
			    	   bean = new Bean_TeacherClass(wkScore);
			       }//if
			       conn_mysql.close();
			    } // try 
				catch (Exception e){
				e.printStackTrace();
				}//catch
				return bean;
			}	
		
		
	public Bean_QnA CountOfQnA() {
		Bean_QnA bean = null;   
	
		 String Query00 = "SELECT count(qContents) FROM QnA ";
	     String Query01 = "WHERE aContents is null AND tEmail = " + ShareVar.currentuser;	
		      
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		        Statement stmt_mysql = conn_mysql.createStatement();
	
		        ResultSet rs = stmt_mysql.executeQuery(Query00+Query01);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴
	
		        while(rs.next()){
		    
		        	 int wksEmail = rs.getInt(1);
		        
		          	bean = new Bean_QnA(wksEmail);
	
		        }
		          conn_mysql.close();
		          
		      	}catch (Exception e){
		      		
		          e.printStackTrace();
		      }
				return bean;
		}
		
	public void deleteAction() {
		PreparedStatement ps = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);

			@SuppressWarnings("unused")

			Statement stmt_mysql = conn_mysql.createStatement();


			String A = "delete from Student where sEmail = "+ ShareVar.currentuser;

			ps = conn_mysql.prepareStatement(A);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e){

			e.printStackTrace();

		}
	}
	
	
}
