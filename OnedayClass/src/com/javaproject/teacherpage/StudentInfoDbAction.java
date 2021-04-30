package com.javaproject.teacherpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

public class StudentInfoDbAction { // 2021.04.30 조혜지  - 강사의 강의를 신청한 학생의 정보 알려주는 뷰와 연결해주는 클라스
	
	public static final String url_mysql = ShareVar.url_mysql;
	public static final String id_mysql = ShareVar.id_mysql;
	public static final String pw_mysql = ShareVar.pw_mysql;
	public static String currentuser = ShareVar.currentuser;
	public static int classId = ShareVar.cId;
		
    // Field*****************************************
	
	String sEmail;
	String sName;
	String sNickName;
	String sTelNo;
	int cId;
	
	// Constructor*****************************************
	
	// 초기 Constructor 생성
	public StudentInfoDbAction() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfoDbAction(int cId) {
		super();
		this.cId = cId;
	}
	
	
	// Method*****************************************
	 



	// 수강 신청한 학생 정보를 mysql에서 불러오는 메소드
	 public ArrayList<StudentInfoBean> selectListStudentInfo() {
	     ArrayList<StudentInfoBean> beanList = new ArrayList<StudentInfoBean>();
	     
	     String QueryA = "select s.sEmail, s.sName, s.sNickName, s.sTelNo ";
	     String QueryB = "from Student as s, Attend as a where s.sEmail = a.sEmail and ";
	     String QueryC = " a.cId = " + RUDDbAction.classId;
	     try{
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	         Statement stmt_mysql = conn_mysql.createStatement();
	

	         ResultSet rs = stmt_mysql.executeQuery(QueryA + QueryB + QueryC);
	
	         while(rs.next()){
	
	           String wksEmail = rs.getString(1);
	           String wksName = rs.getString(2);
	           String wksNickName = rs.getString(3);
	           String wksTelno = rs.getString(4);
	           
	           StudentInfoBean bean = new StudentInfoBean(wksEmail, wksName, wksNickName, wksTelno);
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
