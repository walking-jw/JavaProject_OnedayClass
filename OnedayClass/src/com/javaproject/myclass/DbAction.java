package com.javaproject.myclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAction {
 
	// 재원
	public static final String url_mysql = "jdbc:mysql://192.168.0.128/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	
	// 공용
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	
	public static String currentuser = "hyoeun@gmail.com";
	
	
 // Field
// private final static String url_mysql = ShareVar.url_mysql;
// private final static String id_mysql = ShareVar.id_mysql;
// private final static String pw_mysql = ShareVar.pw_mysql;
 
 int cId;
 String cAttendDate;
 String cName;
 String cDate;
 String cLocation;
 int cPrice;
 String cReview;
 int cScore;
 
 // Constructor
 public DbAction() {
     // TODO Auto-generated constructor stub
 }
 
 
 public DbAction(int cId) {
     super();
     this.cId = cId;
 }

 
 
 
 

 public DbAction(int cId, String cReview, int cScore) {
     super();
     this.cId = cId;
     this.cReview = cReview;
     this.cScore = cScore;
 }


 // Method
 
 public ArrayList<Bean> selectListAfter() {
     ArrayList<Bean> beanList = new ArrayList<Bean>();
     
     String WhereDefault = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice from Class as c, Attend as a where c.cId = a.cId and cName in (select cName from Class where cDate >= curdate())";
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
         Statement stmt_mysql = conn_mysql.createStatement();

         ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

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
 
 
 public ArrayList<Bean> selectListBefore() {
     ArrayList<Bean> beanList = new ArrayList<Bean>();
     
       String WhereDefault = "select c.cId, a.cAttendDate, c.cName, c.cDate, concat(cLocation1, ' ', cLocation2), c.cPrice from Class as c, Attend as a where c.cId = a.cId and cName not in (select cName from Class where cDate >= curdate())";
     try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
       Statement stmt_mysql = conn_mysql.createStatement();
       
       ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
       
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
     

 
}
