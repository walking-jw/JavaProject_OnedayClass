package com.javaproject.teacherpage;

public class Bean_QnA {
	
	//Field
	String sEmail;
	String qDate;
	String qContents;
	String aContents;
	int countOfQnA;
	
	//Constructor
	
	public Bean_QnA() {
	}
	
	// 마이페이지 QnA 수 체크를 위한 Bean
	public Bean_QnA(int countOfQnA) {
		super();
		this.countOfQnA = countOfQnA;
	}

	// QnA 리스트 불러오기 위한 Bean
	public Bean_QnA(String sEmail, String qDate, String qContents) {
		super();
		this.sEmail = sEmail;
		this.qDate = qDate;
		this.qContents = qContents;
	}

	// QnA 답변을 위한 Bean
	public Bean_QnA(String sEmail, String qDate, String qContents, String aContents) {
		super();
		this.sEmail = sEmail;
		this.qDate = qDate;
		this.qContents = qContents;
		this.aContents = aContents;
	}

	// Method * * * * * *
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

	public int getCountOfQnA() {
		return countOfQnA;
	}

	public void setCountOfQnA(int countOfQnA) {
		this.countOfQnA = countOfQnA;
	}
	
	
}
