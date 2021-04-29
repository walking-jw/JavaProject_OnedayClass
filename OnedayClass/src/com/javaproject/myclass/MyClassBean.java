package com.javaproject.myclass;

	public class MyClassBean { // 2021.04.27 조혜지 - selectListAfter와 selectListBefore의 Bean을 가진 ArrayList 만들기 위해 Bean 클라스 추가
	
		 // Field
		 int cId;
		 String cAttendDate;
		 String cName;
		 String cDate;
		 String cLocation;
		 int cPrice;
		 String cReview;
		 int cScore;
		 
		 // Constructor
		 public MyClassBean() {
		     // TODO Auto-generated constructor stub
		 }

		 public MyClassBean(int cId, String cAttendDate, String cName, String cDate, String cLocation, int cPrice) {
		     super();
		     this.cId = cId;
		     this.cAttendDate = cAttendDate;
		     this.cName = cName;
		     this.cDate = cDate;
		     this.cLocation = cLocation;
		     this.cPrice = cPrice;
		 }
	 
		 public MyClassBean(int cId, String cDate, String cName, String cLocation) {
			super();
			this.cId = cId;
			this.cDate = cDate;
			this.cName = cName;
			this.cLocation = cLocation;
		}
		 
		public MyClassBean(String cReview, int cScore) {
			super();
			this.cReview = cReview;
			this.cScore = cScore;
		}

		// Method
		public int getcId() {
			return cId;
		}

		public void setcId(int cId) {
			this.cId = cId;
		}

		public String getcAttendDate() {
			return cAttendDate;
		}

		public void setcAttendDate(String cAttendDate) {
			this.cAttendDate = cAttendDate;
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

		public int getcPrice() {
			return cPrice;
		}

		public void setcPrice(int cPrice) {
			this.cPrice = cPrice;
		}

		public String getcReview() {
			return cReview;
		}

		public void setcReview(String cReview) {
			this.cReview = cReview;
		}

		public int getcScore() {
			return cScore;
		}

		public void setcScore(int cScore) {
			this.cScore = cScore;
		}

		 
		}