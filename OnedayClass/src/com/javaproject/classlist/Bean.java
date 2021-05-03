package com.javaproject.classlist;

public class Bean {
	
		//-----------------------------------Field
	
		int cId;
		int cPrice;
		String cName;
		String cLocation;
		String cDate;
		String cTime;

		String cContents;
		String tName;
		
		String tNickName;
		String tTelNo;
		String tEmail;
			
		String ComboxColumn;

		//-----------------------------------Constructor

		//기본 생성자 만들기
		public Bean() {
			// TODO Auto-generated constructor stub
		}

		
		
		//강의명 , 강사, 장소 , 날짜 (테이블 열 이름)  ---search
		public Bean(String cName, String tName ,String cLocation, String cDate) {
			super();
			this.cName = cName;
			this.tName = tName;
			this.cLocation = cLocation;
			this.cDate = cDate;
		}

		


		//테이블
		public Bean(int cId, String cName,  String tName, String cLocation, String cDate) {
			super();
			this.cId = cId;
			this.cName = cName;
			this.tName = tName;
			this.cLocation = cLocation;
			this.cDate = cDate;
		}
		
		
		
		//  강의정보를 위한 
		
		public Bean(String cName, String tName, String cLocation,  String cTime, String cDate, String cContents) {
			super();
			this.cName = cName;
			this.tName = tName;
			this.cLocation = cLocation;
			this.cTime = cTime;
			this.cDate = cDate;
			this.cContents = cContents;
		}
		
		
		

		
		//-----------------------------------getter & setter
		
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



		public int getcPrice() {
			return cPrice;
		}


		public void setcPrice(int cPrice) {
			this.cPrice = cPrice;
		}



		public String getcContents() {
			return cContents;
		}


		public void setcContents(String cContents) {
			this.cContents = cContents;
		}


		public String gettName() {
			return tName;
		}


		public void settName(String tName) {
			this.tName = tName;
		}


		public String getComboxColumn() {
			return ComboxColumn;
		}


		public void setComboxColumn(String comboxColumn) {
			ComboxColumn = comboxColumn;
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


}//end
