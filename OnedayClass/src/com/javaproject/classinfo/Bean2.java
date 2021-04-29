package com.javaproject.classinfo;

public class Bean2 {

	
//////???? 필요한지 만들어본 Bean
	String tName;
	String tNickName;
	String tTelNo;
	String tEmail;
	String qContents;
	
	
	//////강의대한 세부정보
	int cId;
	int cPrice;
	
	String cName;
	String cLocation;
	String cDate;
	String cTime;
	String cContents;
	//이미지
//	FileInputStream cImg;
	
	//강의 후기 sName  , cReview , cScore
	int cScore;
	String sName;
	String cReview;
	
	public Bean2() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
//	//강의 정보 전체 가져오기
//	public Bean2( String cName, String tName, String cLocation, String cTime, String cDate,  String cContents ,int cPrice) {
//		super();
////		this.cImg = cImg;
//		this.cName = cName;
//		this.tName = tName;
//		this.cLocation = cLocation;
//		this.cTime = cTime;
//		this.cDate = cDate;
//		this.cContents = cContents;
//		this.cPrice = cPrice;
//	}
	
	
	
	
	
	//----- 강의 정보 가져오기----> 바꿔야함 + cPrice추가 ( 2021.04.28, 17:38)
	public Bean2(int cId, String cName, String tName, String cLocation,String cTime, String cDate, String cContents, int cPrice) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.tName = tName;
		this.cLocation = cLocation;
		this.cTime = cTime;
		this.cDate = cDate;
		this.cContents = cContents;
		this.cPrice = cPrice;
	}
	

	


	//강사이름으로 강사정보 가져오기
	public Bean2(String tName, String tNickName, String tTelNo, String tEmail) {
		super();
		this.tName = tName;
		this.tNickName = tNickName;
		this.tTelNo = tTelNo;
		this.tEmail = tEmail;
	}
	
	
	// 강의 후기 테이블
	public Bean2(int cId,String cName, String cContents, int cScore) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cContents = cContents;
		this.cScore = cScore;
	}
	
	
	
	
	




	//getter & setter
	public Bean2(String qContents) {
		super();
		this.qContents = qContents;
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

	public String gettTelNo() {
		return tTelNo;
	}

	public void settTelNo(String tTelNo) {
		this.tTelNo = tTelNo;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String getqContents() {
		return qContents;
	}

	public void setqContents(String qContents) {
		this.qContents = qContents;
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

	public String getcLocation() {
		return cLocation;
	}

	public void setcLocation(String cLocation) {
		this.cLocation = cLocation;
	}

	public String getcDate() {
		return cDate;
	}

	public void setcDate(String cDate) {
		this.cDate = cDate;
	}

	public String getcTime() {
		return cTime;
	}

	public void setcTime(String cTime) {
		this.cTime = cTime;
	}


	public String getcContents() {
		return cContents;
	}

	public void setcContents(String cContents) {
		this.cContents = cContents;
	}



	public int getcScore() {
		return cScore;
	}



	public void setcScore(int cScore) {
		this.cScore = cScore;
	}



	public String getsName() {
		return sName;
	}



	public void setsName(String sName) {
		this.sName = sName;
	}



	public String getcReview() {
		return cReview;
	}



	public void setcReview(String cReview) {
		this.cReview = cReview;
	}




	public int getcPrice() {
		return cPrice;
	}




	public void setcPrice(int cPrice) {
		this.cPrice = cPrice;
	}

	
	
	
	
}
