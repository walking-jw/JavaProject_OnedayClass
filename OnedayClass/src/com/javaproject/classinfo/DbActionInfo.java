package com.javaproject.classinfo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbActionInfo {

	
//	
//	//ShareVar에 저장해둔 DataBase 환경 연결
//		public final String url_mysql = ShareVar.url_mysql;
//		public final String id_mysql = ShareVar.id_mysql;
//		public final String pw_mysql = ShareVar.pw_mysql;
//		public static String currentuser ="'java@naver.com'";  // 계속 바꿔주기
		
	//임시
	
	//Database 환경 정의    
	public static final String url_mysql = "jdbc:mysql://192.168.35.241/useraddress?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";

	
	
	
		//필드값
		
		int cId;
		int cPrice;
		int cScore;
		
		String tName;
		String cName;
		String cLocation;
		String cDate;
		String cTime;
		String cContents;
		String ComboxColumn;
		//이미지
		FileInputStream cImg;
		
		
		
		// 학생 이름 , 강의 후기  후기 테이블 위해 추가
		String sName;
		String cReview;
		
		
		
		//QnA insert를 위해 추가
		String qContents;
		String qDate;
		String sEmail;
		String tEmail;
		
		
		
		
		
		
		//기본 생성자
		public DbActionInfo() {
			// TODO Auto-generated constructor stub
		}
		
		/*/
		 * 2021-04-27 권효은
		 *  cId 와 강의정보 6개 : Table Click을 위한 생성자
		 */
		// cId로 정보 불러오기
		public DbActionInfo(int cId) {
			super();
			this.cId = cId;
		}
		
		// 강의정보에 들어가는 6개 항목
		public DbActionInfo( String cName, String tName, String cLocation, String cTime,String cDate, String cContents , int cPrice) {
			super();
			this.cName = cName;
			this.tName = tName;
			this.cLocation = cLocation;
			this.cTime = cTime;
			this.cDate = cDate;
			this.cContents = cContents;
			this.cPrice = cPrice;
		}

		//강사 이름을 통해 강사 정보 불러오기
		public DbActionInfo(String tName) {
			super();
			this.tName = tName;
		}
		
		
		//강의 후기
		public DbActionInfo(int cId, int cScore, String sName, String cReview) {
			super();
			this.cId = cId;
			this.cScore = cScore;
			this.sName = sName;
			this.cReview = cReview;
		}
		
		
		//QnA
		
		public DbActionInfo(String qContents, String tEmail) {
			super();
			this.qContents = qContents;
			this.tEmail = tEmail;
		}
		
		
		
		
		
		//Button Click -> 강의 세부정보 
		public Bean2 ButtonClassInfo() {
		Bean2 bean2 = null;   

		String WhereDefault1 = "select c.cId, c.cName, t.tName, concat(c.cLocation1,' ',c.cLocation2) as cLocation, c.cTime, c.cDate, c.cContents, cPrice ";
		String WhereDefault2 = "from Class as c, Teacher as t , Register as r "; 
		String WhereDefault3 = " where c.cId = r.cId and t.tEmail = r.tEmail and c.cId = " ;
		      
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		        Statement stmt_mysql = conn_mysql.createStatement();

		        ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2 + WhereDefault3+ cId);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴

		        while(rs.next()){
//		        	FileInputStream wkcImg=(rs.get);??
		        	
		        	int wkcId =(rs.getInt(1));
		        	String wkcName =(rs.getString(2));
		        	String wktName =(rs.getString(3));
		        	String wkcLocation =(rs.getString(4));
		        	String wkcTime =(rs.getString(5));
		        	String wkcDate =(rs.getString(6));
		        	String wkcContents =(rs.getString(7));
		        	int wkcPrice =(rs.getInt(8));
		        
		          	bean2 = new Bean2( wkcId, wkcName, wktName, wkcLocation, wkcTime, wkcDate, wkcContents, wkcPrice);

		        }
		          conn_mysql.close();
		          
		      	}catch (Exception e){
		      		
		          e.printStackTrace();
		      }
				return bean2;
		}//Table Click End

		
		/*/
		 * 2021-04-28 권효은 14:26
		 * 강의 후기 클릭시 해당 강의 후기 정보 가져오기
		 */
		


		public ArrayList<Bean2> ClassReview() {
			
			ArrayList<Bean2> beanList = new ArrayList<Bean2>();   		

			String WhereDefault1 = "select c.cId, s.sName, a.cReview, a.cScore from Student as s , Class as c, Attend as a ";
			String WhereDefault2 = " where s.sEmail = a.sEmail and a.cId = c.cId and c.cId = " ;
			      
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			        Statement stmt_mysql = conn_mysql.createStatement();

			        ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2 +  cId);  // 생성자에서 만들어 놓은 시퀀넘을 가져옴

			        while(rs.next()){
			        	
			        	Integer wkcId =(rs.getInt(1));
			        	String wksName =(rs.getString(2));
			        	String wkcReview =(rs.getString(3));
			        	Integer wkcScore =(rs.getInt(4));
			     
			        
			        Bean2 bean2 = new Bean2(wkcId,wksName, wkcReview,wkcScore);
			        beanList.add(bean2);
			        }
			          conn_mysql.close();
			          
			      	}catch (Exception e){
			      		
			          e.printStackTrace();
			      }
					return beanList;
		}
		
		

		

		/*/
		 * 2021-04-27 권효은
		 * 강사 이름 선택시, 그 이름을 통해 강사 정보 불러오기
		 */
		
		
		public Bean2 teacherInfo(){
			Bean2 bean2 = null;   
			
			 String WhereDefault1 = " select t.tName, t.tNickName, t.tTelNo, t.tEmail from Teacher as t, Register as r, Class as c ";  //outer table에 넣을 것들만!
			 String whereDefault2 = " where c.cId = r.cId and t.tEmail = r.tEmail and c.cId = ";
			 
			 try{
				 Class.forName("com.mysql.cj.jdbc.Driver");
			     Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			     Statement stmt_mysql = conn_mysql.createStatement();

			     ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + whereDefault2 + cId); 
			   
				          
			 while(rs.next()){  
			 String wktName = rs.getString(1);
			 String wktNickName = rs.getString(2);
			 String wktTelNo = rs.getString(3);
			 String wktEmail = rs.getString(4);

			 bean2 = new Bean2(wktName, wktNickName, wktTelNo, wktEmail);
		        }
		          conn_mysql.close();
		          
		      	}catch (Exception e){
		      		
		          e.printStackTrace();
		      }
				return bean2;
		}

		
		
		
		//////////----------
		/*/
		 * 2021-04-28 오전 12:35_권효은
		 * QnA insert를 위한 메소드 
		 */
		

		public boolean insertQnA(){
	        PreparedStatement ps = null;
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	            @SuppressWarnings("unused")
				Statement stmt_mysql = conn_mysql.createStatement();//여기선 안쓰는 애

	            String A = "insert into QnA(qContents, qDate, sEmail, tEmail";
	            String B = ") values (?,curdate(),"+currentuser+",?)";
	            
	            ps = conn_mysql.prepareStatement(A+B);
	            //아래 tfName, tfTelno 등이 누군지 모름
	            //1. 생성자할때 넣어주자!   혹은 2. 매소드 안에 매개변수를 만들어 줄수도 있음 ---> 우리는 1번 씀
	            ps.setString(1, qContents);
	            ps.setString(2, tEmail);
	        
	            ps.executeUpdate();

	            conn_mysql.close();
	            return true;   // 잘됐어!
	        } catch (Exception e){

	            e.printStackTrace();
	            return false;  // 오류 걸렸다!
	        }
		}//insertQnA End
		

		//---- 이미지
	
}
