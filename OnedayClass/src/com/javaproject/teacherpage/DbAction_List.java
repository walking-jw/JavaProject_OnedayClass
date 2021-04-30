package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

	public class DbAction_List { 
 
	 // Field*****************************************
	 int cId;
	 String cName;
	 String cDate;
	 String cLocation;
	 String cTime;
	 int cPrice;
	 String cReview;
	 int cScore;
	 public static int classid = ShareVar.cId;
	 public static String sName = "";
	 
	 // Field - QnAnswer 용 * * * * * *
	 String QnA_sEmail;
	 String QnA_qDate;
	 String QnA_qContents;
	 String QnA_aContents;
 
	 
	 // Constructor*****************************************
	 // QnA 답변 등록시 시용
	 public DbAction_List(String qnA_sEmail, String qnA_qDate, String qnA_qContents, String qnA_aContents) {
		 super();
		 QnA_sEmail = qnA_sEmail;
		 QnA_qDate = qnA_qDate;
		 QnA_qContents = qnA_qContents;
		 QnA_aContents = qnA_aContents;
	 }
		 
	 // 초기 Constructor 생성 - SearchActionAfter, SearchActionBefore에서 사용
	 public DbAction_List() {
	     // TODO Auto-generated constructor stub
	 }
		 
	 public DbAction_List(String cName) {
		super();
		this.cName = cName;
	}

	public DbAction_List(int cId) {
		 super();
		 this.cId = cId;
	}
	
	// Method * * * * * * * * * * * * * * * * * * * * * * * * * *
		 

	// 수강 예정인 데이터를 TeacherLectureList 상단 테이블로 mysql에서 불러오는 메소드
	 public ArrayList<Bean_TeacherClass> selectListAfter() {
	    
		 ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
	     
	     String QueryA = "select c.cId, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2) ";
	     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cName not in (select cName from Class where cDate <= curdate()) ";
	     String QueryC = "and tEmail = " + ShareVar.currentuser;		
	     String QueryD = " and r.cCloseDate is null ";
	     
	     try{
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
	         Statement stmt_mysql = conn_mysql.createStatement();
	
	         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC +QueryD);
	
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
		 
	 // 수강 이력인 데이터를 TeacherLectureList 하단 테이블로 mysql에서 불러오는 메소드
	 public ArrayList<Bean_TeacherClass> selectListBefore() {
	    
		 ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
	     
	     String QueryA = "select c.cId, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2) ";
	     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cDate not in (select cDate from Class where cDate >= curdate()) ";
	     String QueryC = "and tEmail = " + ShareVar.currentuser;
	     String QueryD = " and r.cCloseDate is null ";
	   
	     try{
	       Class.forName("com.mysql.cj.jdbc.Driver");
	       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
	       Statement stmt_mysql = conn_mysql.createStatement();
	       
	       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC + QueryD);
	       
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
		 
		 // 수강 세부사항에서 불러오기 (테이블로) - TeacherLectureDetail
		 public ArrayList<Bean_TeacherClass> selectListBefore_Detail() {
		   
			 ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
		     
		     String QueryA = "select c.cId, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2) ";
		     String QueryB = "from Class as c, Register as r where c.cId = r.cId and cDate not in (select cDate from Class where cDate >= curdate()) ";
		     String QueryC = "and c.cId = " + cId;
		  
		     try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		       Statement stmt_mysql = conn_mysql.createStatement();
		       
		       ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC );
		       
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
		 
		 public Bean_TeacherClass ButtonClassInfo() {
				Bean_TeacherClass bean2 = null;   

				String WhereDefault1 = "select c.cName, t.tName, concat(c.cLocation1,' ',c.cLocation2) as cLocation, c.cTime, c.cDate ";
				String WhereDefault2 = "from Class as c, Teacher as t , Register as r "; 
				String WhereDefault3 = " where c.cId = r.cId and t.tEmail = r.tEmail and c.cId = " ;
				      
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
				        Statement stmt_mysql = conn_mysql.createStatement();

				        ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2 + WhereDefault3+ cId);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴

				        while(rs.next()){
				    
				        	String wkcName =(rs.getString(1));
				        	String wktName =(rs.getString(2));
				        	String wkcLocation =(rs.getString(3));
				        	String wkcTime =(rs.getString(4));
				        	String wkcDate =(rs.getString(5));
				        
				          	bean2 = new Bean_TeacherClass(wkcName, wktName, wkcLocation, wkcTime, wkcDate);

				        }
				          conn_mysql.close();
				          
				      	}catch (Exception e){
				      		
				          e.printStackTrace();
				      }
						return bean2;
		 }
		 
		 
		// QnA 리스트 불러오는 메소드 ( 답변을 아직 달지 않은 리스트만 조회하기)
				 public ArrayList<Bean_QnA> selectList_QnA() {
				     ArrayList<Bean_QnA> beanList = new ArrayList<Bean_QnA>();
				     
				     
				     
				     String Query00 = "SELECT sEmail, qDate, qContents FROM QnA ";
				     String Query01 = "WHERE aContents is null AND tEmail = " + ShareVar.currentuser;		
				     try{
				         Class.forName("com.mysql.cj.jdbc.Driver");
				         Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
				         Statement stmt_mysql = conn_mysql.createStatement();
				
				         ResultSet rs = stmt_mysql.executeQuery(Query00 + Query01);
				
				         while(rs.next()){
				
				           String wksEmail = rs.getString(1);
				           String wkqDate = rs.getString(2);
				           String wkqContents = rs.getString(3);
				           
				           Bean_QnA bean = new Bean_QnA(wksEmail, wkqDate, wkqContents);
				           beanList.add(bean);
				
				         }
				         conn_mysql.close();
				         
				     }
				     catch (Exception e){
				         e.printStackTrace();
				     }
				     return beanList;
				 }
				 
		 // QnA 리스트 불러오는 메소드 ( 답변 완료한 리스트)
		 public ArrayList<Bean_QnA> selectList_QnA_OK() {
		
			 ArrayList<Bean_QnA> beanList = new ArrayList<Bean_QnA>();
		     
		     String Query00 = "SELECT sEmail, qDate, qContents FROM QnA ";
		     String Query01 = "WHERE aContents is not null AND tEmail = " + ShareVar.currentuser;		
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
		         Statement stmt_mysql = conn_mysql.createStatement();
		
		         ResultSet rs = stmt_mysql.executeQuery(Query00 + Query01);
		
		         while(rs.next()){
		
		           String wksEmail = rs.getString(1);
		           String wkqDate = rs.getString(2);
		           String wkqContents = rs.getString(3);
		           
		           Bean_QnA bean = new Bean_QnA(wksEmail, wkqDate, wkqContents);
		           beanList.add(bean);
		
		         }
		         conn_mysql.close();
		         
		     }
		     catch (Exception e){
		         e.printStackTrace();
		     }
		     return beanList;
		 }
		 
		 // * * * * * * * * * * *
		 public Bean_QnA selectList_QnA_Detail() {
				Bean_QnA bean2 = null;   
	
				 String Query00 = "SELECT sEmail, qDate, qContents, aContents FROM QnA ";
			     String Query01 = "WHERE aContents is null AND tEmail = " + ShareVar.currentuser;	
			     String Query02 = "AND sEmail like '" + sName + "'";
				      
					try{
						Class.forName("com.mysql.cj.jdbc.Driver");
				        Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
				        Statement stmt_mysql = conn_mysql.createStatement();

				        ResultSet rs = stmt_mysql.executeQuery(Query00+Query01+Query02);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴

				        while(rs.next()){
				    
				           String wksEmail = rs.getString(1);
				           String wkqDate = rs.getString(2);
				           String wkqContents = rs.getString(3);
				           String wkaContents = rs.getString(4);
				        
				           bean2 = new Bean_QnA(wksEmail, wkqDate, wkqContents, wkaContents);

				        }
				          conn_mysql.close();
				          
				      	}catch (Exception e){
				      		
				          e.printStackTrace();
				      }
						return bean2;
		 }
	
		// QnA 답변달기용 
		public boolean UpdateAction_QnA() {
				
		PreparedStatement ps = null;
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql,ShareVar.id_mysql,ShareVar.pw_mysql);
			    Statement stmt_mysql = conn_mysql.createStatement();
			    
			    String Query00 = "UPDATE QnA set aContents = ?, aDate = curdate() ";
			    String Query01 = "WHERE sEmail = ? And qDate = ? ";
			    
			    ps = conn_mysql.prepareStatement(Query00+Query01);
			    
			    ps.setString(1, QnA_aContents);
			    ps.setString(2, QnA_sEmail.trim());
			    ps.setString(3, QnA_qDate.trim());
			    ps.executeUpdate();
			    
			    
			    conn_mysql.close();
			    
			    
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}//
		 
		 
	}