package com.javaproject.teacherpage;

public class Bean_TeacherClass {

	
	// Field

	int cId;
	String cName;
	String cDate;
	String cLocation;
	int attendCount;
	
	
	// Constructor
	
	
	public Bean_TeacherClass() {
	}
	
	public Bean_TeacherClass(int cId, String cName, String cDate, String cLocation, int attendCount) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cDate = cDate;
		this.cLocation = cLocation;
		this.attendCount = attendCount;
	}
	
	
	
	
	
	
	
	
	
	
	// Method
	



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
	public int getAttendCount() {
		return attendCount;
	}
	public void setAttendCount(int attendCount) {
		this.attendCount = attendCount;
	}
	
	
}
