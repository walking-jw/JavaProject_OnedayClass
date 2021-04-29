package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.javaproject.myclass.Bean;

public class DbAction {

	// Field
	String tName;
	String tNickName;
	String tEmail;
	String tTelNo;
	String tPassword;
	
	
	// Constructor
	public DbAction(String tEmail) {
		super();
		this.tEmail = tEmail;
	}





	public DbAction() {
		
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





	// (TeacherMyClass) 강의 예정 리스트 DB 에서 불러오기 * * * * * * * * * * * * * [2021.04.26,10:44]

//	public ArrayList<Bean_TeacherClass> selectList_Up(){
//		
//		ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
//		
//		String Query01 = "SELECT Class.cId, Class.cName, Class.cDate, concat(Class.cLocation1,' ',Class.cLocation2), ";
//		String Query02 = "(Select count(Attend.cId) FROM Attend, Class WHERE Class.cId = Attend.cId And Class.cId =2) ";
//		String Query03 = "FROM Teacher, Register, Class WHERE Teacher.tEmail = Register.tEmail and Register.cId = Class.cId ";		
//		String Query04 = "And cName in (select cName from Class where cDate <= curdate()) AND Teacher.tEmail = " + ShareVar.currentuser;
//		
//		  try{
//		       Class.forName("com.mysql.cj.jdbc.Driver");
//		       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql, ShareVarTest.id_mysql, ShareVarTest.pw_mysql);
//		       Statement stmt_mysql = conn_mysql.createStatement();
//		       														// url 지금 주석처리되어있어서 그럼!!
//		       ResultSet rs = stmt_mysql.executeQuery(Query01 + Query02 + Query03 + Query04);
//		       
//		       while(rs.next()){
//		           
//		               int wkcId = rs.getInt(1);
//		               String wkcName = rs.getString(2);
//		               String wkcDate = rs.getString(3);
//		               String wkcLocation = rs.getString(4);
//		               int wkcCount = rs.getInt(5);
//		
//		       Bean_TeacherClass bean = new Bean_TeacherClass(wkcId, wkcName, wkcDate, wkcLocation, wkcCount);
//		       beanList.add(bean);
//		       } 
//		  	   conn_mysql.close();
//			}
//			catch (Exception e){
//			e.printStackTrace();
//			}
//			return beanList;
//		}
	
	// (TeacherMypage) 마이페이지에서 정보 불러오기 * * * * * * * * * * * * * * [2021.04.27,15:30~19:28]
	
	public Bean_TeacherClass DBtoMypage(){
	
		Bean_TeacherClass bean = null;
		
		String Query00 = "select tName, tNickName, tEmail, tTelNo from Teacher where tEmail = ";
		String Query01 = "'" + ShareVarTest.currentuser + "'";
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql, ShareVarTest.id_mysql, ShareVarTest.pw_mysql);
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
		    Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql, ShareVarTest.id_mysql, ShareVarTest.pw_mysql);
		    Statement stmt_mysql = conn_mysql.createStatement();
		    
		    String Query00 = "UPDATE Teacher set tName = ?, tNickName = ?, tTelNo = ?, tPassword = ? ";
		    String Query01 = "WHERE tEmail = '" + ShareVarTest.currentuser + "'";
		    
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
		String Query02 = "And Register.tEmail ='" + ShareVarTest.currentuser + "'";
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql, ShareVarTest.id_mysql, ShareVarTest.pw_mysql);
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
	
	
	
	
	
	
public Bean_TeacherClass CountOfClass(){
		
		Bean_TeacherClass bean = null;
		
		String Query00 = "SELECT count(Class.cId) FROM Class, Register ";
		String Query01 = "WHERE Register.cId = Class.cId AND Register.tEmail = '" + ShareVarTest.currentuser + "'";
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql, ShareVarTest.id_mysql, ShareVarTest.pw_mysql);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		public ArrayList<Bean_TeacherClass> DBtoMypage(){
//				
//				ArrayList<Bean_TeacherClass> beanList2 = new ArrayList<Bean_TeacherClass>();
//				String Query00 = "SELECT tName, tNickName, tEmail, tTelNo FROM Teacher WHERE tEmail = ";
//				String Quert01 = "'aaa@naver.com'";
//				
//				  try{
//				       Class.forName("com.mysql.cj.jdbc.Driver");
//				       Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
//				       Statement stmt_mysql = conn_mysql.createStatement();
//				       														// url 지금 주석처리되어있어서 그럼!!
//				
//				       ResultSet rs = stmt_mysql.executeQuery(Query00);
//				       
//				       while(rs.next()) {
//				    	   
//				    	   String wktName = rs.getString(1);
//				    	   String wktNickName = rs.getString(2);
//				    	   String wktEmail = rs.getString(3);
//				    	   String wktTelNo = rs.getString(4);
//				    	   
//				    	   
//				    	  Bean_TeacherClass bean = new Bean_TeacherClass(wktName, wktNickName, wktEmail, wktTelNo);
//				    	  beanList2.add(bean);   
//				       }//if
//				       conn_mysql.close();
//				    } // try 
//					catch (Exception e){
//					e.printStackTrace();
//					}//catch
//					return beanList2;
//				}
//		
//		
//		
//		
		
		
public Bean_QnA CountOfQnA() {
	Bean_QnA bean = null;   

	 String Query00 = "SELECT count(qContents) FROM QnA ";
     String Query01 = "WHERE aContents is null AND tEmail = '" + ShareVarTest.currentuser + "' ";	
	      
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql,ShareVarTest.id_mysql,ShareVarTest.pw_mysql);
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
	
	
	
	
	
	
	
	
//	public void searchAction_TeacherMypage() {
//		
//		
//		String Query00 = "SELECT tName, tNickName, tEmail, tTelNo FROM Teacher WHERE tEmail =";
////		'aaa@naver.com';
//		
//		
//		
//		
//		
//		
//	}
	
	
	
}
