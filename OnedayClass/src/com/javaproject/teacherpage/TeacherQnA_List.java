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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TeacherQnA_List {

	private JFrame frmQna;
	private JButton btnAnswer;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_QnA;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_AnswerOK = new DefaultTableModel();
	private JScrollPane scrollPane_1;
	private JTable Inner_Table_AnswerOK;
	private JLabel lblNewLabel_1;
	private JButton btn_ToMypage;

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
		frmQna = new JFrame();
		frmQna.setTitle("QnA");
		frmQna.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				TableInit();
				TableInit_OK();
				SearchActionAfter();
				SearchActionAfter_OK();
				
			}
		});
		frmQna.setBounds(100, 100, 560, 625);
		frmQna.setLocationRelativeTo(frmQna);
		frmQna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQna.getContentPane().setLayout(null);
		frmQna.getContentPane().add(getBtnAnswer());
		frmQna.getContentPane().add(getLblNewLabel());
		frmQna.getContentPane().add(getScrollPane());
		frmQna.getContentPane().add(getScrollPane_1());
		frmQna.getContentPane().add(getLblNewLabel_1());
		frmQna.getContentPane().add(getBtn_ToMypage());
	}

	
	
	// 해당 클라스 켜주기 
	public void setVisible_TeacherQnA_List(boolean b) {
		frmQna.setVisible(true);
	}
	private JButton getBtnAnswer() {
		if (btnAnswer == null) {
			btnAnswer = new JButton("답변하기");
			btnAnswer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					DbAction_List.sName = ReviewSub();
					
					TeacherQnA go = new TeacherQnA();
					go.setVisible_QnA(true);
					frmQna.dispose();
					
					
					
				}
			});
			btnAnswer.setBounds(445, 267, 86, 29);
		}
		return btnAnswer;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("문의리스트");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(30, 25, 122, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 53, 501, 202);
			scrollPane.setViewportView(getInner_Table_QnA());
		}
		return scrollPane;
	}
	private JTable getInner_Table_QnA() {
		if (Inner_Table_QnA == null) {
			Inner_Table_QnA = new JTable();
			Inner_Table_QnA.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_QnA.setModel(Outer_Table); // * * * * * * * 상단 테이블 세팅
		}
		return Inner_Table_QnA;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(30, 334, 501, 202);
			scrollPane_1.setViewportView(getInner_Table_AnswerOK());
		}
		return scrollPane_1;
	}
	private JTable getInner_Table_AnswerOK() {
		if (Inner_Table_AnswerOK == null) {
			Inner_Table_AnswerOK = new JTable();
			Inner_Table_AnswerOK.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_AnswerOK.setModel(Outer_Table_AnswerOK);// * * * * * * * 하단 테이블 세팅
		}
		return Inner_Table_AnswerOK;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("답변완료 리스트");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(30, 306, 109, 16);
		}
		return lblNewLabel_1;
	}
	
	// * * * * * * MeThod * * * * * * //
	
	// Teacher - QnA (답변 아직 하지 않은 리스트 테이블 세팅) * * * * * * * * * * * * * * * [2021.04.29, 12:41]
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
	// Teacher - QnA (답변 아직 하지 않은 리스트 DB에서 불러오기) * * * * * * * * * * * * [2021.04.29, 12:46]
	private void SearchActionAfter(){
	     
	     DbAction_List dbAction_List = new DbAction_List();
	     ArrayList<Bean_QnA> beanList = dbAction_List.selectList_QnA();
	   
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String[] qTxt = {beanList.get(i).getsEmail(), beanList.get(i).getqDate(), beanList.get(i).getqContents()};
	       Outer_Table.addRow(qTxt);
	     }
	 }// SearchActionAfter
			 	
	 // Teacher - QnA (답변 완료한 리스트 테이블 세팅) * * * * * * * * * * * * * * * * * [2021.04.29, 12:51]	 
	 private void TableInit_OK(){
		 int i = Outer_Table_AnswerOK.getRowCount();
			       
			     Outer_Table_AnswerOK.addColumn("질문자");
			     Outer_Table_AnswerOK.addColumn("질문날짜");
			     Outer_Table_AnswerOK.addColumn("질문내용");
			     Outer_Table_AnswerOK.addColumn("답변내용");
			     Outer_Table_AnswerOK.setColumnCount(4);

				       for(int j = 0 ; j < i ; j++){
				           Outer_Table_AnswerOK.removeRow(0);
				       }
	
				       Inner_Table_AnswerOK.setAutoResizeMode(Inner_Table_AnswerOK.AUTO_RESIZE_OFF);
				       
	
					       int vColIndex = 0;
					       TableColumn col = Inner_Table_AnswerOK.getColumnModel().getColumn(vColIndex);
					       int width = 120;
					       col.setPreferredWidth(width);
		
					       vColIndex = 1;
					       col = Inner_Table_AnswerOK.getColumnModel().getColumn(vColIndex);
					       width = 100;
					       col.setPreferredWidth(width);
					       
					       vColIndex = 2;
					       col = Inner_Table_AnswerOK.getColumnModel().getColumn(vColIndex);
					       width = 200;
					       col.setPreferredWidth(width);
					       
					       vColIndex = 3;
					       col = Inner_Table_AnswerOK.getColumnModel().getColumn(vColIndex);
					       width = 300;
					       col.setPreferredWidth(width);
			 }
	 // Teacher - QnA (답변 완료한 리스트 DB에서 불러오기) * * * * * * * * * * * * [2021.04.29, 12:55]		 
	 private void SearchActionAfter_OK(){
		     
		     DbAction_List dbAction_List = new DbAction_List();
		     ArrayList<Bean_QnA> beanList = dbAction_List.selectList_QnA_OK();
		     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String[] qTxt = {beanList.get(i).getsEmail(), beanList.get(i).getqDate(), beanList.get(i).getqContents(), beanList.get(i).getaContents()};
		       Outer_Table_AnswerOK.addRow(qTxt);
		     }
	 }
			 
	  public String ReviewSub() {
			int i = Inner_Table_QnA.getSelectedRow();
			String wkSequence = (String)Inner_Table_QnA.getValueAt(i, 0);
			return wkSequence;
	  }
	private JButton getBtn_ToMypage() {
		if (btn_ToMypage == null) {
			btn_ToMypage = new JButton("닫기");
			btn_ToMypage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TeacherMypage tm = new TeacherMypage();
					tm.setVisible_TeacherMypage(true);
					frmQna.dispose();
							
				}
			});
			btn_ToMypage.setBounds(445, 548, 86, 29);
		}
		return btn_ToMypage;
	}
}
