package com.javaproject.searchpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.javaproject.base.ShareVar;

public class DbSearchAction {

	//Field
	String searching;
	String conditionQueryColumn;
	
	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pwd_mysql = ShareVar.pw_mysql;
	
	// Constructor
	public DbSearchAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public DbSearchAction(String searching, String conditionQueryColumn) {
		super();
		this.searching = searching;
		this.conditionQueryColumn = conditionQueryColumn;
	}


	// Method
	
	public ArrayList<SearchBean> conditionList() {
		 
		ArrayList<SearchBean> beanList = new ArrayList<SearchBean>();
 
		String WhereDefault = "select cid, cName, cCategory, concat(cLocation1, ' ',cLocation2), cDate from Class where " + conditionQueryColumn;
		String WhereDefault2 = " like '%" + searching + "%'";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
 
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
 
			while(rs.next()){
				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkCategory = rs.getString(3);
				String wkLocation = rs.getString(4);
				Date wkDate = rs.getDate(5);
				
				SearchBean bean = new SearchBean(wkId, wkName, wkCategory, wkLocation, wkDate);
				

				beanList.add(bean);
			}
			conn_mysql.close();
		}
		catch (Exception e){
			e.printStackTrace();
		}
 
		return beanList;
	}
}
