package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class TeacherInfo_QnA {

	private JFrame frame;
	private JLabel lbltName;
	private JLabel lbltNickName;
	private JLabel lbltTelNo;
	private JLabel lbltEmail;
	private JTextField tftName;
	private JTextField tftNickName;
	private JTextField tftTelNo;
	private JTextField tftEmail;
	private JLabel lblQnA;
	private JTextField textField;
	private JButton btnQnA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInfo_QnA window = new TeacherInfo_QnA();
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
	public TeacherInfo_QnA() {
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
		frame.getContentPane().add(getLbltName());
		frame.getContentPane().add(getLbltNickName());
		frame.getContentPane().add(getLbltTelNo());
		frame.getContentPane().add(getLbltEmail());
		frame.getContentPane().add(getTftName());
		frame.getContentPane().add(getTftNickName());
		frame.getContentPane().add(getTftTelNo());
		frame.getContentPane().add(getTftEmail());
		frame.getContentPane().add(getLblQnA());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnQnA());
	}

	private JLabel getLbltName() {
		if (lbltName == null) {
			lbltName = new JLabel("강사명 :");
			lbltName.setBounds(167, 82, 61, 16);
		}
		return lbltName;
	}
	private JLabel getLbltNickName() {
		if (lbltNickName == null) {
			lbltNickName = new JLabel("닉네임 :");
			lbltNickName.setBounds(167, 120, 61, 16);
		}
		return lbltNickName;
	}
	private JLabel getLbltTelNo() {
		if (lbltTelNo == null) {
			lbltTelNo = new JLabel("전화번호 :");
			lbltTelNo.setBounds(167, 158, 61, 16);
		}
		return lbltTelNo;
	}
	private JLabel getLbltEmail() {
		if (lbltEmail == null) {
			lbltEmail = new JLabel("이메일 :");
			lbltEmail.setBounds(167, 195, 61, 16);
		}
		return lbltEmail;
	}
	private JTextField getTftName() {
		if (tftName == null) {
			tftName = new JTextField();
			tftName.setEditable(false);
			tftName.setBounds(232, 77, 130, 26);
			tftName.setColumns(10);
		}
		return tftName;
	}
	private JTextField getTftNickName() {
		if (tftNickName == null) {
			tftNickName = new JTextField();
			tftNickName.setEditable(false);
			tftNickName.setColumns(10);
			tftNickName.setBounds(232, 115, 130, 26);
		}
		return tftNickName;
	}
	private JTextField getTftTelNo() {
		if (tftTelNo == null) {
			tftTelNo = new JTextField();
			tftTelNo.setEditable(false);
			tftTelNo.setColumns(10);
			tftTelNo.setBounds(232, 153, 227, 26);
		}
		return tftTelNo;
	}
	private JTextField getTftEmail() {
		if (tftEmail == null) {
			tftEmail = new JTextField();
			tftEmail.setEditable(false);
			tftEmail.setColumns(10);
			tftEmail.setBounds(232, 190, 227, 26);
		}
		return tftEmail;
	}
	private JLabel getLblQnA() {
		if (lblQnA == null) {
			lblQnA = new JLabel("QnA");
			lblQnA.setHorizontalAlignment(SwingConstants.CENTER);
			lblQnA.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblQnA.setBounds(25, 280, 67, 26);
		}
		return lblQnA;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(35, 318, 467, 175);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnQnA() {
		if (btnQnA == null) {
			btnQnA = new JButton("작성");
			btnQnA.setBounds(385, 518, 117, 29);
		}
		return btnQnA;
	}
}
