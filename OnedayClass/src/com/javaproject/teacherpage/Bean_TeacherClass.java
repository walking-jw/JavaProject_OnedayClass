package com.javaproject.teacherpage;

public class Bean_TeacherClass {

	
	// Field

	int cId;
	String cName;
	String cDate;
	String cLocation;
	int attendCount;
	String cTime;
	// Mypage 사용하기 위한 bean 값
	String tName;
	String tNickName;
	String tEmail;
	String tTelNo;
	
	
	
	// Constructor
	
	
	public Bean_TeacherClass() {
	}

	public Bean_TeacherClass(int cId, String cName, String cDate, String cLocation) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDate = cDate;
		this.cLocation = cLocation;
	}
	
	public Bean_TeacherClass(String tName, String tNickName, String tEmail, String tTelNo) {
		super();
		this.tName = tName;
		this.tNickName = tNickName;
		this.tEmail = tEmail;
		this.tTelNo = tTelNo;
	}
	
	
	
	
	
	
	
	public Bean_TeacherClass(String cName, String cDate, String cLocation, String cTime, String tName) {
		super();
		this.cName = cName;
		this.cDate = cDate;
		this.cLocation = cLocation;
		this.cTime = cTime;
		this.tName = tName;
	}

	// Method
	
	public String getcTime() {
		return cTime;
	}
	
	public void setcTime(String cTime) {
		this.cTime = cTime;
	}


	public Bean_TeacherClass(int cId) {
		super();
		this.cId = cId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettNickName() {
		return tNickName;
	}

	public void settNickName(String tNickName) {
		this.tNickName = tNickName;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettTelNo() {
		return tTelNo;
	}

	public void settTelNo(String tTelNo) {
		this.tTelNo = tTelNo;
	}

	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getcLocation() {
		return cLocation;
	}
	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}
}
