package com.javaproject.studentpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class StudentPage {

	private JFrame frame;
	private JTextField tfName;
	private JTextField tfNickName;
	private JTextField tfPhone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage window = new StudentPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentPage() {
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
		
		JLabel lblNewLabel = new JLabel("당신은 입니다.");
		lblNewLabel.setBounds(235, 80, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("이름");
		lblNewLabel_1.setBounds(196, 153, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("닉네임");
		lblNewLabel_2.setBounds(196, 209, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(44, 300, 61, 16);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblMyIdEmail = new JLabel("이메일주소");
		lblMyIdEmail.setBounds(173, 300, 61, 16);
		frame.getContentPane().add(lblMyIdEmail);
		
		JLabel lblNewLabel_5 = new JLabel("전화번호");
		lblNewLabel_5.setBounds(44, 390, 61, 16);
		frame.getContentPane().add(lblNewLabel_5);
		
		tfName = new JTextField();
		tfName.setBounds(303, 148, 130, 26);
		frame.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		tfNickName = new JTextField();
		tfNickName.setColumns(10);
		tfNickName.setBounds(303, 204, 130, 26);
		frame.getContentPane().add(tfNickName);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(152, 385, 130, 26);
		frame.getContentPane().add(tfPhone);
		
		JButton btnEdit = new JButton("정보변경");
		btnEdit.setBounds(235, 529, 117, 29);
		frame.getContentPane().add(btnEdit);
		
		JButton btnLeave = new JButton("탈퇴");
		btnLeave.setBounds(371, 529, 117, 29);
		frame.getContentPane().add(btnLeave);
		
		JButton btnSignOut = new JButton("로그아웃");
		btnSignOut.setBounds(29, 204, 117, 29);
		frame.getContentPane().add(btnSignOut);
	}

}
