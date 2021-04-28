package com.javaproject.myclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

	public class DbAction { // 2021.04.26 조혜지 - 수강 예정과 수강 이력 데이터 테이블표에 불러오 & 수강 예정 강의 mysql 연결해 수강 신청 취소하기
 
	// 여기부터 4줄은 완성되면 없애기 ***************************************************
	public static final String url_mysql = "jdbc:mysql://192.168.0.128/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	public static String currentuser = "'hyoeun@gmail.com'";
	public static int ccId = 0;
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
		 public DbAction() {
		     // TODO Auto-generated constructor stub
		 }

		 // 수강 신청 취소하는 CancelClick 에서 사용
		 public DbAction(int cId) {
			super();
			this.cId = cId;
		}
		 
		// 리뷰 등록하는 reviewRegister 에서 사용
		 public DbAction(int cId, String cReview, int cScore) {
		      super();
		      this.cId = cId;
		      this.cReview = cReview;
		      this.cScore = cScore;
		   }


		// Method*****************************************
		 
		 // 수강 예정인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<Bean> selectListAfter() {
		     ArrayList<Bean> beanList = new ArrayList<Bean>();
		     
		     String QueryA = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice ";
		     String QueryB = "from Class as c, Attend as a where c.cId = a.cId and cName in (select cName from Class where cDate >= curdate()) ";
		     String QueryC = "and sEmail = " + currentuser;
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		
		         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
		
		         while(rs.next()){
		
		           int wkcId = rs.getInt(1);
		           String wkcAttendDate = rs.getString(2);
		           String wkcName = rs.getString(3);
		           String wktcDate = rs.getString(4);
		           String wkcLocation = rs.getString(5);
		           int wkcPrice = rs.getInt(6);
		           
		           Bean bean = new Bean(wkcId, wkcAttendDate, wkcName, wktcDate, wkcLocation, wkcPrice);
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
		 public ArrayList<Bean> selectListBefore() {
		     ArrayList<Bean> beanList = new ArrayList<Bean>();
		     
		     String QueryA = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice ";
		     String QueryB = "from Class as c, Attend as a where c.cId = a.cId and cName not in (select cName from Class where cDate >= curdate()) ";
		     String QueryC = "and sEmail = " + currentuser;		     
		     try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       
		       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
		       
		       while(rs.next()){
		           
		               int wkcId = rs.getInt(1);
		               String wkcAttendDate = rs.getString(2);
		               String wkcName = rs.getString(3);
		               String wktcDate = rs.getString(4);
		               String wkcLocation = rs.getString(5);
		               int wkcPrice = rs.getInt(6);
		           
		               Bean bean = new Bean(wkcId, wkcAttendDate, wkcName, wktcDate, wkcLocation, wkcPrice);
		           beanList.add(bean);
		           
		       }
		       conn_mysql.close();
		       
		     }
		     catch (Exception e){
		       e.printStackTrace();
		     }
		     return beanList;
		 }
		 
		 // 수강 예정 강의 중 mysql에서 수강 취소하는 메소드
		 public boolean delete() {
		     
		       PreparedStatement ps = null;
		       try{
		           Class.forName("com.mysql.cj.jdbc.Driver");
		           Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		           @SuppressWarnings("unused")
		           Statement stmt_mysql = conn_mysql.createStatement();
		
		           String A = "delete from Attend where cId = ? ";
		
		           ps = conn_mysql.prepareStatement(A);
		           ps.setInt(1, cId);
		           
		           ps.executeUpdate();
		
		           conn_mysql.close();
		           return true;
		       } catch (Exception e){
		           e.printStackTrace();
		           return false;
		       }
		
		     }
		     

		   public boolean reviewRegister() {
		         PreparedStatement ps = null;
		         try{
		             Class.forName("com.mysql.cj.jdbc.Driver");
		             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		             @SuppressWarnings("unused")
		            Statement stmt_mysql = conn_mysql.createStatement();

		             String A = "update Attend set cReview = ?, cScore = ? where cId = ? ";
		             

		             ps = conn_mysql.prepareStatement(A);
		             
		             ps.setString(1, cReview.trim());
		             ps.setInt(2, cScore);
		             ps.setInt(3, cId);

		             
		             ps.executeUpdate();

		             conn_mysql.close();
		             return true;
		         } catch (Exception e){                   
		             e.printStackTrace();
		             return false;
		         }

		      }

		   public static int i = 0;
	}