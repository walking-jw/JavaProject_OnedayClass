package com.javaproject.teacherpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RUDDbAction { // 2021.04.27~28 조혜지  - 강사 페이지 중 강의 등록/수정/삭제할 때 뷰와 sql에 연결해주는 클라스

	// 여기부터 4줄은 완성되면 없애기 ***************************************************
	public static final String url_mysql = "jdbc:mysql://192.168.0.3/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	public static String currentuser = "'hyejji@gmail.com'";
	public static int dcId = 0;
	public static int filename = 0;
	

	
//	public static int filename = 0;
	
	// 여기까지 4줄은 완성되면 없애기 ***************************************************

	// 여기부터 3줄은 완성되면 살리기 ***************************************************
		// private final static String url_mysql = ShareVar.url_mysql;
		// private final static String id_mysql = ShareVar.id_mysql;
		// private final static String pw_mysql = ShareVar.pw_mysql;
	// 여기까지 3줄은 완성되면 살리기 ***************************************************
		 
	
	    // Field*****************************************
	
		FileInputStream file;
		String cName;
		String cCategory;
		String cLocation1;
		String cLocation2;
		String cTime;
		String cDate;
		String cContents;
		int cPrice;
		int cId;

		
		// Constructor*****************************************
		
		// 초기 Constructor 생성
		public RUDDbAction() {
			// TODO Auto-generated constructor stub
		}

		// 강의 등록버튼 눌렀을 때의 메소드인 RegisterAction에서 사용
		public RUDDbAction(FileInputStream file, String cName, String cCategory, String cLocation1, String cLocation2,
				String cTime, String cDate, String cContents, int cPrice) {
			super();
			this.file = file;
			this.cName = cName;
			this.cCategory = cCategory;
			this.cLocation1 = cLocation1;
			this.cLocation2 = cLocation2;
			this.cTime = cTime;
			this.cDate = cDate;
			this.cContents = cContents;
			this.cPrice = cPrice;
		}

		// 깅의 삭제버튼 눌렀을 때의 메소드인 DeleteAction에서 사용
		public RUDDbAction(int cId) {
			super();
			this.cId = cId;
		}

		// 깅의 수정버튼 눌렀을 때의 메소드인 DeleteAction에서 사용
		public RUDDbAction(FileInputStream file, String cName, String cCategory, String cLocation1, String cLocation2,
				String cTime, String cDate, String cContents, int cPrice, int cId) {
			super();
			this.file = file;
			this.cName = cName;
			this.cCategory = cCategory;
			this.cLocation1 = cLocation1;
			this.cLocation2 = cLocation2;
			this.cTime = cTime;
			this.cDate = cDate;
			this.cContents = cContents;
			this.cPrice = cPrice;
			this.cId = cId;
		}

		
		// Method*****************************************

		// 강의 등록하는 메소드로서 mysql에 insert해주는 메소드 생성
		public boolean RegisterAction() {
		      PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String QueryA = "insert into Class (cName, cCategory, cLocation1, cLocation2, cDate, cTime, cPrice, cContents, cImg";
		          String QueryB = ") values (?,?,?,?,?,?,?,?,?)";
		
		          ps = conn_mysql.prepareStatement(QueryA + QueryB);
		          ps.setString(1, cName.trim());
		          ps.setString(2, cCategory.trim());
		          ps.setString(3, cLocation1.trim());
		          ps.setString(4, cLocation2.trim());
		          ps.setString(5, cDate.trim());
		          ps.setString(6, cTime.trim());
		          ps.setInt(7, cPrice);
		          ps.setString(8, cContents.trim());
		          ps.setBinaryStream(9, file);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}

		// 강의 등록일자, 강의id, 강사 이메일을 mysql에 insert해주는 메소드 생성
		public boolean RegisterDateAction() {
		      PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String QueryA = "insert into Register (cRegisterDate, cId, tEmail) values (curdate(), ?, ";
		          String QueryB = currentuser + ")";
		
		          ps = conn_mysql.prepareStatement(QueryA + QueryB);
		          ps.setInt(1, cId);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		          
		      }
		      return true;
		}
		
		// relation의 attribute 중 하나인 강의id를 가져오기 위해 메소드 하나를 추가로 생성
		public int getClassId() {
			int wkcId = 0;
			String Query = "select cId +1 from register order by cId desc limit 1";
			try {
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
				  Statement stmt_mysql = conn_mysql.createStatement();
		          ResultSet rs = stmt_mysql.executeQuery(Query);
		          
		          while(rs.next()) {
		        	  wkcId = rs.getInt(1);
		        	  
		          }
		          conn_mysql.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
			return wkcId;
		}
		
		// 강의 삭제해주는 메소드로서 mysql에 cCloseDate를 update해주는 메소드 생성
		public boolean DeleteAction() {
		      PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String QueryA = "update Register set cCloseDate = curdate()";
		          String QueryB = " where cId = ?";
		
		          ps = conn_mysql.prepareStatement(QueryA+QueryB);
		          ps.setInt(1, cId);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}
		
		// 강의 수정해주는 메소드로서 mysql에 class관련 정보 update해주는 메소드 생성
		public boolean UpdateAction() {
		      PreparedStatement ps = null;
		      try{
		          Class.forName("com.mysql.cj.jdbc.Driver");
		          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		          @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();
		
		          String QueryA = "update Class set cName = ?, cCategory = ?, cLocation1 = ?, cLocation2 = ?, cTime = ?, cDate = ?, cContents = ?, cPrice = ?, cImg = ? ";
		          String QueryB = " where cId = ?";
		
		          ps = conn_mysql.prepareStatement(QueryA+QueryB);
		          ps.setString(1, cName);
		          ps.setString(2, cCategory);
		          ps.setString(3, cLocation1);
		          ps.setString(4, cLocation2);
		          ps.setString(5, cTime);
		          ps.setString(6, cDate);
		          ps.setString(7, cContents);
		          ps.setInt(8, cPrice);
		          ps.setBinaryStream(9, file);
		          ps.setInt(10, cId);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}
		
		// mysql에 있는 강의 관련 정보를 view로 불러오기 위한 메소드
		public RUDBean TableClick() {
			RUDBean bean = null;
			String WhereDefault = "select cName, cCategory, cLocation1, cLocation2, cTime, cDate, cContents, cPrice, cImg from Class ";
		    String WhereDefault2 = "where cId = " + cId;
		    try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            Statement stmt_mysql = conn_mysql.createStatement();
	 
	            ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
	            
	            
	 
	            if(rs.next()){
	               
	               String cName = rs.getString(1);
	               String cCategory = rs.getString(2);
	               String cLocation1 = rs.getString(3);
	               String cLocation2 = rs.getString(4);
	               String cTime = rs.getString(5);
	               String cDate = rs.getString(6);
	               String cContents = rs.getString(7);
	               int cPrice = rs.getInt(8);
	               
	               // File
	               filename = filename + 1;
//	               ShareVar.filename = ShareVar.filename + 1;
	               File file = new File(Integer.toString(filename));
//	               File file = new File(Integer.toString(ShareVar.filename));
	               FileOutputStream output = new FileOutputStream(file);
	               InputStream input = rs.getBinaryStream(9);
	                byte[] buffer = new byte[1024];
	                while (input.read(buffer) > 0) {
	                    output.write(buffer);
	                }
	               
	            bean = new RUDBean(cName, cCategory, cLocation1, cLocation2, cTime, cDate, cContents, cPrice);
	            }
	            
	            conn_mysql.close();
	        }
	        catch (Exception e){
	            e.printStackTrace();
	        }
	      
	      return bean;
	
	
			   }
}
