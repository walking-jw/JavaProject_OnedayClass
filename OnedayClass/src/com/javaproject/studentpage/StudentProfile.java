package com.javaproject.studentpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javaproject.base.ShareVar;
import com.javaproject.login.SignIn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class StudentProfile {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_1;
	private JTextField tfName;
	private JTextField tfNickName;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_1_1_1_2;
	private JButton btnSignOut;
	private JTextField tfEmail;
	private JTextField tfPhoneNumber;
	private JButton btnWithdraw;
	private JButton btnChangePwd;
	private JButton btnEdit;
	private JLabel lblNewLabel_1_1_1_2_1;
	private JLabel lblNewLabel_1_1_1_2_1_1;
	private JPasswordField pwdF;
	private JPasswordField pwdFCheck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentProfile window = new StudentProfile();
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
	public StudentProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				tfEmail.setText(ShareVar.currentuser);
				loadProfile();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTfName());
		frame.getContentPane().add(getTfNickName());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_2());
		frame.getContentPane().add(getBtnSignOut());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfPhoneNumber());
		frame.getContentPane().add(getBtnWithdraw());
		frame.getContentPane().add(getBtnChangePwd());
		frame.getContentPane().add(getBtnEdit());
		frame.getContentPane().add(getLblNewLabel_1_1_1_2_1());
		frame.getContentPane().add(getLblNewLabel_1_1_1_2_1_1());
		frame.getContentPane().add(getPwdF());
		frame.getContentPane().add(getPwdFCheck());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("당신은 손입니다.");
			lblNewLabel.setBounds(236, 104, 106, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(146, 156, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("닉네임");
			lblNewLabel_1_1.setBounds(146, 184, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(219, 151, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfNickName() {
		if (tfNickName == null) {
			tfNickName = new JTextField();
			tfNickName.setColumns(10);
			tfNickName.setBounds(219, 179, 130, 26);
		}
		return tfNickName;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("이메일");
			lblNewLabel_1_1_1.setBounds(146, 219, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_2() {
		if (lblNewLabel_1_1_1_2 == null) {
			lblNewLabel_1_1_1_2 = new JLabel("전화번호");
			lblNewLabel_1_1_1_2.setBounds(146, 247, 61, 16);
		}
		return lblNewLabel_1_1_1_2;
	}
	private JButton getBtnSignOut() {
		if (btnSignOut == null) {
			btnSignOut = new JButton("로그아웃");
			btnSignOut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 로그아웃!
					signOutAction();
				}
			});
			btnSignOut.setBounds(399, 508, 117, 29);
		}
		return btnSignOut;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(219, 214, 130, 26);
		}
		return tfEmail;
	}
	private JTextField getTfPhoneNumber() {
		if (tfPhoneNumber == null) {
			tfPhoneNumber = new JTextField();
			tfPhoneNumber.setColumns(10);
			tfPhoneNumber.setBounds(219, 242, 130, 26);
		}
		return tfPhoneNumber;
	}
	private JButton getBtnWithdraw() {
		if (btnWithdraw == null) {
			btnWithdraw = new JButton("탈퇴");
			btnWithdraw.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					withdrawAction();
				}
			});
			btnWithdraw.setBounds(399, 549, 117, 29);
		}
		return btnWithdraw;
	}
	private JButton getBtnChangePwd() {
		if (btnChangePwd == null) {
			btnChangePwd = new JButton("비밀번호 변경");
			btnChangePwd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					changePassword();
				}
			});
			btnChangePwd.setBounds(248, 439, 117, 29);
		}
		return btnChangePwd;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("정보수정");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 정보수정
					updateProfile();
					loadProfile();
				}
			});
			btnEdit.setBounds(232, 274, 117, 29);
		}
		return btnEdit;
	}
	private JLabel getLblNewLabel_1_1_1_2_1() {
		if (lblNewLabel_1_1_1_2_1 == null) {
			lblNewLabel_1_1_1_2_1 = new JLabel("비밀번호");
			lblNewLabel_1_1_1_2_1.setBounds(146, 353, 61, 16);
		}
		return lblNewLabel_1_1_1_2_1;
	}
	private JLabel getLblNewLabel_1_1_1_2_1_1() {
		if (lblNewLabel_1_1_1_2_1_1 == null) {
			lblNewLabel_1_1_1_2_1_1 = new JLabel("비밀번호확인");
			lblNewLabel_1_1_1_2_1_1.setBounds(146, 381, 73, 16);
		}
		return lblNewLabel_1_1_1_2_1_1;
	}
	private JPasswordField getPwdF() {
		if (pwdF == null) {
			pwdF = new JPasswordField();
			pwdF.setBounds(224, 348, 130, 26);
		}
		return pwdF;
	}
	private JPasswordField getPwdFCheck() {
		if (pwdFCheck == null) {
			pwdFCheck = new JPasswordField();
			pwdFCheck.setBounds(219, 376, 130, 26);
		}
		return pwdFCheck;
	}
	
	// Method
	//================================================================================
	// 프로필 불러오기
	private void loadProfile() {
		DbProfileAction dbProfileAction = new DbProfileAction();
		ProfileBean bean = dbProfileAction.loadProfile();
		
		tfName.setText(bean.getName());
		tfNickName.setText(bean.getNickName());
		tfPhoneNumber.setText(bean.getTelNo());
		
		
	}
	
	// 프로필 변경하기
	private void updateProfile() {
		String name = tfName.getText().trim();
		String nickName = tfNickName.getText().trim();
		String telNo = tfPhoneNumber.getText().trim();
	
		DbProfileAction dbProfileAction = new DbProfileAction(name, nickName, telNo);
		dbProfileAction.updateAction();
	}
	
	// 비밀번호 변경하기
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
	private void changePassword() {
		if (strPwd()==strPwdCheck()) {
			DbProfileAction dbProfileAction = new DbProfileAction();
			dbProfileAction.changePwd();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호 확인이 다릅니다.");
		}
	}
	//로그아웃
	private void signOutAction() {
		ShareVar.currentuser = "";
		SignIn signIn = new SignIn();
		signIn.setVisible_SignIn(true);
		frame.dispose();
	}
	
	// 탈퇴하기
	private void withdrawAction() {
		DbProfileAction dbProfileAction = new DbProfileAction();
		dbProfileAction.deleteAction();
		signOutAction();
	}
	
	
	public void setVisible_StudentProfile(boolean b) {
		frame.setVisible(b);
	}
	
}

