package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class TeacherLectureDetail {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField tf_cName;
	private JLabel lblNewLabel_1;
	private JTextField tf_tName;
	private JLabel lblNewLabel_1_1;
	private JTextField tf_cLocation;
	private JLabel lblNewLabel_1_1_1;
	private JTextField tf_cTime;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField tf_cDate;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTable Inner_Table_Before;
	private final DefaultTableModel Outer_Table_Before = new DefaultTableModel();     // * * * * * [0428, 14:51]
	
	public void setVisible_LectureListDetail(boolean i) {
		frame.setVisible(true);
		
	}
	
	/**
	 * Create the application.
	 */
	public TeacherLectureDetail() {
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
				TableInitBefore();
				ClassInfo();
				SearchActionBefore();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTf_cName());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTf_tName());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTf_cLocation());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getTf_cTime());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getTf_cDate());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_2());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setBounds(91, 122, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTf_cName() {
		if (tf_cName == null) {
			tf_cName = new JTextField();
			tf_cName.setBounds(164, 117, 224, 26);
			tf_cName.setColumns(10);
		}
		return tf_cName;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강사");
			lblNewLabel_1.setBounds(91, 165, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTf_tName() {
		if (tf_tName == null) {
			tf_tName = new JTextField();
			tf_tName.setColumns(10);
			tf_tName.setBounds(164, 160, 224, 26);
		}
		return tf_tName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("장소");
			lblNewLabel_1_1.setBounds(91, 215, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTf_cLocation() {
		if (tf_cLocation == null) {
			tf_cLocation = new JTextField();
			tf_cLocation.setColumns(10);
			tf_cLocation.setBounds(164, 210, 224, 26);
		}
		return tf_cLocation;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("강의시간");
			lblNewLabel_1_1_1.setBounds(91, 269, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTf_cTime() {
		if (tf_cTime == null) {
			tf_cTime = new JTextField();
			tf_cTime.setColumns(10);
			tf_cTime.setBounds(164, 264, 224, 26);
		}
		return tf_cTime;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("날짜");
			lblNewLabel_1_1_1_1.setBounds(91, 320, 61, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTf_cDate() {
		if (tf_cDate == null) {
			tf_cDate = new JTextField();
			tf_cDate.setColumns(10);
			tf_cDate.setBounds(164, 315, 224, 26);
		}
		return tf_cDate;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 395, 469, 145);
			scrollPane.setViewportView(getInner_Table_Before());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("후기");
			lblNewLabel_2.setBounds(43, 367, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTable getInner_Table_Before() {
		if (Inner_Table_Before == null) {
			Inner_Table_Before = new JTable();
			Inner_Table_Before.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Before.setModel(Outer_Table_Before); // * * * * * * * * * * * * * * 하단 테이블 세팅
		}
		return Inner_Table_Before;
	}
	
	// 수강 이력 테이블 초기화
	 private void TableInitBefore(){
	
	     int k = Outer_Table_Before.getRowCount();
	     
	     Outer_Table_Before.addColumn("강의ID");
	     Outer_Table_Before.addColumn("강의명");
	     Outer_Table_Before.addColumn("수강날짜");
	     Outer_Table_Before.addColumn("장소");
	     Outer_Table_Before.setColumnCount(4);
	     
		     for(int j = 0 ; j < k ; j++){
		       Outer_Table_Before.removeRow(0);
		       }
	
		     Inner_Table_Before.setAutoResizeMode(Inner_Table_Before.AUTO_RESIZE_OFF);
	
	     int vColIndex = 0;
	     TableColumn col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     int width = 40;
	     col.setPreferredWidth(width);
	 
	     vColIndex = 1;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 200;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 2;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 120;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 3;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 150;
	     col.setPreferredWidth(width);
	     
	 }
	 
	public void ClassInfo() {
		
		int cid = DbAction_List.classid;
		
		DbAction_List dbActioninfo = new DbAction_List(cid);
		
		Bean_TeacherClass bean2 = dbActioninfo.ButtonClassInfo();
		
		tf_cName.setText(bean2.getcName());
		tf_tName.setText(bean2.gettName());
		tf_cLocation.setText(bean2.getcLocation());
		tf_cTime.setText(bean2.getcTime());
		tf_cDate.setText(bean2.getcDate());
		
		
	}

	
	 // 수강 이력 데이터 불러오기
	 private void SearchActionBefore(){
	     
		 int cid = DbAction_List.classid;
		 
	     DbAction_List dbAction = new DbAction_List(cid);
	     ArrayList<Bean_TeacherClass> beanList = dbAction.selectListBefore_Detail();
	     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String temp1 = Integer.toString(beanList.get(i).getcId());
		       String[] qTxt = {temp1, beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation()};
		       Outer_Table_Before.addRow(qTxt);
	     }

	 }
	 
}
