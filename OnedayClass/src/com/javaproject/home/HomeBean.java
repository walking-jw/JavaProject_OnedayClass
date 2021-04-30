package com.javaproject.home;

public class HomeBean {

	int id;
	String name;
	
	public HomeBean() {
		// TODO Auto-generated constructor stub
	}

	

	public HomeBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
