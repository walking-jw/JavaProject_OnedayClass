package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.javaproject.base.ShareVar;
import com.javaproject.home.HomeView;
import com.javaproject.teacherpage.TeacherMypage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class SignIn {

	private JFrame frame;
	private JRadioButton rdbtnCommon;
	private JRadioButton rdbtnTeacher;
	private JTextField tfEmail;
	private JComboBox cbEmail;
	private JPasswordField pwdF;
	private JButton btnSignIn;
	private JButton btnSignUp;
	private JButton btnFind;
	private JLabel lblNewLabel;
	private JLabel lblId;
	private JLabel lblId_1;
	private JLabel lblId_1_1;
	private JLabel lblId_1_2;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the application.
	 */
	public SignIn() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getRdbtnCommon());
		frame.getContentPane().add(getRdbtnTeacher());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getCbEmail());
		frame.getContentPane().add(getPwdF());
		frame.getContentPane().add(getBtnSignIn());
		frame.getContentPane().add(getBtnSignUp());
		frame.getContentPane().add(getBtnFind());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblId());
		frame.getContentPane().add(getLblId_1());
		frame.getContentPane().add(getLblId_1_1());
		frame.getContentPane().add(getLblId_1_2());
	}
	private JRadioButton getRdbtnCommon() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("일반회원");
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setSelected(true);
			rdbtnCommon.setBounds(176, 120, 90, 23);
		}
		return rdbtnCommon;
	}
	private JRadioButton getRdbtnTeacher() {
		if (rdbtnTeacher == null) {
			rdbtnTeacher = new JRadioButton("강사회원");
			buttonGroup.add(rdbtnTeacher);
			rdbtnTeacher.setBounds(277, 120, 90, 23);
		}
		return rdbtnTeacher;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(188, 168, 154, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "daum.net", "kakao.com", "icloud.com"}));
			cbEmail.setBounds(347, 169, 117, 27);
		}
		return cbEmail;
	}
	private JPasswordField getPwdF() {
		if (pwdF == null) {
			pwdF = new JPasswordField();
			pwdF.setBounds(188, 203, 154, 26);
		}
		return pwdF;
	}
	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("로그인");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 로그인
					if (tfEmail.getText().trim().isEmpty()||strPwd().equals("")) {
						JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해주세요.");
					} else {
						signInAction();
					}
				}
			});
			btnSignIn.setBounds(142, 241, 241, 29);
		}
		return btnSignIn;
	}
	private JButton getBtnSignUp() {
		if (btnSignUp == null) {
			btnSignUp = new JButton("회원가입");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 회원가입
					SignUp signUp = new SignUp();
					signUp.setVisible_SignUp(true);
					frame.dispose();
				}
			});
			btnSignUp.setBounds(142, 324, 241, 29);
		}
		return btnSignUp;
	}
	private JButton getBtnFind() {
		if (btnFind == null) {
			btnFind = new JButton("아이디 / 비밀번호 찾기");
			btnFind.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FindIdAndPwd findView = new FindIdAndPwd();
					findView.setVisible_FindView(true);
					frame.dispose();
				}
			});
			btnFind.setBounds(152, 487, 225, 29);
		}
		return btnFind;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("반갑습니다!");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 21));
			lblNewLabel.setBounds(221, 47, 97, 36);
		}
		return lblNewLabel;
	}
	private JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("아이디(이메일) :");
			lblId.setBounds(87, 173, 82, 16);
		}
		return lblId;
	}
	private JLabel getLblId_1() {
		if (lblId_1 == null) {
			lblId_1 = new JLabel("비밀번호 :");
			lblId_1.setBounds(115, 208, 61, 16);
		}
		return lblId_1;
	}
	private JLabel getLblId_1_1() {
		if (lblId_1_1 == null) {
			lblId_1_1 = new JLabel("또는");
			lblId_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblId_1_1.setBounds(231, 296, 61, 16);
		}
		return lblId_1_1;
	}
	private JLabel getLblId_1_2() {
		if (lblId_1_2 == null) {
			lblId_1_2 = new JLabel("아이디 혹은 비밀번호를 잊어버렸습니까?");
			lblId_1_2.setBounds(164, 444, 206, 16);
		}
		return lblId_1_2;
	}
	
	public void setVisible_SignIn(boolean b) {
		frame.setVisible(b);
	}
	
	// Method
	private String strPwd() {
		char[] str = pwdF.getPassword();
		String passString = new String(str);
		return passString;
	}
	
	private void signInAction() {
		String emailId = tfEmail.getText().trim()+ "@" + cbEmail.getSelectedItem();
		DbSignAction dbAction = new DbSignAction(emailId, strPwd());
		if (rdbtnCommon.isSelected()) {
			dbAction.signInStudent();
			if (dbAction.signInStudent() == true) {
				ShareVar.currentuser = "'" + emailId + "'";
				segueToStu();
				//System.out.println("Success" + ShareVar.currentuser);
			} else {
				JOptionPane.showMessageDialog(null, "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
				//System.out.println("Fail" + emailId);
			}
		} else {
			dbAction.signInTeacher();
			if (dbAction.signInTeacher() == true) {
				ShareVar.currentuser =  "'" + emailId + "'";
				
				TeacherMypage tc = new TeacherMypage();
				tc.setVisible_TeacherMypage(true);
				frame.dispose();
				// 강사페이지 열기
			} else {
				JOptionPane.showMessageDialog(null, "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			}
		}
	}
	
	private void segueToStu() {
		HomeView homeView = new HomeView();
		homeView.setVisible_HomeView(true);
		frame.dispose();
	}
}
