package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FindIdOrPwd {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_2_2_1;
	private JTextField tfNameFindId;
	private JTextField tfNameFindPwd;
	private JTextField tfPhone;
	private JTextField tfEmail;
	private JComboBox cbPhone;
	private JComboBox cbEmail;
	private JButton btnFindId;
	private JButton btnFindPwd;

	/**
	 * Create the application.
	 */
	public FindIdOrPwd() {
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
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getLblNewLabel_2_2());
		frame.getContentPane().add(getLblNewLabel_2_2_1());
		frame.getContentPane().add(getTfNameFindId());
		frame.getContentPane().add(getTfNameFindPwd());
		frame.getContentPane().add(getTfPhone());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getCbPhone());
		frame.getContentPane().add(getCbEmail());
		frame.getContentPane().add(getBtnFindId());
		frame.getContentPane().add(getBtnFindPwd());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("가입시 등록한 이름과 전화번호를 입력해주세요.");
			lblNewLabel.setBounds(132, 163, 278, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("가입시 등록한 이름과 이메일을 입력해주세요.");
			lblNewLabel_1.setBounds(132, 359, 278, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름 :");
			lblNewLabel_2.setBounds(132, 196, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("전화번호 :");
			lblNewLabel_2_1.setBounds(132, 229, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_2() {
		if (lblNewLabel_2_2 == null) {
			lblNewLabel_2_2 = new JLabel("이름 :");
			lblNewLabel_2_2.setBounds(132, 391, 61, 16);
		}
		return lblNewLabel_2_2;
	}
	private JLabel getLblNewLabel_2_2_1() {
		if (lblNewLabel_2_2_1 == null) {
			lblNewLabel_2_2_1 = new JLabel("이메일 :");
			lblNewLabel_2_2_1.setBounds(132, 424, 61, 16);
		}
		return lblNewLabel_2_2_1;
	}
	private JTextField getTfNameFindId() {
		if (tfNameFindId == null) {
			tfNameFindId = new JTextField();
			tfNameFindId.setBounds(205, 191, 205, 26);
			tfNameFindId.setColumns(10);
		}
		return tfNameFindId;
	}
	private JTextField getTfNameFindPwd() {
		if (tfNameFindPwd == null) {
			tfNameFindPwd = new JTextField();
			tfNameFindPwd.setColumns(10);
			tfNameFindPwd.setBounds(205, 386, 205, 26);
		}
		return tfNameFindPwd;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(277, 224, 133, 26);
		}
		return tfPhone;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(205, 419, 115, 26);
		}
		return tfEmail;
	}

	private findId() {
		
	}
	
	private findPwd() {
		
	}
}
