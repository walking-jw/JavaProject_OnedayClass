package com.javaproject.studentpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javaproject.base.ShareVar;

public class DbProfileAction {

	private final String url_mysql = "jdbc:mysql://192.168.0.6/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = ShareVar.id_mysql;
	private final String pwd_mysql = ShareVar.pw_mysql;
	
	
	String name;
	String nickName;
	String telNo;
	String password;
	
	public DbProfileAction() {
		// TODO Auto-generated constructor stub
	}
	
	public DbProfileAction(String name, String nickName, String telNo) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.telNo = telNo;
	}

	
	public DbProfileAction(String password) {
		super();
		this.password = password;
	}

	// 프로필 가져오기
	public ProfileBean loadProfile() {
		
		ProfileBean bean = null;
		
		String WhereDefault = "select sName, sNickname, sTelNo from Student where sEmail = '"+ShareVar.currentuser + "'";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(WhereDefault);

			if(rs.next()){

				String wkName = rs.getString(1);
				String wkNickName = rs.getString(2);
				String wkTelno = rs.getString(3);
				bean = new ProfileBean(wkName, wkNickName, wkTelno);
			}
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return bean;
	}

	
	//정보 수정하기
	public void updateAction() {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update Student set sName = ?, sNickName = ?, sTelNo = ?";
			String B = " where sEmail = " + ShareVar.currentuser;

			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, name);
			ps.setString(2, nickName);
			ps.setString(3, telNo);
			ps.executeUpdate();
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// 비밀번호 변경하기
	public void changePwd() {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();

			String A = "update Student set sPassword = ?";
			String B = " where sEmail = '" + ShareVar.currentuser + "'";

			ps = conn_mysql.prepareStatement(A+B);
			ps.setString(1, password);
			ps.executeUpdate();
			conn_mysql.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// 탈퇴하기
	public void deleteAction() {
		PreparedStatement ps = null;

		try{

			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);

			@SuppressWarnings("unused")

			Statement stmt_mysql = conn_mysql.createStatement();


			String A = "delete from Student where sEmail = '"+ ShareVar.currentuser + "'";

			ps = conn_mysql.prepareStatement(A);

			ps.executeUpdate();

			conn_mysql.close();

		} catch (Exception e){

			e.printStackTrace();

		}
	}
	
}
