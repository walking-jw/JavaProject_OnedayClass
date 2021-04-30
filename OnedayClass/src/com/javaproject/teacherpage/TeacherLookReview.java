package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherLookReview {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField textField;
	private JButton btnClose;

	/**
	 * Create the application.
	 */
	public TeacherLookReview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnClose());
	}

	public void setVisible_TeacherLookReview(boolean b) {
		frame.setVisible(true);
	}
	
	
	
	
	
	
	
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("질문 등록날짜");
			lblNewLabel.setBounds(52, 52, 164, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("질문 등록자");
			lblNewLabel_1.setBounds(52, 80, 164, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("별점");
			lblNewLabel_1_1.setBounds(52, 108, 164, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(52, 136, 450, 322);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnClose() {    // * * * * * * * * * * * * * * * * * 해당 창 닫기 [2021.04.27,13:43] 
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				TeacherMypage tc = new TeacherMypage();
				tc.setVisible_TeacherMypage(true);
				frame.dispose();
				
				}
			});
			btnClose.setBounds(385, 490, 117, 29);
		}
		return btnClose;
	}
}
