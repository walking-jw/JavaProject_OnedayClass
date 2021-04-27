package com.javaproject.searchpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbSearchAction {

	//Field
	
	
	// Constructor
	public DbSearchAction() {
		// TODO Auto-generated constructor stub
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
				int wkSeq = rs.getInt(1);
				String wkName = rs.getString(2);
				String wkTelno = rs.getString(3);
				String wkRelation = rs.getString(4);
				
				Bean bean = new Bean(wkSeq, wkName, wkTelno, wkRelation);
				
				wkName = bean.getName();
				wkTelno = bean.getTelno();
				wkRelation = bean.getRelation();
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
