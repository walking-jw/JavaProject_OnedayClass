package com.javaproject.studentpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.javaproject.base.ShareVar;
import com.javaproject.home.HomeView;
import com.javaproject.login.SignIn;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class StudentProfile {

	private JFrame frame;
	private JLabel lblLevel;
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
	private JLabel lblNewLabel;
	private JButton btnCancel;

	

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
		frame.setTitle("내 정보");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				loadProfile();
				level();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblLevel());
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
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnCancel());
	}

	private JLabel getLblLevel() {
		if (lblLevel == null) {
			lblLevel = new JLabel("발!");
			lblLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
			lblLevel.setBounds(285, 52, 91, 40);
		}
		return lblLevel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setFont(new Font("SF Pro", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(60, 149, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("닉네임");
			lblNewLabel_1_1.setFont(new Font("SF Pro", Font.PLAIN, 16));
			lblNewLabel_1_1.setBounds(60, 191, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(140, 145, 285, 30);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfNickName() {
		if (tfNickName == null) {
			tfNickName = new JTextField();
			tfNickName.setColumns(10);
			tfNickName.setBounds(140, 185, 285, 30);
		}
		return tfNickName;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("이메일");
			lblNewLabel_1_1_1.setFont(new Font("SF Pro", Font.PLAIN, 16));
			lblNewLabel_1_1_1.setBounds(60, 226, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_2() {
		if (lblNewLabel_1_1_1_2 == null) {
			lblNewLabel_1_1_1_2 = new JLabel("전화번호");
			lblNewLabel_1_1_1_2.setFont(new Font("SF Pro", Font.PLAIN, 16));
			lblNewLabel_1_1_1_2.setBounds(60, 266, 61, 16);
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
			btnSignOut.setBounds(409, 442, 117, 29);
		}
		return btnSignOut;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setEditable(false);
			tfEmail.setColumns(10);
			tfEmail.setBounds(140, 220, 285, 30);
		}
		return tfEmail;
	}
	private JTextField getTfPhoneNumber() {
		if (tfPhoneNumber == null) {
			tfPhoneNumber = new JTextField();
			tfPhoneNumber.setColumns(10);
			tfPhoneNumber.setBounds(143, 260, 285, 30);
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
			btnWithdraw.setBounds(409, 483, 117, 29);
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
			btnChangePwd.setBounds(143, 414, 183, 29);
		}
		return btnChangePwd;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("정보수정");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 정보수정
					JOptionPane.showMessageDialog(null, "정보가 수정되었습니다.");
					updateProfile();
					loadProfile();
				}
			});
			btnEdit.setBounds(140, 302, 285, 29);
		}
		return btnEdit;
	}
	private JLabel getLblNewLabel_1_1_1_2_1() {
		if (lblNewLabel_1_1_1_2_1 == null) {
			lblNewLabel_1_1_1_2_1 = new JLabel("비밀번호");
			lblNewLabel_1_1_1_2_1.setBounds(60, 353, 61, 16);
		}
		return lblNewLabel_1_1_1_2_1;
	}
	private JLabel getLblNewLabel_1_1_1_2_1_1() {
		if (lblNewLabel_1_1_1_2_1_1 == null) {
			lblNewLabel_1_1_1_2_1_1 = new JLabel("비밀번호확인");
			lblNewLabel_1_1_1_2_1_1.setBounds(60, 381, 73, 16);
		}
		return lblNewLabel_1_1_1_2_1_1;
	}
	private JPasswordField getPwdF() {
		if (pwdF == null) {
			pwdF = new JPasswordField();
			pwdF.setBounds(143, 348, 185, 26);
		}
		return pwdF;
	}
	private JPasswordField getPwdFCheck() {
		if (pwdFCheck == null) {
			pwdFCheck = new JPasswordField();
			pwdFCheck.setBounds(143, 376, 185, 26);
		}
		return pwdFCheck;
	}
	
	public void setVisible_StudentProfile(boolean b) {
		frame.setVisible(b);
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("당신의 손은 ");
			lblNewLabel.setBounds(212, 68, 73, 16);
		}
		return lblNewLabel;
	}
	
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("닫기");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomeView hv = new HomeView();
					hv.setVisible_HomeView(true);
					frame.dispose();
				}
			});
			btnCancel.setBounds(409, 541, 117, 29);
		}
		return btnCancel;
	}
	
	// Method
	//================================================================================
	// 프로필 불러오기
	private void loadProfile() {
		DbProfileAction dbProfileAction = new DbProfileAction();
		ProfileBean bean = dbProfileAction.loadProfile();
		tfName.setText(bean.getName());
		tfNickName.setText(bean.getNickName());
		tfEmail.setText(bean.getEmail());
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
		if (strPwd().equals(strPwdCheck()) && strPwd().isEmpty() == false) {
			DbProfileAction dbProfileAction = new DbProfileAction(strPwdCheck());
			dbProfileAction.changePwd();
			JOptionPane.showMessageDialog(null, "비밀번호가 변경 되었습니다.");
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호 확인이 다릅니다.");
		}
	}
	//로그아웃
	private void signOutAction() {
		JOptionPane.showMessageDialog(null, "로그아웃이 되었습니다.");
		ShareVar.currentuser = "";
		SignIn signIn = new SignIn();
		signIn.setVisible_SignIn(true);
		frame.dispose();
	}
	
	// 탈퇴하기
	private void withdrawAction() {
		int result = JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?\n탈퇴시 등록한 강좌가 없는지 확인바랍니다.", "예 아니오", JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION) {
			try {
			DbProfileAction dbProfileAction = new DbProfileAction();
			dbProfileAction.deleteAction();
			signOutAction();
			} catch (Exception e) {
				System.out.println("error!");
			}
		}
	}
	
	
	// 등급구하기
	private void level() {
		DbProfileAction action = new DbProfileAction();
		int res = action.countAttend();
		
		if (res < 1) {
			lblLevel.setText("발!");
		} 
		else if (res < 5) {
			lblLevel.setText("동손!");
		}
		else if (res < 12) {
			lblLevel.setText("은손!");
		} 
		else {
			lblLevel.setText("금손!");
		}
		
	}
	
	
}

