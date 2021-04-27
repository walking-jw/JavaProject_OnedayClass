package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherMyClass {

	private JFrame frame;

	// Outer_Table Setting [2021.04.26, 23:27]
	private final DefaultTableModel Outer_Table_Up = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_Down= new DefaultTableModel();
	private JLabel lblNewLabel;
	private JScrollPane Scroll_up;
	private JLabel lblNewLabel_1;
	private JScrollPane Scroll_Down;
	private JTable Inner_Table_Up;
	private JTable Inner_Table_Down;
	private JButton btnNewClass;
	private JButton btnNewButton;
	
	/**
	 * Create the application.
	 */
	public TeacherMyClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {       // * * * * * * * * * * * *  해당 화면으로 이동 시 수강데이터 불러오기 [2021.04.27 09:54]
				TableInit_Up();
				TableInit_Down();
//				SearchActionUp();
//				SearchActionDown();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScroll_up());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getScroll_Down());
		frame.getContentPane().add(getBtnNewClass());
		frame.getContentPane().add(getBtnNewButton());
	}

	
	
	public void setVisible_TeacherMyClass(boolean i) {
		frame.setVisible(true);
		
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의 예정");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(23, 22, 86, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScroll_up() {
		if (Scroll_up == null) {
			Scroll_up = new JScrollPane();
			Scroll_up.setBounds(23, 50, 501, 202);
			Scroll_up.setViewportView(getInner_Table_Up());
		}
		return Scroll_up;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강의 완료");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(23, 303, 86, 16);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScroll_Down() {
		if (Scroll_Down == null) {
			Scroll_Down = new JScrollPane();
			Scroll_Down.setBounds(23, 331, 501, 202);
			Scroll_Down.setViewportView(getInner_Table_Down());
		}
		return Scroll_Down;
	}
	private JTable getInner_Table_Up() {
		if (Inner_Table_Up == null) {
			Inner_Table_Up = new JTable();
		}
		return Inner_Table_Up;
	}
	private JTable getInner_Table_Down() {
		if (Inner_Table_Down == null) {
			Inner_Table_Down = new JTable();
			Inner_Table_Down.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //* * * * * * Inner_Table & Outer_Table 연결(Down)
			Inner_Table_Down.setModel(Outer_Table_Down);
		}
		return Inner_Table_Down;
	}
	private JButton getBtnNewClass() {
		if (btnNewClass == null) {
			btnNewClass = new JButton("강의추가");
			btnNewClass.setBounds(407, 545, 117, 29);
		}
		return btnNewClass;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("수정 / 삭제");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					
					
				}
			});
			btnNewButton.setBounds(407, 264, 117, 29);
		}
		return btnNewButton;
	}
	
	
	// * * * * * * * * * * * * * * MeThod * * * * * * * * * * * * * * * * * 
	
	// 수강예정 선생님판 테이블 초기화 (Up, Down)
	

	// 수강 이력 테이블 초기화 (Up) * * * * * * * * * * * * * [2021.04.26,10:08]
	 private void TableInit_Up(){

	     int k = Outer_Table_Up.getRowCount();
	     
	     Outer_Table_Up.addColumn("강의ID");
	     Outer_Table_Up.addColumn("강의명");
	     Outer_Table_Up.addColumn("수강날짜");
	     Outer_Table_Up.addColumn("장소");
	     Outer_Table_Up.addColumn("수강인원");
	     Outer_Table_Up.setColumnCount(5);
	     
	     for(int j = 0 ; j < k ; j++){
	    	 Outer_Table_Up.removeRow(0);
	       }

	     Inner_Table_Up.setAutoResizeMode(Inner_Table_Up.AUTO_RESIZE_OFF);

	     int vColIndex = 0;
	     TableColumn col = Inner_Table_Up.getColumnModel().getColumn(vColIndex);
	     int width = 40;
	     col.setPreferredWidth(width);
	 
	     vColIndex = 1;
	     col = Inner_Table_Up.getColumnModel().getColumn(vColIndex);
	     width = 200;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 2;
	     col = Inner_Table_Up.getColumnModel().getColumn(vColIndex);
	     width = 120;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 3;
	     col = Inner_Table_Up.getColumnModel().getColumn(vColIndex);
	     width = 150;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 4;
	     col = Inner_Table_Up.getColumnModel().getColumn(vColIndex);
	     width = 70;
	     col.setPreferredWidth(width);
	     
	 }
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	
	// 수강 이력 테이블 초기화 (Down)* * * * * * * * * * * * * [2021.04.26,10:11]
	 private void TableInit_Down(){

	     int k = Outer_Table_Down.getRowCount();
	     
	     Outer_Table_Down.addColumn("강의ID");
	     Outer_Table_Down.addColumn("강의명");
	     Outer_Table_Down.addColumn("수강날짜");
	     Outer_Table_Down.addColumn("장소");
	     Outer_Table_Down.addColumn("수강인원");
	     Outer_Table_Down.setColumnCount(5);
	     
	     for(int j = 0 ; j < k ; j++){
	    	 Outer_Table_Down.removeRow(0);
	       }

	     Inner_Table_Down.setAutoResizeMode(Inner_Table_Up.AUTO_RESIZE_OFF);

	     int vColIndex = 0;  //수강번호
	     TableColumn col = Inner_Table_Down.getColumnModel().getColumn(vColIndex);
	     int width = 40;
	     col.setPreferredWidth(width);
	 
	     vColIndex = 1;  // 강의명
	     col = Inner_Table_Down.getColumnModel().getColumn(vColIndex);
	     width = 200;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 2;  // 날짜
	     col = Inner_Table_Down.getColumnModel().getColumn(vColIndex);
	     width = 120;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 3;  // 장소
	     col = Inner_Table_Down.getColumnModel().getColumn(vColIndex);
	     width = 150;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 4;  // 수강인원
	     col = Inner_Table_Down.getColumnModel().getColumn(vColIndex);
	     width = 70;
	     col.setPreferredWidth(width);
	 }
	 // * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	 
	 
	 
	 
	 
	
	
}
