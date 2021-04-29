package com.javaproject.studentpage;

public class ProfileBean {

	String name;
	String nickName;
	String telNo;
	
	public ProfileBean() {
		// TODO Auto-generated constructor stub
	}

	public ProfileBean(String name, String nickName, String telNo) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.telNo = telNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
	
	
}
