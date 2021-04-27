package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignInView {

	private JFrame frame;
	private JLabel lblTitle;
	private JRadioButton rdbtnCommon;
	private JRadioButton rdbtnTeacher;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox cBEmail;
	private JTextField tfEmail;
	private JPasswordField pwdF;
	private JButton btnSignIn;
	private JLabel lblId;
	private JLabel lblPwd;
	private JButton btnSignUp;
	private JLabel lblInfo;
	private JButton btnFindId;
	private JButton btnFindPwd;

	
	/**
	 * Create the application.
	 */
	public SignInView() {
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
		frame.getContentPane().add(getLblTitle());
		frame.getContentPane().add(getRdbtnCommon());
		frame.getContentPane().add(getRdbtnTeacher());
		frame.getContentPane().add(getCBEmail());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getPwdF());
		frame.getContentPane().add(getBtnSignIn());
		frame.getContentPane().add(getLblId());
		frame.getContentPane().add(getLblPwd());
		frame.getContentPane().add(getBtnSignUp());
		frame.getContentPane().add(getLblInfo());
		frame.getContentPane().add(getBtnFindId());
		frame.getContentPane().add(getBtnFindPwd());
	}
	private JLabel getLblTitle() {
		if (lblTitle == null) {
			lblTitle = new JLabel("반갑습니다!");
			lblTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblTitle.setBounds(250, 47, 129, 69);
		}
		return lblTitle;
	}
	private JRadioButton getRdbtnCommon() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("일반회원");
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setBounds(140, 156, 141, 23);
		}
		return rdbtnCommon;
	}
	private JRadioButton getRdbtnTeacher() {
		if (rdbtnTeacher == null) {
			rdbtnTeacher = new JRadioButton("강사회원");
			buttonGroup.add(rdbtnTeacher);
			rdbtnTeacher.setBounds(342, 156, 141, 23);
		}
		return rdbtnTeacher;
	}
	private JComboBox getCBEmail() {
		if (cBEmail == null) {
			cBEmail = new JComboBox();
			cBEmail.setBounds(368, 232, 87, 27);
		}
		return cBEmail;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(190, 231, 166, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JPasswordField getPwdF() {
		if (pwdF == null) {
			pwdF = new JPasswordField();
			pwdF.setBounds(190, 268, 255, 26);
		}
		return pwdF;
	}
	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("로그인");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO Sign In
					//
					//
					//
					//
					//
				}
			});
			btnSignIn.setBounds(118, 320, 305, 42);
		}
		return btnSignIn;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("이메일 :");
			lblId.setBounds(118, 236, 61, 16);
		}
		return lblId;
	}
	private JLabel getLblPwd() {
		if (lblPwd == null) {
			lblPwd = new JLabel("비밀번호 :");
			lblPwd.setBounds(118, 273, 61, 16);
		}
		return lblPwd;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("회원가입");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			btnSignUp.setBounds(213, 422, 117, 29);
		}
		return btnSignUp;
	}
	private JLabel getLblInfo() {
		if (lblInfo == null) {
			lblInfo = new JLabel("아이디 혹은 비밀번호를 잊어버겼습니까?");
			lblInfo.setBounds(195, 463, 209, 16);
		}
		return lblInfo;
	}
	private JButton getBtnFindId() {
		if (btnFindId == null) {
			btnFindId = new JButton("아이디 찾기");
			btnFindId.setBounds(180, 491, 117, 29);
		}
		return btnFindId;
	}
	private JButton getBtnFindPwd() {
		if (btnFindPwd == null) {
			btnFindPwd = new JButton("비밀번호 찾기");
			btnFindPwd.setBounds(309, 491, 117, 29);
		}
		return btnFindPwd;
	}
	
	public void setVisible_SigninView(boolean b) {
		frame.setVisible(b);
	}
}
