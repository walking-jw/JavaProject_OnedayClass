package com.javaproject.teacherpage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AttendStudentInfo {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_StudentInfo;
	// OuterTable 초기 설정
	private final DefaultTableModel Outer_Table_StudentInfo = new DefaultTableModel();
	private JButton btnClose;
	/**
	 * Create the application.
	 */
	public AttendStudentInfo() { // 2021.04.30 조혜지 view - 수강 신청한 학생 정보 불러오기
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
				TableInitStudentInfo();
				SearchActionIncomplete();
			}
		});
		frame.setTitle("수강 학생 정보 © Copyright 권효은, 박재원, 이도영, 조혜지");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnClose());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("수강 학생 정보");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(30, 25, 122, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 53, 501, 483);
			scrollPane.setViewportView(getInner_Table_StudentInfo());
		}
		return scrollPane;
	}
	private JTable getInner_Table_StudentInfo() {
		if (Inner_Table_StudentInfo == null) {
			Inner_Table_StudentInfo = new JTable();
			Inner_Table_StudentInfo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			Inner_Table_StudentInfo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// InnerTable과 OuterTable연결
			Inner_Table_StudentInfo.setModel(Outer_Table_StudentInfo);
			
		}
		return Inner_Table_StudentInfo;
	}
	
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					TeacherClassUpdateDelete updateDelete = new TeacherClassUpdateDelete();
					updateDelete.setVisible_TeacherClassUpdateDelete(true);
					frame.dispose();
					
				}
			});
			btnClose.setBounds(445, 548, 86, 29);
		}
		return btnClose;
	}
	
	// 메소드 시작 ***************************************************************
	
	// 메인과 해당 창을 연결하는 메소드
	public void setVisible_AttendStudentInfo(boolean j) {
		frame.setVisible(j);
	}
	
	// 수강 신청한 학생 정보 테이블 초기화
	private void TableInitStudentInfo(){
	       int i = Outer_Table_StudentInfo.getRowCount();
	       
	       Outer_Table_StudentInfo.addColumn("학생 Email");
	       Outer_Table_StudentInfo.addColumn("학생 이름");
	       Outer_Table_StudentInfo.addColumn("학생 닉네임");
	       Outer_Table_StudentInfo.addColumn("전화번호");
	       Outer_Table_StudentInfo.setColumnCount(4);

	       for(int j = 0 ; j < i ; j++){
	           Outer_Table_StudentInfo.removeRow(0);
	       }

	       Inner_Table_StudentInfo.setAutoResizeMode(Inner_Table_StudentInfo.AUTO_RESIZE_OFF);
	       

	       int vColIndex = 0;
	       TableColumn col = Inner_Table_StudentInfo.getColumnModel().getColumn(vColIndex);
	       int width = 150;
	       col.setPreferredWidth(width);

	       vColIndex = 1;
	       col = Inner_Table_StudentInfo.getColumnModel().getColumn(vColIndex);
	       width = 95;
	       col.setPreferredWidth(width);
	       
	       vColIndex = 2;
	       col = Inner_Table_StudentInfo.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);

	       vColIndex = 3;
	       col = Inner_Table_StudentInfo.getColumnModel().getColumn(vColIndex);
	       width = 150;
	       col.setPreferredWidth(width);
	}
	

	 // 수강 신청한 학생 정보 불러오기
	 private void SearchActionIncomplete(){
		 
	     StudentInfoDbAction dbAction = new StudentInfoDbAction();
	     ArrayList<StudentInfoBean> beanList = dbAction.selectListStudentInfo();
	     
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String[] qTxt = {beanList.get(i).getsEmail(), beanList.get(i).getsName(), beanList.get(i).getsNickName(), beanList.get(i).getsTelNo()};
	       Outer_Table_StudentInfo.addRow(qTxt);

	     }

	 }

}
