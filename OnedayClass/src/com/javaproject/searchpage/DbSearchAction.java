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
	
	private final String url_mysql = "jdbc:mysql://192.168.0.6/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
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
	
	public ArrayList<SearchBean> conditionQueryAction() {
		 
		ArrayList<SearchBean> beanList = new ArrayList<SearchBean>();
 
		String WhereDefault = "select seqno, name, telno, relation from userinfo where " + conditionQueryColumn;
		String WhereDefault2 = " like '%" + searching + "%'";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
 
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault2);
 
			while(rs.next()){
				String wkName = rs.getString(1);
				String wkLocation = rs.getString(2);
				Date wkDate = rs.getDate(3);
				String wkPrice = rs.getString(4);
				
				SearchBean bean = new SearchBean(wkName, wkLocation, wkDate, wkPrice);
				
				wkName = bean.getName();
				wkLocation = bean.getLacation();
				wkDate = bean.getDate();
				wkPrice = bean.getPrice();
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
