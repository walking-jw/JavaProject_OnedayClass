package com.javaproject.searchpage;

import java.util.Date;

public class SearchBean {

	String name;
	String category;
	String lacation;
	Date date;
	
	
	public SearchBean() {
		// TODO Auto-generated constructor stub
	}

	public SearchBean(String name, String category, String lacation, Date date) {
		super();
		this.name = name;
		this.category = category;
		this.lacation = lacation;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLacation() {
		return lacation;
	}

	public void setLacation(String lacation) {
		this.lacation = lacation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
}
