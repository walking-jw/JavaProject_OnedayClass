package com.javaproject.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

public class DbHomeAction {

	private final String url_mysql = ShareVar.url_mysql;
	private final String id_mysql = ShareVar.id_mysql;
	private final String pwd_mysql = ShareVar.pw_mysql;
	
	
	public DbHomeAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	//Method
	public ArrayList<HomeBean> recommandClass() {
		ArrayList<HomeBean> beanList = new ArrayList<HomeBean>();
		String WhereDefault = "select cId,cName from class order by rand() limit 2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			while(rs.next()) {
				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				
				HomeBean bean = new HomeBean(wkId, wkName);
				wkId = bean.getId();
				wkName = bean.getName();
				beanList.add(bean);
			}
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return beanList;
	}
	
	public void firstRecommndClass() {
		
	}

	public void secondRecommandClass() {
		
	}
}
