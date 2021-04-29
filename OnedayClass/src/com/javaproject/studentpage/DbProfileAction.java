package com.javaproject.studentpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DbProfileAction {

	public DbProfileAction() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateAction() {

	      PreparedStatement ps = null;

	      //Bean bean = null;

	      try{

	          Class.forName("com.mysql.cj.jdbc.Driver");

	          Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pwd_mysql);

	          @SuppressWarnings("unused")

	          Statement stmt_mysql = conn_mysql.createStatement();

	 

	          String A = "update userinfo set name = ?, telno = ?, address = ?, email = ?, relation = ? ";

	          String B = " where seqno = ? ";

	 

	          //bean = new Bean(seqno, name, telno, address, email, relation);

	          ps = conn_mysql.prepareStatement(A+B);

	          ps.setString(1, name);

	          ps.setString(2, telno);

	          ps.setString(3, address);

	          ps.setString(4, email);

	          ps.setString(5, relation);

	          ps.setInt(6, seqno);

	          ps.executeUpdate();

	          conn_mysql.close();

	      } catch (Exception e){

	          e.printStackTrace();

	      }

		}
}
