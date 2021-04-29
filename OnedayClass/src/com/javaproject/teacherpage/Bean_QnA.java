package com.javaproject.teacherpage;

public class Bean_QnA {
	
	//Field
	
	String sEmail;
	String qDate;
	String qContents;
	String aContents;
	
	//Constructor
	
	public Bean_QnA() {
		
	}
	
	public Bean_QnA(String sEmail, String qDate, String qContents) {
		super();
		this.sEmail = sEmail;
		this.qDate = qDate;
		this.qContents = qContents;
	}

	
	
	public Bean_QnA(String sEmail, String qDate, String qContents, String aContents) {
		super();
		this.sEmail = sEmail;
		this.qDate = qDate;
		this.qContents = qContents;
		this.aContents = aContents;
	}

	//Method
	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getqDate() {
		return qDate;
	}

	public void setqDate(String qDate) {
		this.qDate = qDate;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
	}

	public String getaContents() {
		return aContents;
	}

	public void setaContents(String aContents) {
		this.aContents = aContents;
	}
	
	
	
	

	
	
	
}
