package com.javaproject.classlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAction {

	
	//Field
	public static final String url_mysql = "jdbc:mysql://IP/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	
	public static String currentuser = "";
	

	
	
	
	
	
	//Constructor
	public DbAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//Method
	
	//콤보상자에 있는 카테고리별 강의명, 강사, 장소, 날짜 정보를 테이블로 불러오기
		public ArrayList<Bean> selectList(){
			
			ArrayList<Bean> beanList = new ArrayList<Bean>();   		
			 String whereDefault1 = "select c.className, t.teacherName, c.classLocation, c.classDate from Class as c, Teacher as t , Register as r ";  
			 String whereDefault2 = " where c.classId = r.Class_classId and t.teacherEmail = r.Teacher_teacherEmail ";
			 String whereDefault3 = " and classCategory ='"; 
			 String whereDefault4 = " '";
			 
				 try{ 
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				 Statement stmt_mysql = conn_mysql.createStatement();
					
				 ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3 + ComboxColumn + whereDefault4);  
				          
					 while(rs.next()){  // 데이터 가져오기 --DB는 한줄씩 움직이니까 //Record단위
					 String wkClassName = rs.getString(1);
					 String wkTeacherName = rs.getString(2);
					 String wkClassLocation = rs.getString(3);
					 String wkClassDate = rs.getString(4);
	
					 Bean bean = new Bean(wkClassName, wkTeacherName, wkClassLocation, wkClassDate);
					 beanList.add(bean);
				
				 }
				 conn_mysql.close();
				 }catch (Exception e){
					 e.printStackTrace();
				 }
				 return beanList;
					
		} //selectList 	End

	
	
	
	
	
}
