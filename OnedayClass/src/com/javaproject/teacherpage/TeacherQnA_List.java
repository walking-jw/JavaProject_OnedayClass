package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeacherQnA_List {

	private JFrame frame;
	private JButton btnAnswer;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_QnA;

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
		}
		return Inner_Table_QnA;
	}
}
