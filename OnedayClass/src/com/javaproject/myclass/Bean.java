package com.javaproject.myclass;

	public class Bean { // 혜지 DbAction의 서브클라스 - selectListAfter와 selectListBefore의 Bean을 가진 ArrayList 만들기 위해 클라스 추가
	
		 // Field
		 int cId;
		 String cAttendDate;
		 String cName;
		 String cDate;
		 String cLocation;
		 int cPrice;
		 
		 // Constructor
		 public Bean() {
		     // TODO Auto-generated constructor stub
		 }

		 public Bean(int cId, String cAttendDate, String cName, String cDate, String cLocation, int cPrice) {
		     super();
		     this.cId = cId;
		     this.cAttendDate = cAttendDate;
		     this.cName = cName;
		     this.cDate = cDate;
		     this.cLocation = cLocation;
		     this.cPrice = cPrice;
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
		 
		 
		}