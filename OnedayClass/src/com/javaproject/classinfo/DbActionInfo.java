package com.javaproject.classinfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.javaproject.base.ShareVar;

public class DbActionInfo {

	//----------------------------Field
	
		//ShareVar에 저장해둔 DataBase 환경 연결
		public static final String url_mysql = ShareVar.url_mysql;
		public static final String id_mysql = ShareVar.id_mysql;
		public static final String pw_mysql = ShareVar.pw_mysql;
		public static String currentuser = ShareVar.currentuser;
		public static int classid = ShareVar.cId;
		public static int filename = ShareVar.filename;
		
		//이미지를 넣어주기 
		FileInputStream file;
		
		
		
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
		
		
		
		
		//  강의 후기  후기 테이블 위해 추가
		String cReview;
		
		
		
		//QnA insert를 위해 추가
		String qContents;
		String qDate;
		String sEmail;
		String tEmail;
		
		
		
		
		//--------------------------------constructor
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
		
		// 강의정보에 들어가는 7개 항목
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
		
		// 이미지를 함께 넣기 
		public DbActionInfo(FileInputStream file, int cPrice, String tName, String cName, String cLocation, String cDate,
				String cTime, String cContents) {
			super();
//			this.file = file;
			this.cPrice = cPrice;
			this.tName = tName;
			this.cName = cName;
			this.cLocation = cLocation;
			this.cDate = cDate;
			this.cTime = cTime;
			this.cContents = cContents;
		}
		
		


		//강사 이름을 통해 강사 정보 불러오기
		public DbActionInfo(String tName) {
			super();
			this.tName = tName;
		}
		
		

		//강의 후기 불러오기
		public DbActionInfo(int cId, String sEmail, String cReview,int cScore) {
			super();
			this.cId = cId;
			this.sEmail = sEmail;
			this.cReview = cReview;
			this.cScore = cScore;
		}
		
		
		//QnA 등록
		
		public DbActionInfo(String qContents, String tEmail) {
			super();
			this.qContents = qContents;
			this.tEmail = tEmail;
		}
		
		
		
		//---------------------------------------Method
		
		//Button Click -> 강의 세부정보 
		public Bean2 ButtonClassInfo() {
		Bean2 bean2 = null;   
		
		String WhereDefault1 = "select c.cId, c.cName, t.tName, concat(c.cLocation1,' ',c.cLocation2) as cLocation, c.cTime, c.cDate, c.cContents, cPrice, cImg ";
		String WhereDefault2 = "from Class as c, Teacher as t , Register as r "; 
		String WhereDefault3 = " where c.cId = r.cId and t.tEmail = r.tEmail and c.cId = " ;
		      
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		        Statement stmt_mysql = conn_mysql.createStatement();

		        ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2 + WhereDefault3 + cId); 

		        while(rs.next()){
		        	
		        	int wkcId =(rs.getInt(1));
		        	String wkcName =(rs.getString(2));
		        	String wktName =(rs.getString(3));
		        	String wkcLocation =(rs.getString(4));
		        	String wkcTime =(rs.getString(5));
		        	String wkcDate =(rs.getString(6));
		        	String wkcContents =(rs.getString(7));
		        	int wkcPrice =(rs.getInt(8));
		        	
		        	
		        	// File 이미지 불러오기
		               ShareVar.filename = ShareVar.filename + 1;
		               File file = new File(Integer.toString(ShareVar.filename));
		               FileOutputStream output = new FileOutputStream(file);
		               InputStream input = rs.getBinaryStream(9);
		                byte[] buffer = new byte[1024];
		                while (input.read(buffer) > 0) {
		                    output.write(buffer);
		                }
		                
//		                output.close();
		        
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

			
			String WhereDefault1 = "select c.cId, s.sEmail, a.cReview, a.cScore from Student as s , Class as c, Attend as a ";
			String WhereDefault2 = " where s.sEmail = a.sEmail and a.cId = c.cId and c.cId = " ;
			      
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
			        Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			        Statement stmt_mysql = conn_mysql.createStatement();

			        ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + WhereDefault2 +  cId);  

			        while(rs.next()){
			        	
			        	Integer wkcId =(rs.getInt(1));
			        	String wksEmail =(rs.getString(2));
			        	String wkcReview =(rs.getString(3));
			        	Integer wkcScore =(rs.getInt(4));
			        
			     
			        
			        Bean2 bean2 = new Bean2(wkcId,wksEmail, wkcReview,wkcScore);
			        beanList.add(bean2);
			        }
			          conn_mysql.close();
			          
			      	}catch (Exception e){
			      		
			          e.printStackTrace();
			      }
					return beanList;
		}//ClassReview End
		
		
		/*/
		 * 2021-04-29 18:10 권효은
		 * 해당 강의에 대한 강의후기 숫자 구하기
		 */

		public Bean2 CountReview() {
			
			Bean2 bean2 = null;   
			
			String WhereDefault1 = " select count(cReview) from Attend where cId =";
		
			 
			try{
				 Class.forName("com.mysql.cj.jdbc.Driver");
			     Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
			     Statement stmt_mysql = conn_mysql.createStatement();

			     ResultSet rs = stmt_mysql.executeQuery(WhereDefault1 + cId); 
			   
				          
				while(rs.next()){  
					 int wkCountReview = rs.getInt(1);
			
					 bean2 = new Bean2(wkCountReview);
					 
				    }
			          conn_mysql.close();
		          
		      	}catch (Exception e){
		      		
		          e.printStackTrace();
		      }
				return bean2;
		
		}//CountReview End 
		
		
		

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
		}//teacherInfo End
		

		
		

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
	            String B = ") values (?,curdate(),"+ShareVar.currentuser+",?)";
	            
	            ps = conn_mysql.prepareStatement(A+B);
	           
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
		

		
		
		/*/
		 * 2021-04-29 15:46 권효은
		 * 강의 수강신청 (버튼 클릭) 시 강의 날짜 , 학생이메일, 강의id - DB에 삽입 
		 */
		
		public boolean AttendOk() {
			 PreparedStatement ps = null;
		     try{
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
		         @SuppressWarnings("unused")
					Statement stmt_mysql = conn_mysql.createStatement();//여기선 안쓰는 애
		
		         String A = "insert into Attend(cAttendDate, sEmail, cId";
		         String B = ") values(curdate(),"+ ShareVar.currentuser+", ?)";
		         
		         ps = conn_mysql.prepareStatement(A+B);
		        
		         ps.setInt(1, cId);
		      
		     
		         ps.executeUpdate();
		
		         conn_mysql.close();
		         
		         return true;   
		     } catch (Exception e){
		
		         e.printStackTrace();
		         return false;  
		     }
			
		}//AttendOk End

	
}//end
