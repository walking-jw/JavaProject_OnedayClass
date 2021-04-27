package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;
import com.javaproject.myclass.Bean;

public class DbAction {

	
	
	public DbAction() {
		
	}
	
	
	// 강의 예정 리스트 DB 에서 불러오기 * * * * * * * * * * * * * [2021.04.26,10:44]
	
	public ArrayList<Bean_TeacherClass> selectList_Up(){
		
	
		ArrayList<Bean_TeacherClass> beanList = new ArrayList<Bean_TeacherClass>();
		
		String Query01 = "SELECT Class.cId, Class.cName, Class.cDate, concat(Class.cLocation1,' ',Class.cLocation2), ";
		String Query02 = "(Select count(Attend.cId) FROM Attend, Class WHERE Class.cId = Attend.cId And Class.cId =2) ";
		String Query03 = "FROM Teacher, Register, Class WHERE Teacher.tEmail = Register.tEmail and Register.cId = Class.cId ";		
		String Query04 = "And cName in (select cName from Class where cDate <= curdate()) AND Teacher.tEmail = " + ShareVar.currentuser;
		
	//	SElECT Class.cId, Class.cName, Class.cDate, concat(Class.cLocation1,' ',Class.cLocation2),
	//	(Select count(Attend.cId) from Attend, Class WHERE Class.cId = Attend.cId 
	//	And Class.cId =2) as 수강인원
	//	FROM Teacher, Register, Class
	//	WHERE Teacher.tEmail = Register.tEmail and Register.cId = Class.cId 
	//	And cName in (select cName from Class where cDate <= curdate())
	//	AND Teacher.tEmail = 'aaa@naver.com'; 
		
		  try{
		       Class.forName("com.mysql.cj.jdbc.Driver");
		       Connection conn_mysql = DriverManager.getConnection(ShareVar.url_mysql, ShareVar.id_mysql, ShareVar.pw_mysql);
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
}
