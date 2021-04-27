package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.javaproject.myclass.Bean;

public class DbAction {

	String tName;
	String tNickName;
	String tEmail;
	String tTelNo;
	
	
public static final String url_mysql = "jdbc:mysql://172.20.10.6/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	
	// 공용
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	
	
	
	
	
	
	
	
	public DbAction() {
		
	}
	
	
	
	
	
	public DbAction(String tName, String tNickName, String tEmail, String tTelNo) {
		super();
		this.tName = tName;
		this.tNickName = tNickName;
		this.tEmail = tEmail;
		this.tTelNo = tTelNo;
	}
	
	
	
	
	// (TeacherMyClass) 강의 예정 리스트 DB 에서 불러오기 * * * * * * * * * * * * * [2021.04.26,10:44]








	public ArrayList<Bean_TeacherClass> selectList_Up(){
		
		ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
		
		String Query01 = "SELECT Class.cId, Class.cName, Class.cDate, concat(Class.cLocation1,' ',Class.cLocation2), ";
		String Query02 = "(Select count(Attend.cId) FROM Attend, Class WHERE Class.cId = Attend.cId And Class.cId =2) ";
		String Query03 = "FROM Teacher, Register, Class WHERE Teacher.tEmail = Register.tEmail and Register.cId = Class.cId ";		
		String Query04 = "And cName in (select cName from Class where cDate <= curdate()) AND Teacher.tEmail = " + ShareVar.currentuser;
		
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       														// url 지금 주석처리되어있어서 그럼!!
		       ResultSet rs = stmt_mysql.executeQuery(Query01 + Query02 + Query03 + Query04);
		       
		       while(rs.next()){
		           
		               int wkcId = rs.getInt(1);
		               String wkcName = rs.getString(2);
		               String wkcDate = rs.getString(3);
		               String wkcLocation = rs.getString(4);
		               int wkcCount = rs.getInt(5);
		
		       Bean_TeacherClass bean = new Bean_TeacherClass(wkcId, wkcName, wkcDate, wkcLocation, wkcCount);
		       beanList.add(bean);
		       } 
		  	   conn_mysql.close();
			}
			catch (Exception e){
			e.printStackTrace();
			}
			return beanList;
		}
	
	// (TeacherMypage) 마이페이지에서 정보 불러오기 * * * * * * * * * * * * * * [2021.04.27,15:30]
	
	public Bean_TeacherClass DBtoMypage(){
	
		Bean_TeacherClass bean = null;
		
		String Query00 = "select tName, tNickName, tEmail, tTelNo from Teacher where tEmail = aaa@naver.com";
		
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       														// url 지금 주석처리되어있어서 그럼!!
		
		       ResultSet rs = stmt_mysql.executeQuery(Query00);
		       
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
