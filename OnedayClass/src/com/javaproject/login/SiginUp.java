package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SiginUp {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfName;
	private JTextField tfNickName;
	private JTextField tfPhone1;
	private JTextField tfPhone2;
	private JTextField tfEmail;
	private JPasswordField pwdF;
	private JPasswordField pwdFCheck;

	/**
	 * Create the application.
	 */
	public SiginUp() {
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
		
		JRadioButton rdbtnCommon = new JRadioButton("일반회원");
		buttonGroup.add(rdbtnCommon);
		rdbtnCommon.setSelected(true);
		rdbtnCommon.setBounds(26, 97, 141, 23);
		frame.getContentPane().add(rdbtnCommon);
		
		JRadioButton rdbtnTeacher = new JRadioButton("강사회원");
		buttonGroup.add(rdbtnTeacher);
		rdbtnTeacher.setBounds(179, 97, 141, 23);
		frame.getContentPane().add(rdbtnTeacher);
		
		JLabel lblSignUp = new JLabel("회원가입");
		lblSignUp.setBounds(26, 54, 61, 16);
		frame.getContentPane().add(lblSignUp);
		
		JLabel lblEmail = new JLabel("아이디(이메일)");
		lblEmail.setBounds(26, 172, 120, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("비밀번호");
		lblNewLabel_1.setBounds(26, 232, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호 확인");
		lblNewLabel_2.setBounds(26, 290, 87, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(26, 351, 61, 16);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("닉네임");
		lblNewLabel_4.setBounds(26, 408, 61, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("전화");
		lblNewLabel_5.setBounds(26, 461, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfName = new JTextField();
		tfName.setBounds(125, 351, 130, 26);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfNickName = new JTextField();
		tfNickName.setColumns(10);
		tfNickName.setBounds(125, 403, 130, 26);
		frame.getContentPane().add(tfNickName);
		
		tfPhone1 = new JTextField();
		tfPhone1.setColumns(10);
		tfPhone1.setBounds(219, 456, 130, 26);
		frame.getContentPane().add(tfPhone1);
		
		tfPhone2 = new JTextField();
		tfPhone2.setColumns(10);
		tfPhone2.setBounds(373, 456, 130, 26);
		frame.getContentPane().add(tfPhone2);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(125, 167, 130, 26);
		frame.getContentPane().add(tfEmail);
		
		pwdF = new JPasswordField();
		pwdF.setBounds(125, 227, 130, 26);
		frame.getContentPane().add(pwdF);
		
		pwdFCheck = new JPasswordField();
		pwdFCheck.setBounds(125, 285, 130, 26);
		frame.getContentPane().add(pwdFCheck);
		
		JComboBox cbPhone = new JComboBox();
		cbPhone.setBounds(131, 457, 52, 27);
		frame.getContentPane().add(cbPhone);
		
		JComboBox cbEmail = new JComboBox();
		cbEmail.setBounds(326, 168, 52, 27);
		frame.getContentPane().add(cbEmail);
		
		JButton btnCheckID = new JButton("아이디확인");
		btnCheckID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO

			}
		});
		btnCheckID.setBounds(396, 167, 117, 29);
		frame.getContentPane().add(btnCheckID);
		
		JButton btnCancel = new JButton("취소");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnCancel.setBounds(252, 528, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JButton btnDone = new JButton("확인");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		btnDone.setBounds(386, 528, 117, 29);
		frame.getContentPane().add(btnDone);
	}
}
