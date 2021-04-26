package com.javaproject.myclass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentMyClass {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_After;
	private JButton btnCancle;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_1;
	private JButton btnReview;
	private JTable Inner_Table_Before;
	private final DefaultTableModel Outer_Table_After = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_Before = new DefaultTableModel();


	/**
	 * Create the application.
	 */
	public StudentMyClass() {
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
				TableInitAfter();
				TableInitBefore();
				SearchActionAfter();
				SearchActionBefore();
			}
		});
		frame.setTitle("수강관리");
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnCancle());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getBtnReview());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("수강 예정");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(30, 25, 86, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 53, 501, 202);
			scrollPane.setViewportView(getInner_Table_After());
		}
		return scrollPane;
	}
	private JTable getInner_Table_After() {
		if (Inner_Table_After == null) {
			Inner_Table_After = new JTable();
			Inner_Table_After.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			Inner_Table_After.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_After.setModel(Outer_Table_After);
			
		}
		return Inner_Table_After;
	}
	private JButton getBtnCancle() {
		if (btnCancle == null) {
			btnCancle = new JButton("수강 취소");
			btnCancle.setBounds(414, 265, 117, 29);
		}
		return btnCancle;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("수강 이력");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(30, 306, 86, 16);
		}
		return lblNewLabel_1;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(30, 334, 501, 202);
			scrollPane_1.setViewportView(getInner_Table_Before());
		}
		return scrollPane_1;
	}
	private JButton getBtnReview() {
		if (btnReview == null) {
			btnReview = new JButton("후기 등록");
			btnReview.setBounds(414, 546, 117, 29);
		}
		return btnReview;
	}
	private JTable getInner_Table_Before() {
		if (Inner_Table_Before == null) {
			Inner_Table_Before = new JTable();
			Inner_Table_Before.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			Inner_Table_Before.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table_Before.setModel(Outer_Table_Before);
		}

		return Inner_Table_Before;
	}
	
	public void setVisible_StudentMyClass(boolean j) {
		frame.setVisible(j);
	}
	
	private void TableInitAfter(){
	       int i = Outer_Table_After.getRowCount();
	       
	       Outer_Table_After.addColumn("강의ID");
	       Outer_Table_After.addColumn("신청날짜");
	       Outer_Table_After.addColumn("강의명");
	       Outer_Table_After.addColumn("수강날짜");
	       Outer_Table_After.addColumn("장소");
	       Outer_Table_After.addColumn("가격");
	       Outer_Table_After.setColumnCount(6);

	       for(int j = 0 ; j < i ; j++){
	           Outer_Table_After.removeRow(0);
	       }

	       Inner_Table_After.setAutoResizeMode(Inner_Table_After.AUTO_RESIZE_OFF);
	       

	       int vColIndex = 0;
	       TableColumn col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       int width = 40;
	       col.setPreferredWidth(width);

	       vColIndex = 1;
	       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);
	       
	       vColIndex = 2;
	       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       width = 120;
	       col.setPreferredWidth(width);

	       vColIndex = 3;
	       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);
	       
	       vColIndex = 4;
	       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       width = 70;
	       col.setPreferredWidth(width);
	     
	       vColIndex = 5;
	       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
	       width = 50;
	       col.setPreferredWidth(width);
	       

	 }
	 private void TableInitBefore(){

	     int k = Outer_Table_Before.getRowCount();
	     
	     Outer_Table_Before.addColumn("강의ID");
	     Outer_Table_Before.addColumn("신청날짜");
	     Outer_Table_Before.addColumn("강의명");
	     Outer_Table_Before.addColumn("수강날짜");
	     Outer_Table_Before.addColumn("장소");
	     Outer_Table_Before.addColumn("가격");
	     Outer_Table_Before.setColumnCount(6);
	     
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
	     width = 100;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 2;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 120;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 3;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 100;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 4;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 70;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 5;
	     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
	     width = 50;
	     col.setPreferredWidth(width);
	     
	 }

	 private void SearchActionAfter(){
	     
	     DbAction dbAction = new DbAction();
	     ArrayList<Bean> beanList = dbAction.selectListAfter();
	     
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String temp1 = Integer.toString(beanList.get(i).getcId());
	       String temp2 = Integer.toString(beanList.get(i).getcPrice());
	       String[] qTxt = {temp1, beanList.get(i).getcAttendDate(), beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation(), temp2};
	       Outer_Table_After.addRow(qTxt);
	     }

	 
	     
	 }
	 private void SearchActionBefore(){
	     
	     DbAction dbAction = new DbAction();
	     ArrayList<Bean> beanList = dbAction.selectListBefore();
	     
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String temp1 = Integer.toString(beanList.get(i).getcId());
	       String temp2 = Integer.toString(beanList.get(i).getcPrice());
	       String[] qTxt = {temp1, beanList.get(i).getcAttendDate(), beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation(), temp2};
	       Outer_Table_Before.addRow(qTxt);
	     }
	     
	     
	     
	 }
	
	
}
