package com.javaproject.base;

public class ShareVar {
	
		
							/* * * * * * * * * * * * *
							 *  DATABASE SETTING 	 *
							 *  - 2021.04.26, 15:15  *
							 *  - Park Jaewon  	     *
							 * * * * * * * * * * * * *  
							 */
	
		/* >>>>>>>> 작업시 착안사항 [ 1 ] <<<<<<<<
		 * Main(금손양성소) 페이지에서 각자 자기 버튼 눌러서 시작하고 작업해주시면 됩니다.
		 * 하단에 지정해주신 이름으로 클라스를 만들고 + 착안사항 [ 3 ]의 Method를 추가해주시고 시작해주세요 ~!^^
		 * 
		 *  도영님 : Doyoung start 버튼 ---> Signin.java
		 *  혜지님 : Hyeji start 버튼 ---> StudentMylecture.java
		 *  효은님 : Hyoeun start 버튼 ---> Category.java
		 *  재원님 : Jaewon start 버튼 ---> TeacherMypage.java
		 *  
		 */
		
		/*
		 *  >>>>>>>> 작업시 착안사항 [ 2 ] <<<<<<<<	
		 *  작업하실때 자신의 IP 입력후 작업해주시고 Merge할 때 꼭!!! IP 로 다시 돌려주시고 주석처리 하셔야합니다.
		 *  
		 */ 
			
		/*  >>>>>>>> 작업시 착안사항 [ 3 ] <<<<<<<<	
		 *  // 도영님 복사
		 *  public void setVisible_Signin(boolean i){
		 *  	frame.setVisible(i);
		 *  }
		 *  
		 *  // 혜지님 복사
		 *  public void setVisible_StudenMylecture(boolean i){
		 *  	frame.setVisible(i);
		 *  }
		 *  
		 *  // 효은님 복사
		 *  public void Category(boolean i){
		 *  	frame.setVisible(i);
		 *  }
		 *  
		 */
	
	// 효은
//	public static final String url_mysql = "jdbc:mysql://IP/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";

	// 혜지
//	public static final String url_mysql = "jdbc:mysql://IP/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	
	// 도영
//	public static final String url_mysql = "jdbc:mysql://IP/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	
	// 재원
//	public static final String url_mysql = "jdbc:mysql://IP/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	
	// 공용
	public static final String url_mysql = "jdbc:mysql://172.30.3.144/OnedayClass?serverTimezone=UTC&characterEncoding=utf8&useSSL=FALSE";
	public static final String id_mysql = "root";
	public static final String pw_mysql = "qwer1234";
	
	public static String currentuser = "";
	public static int cId = 0;
	public static int filename = 0;
	// ** "WHERE studentid = " + ShareVar.currentuser
	
	
	
}
