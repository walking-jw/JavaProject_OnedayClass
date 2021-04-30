package com.javaproject.classlist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DbAction {

//	
//	//ShareVar에 저장해둔 DataBase 환경 연결
//		public final String url_mysql = ShareVar.url_mysql;
//		public final String id_mysql = ShareVar.id_mysql;
//		public final String pw_mysql = ShareVar.pw_mysql;
//
	
	/*/
	 * static 이므로 -----> (금 작업)
	 */
//		//강의 아이디 가져오기
//		public static int classid = 0;  
		
		
		
		//Field
		int cId;
		String tName;
		String cName;
		String cLocation;
		String cDate;
		String cTime;
		String cContents;
		String ComboxColumn;


		
		//Constructor
		
		public DbAction() {
			// TODO Auto-generated constructor stub
		}
		
		//OuterTable 에 나올 것만 (생성자)  tName, cName, cLocation, cDate
		
		public DbAction(String tName, String cName, String cLocation, String cDate) {
			super();
			this.tName = tName;
			this.cName = cName;
			this.cLocation = cLocation;
			this.cDate = cDate;
		}
		

		
			
		//콤보박스를 위해 하나만 (생성자)
			
		public DbAction(String comboxColumn) {
		super();
		ComboxColumn = comboxColumn;
		}
			

	// 전체
		public DbAction(int cId, String cName, String tName, String cLocation, String cDate, String cContents,
				String comboxColumn) {
			super();
			this.cId = cId;
			this.tName = tName;
			this.cName = cName;
			this.cLocation = cLocation;
			this.cDate = cDate;
			this.cContents = cContents;
			ComboxColumn = comboxColumn;
		}
		
		

		
		
		//Search (콤보박스에 대한)
		
		public DbAction(String cName, String tName, String cLocation, String cDate, String comboxColumn) {
		super();
		this.cName = cName;
		this.tName = tName;
		this.cLocation = cLocation;
		this.cDate = cDate;
		ComboxColumn = comboxColumn;
	}
		
		

		
		//cId활용
		public DbAction(int cId) {
			super();
			this.cId = cId;
		}
		
		// 테이블 목록 불러오기
		
		public DbAction(int cId,  String cName, String tName,String cLocation, String cDate) {
			super();
			this.cId = cId;
			this.cName = cName;
			this.tName = tName;
			this.cLocation = cLocation;
			this.cDate = cDate;
		}
		
		
		
		
		

		//Method

		//콤보상자에 있는 카테고리별 강의명, 강사, 장소, 날짜 정보를 테이블로 불러오기
			public ArrayList<Bean> selectList(){
				
			ArrayList<Bean> beanList = new ArrayList<Bean>();   		
			String whereDefault1 = "select c.cId,c.cName, t.tName, concat(c.cLocation1,' ',c.cLocation2) as cLocation, c.cDate from Class as c, Teacher as t , Register as r ";  
		    String whereDefault2 = "where c.cId = r.cId and t.tEmail = r.tEmail and ";
			String whereDefault3 = " cCategory = '";
			String whereDefault4 = "'";
			
		
				 
				try{ 
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
				Statement stmt_mysql = conn_mysql.createStatement();
						
				ResultSet rs = stmt_mysql.executeQuery(whereDefault1 + whereDefault2 + whereDefault3 + ComboxColumn + whereDefault4);  
					          
					 while(rs.next()){  
					 int wkClassId = rs.getInt(1);
					 String wkClassName = rs.getString(2);
					 String wkTeacherName = rs.getString(3);
					 String wkClassLocation = rs.getString(4);
					 String wkClassDate = rs.getString(5);

				Bean bean = new Bean(wkClassId,wkClassName, wkTeacherName, wkClassLocation, wkClassDate);
				beanList.add(bean);
					
					 }
				conn_mysql.close();
				
				}catch (Exception e){
					e.printStackTrace();
				}
				return beanList;
						
			} //selectList 	End


	
	
	
	
	
}
