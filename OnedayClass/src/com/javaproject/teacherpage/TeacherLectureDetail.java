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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

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
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	
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
		frame.setTitle("강의정보");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				TableInitBefore();
				ClassInfo();
				SearchActionBefore();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
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
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getLblNewLabel_3());
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(113, 72, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTf_cName() {
		if (tf_cName == null) {
			tf_cName = new JTextField();
			tf_cName.setEditable(false);
			tf_cName.setBounds(186, 67, 224, 26);
			tf_cName.setColumns(10);
		}
		return tf_cName;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강사");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(113, 124, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTf_tName() {
		if (tf_tName == null) {
			tf_tName = new JTextField();
			tf_tName.setEditable(false);
			tf_tName.setColumns(10);
			tf_tName.setBounds(186, 119, 138, 26);
		}
		return tf_tName;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("장소");
			lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1_1.setBounds(113, 173, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTf_cLocation() {
		if (tf_cLocation == null) {
			tf_cLocation = new JTextField();
			tf_cLocation.setEditable(false);
			tf_cLocation.setColumns(10);
			tf_cLocation.setBounds(186, 168, 138, 26);
		}
		return tf_cLocation;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("강의시간");
			lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1_1_1.setBounds(113, 227, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTf_cTime() {
		if (tf_cTime == null) {
			tf_cTime = new JTextField();
			tf_cTime.setEditable(false);
			tf_cTime.setColumns(10);
			tf_cTime.setBounds(186, 222, 61, 26);
		}
		return tf_cTime;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("날짜");
			lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1_1_1_1.setBounds(113, 280, 61, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTf_cDate() {
		if (tf_cDate == null) {
			tf_cDate = new JTextField();
			tf_cDate.setEditable(false);
			tf_cDate.setColumns(10);
			tf_cDate.setBounds(186, 275, 192, 26);
		}
		return tf_cDate;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(45, 385, 469, 145);
			scrollPane.setViewportView(getInner_Table_Before());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("후기");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(45, 357, 61, 16);
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("닫기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TeacherLectureList myClass = new TeacherLectureList();
					myClass.setVisible_LectureList(true);
					frame.dispose();
					
				}
			});
			btnNewButton.setBounds(395, 542, 117, 29);
		}
		return btnNewButton;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("시간");
			lblNewLabel_3.setBounds(247, 228, 35, 16);
		}
		return lblNewLabel_3;
	}
	
	// 수강 이력 테이블 초기화
	 private void TableInitBefore(){
	
	     int k = Outer_Table_Before.getRowCount();
	     
	     Outer_Table_Before.addColumn("No.");
	     Outer_Table_Before.addColumn("강의명");
	     Outer_Table_Before.addColumn("강의날짜");
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
