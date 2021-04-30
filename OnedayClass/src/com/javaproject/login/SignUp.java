package com.javaproject.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class SignUp {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JRadioButton rdbtnCommon;
	private JRadioButton rdbtnTeacher;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField tfName;
	private JTextField tfNickName;
	private JTextField tfPhone;
	private JPasswordField pwdF;
	private JPasswordField pwdFCheck;
	private JTextField tfEmail;
	private JComboBox cbEmail;
	private JComboBox cbPhone;
	private JButton btnCheck;
	private JButton btnCancel;
	private JButton btnDone;

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("회원가입");
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getRdbtnCommon());
		frame.getContentPane().add(getRdbtnTeacher());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfNickName());
		frame.getContentPane().add(getTfPhone());
		frame.getContentPane().add(getPwdF());
		frame.getContentPane().add(getPwdFCheck());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getCbEmail());
		frame.getContentPane().add(getCbPhone());
		frame.getContentPane().add(getBtnCheck());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getBtnDone());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("회원가입");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
			lblNewLabel.setBounds(39, 68, 73, 23);
		}
		return lblNewLabel;
	}
	private JRadioButton getRdbtnCommon() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("일반회원");
			rdbtnCommon.setSelected(true);
			rdbtnCommon.setBounds(39, 117, 111, 23);
		}
		return rdbtnCommon;
	}
	private JRadioButton getRdbtnTeacher() {
		if (rdbtnTeacher == null) {
			rdbtnTeacher = new JRadioButton("강사회원");
			rdbtnTeacher.setBounds(144, 117, 141, 23);
		}
		return rdbtnTeacher;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("아이디(이메일)");
			lblNewLabel_1.setBounds(39, 172, 111, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("비밀번호");
			lblNewLabel_2.setBounds(39, 215, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("비밀번호 확인");
			lblNewLabel_3.setBounds(39, 263, 90, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("이름");
			lblNewLabel_4.setBounds(39, 323, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("닉네임");
			lblNewLabel_5.setBounds(39, 377, 61, 16);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("전화");
			lblNewLabel_6.setBounds(39, 420, 61, 16);
		}
		return lblNewLabel_6;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(144, 318, 130, 26);
		}
		return tfName;
	}
	private JTextField getTfNickName() {
		if (tfNickName == null) {
			tfNickName = new JTextField();
			tfNickName.setColumns(10);
			tfNickName.setBounds(144, 372, 130, 26);
		}
		return tfNickName;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(243, 415, 157, 26);
		}
		return tfPhone;
	}
	private JPasswordField getPwdF() {
		if (pwdF == null) {
			pwdF = new JPasswordField();
			pwdF.setBounds(144, 210, 130, 26);
		}
		return pwdF;
	}
	private JPasswordField getPwdFCheck() {
		if (pwdFCheck == null) {
			pwdFCheck = new JPasswordField();
			pwdFCheck.setBounds(144, 258, 130, 26);
		}
		return pwdFCheck;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setBounds(144, 167, 130, 26);
			tfEmail.setColumns(10);
		}
		return tfEmail;
	}
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "google.com"}));
			cbEmail.setBounds(274, 168, 143, 27);
		}
		return cbEmail;
	}
	private JComboBox getCbPhone() {
		if (cbPhone == null) {
			cbPhone = new JComboBox();
			cbPhone.setModel(new DefaultComboBoxModel(new String[] {"010"}));
			cbPhone.setBounds(144, 416, 87, 27);
		}
		return cbPhone;
	}
	private JButton getBtnCheck() {
		if (btnCheck == null) {
			btnCheck = new JButton("아이디 확인");
			btnCheck.setBackground(UIManager.getColor("Desktop.background"));
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//id check
					if (checkInputId() == true) {
						checking = true;
						JOptionPane.showMessageDialog(null, "사용 가능한 이메일입니다.");
					} else {
						checking = false;
						JOptionPane.showMessageDialog(null, "사용할 수 없는 이메일입니다.");
					}
				}
			});
			btnCheck.setBounds(414, 167, 117, 29);
		}
		return btnCheck;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignIn signIn = new SignIn();
					signIn.setVisible_SignIn(true);
					frame.dispose();
				}
			});
			btnCancel.setBounds(270, 539, 117, 29);
		}
		return btnCancel;
	}
	private JButton getBtnDone() {
		if (btnDone == null) {
			btnDone = new JButton("가입");
			btnDone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//회원가입 
					signUpAction();
				}
			});
			btnDone.setBounds(399, 539, 117, 29);
		}
		return btnDone;
	}
	
	public void setVisible_SignUp(boolean b) {
		frame.setVisible(b);
	}
	
	//Method
	private String strPwd() {
		char[] str = pwdF.getPassword();
		String passString = new String(str);
		return passString;
	}
	
	private String strPwdCheck() {
		char[] str = pwdFCheck.getPassword();
		String passString = new String(str);
		return passString;
	}
	
	private void applyInfo() {
		String email = tfEmail.getText().trim() + "@" + cbEmail.getSelectedItem();
		String name = tfName.getText().trim();
		String nickName = tfNickName.getText().trim();
		String phone = cbPhone.getSelectedItem() + tfPhone.getText().trim();
		String password = strPwd();
		DbSignAction dbSignAction = new DbSignAction(email, name, nickName, phone, password);
		if (rdbtnCommon.isSelected()) {
			dbSignAction.signUpStudent();
		} else {
			dbSignAction.signUpTeacher();
		}
	
	}
	
	boolean checking = false;
	
	private boolean checkInputId() {
		String email = tfEmail.getText().trim() + "@" + cbEmail.getSelectedItem();
		DbSignAction dbSignAction = new DbSignAction(email);
		if (rdbtnCommon.isSelected()) {
			return dbSignAction.checkingStudentId();
		} else {
			return dbSignAction.checkingTeacherId();
		}
	}
	
	private void signUpAction() {
		if (checking = false) {
			JOptionPane.showMessageDialog(null, "아이디 중복체크를 해주세요.");
		} else if (tfName.getText().trim().isEmpty() || tfNickName.getText().trim().isEmpty() || tfPhone.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "정보를 전부 입력해주세요.");
		} else if (strPwd().equals(strPwdCheck())) {
			applyInfo();
			JOptionPane.showMessageDialog(null, "금손양성소에 오신걸 환영합니다.");
			SignIn signIn = new SignIn();
			signIn.setVisible_SignIn(true);
			frame.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 확인과 다릅니다.");
		}
	}
}
