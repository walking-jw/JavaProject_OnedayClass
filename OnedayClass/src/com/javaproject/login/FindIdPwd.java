package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindIdPwd {

	private JFrame frame;
	private JTextField tfNameForId;
	private JTextField tfPhone1;
	private JTextField tfPhon2;
	private JTextField tfNameForPwd;
	private JTextField tfEmail;


	/**
	 * Create the application.
	 */
	public FindIdPwd() {
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
		
		JLabel lblNewLabel = new JLabel("가입시 등록한 이름과 전화번호를 입력해주세요.");
		lblNewLabel.setBounds(67, 98, 302, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("가입시 등록한 이름과 이메일을 입력해주세요.");
		lblNewLabel_1.setBounds(67, 312, 302, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름 :");
		lblNewLabel_2.setBounds(67, 148, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("전화번호 :");
		lblNewLabel_2_1.setBounds(67, 206, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		tfNameForId = new JTextField();
		tfNameForId.setBounds(145, 143, 130, 26);
		frame.getContentPane().add(tfNameForId);
		tfNameForId.setColumns(10);
		
		tfPhone1 = new JTextField();
		tfPhone1.setColumns(10);
		tfPhone1.setBounds(229, 201, 130, 26);
		frame.getContentPane().add(tfPhone1);
		
		tfPhon2 = new JTextField();
		tfPhon2.setColumns(10);
		tfPhon2.setBounds(371, 201, 130, 26);
		frame.getContentPane().add(tfPhon2);
		
		tfNameForPwd = new JTextField();
		tfNameForPwd.setColumns(10);
		tfNameForPwd.setBounds(145, 349, 130, 26);
		frame.getContentPane().add(tfNameForPwd);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(145, 402, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		JLabel lblNewLabel_2_2 = new JLabel("이름 :");
		lblNewLabel_2_2.setBounds(67, 354, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("이메일 :");
		lblNewLabel_2_3.setBounds(67, 407, 61, 16);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JComboBox cbPhone = new JComboBox();
		cbPhone.setBounds(165, 202, 52, 27);
		frame.getContentPane().add(cbPhone);
		
		JComboBox cbEmail = new JComboBox();
		cbEmail.setBounds(307, 403, 52, 27);
		frame.getContentPane().add(cbEmail);
		
		JButton btnFindId = new JButton("아이디 찾기");
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnFindId.setBounds(384, 260, 117, 29);
		frame.getContentPane().add(btnFindId);
		
		JButton btnFindPwd = new JButton("비밀번호 찾기");
		btnFindPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				
			}
		});
		btnFindPwd.setBounds(384, 446, 117, 29);
		frame.getContentPane().add(btnFindPwd);
		
		JButton btnCancel = new JButton("닫기");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnCancel.setBounds(384, 531, 117, 29);
		frame.getContentPane().add(btnCancel);
	}

}
