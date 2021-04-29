package com.javaproject.studentpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("당신은 손입니다.");
			lblNewLabel.setBounds(236, 147, 106, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(146, 210, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("닉네임");
			lblNewLabel_1_1.setBounds(146, 238, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(219, 205, 130, 26);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfNickName() {
		if (tfNickName == null) {
			tfNickName = new JTextField();
			tfNickName.setColumns(10);
			tfNickName.setBounds(219, 233, 130, 26);
		}
		return tfNickName;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("이메일");
			lblNewLabel_1_1_1.setBounds(146, 273, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JLabel getLblNewLabel_1_1_1_2() {
		if (lblNewLabel_1_1_1_2 == null) {
			lblNewLabel_1_1_1_2 = new JLabel("전화번호");
			lblNewLabel_1_1_1_2.setBounds(146, 301, 61, 16);
		}
		return lblNewLabel_1_1_1_2;
	}
	private JButton getBtnSignOut() {
		if (btnSignOut == null) {
			btnSignOut = new JButton("로그아웃");
			btnSignOut.setBounds(399, 487, 117, 29);
		}
		return btnSignOut;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(219, 268, 130, 26);
		}
		return tfEmail;
	}
	private JTextField getTfPhoneNumber() {
		if (tfPhoneNumber == null) {
			tfPhoneNumber = new JTextField();
			tfPhoneNumber.setColumns(10);
			tfPhoneNumber.setBounds(219, 296, 130, 26);
		}
		return tfPhoneNumber;
	}
	private JButton getBtnWithdraw() {
		if (btnWithdraw == null) {
			btnWithdraw = new JButton("탈퇴");
			btnWithdraw.setBounds(399, 549, 117, 29);
		}
		return btnWithdraw;
	}
	private JButton getBtnChangePwd() {
		if (btnChangePwd == null) {
			btnChangePwd = new JButton("비밀번호 변경");
			btnChangePwd.setBounds(399, 445, 117, 29);
		}
		return btnChangePwd;
	}
	private JButton getBtnEdit() {
		if (btnEdit == null) {
			btnEdit = new JButton("정보수정");
			btnEdit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 정보수정
				}
			});
			btnEdit.setBounds(399, 404, 117, 29);
		}
		return btnEdit;
	}
}
