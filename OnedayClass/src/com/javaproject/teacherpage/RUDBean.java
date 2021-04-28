package com.javaproject.teacherpage;

public class RUDBean { // 2021.04.28 조혜지 - ShowData의 Bean을 가진 ArrayList 만들기 위해 Bean 클라스 추가
	
	// Field
	String cName;
	String cCategory;
	String cLocation1;
	String cLocation2;
	String cTime;
	String cDate;
	String cContents;
	int cPrice;
	
	// Constructor
	public RUDBean() {
		// TODO Auto-generated constructor stub
	}
	

	public RUDBean(String cName, String cCategory, String cLocation1, String cLocation2, String cTime, String cDate,
			String cContents, int cPrice) {
		super();
		this.cName = cName;
		this.cCategory = cCategory;
		this.cLocation1 = cLocation1;
		this.cLocation2 = cLocation2;
		this.cTime = cTime;
		this.cDate = cDate;
		this.cContents = cContents;
		this.cPrice = cPrice;
	}

	// Method
	public String getcName() {
		return cName;
	}


	public void setcName(String cName) {
		this.cName = cName;
	}


	public String getcCategory() {
		return cCategory;
	}


	public void setcCategory(String cCategory) {
		this.cCategory = cCategory;
	}


	public String getcLocation1() {
		return cLocation1;
	}


	public void setcLocation1(String cLocation1) {
		this.cLocation1 = cLocation1;
	}


	public String getcLocation2() {
		return cLocation2;
	}


	public void setcLocation2(String cLocation2) {
		this.cLocation2 = cLocation2;
	}


	public String getcTime() {
		return cTime;
	}


	public void setcTime(String cTime) {
		this.cTime = cTime;
	}


	public String getcDate() {
		return cDate;
	}


	public void setcDate(String cDate) {
		this.cDate = cDate;
	}


	public String getcContents() {
		return cContents;
	}


	public void setcContents(String cContents) {
		this.cContents = cContents;
	}


	public int getcPrice() {
		return cPrice;
	}


	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}	
	
	
}