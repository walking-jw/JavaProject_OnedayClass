package com.javaproject.myclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

	public class MyClassDbAction { // 2021.04.26 조혜지 - 수강 예정과 수강 이력 데이터 테이블표에 불러오기 & 수강 예정 강의 mysql 연결해 수강 신청 취소하기
		                           // 2021.04.29 조혜지 - 후기 미작성 내역과 작성 내역 데이터 테이블표에 불러오기
 
	// 여기부터 4줄은 완성되면 없애기 ***************************************************
	public static final String url_mysql = "jdbc:mysql://192.168.0.5/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	public static String currentuser = "'hyoeun@gmail.com'";
	public static int ccId = 0;
//	public static int rcId = 0;
//	public static int ucId = 0;
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
		 public MyClassDbAction() {
		     // TODO Auto-generated constructor stub
		 }

		 // 수강 신청 취소하는 CancelClick 에서 사용
		 public MyClassDbAction(int cId) {
			super();
			this.cId = cId;
		}
		 
		// 리뷰 등록하는 reviewRegister 에서 사용
		 public MyClassDbAction(int cId, String cReview, int cScore) {
		      super();
		      this.cId = cId;
		      this.cReview = cReview;
		      this.cScore = cScore;
		   }


		// Method*****************************************
		 
		 // 수강 예정인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<MyClassBean> selectListAfter() {
		     ArrayList<MyClassBean> beanList = new ArrayList<MyClassBean>();
		     
		     String QueryA = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice ";
		     String QueryB = "from Class as c, Attend as a, Register as r where c.cId = r.cId and c.cId = a.cId and cDate in (select cDate from Class where cDate >= curdate()) ";
		     String QueryC = "and sEmail = " + currentuser;
		     String QueryD = " and r.cCloseDate is null and a.cCancelDate is null";
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		
		         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC + QueryD);
		
		         while(rs.next()){
		
		           int wkcId = rs.getInt(1);
		           String wkcAttendDate = rs.getString(2);
		           String wkcName = rs.getString(3);
		           String wkcDate = rs.getString(4);
		           String wkcLocation = rs.getString(5);
		           int wkcPrice = rs.getInt(6);
		           
		           MyClassBean bean = new MyClassBean(wkcId, wkcAttendDate, wkcName, wkcDate, wkcLocation, wkcPrice);
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
		 public ArrayList<MyClassBean> selectListBefore() {
		     ArrayList<MyClassBean> beanList = new ArrayList<MyClassBean>();
		     
		     String QueryA = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice ";
		     String QueryB = "from Class as c, Attend as a, Register as r where c.cId = r.cId and c.cId = a.cId and cDate not in (select cDate from Class where cDate >= curdate()) ";
		     String QueryC = "and sEmail = " + currentuser;
		     String QueryD = " and r.cCloseDate is null and a.cCancelDate is null";     
		     try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       
		       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC + QueryD);
		       
		       while(rs.next()){
		           
		               int wkcId = rs.getInt(1);
		               String wkcAttendDate = rs.getString(2);
		               String wkcName = rs.getString(3);
		               String wkcDate = rs.getString(4);
		               String wkcLocation = rs.getString(5);
		               int wkcPrice = rs.getInt(6);
		           
		               MyClassBean bean = new MyClassBean(wkcId, wkcAttendDate, wkcName, wkcDate, wkcLocation, wkcPrice);
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
		 public boolean Delete() {
		     
		       PreparedStatement ps = null;
		       try{
		           Class.forName("com.mysql.cj.jdbc.Driver");
		           Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		           @SuppressWarnings("unused")
		           Statement stmt_mysql = conn_mysql.createStatement();
		
		           String A = "update Attend set cCancelDate = curdate() where cId = ?";
		
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
		     
		 // 후기 미완료인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<MyClassBean> selectListIncomplete() {
		     ArrayList<MyClassBean> beanList = new ArrayList<MyClassBean>();
		     
		     String QueryA = "select c.cId, c.cDate, c.cName, concat(cLocation1, ' ', cLocation2) ";
		     String QueryB = "from Class as c, Attend as a, Register as r where c.cId = r.cId and c.cId = a.cId and cDate not in (select cDate from Class where cDate >= curdate()) ";
		     String QueryC = "and sEmail = " + currentuser;
		     String QueryD = " and r.cCloseDate is null and a.cReview is null and a.cScore is null and a.cCancelDate is null";
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		
		         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC + QueryD);
		
		         while(rs.next()){
		
		           int wkcId = rs.getInt(1);
		           String wkcDate = rs.getString(2);
		           String wkcName = rs.getString(3);
		           String wkcLocation = rs.getString(4);
	           
		           MyClassBean bean = new MyClassBean(wkcId, wkcDate, wkcName, wkcLocation);
		           beanList.add(bean);
		
		         }
		         conn_mysql.close();
		         
		     }
		     catch (Exception e){
		         e.printStackTrace();
		     }
		     return beanList;
		 }
		 
		 // 후기 완료인 데이터를 mysql에서 불러오는 메소드
		 public ArrayList<MyClassBean> selectListComplete() {
			 ArrayList<MyClassBean> beanList = new ArrayList<MyClassBean>();
			 
			 String QueryA = "select a.cId, c.cDate, c.cName, concat(cLocation1, ' ', cLocation2) ";
			 String QueryB = "from Class as c, Attend as a, Register as r where c.cId = r.cId and c.cId = a.cId and cDate not in (select cDate from Class where cDate >= curdate()) ";
			 String QueryC = "and sEmail = " + currentuser;
			 String QueryD = " and r.cCloseDate is null and a.cScore is not null and a.cReviewDeleteDate is null";
			 try{
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				 Statement stmt_mysql = conn_mysql.createStatement();
				 
				 ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC + QueryD);
				 
				 while(rs.next()){
					 
					 int wkcId = rs.getInt(1);
					 String wkcDate = rs.getString(2);
					 String wkcName = rs.getString(3);
					 String wkcLocation = rs.getString(4);
					 
					 MyClassBean bean = new MyClassBean(wkcId, wkcDate, wkcName, wkcLocation);
					 beanList.add(bean);
					 
				 }
				 conn_mysql.close();
				 
			 }
			 catch (Exception e){
				 e.printStackTrace();
			 }
			 return beanList;
		 }
		 
		 

		 // Review 등록하는 Method
		 public boolean reviewRegister() {
			 PreparedStatement ps = null;
	         try{
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	             @SuppressWarnings("unused")
	            Statement stmt_mysql = conn_mysql.createStatement();

	             String A = "update Attend set cReviewRegisterDate = curdate(), cReview = ?, cScore = ?, cReviewDeleteDate = null where cId = ? and sEmail = " + currentuser;
	             

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
		 
		 // Review 삭제 버튼을 눌렀을 경우 cReviewDeleteDate를 추가하는 Method
		 public boolean reviewDelete() {
			 PreparedStatement ps = null;
	         try{
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	             @SuppressWarnings("unused")
	            Statement stmt_mysql = conn_mysql.createStatement();

	             String A = "update Attend set cReviewDeleteDate = curdate(), cReview = null, cScore = null where cId = ? and sEmail = " + currentuser;
	             

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
		 
		 // Review 수정 버튼을 눌렀을 경우 cRevieUpdateDate를 추가하는 Method
		 public boolean reviewUpdate() {
			 PreparedStatement ps = null;
	         try{
	             Class.forName("com.mysql.cj.jdbc.Driver");
	             Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	             @SuppressWarnings("unused")
	            Statement stmt_mysql = conn_mysql.createStatement();

	             String A = "update Attend set cReviewEditDate = curdate(), cReview = ?, cScore = ? where cId = ? and sEmail = " + currentuser;
	             

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
		 
	     // mysql에 있는 리뷰 관련 정보를 view로 불러오기 위한 메소드
		 public MyClassBean ReviewShowData() {
				MyClassBean bean = null;
				String QueryA = "select a.cReview, a.cScore from Attend as a, Class as c ";
				String QueryB = "where a.cId = c.cId and c.cId = " + cId;
				String QueryC = " and sEmail = " + currentuser;

			    try{
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		            Statement stmt_mysql = conn_mysql.createStatement();
		 
		            ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);

		            if(rs.next()){
		               
		               String cReview = rs.getString(1);
		               int cScore = rs.getInt(2);		               

		               bean = new MyClassBean(cReview, cScore);
		                }

		            conn_mysql.close();
           
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
		      
		      return bean;

			}

  
		 
		 
		 
	}//------