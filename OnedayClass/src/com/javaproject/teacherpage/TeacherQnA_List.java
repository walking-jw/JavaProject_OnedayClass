package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TeacherQnA_List {

	private JFrame frame;
	private JButton btnAnswer;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_QnA;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Create the application.
	 */
	public TeacherQnA_List() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				TableInit();
				SearchActionAfter();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnAnswer());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
	}

	
	
	// 해당 클라스 켜주기 
	public void setVisible_TeacherQnA_List(boolean b) {
		frame.setVisible(true);
	}
	private JButton getBtnAnswer() {
		if (btnAnswer == null) {
			btnAnswer = new JButton("답변하기");
			btnAnswer.setBounds(374, 490, 117, 29);
		}
		return btnAnswer;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("문의리스트");
			lblNewLabel.setBounds(56, 59, 149, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(56, 98, 430, 347);
			scrollPane.setViewportView(getInner_Table_QnA());
		}
		return scrollPane;
	}
	private JTable getInner_Table_QnA() {
		if (Inner_Table_QnA == null) {
			Inner_Table_QnA = new JTable();
			Inner_Table_QnA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_QnA.setModel(Outer_Table);
			
		}
		return Inner_Table_QnA;
	}
	
	private void TableInit(){
	       int i = Outer_Table.getRowCount();
	       
	       Outer_Table.addColumn("질문자");
	       Outer_Table.addColumn("질문날짜");
	       Outer_Table.addColumn("질문내용");
	       Outer_Table.setColumnCount(3);

	       for(int j = 0 ; j < i ; j++){
	           Outer_Table.removeRow(0);
	       }

	       Inner_Table_QnA.setAutoResizeMode(Inner_Table_QnA.AUTO_RESIZE_OFF);
	       

	       int vColIndex = 0;
	       TableColumn col = Inner_Table_QnA.getColumnModel().getColumn(vColIndex);
	       int width = 120;
	       col.setPreferredWidth(width);

	       vColIndex = 1;
	       col = Inner_Table_QnA.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);
	       
	       vColIndex = 2;
	       col = Inner_Table_QnA.getColumnModel().getColumn(vColIndex);
	       width = 300;
	       col.setPreferredWidth(width);
	 }
	
	// 수강 예정인 데이터를 mysql에서 불러오는 메소드
			 public ArrayList<Bean_QnA> qnaListAfter() {
			     ArrayList<Bean_QnA> beanList = new ArrayList<Bean_QnA>();
			     
//			     SELECT sEmail, qDate, qContents 
//			     FROM QnA 
//			     WHERE tEmail = 'aaa@naver.com';
			     
			     
			     
			     String Query00 = "select sEmail, qDate, qContents From QnA ";
			     String Query01 = "WHERE tEmail = '" + ShareVarTest.currentuser + "'";		
			     try{
			         Class.forName("com.mysql.cj.jdbc.Driver");
			         Connection conn_mysql = DriverManager.getConnection(ShareVarTest.url_mysql,ShareVarTest.id_mysql,ShareVarTest.pw_mysql);
			         Statement stmt_mysql = conn_mysql.createStatement();
			
			         ResultSet rs = stmt_mysql.executeQuery(Query00 + Query01);
			
			         while(rs.next()){
			
			           String wksEmail = rs.getString(1);
			           String wktqDate = rs.getString(2);
			           String wkqContents = rs.getString(3);
			           
			           Bean_QnA bean = new Bean_QnA(wksEmail, wktqDate, wkqContents);
			           beanList.add(bean);
			
			         }
			         conn_mysql.close();
			         
			     }
			     catch (Exception e){
			         e.printStackTrace();
			     }
			     return beanList;
			 }
			 
			 private void SearchActionAfter(){
			     
			     DbAction_List dbAction_List = new DbAction_List();
			     ArrayList<Bean_QnA> beanList = dbAction_List.selectList_QnA();
			     int listCount = beanList.size();
			     for(int i=0; i<listCount; i++) {
			       String[] qTxt = {beanList.get(i).getsEmail(), beanList.get(i).getqDate(), beanList.get(i).getqContents()};
			       Outer_Table.addRow(qTxt);
			     }

			 }
			 
	
}
