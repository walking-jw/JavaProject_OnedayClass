package com.javaproject.teacherpage;

public class StudentInfoBean { // 2021.04.30 조혜지 - selectListStudentInfo의 Bean을 가진 ArrayList 만들기 위해 Bean 클라스 추가
	
    // Field*****************************************
	
	String sEmail;
	String sName;
	String sNickName;
	String sTelNo;
	
	// Constructor*****************************************
	
	public StudentInfoBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentInfoBean(String sEmail, String sName, String sNickName, String sTelNo) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sNickName = sNickName;
		this.sTelNo = sTelNo;
	}

	// Method*****************************************

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsNickName() {
		return sNickName;
	}

	public void setsNickName(String sNickName) {
		this.sNickName = sNickName;
	}

	public String getsTelNo() {
		return sTelNo;
	}

	public void setsTelNo(String sTelNo) {
		this.sTelNo = sTelNo;
	}
	
	
}
