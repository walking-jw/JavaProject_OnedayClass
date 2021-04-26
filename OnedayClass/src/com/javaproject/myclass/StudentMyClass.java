package com.javaproject.myclass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;

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
			Inner_Table_After.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
			Inner_Table_Before.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return Inner_Table_Before;
	}
}
