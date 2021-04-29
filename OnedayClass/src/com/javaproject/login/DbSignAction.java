package com.javaproject.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.javaproject.base.ShareVar;

public class DbSignAction {

	private final String url_mysql = "jdbc:mysql://192.168.0.6/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	private final String id_mysql = ShareVar.id_mysql;
	private final String pwd_mysql = ShareVar.pw_mysql;
	
	String email;
	String name;
	String nickName;
	String telNo;
	String password;
	
	// Constructor
	public DbSignAction() {
		// TODO Auto-generated constructor stub
	}

	public DbSignAction(String email, String name, String nickName, String telNo, String password) {
		super();
		this.email = email;
		this.name = name;
		this.nickName = nickName;
		this.telNo = telNo;
		this.password = password;
	}
	public DbSignAction(String email) {
		super();
		this.email = email;
	}
	public DbSignAction(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	//Method
	
	// 로그인 메소드
	public boolean signInStudent() {
		PreparedStatement ps = null;
		String query = "SELECT sPassword FROM Student WHERE sEmail = ?";
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).contentEquals(password)) {
					return true;
				} else {
					return false;
				}
			}return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean signInTeacher() {
		PreparedStatement ps = null;
		String query = "SELECT tPassword FROM Teacher WHERE tEmail = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).contentEquals(password)) {
					return true;
				} else {
					return false;
				}
			}return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	//회원가입 메소드
	public void signUpStudent() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "INSERT INTO Student (sEmail, sName, sNickName, sTelNo, sPassword) VALUES (?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, nickName);
			ps.setString(4, telNo);
			ps.setString(5, password);
			ps.executeUpdate();

			conn_mysql.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void signUpTeacher() {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "INSERT INTO Teacher (tEmail, tName, tNickName, tTelNo, tPassword) VALUES (?,?,?,?,?)";

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, nickName);
			ps.setString(4, telNo);
			ps.setString(5, password);
			ps.executeUpdate();

			conn_mysql.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	// 중복된 학생아이디 체크
	public boolean checkingStudentId() {
		PreparedStatement ps = null;
		String query = "SELECT sEmail FROM Student WHERE sEmail = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();

			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).contentEquals(email)) {
					return false;
				} else {
					return true;
				}
			}return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	// 중복된 학생아이디 체크
	public boolean checkingTeacherId() {
		PreparedStatement ps = null;
		String query = "SELECT tEmail FROM Student WHERE tEmail = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			
			ps = conn_mysql.prepareStatement(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).contentEquals(email)) {
					return false;
				} else {
					return true;
				}
			}return false;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
		
	// 학생 아이디 찾기
	public String findCommonId(String name, String phone) {
		
		String id = null;
		
		String query = "SELECT sEmail FROM Student WHERE sNmae = "+ name + " and sTelNo = " + phone;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			conn_mysql.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return id;
	}
	
	// 강사 아이디 찾기
public String findTeacherId(String name, String phone) {
		
		String id = null;
		
		String query = "SELECT tEmail FROM Teacher WHERE tNmae = "+ name + " and tTelNo = " + phone;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(query);
			
			if(rs.next()) {
				id = rs.getString(1);
			}
			conn_mysql.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return id;
	}
	// 학생 비밀번호 찾기
	public boolean findCommonPwd(String name, String email, String pwd) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			String query = "update Student set sPassword = " + pwd + "WHERE sNmae = "+ name + " and sEamil = " + email;
			
			ps = conn_mysql.prepareStatement(query);
			ps.executeUpdate();
			conn_mysql.close();
			
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	// 강사 비밀번호 찾기
	public boolean findTeacherPwd(String name, String email, String pwd) {
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);
			@SuppressWarnings("unused")
			Statement stmt_mysql = conn_mysql.createStatement();
			String query = "update Teacher set tPassword = " + pwd + "WHERE tNmae = "+ name + " and tEamil = " + email;
			
			ps = conn_mysql.prepareStatement(query);
			ps.executeUpdate();
			conn_mysql.close();
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
}
