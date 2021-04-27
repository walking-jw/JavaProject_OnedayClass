package com.javaproject.teacherpage;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RUDDbAction { // 혜지  - 강사 페이지 중 강의 등록

	// 여기부터 4줄은 완성되면 없애기 ***************************************************
	public static final String url_mysql = "jdbc:mysql://192.168.0.5/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	public static String currentuser = "'hyejji@gmail.com'";
	public static int filename = 0;
	
	// 여기까지 4줄은 완성되면 없애기 ***************************************************

	// 여기부터 3줄은 완성되면 살리기 ***************************************************
		// private final static String url_mysql = ShareVar.url_mysql;
		// private final static String id_mysql = ShareVar.id_mysql;
		// private final static String pw_mysql = ShareVar.pw_mysql;
	// 여기까지 3줄은 완성되면 살리기 ***************************************************
		 
	
	    // Field
		FileInputStream file;
		String cName;
		String cCategory;
		String cLocation1;
		String cLocation2;
		String cTime;
		String cDate1;
		String cDate2;
		String cDate3;
		String cContents;
		int cPrice;
		
		
		// Constructor
		public RUDDbAction() {
			// TODO Auto-generated constructor stub
		}
		
	
		public RUDDbAction(FileInputStream file, String cName, String cCategory, String cLocation1, String cLocation2,
				String cTime, String cDate1, String cDate2, String cDate3, String cContents, int cPrice) {
			super();
			this.file = file;
			this.cName = cName;
			this.cCategory = cCategory;
			this.cLocation1 = cLocation1;
			this.cLocation2 = cLocation2;
			this.cTime = cTime;
			this.cDate1 = cDate1;
			this.cDate2 = cDate2;
			this.cDate3 = cDate3;
			this.cContents = cContents;
			this.cPrice = cPrice;
		}

	
		// Method
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
		          ps.setString(5, cDate1.trim() + '-' + cDate2.trim() + '-' + cDate3.trim());
		          ps.setString(6, cTime.trim());
		          ps.setInt(7, cPrice);
		          ps.setString(8, cContents);
		          ps.setBinaryStream(9, file);
		          ps.executeUpdate();
		
		          conn_mysql.close();
		      } catch (Exception e){
		          e.printStackTrace();
		          return false;
		      }
		      return true;
		}
	
}
