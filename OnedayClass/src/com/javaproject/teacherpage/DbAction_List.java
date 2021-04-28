package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

	public class DbAction_List { // 혜지 서브클래스 - 수강 예정과 수강 이력 데이터 테이블표에 불러오기 & 수강 예정 강의 mysql 연결해 수강 신청 취소하기
 
	// 여기부터 4줄은 완성되면 없애기 ***************************************************
	public static final String url_mysql = "jdbc:mysql://192.168.0.5/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	public static String currentuser = "'hyoeun@gmail.com'";
	// 여기까지 4줄은 완성되면 없애기 ***************************************************

	// 여기부터 3줄은 완성되면 살리기 ***************************************************
		// private final static String url_mysql = ShareVar.url_mysql;
		// private final static String id_mysql = ShareVar.id_mysql;
		// private final static String pw_mysql = ShareVar.pw_mysql;
	// 여기까지 3줄은 완성되면 살리기 ***************************************************
		 
		 // Field*****************************************
		 int cId;
		 String cAttendDate;
		 String cName;
		 String cDate;
		 String cLocation;
		 int cPrice;
		 String cReview;
		 int cScore;
		 
		 // Constructor*****************************************
		 
		 // 초기 Constructor 생성 - SearchActionAfter, SearchActionBefore에서 사용
		 public DbAction_List() {
		     // TODO Auto-generated constructor stub
		 }

		// Method*****************************************
		 
		 public DbAction_List(int cId) {
			super();
			this.cId = cId;
		}

		// 수강 예정인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<Bean_TeacherClass> selectListAfter() {
		     ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
		     
		     String QueryA = "select c.cId, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2) ";
		     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cName not in (select cName from Class where cDate <= curdate()) ";
		     String QueryC = "and tEmail = '" + ShareVarTest.currentuser + "'";		
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql,ShareVarTest.id_mysql,ShareVarTest.pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		
		         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
		
		         while(rs.next()){
		
		           int wkcId = rs.getInt(1);
		           String wkcName = rs.getString(2);
		           String wktcDate = rs.getString(3);
		           String wkcLocation = rs.getString(4);
		           
		           Bean_TeacherClass bean = new Bean_TeacherClass(wkcId, wkcName, wktcDate, wkcLocation);
		           beanList.add(bean);
		
		         }
		         conn_mysql.close();
		         
		     }
		     catch (Exception e){
		         e.printStackTrace();
		     }
		     return beanList;
		 }
		 
		 // 수강 이력인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<Bean_TeacherClass> selectListBefore() {
		     ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
		     
		     String QueryA = "select c.cId, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2) ";
		     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cName not in (select cName from Class where cDate >= curdate()) ";
		     String QueryC = "and tEmail = '" + ShareVarTest.currentuser + "'";		     
		     try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql,ShareVarTest.id_mysql,ShareVarTest.pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       
		       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
		       
		       while(rs.next()){
		           
		               int wkcId = rs.getInt(1);
		               String wkcName = rs.getString(2);
		               String wktcDate = rs.getString(3);
		               String wkcLocation = rs.getString(4);
		           
		               Bean_TeacherClass bean = new Bean_TeacherClass(wkcId, wkcName, wktcDate, wkcLocation);
		           beanList.add(bean);
		           
		       }
		       conn_mysql.close();
		       
		     }
		     catch (Exception e){
		       e.printStackTrace();
		     }
		     return beanList;
		 }
		 
		 
		 // Table Click 하면 cId 보관하게 하기 * * * * * * * * * * * * * * * * [2021.04.28,11:47]
		 
		 public Bean_TeacherClass TableClick() {
			 
			 Bean_TeacherClass bean = null;
			 
			 String QueryA = "select c.cId";
		     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cName not in (select cName from Class where cDate <= curdate()) ";
		     String QueryC = "and tEmail = '" + ShareVarTest.currentuser + "'";		
		     
		     try{
			       Class.forName("com.mysql.cj.jdbc.Driver");
			       Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql,ShareVarTest.id_mysql,ShareVarTest.pw_mysql);
			       Statement stmt_mysql = conn_mysql.createStatement();
			       
			       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
			       
			       if(rs.next()) {
			    	   int wkId = rs.getInt(1);
			    	   
			    	   bean = new Bean_TeacherClass(wkId);
			       }
			     conn_mysql.close();
			 }catch (Exception e) {
				 e.printStackTrace();
			 }
			     return bean;
		 
		 }//TableClick
		 
		 
		 
		 
		 
		 
		 
		 
		 
	

		   public static int i = 0;
	}