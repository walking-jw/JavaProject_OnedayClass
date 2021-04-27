package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TeacherQnA {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2_1;
	private JTextField textField;
	private JLabel lblNewLabel_2_1_1;
	private JButton btnNewButton;
	private JTextField textField_1;

	/**
	 * Create the application.
	 */
	public TeacherQnA() {
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
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getTextField_1());
	}

	
	
	
	
	
	
	
	// 해당 화면 보이게 하기
	public void setVisible_TeacherQnA(boolean a) {
		frame.setVisible(true);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("질문자");
			lblNewLabel.setBounds(42, 42, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("김질문");
			lblNewLabel_1.setBounds(131, 42, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("강의명");
			lblNewLabel_2.setBounds(42, 70, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("유니의 비밀레시피");
			lblNewLabel_1_1.setBounds(131, 70, 189, 16);
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("질문내용");
			lblNewLabel_2_1.setBounds(42, 98, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(42, 126, 466, 104);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("답변");
			lblNewLabel_2_1_1.setBounds(42, 256, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("작성");
			btnNewButton.setBounds(391, 530, 117, 29);
		}
		return btnNewButton;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(42, 284, 466, 234);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
