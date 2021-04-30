package com.javaproject.home;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
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
	public static int filename = ShareVar.filename;
	
	public DbHomeAction() {
		// TODO Auto-generated constructor stub
	}
	FileInputStream file;
	
	//Method

	public HomeBean recommandClassOne() {
		HomeBean bean = null;
		String WhereDefault = "select cId,cName,cImg from class order by rand() limit 1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			if(rs.next()) {
				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				
				// File
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(ShareVar.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(3);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				bean = new HomeBean(wkId, wkName);
			}
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	
	public HomeBean recommandClassTwo() {
		HomeBean bean = null;
		String WhereDefault = "select cId,cName,cImg from class order by rand() limit 1";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);
			
			if(rs.next()) {
				int wkId = rs.getInt(1);
				String wkName = rs.getString(2);
				
				// File
				ShareVar.filename = ShareVar.filename + 1;
				File file = new File(Integer.toString(filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(3);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				bean = new HomeBean(wkId, wkName);
				wkId = bean.getId();
				wkName = bean.getName();
			}
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}
	
}
