package com.javaproject.login;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class FindIdAndPwd {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfNameId;
	private JTextField tfTelNo;
	private JTextField tfEmail;
	private JTextField tfNamePwd;
	private JComboBox cbTelNo;
	private JComboBox cbEmail;
	private JLabel lblNewLabel_6;
	private JButton btnFindId;
	private JButton btnFindPwd;
	private JRadioButton rdbtnCommon;
	private JRadioButton rdbtnTeacher;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnSignIn;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_5_1;

	
	/**
	 * Create the application.
	 */
	public FindIdAndPwd() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("아이디/비밀번호 찾기");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getTfNameId());
		frame.getContentPane().add(getTfTelNo());
		frame.getContentPane().add(getTfEmail());
		frame.getContentPane().add(getTfNamePwd());
		frame.getContentPane().add(getCbTelNo());
		frame.getContentPane().add(getCbEmail());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getBtnFindId());
		frame.getContentPane().add(getBtnFindPwd());
		frame.getContentPane().add(getRdbtnCommon());
		frame.getContentPane().add(getRdbtnTeacher());
		frame.getContentPane().add(getBtnSignIn());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getLblNewLabel_5_1());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("가입시 등록한 이름과 전화번호를 입력하세요.");
			lblNewLabel.setBounds(101, 139, 244, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이름");
			lblNewLabel_1.setBounds(101, 383, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이름");
			lblNewLabel_2.setBounds(101, 172, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("전화번호");
			lblNewLabel_3.setBounds(101, 204, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("이메일");
			lblNewLabel_4.setBounds(101, 411, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfNameId() {
		if (tfNameId == null) {
			tfNameId = new JTextField();
			tfNameId.setBounds(158, 167, 130, 26);
			tfNameId.setColumns(10);
		}
		return tfNameId;
	}
	private JTextField getTfTelNo() {
		if (tfTelNo == null) {
			tfTelNo = new JTextField();
			tfTelNo.setColumns(10);
			tfTelNo.setBounds(260, 199, 158, 26);
		}
		return tfTelNo;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(174, 406, 130, 26);
		}
		return tfEmail;
	}
	private JTextField getTfNamePwd() {
		if (tfNamePwd == null) {
			tfNamePwd = new JTextField();
			tfNamePwd.setColumns(10);
			tfNamePwd.setBounds(174, 378, 130, 26);
		}
		return tfNamePwd;
	}
	private JComboBox getCbTelNo() {
		if (cbTelNo == null) {
			cbTelNo = new JComboBox();
			cbTelNo.setModel(new DefaultComboBoxModel(new String[] {"010"}));
			cbTelNo.setBounds(158, 200, 97, 27);
		}
		return cbTelNo;
	}
	private JComboBox getCbEmail() {
		if (cbEmail == null) {
			cbEmail = new JComboBox();
			cbEmail.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "daum.net", "kakao.com", "icloud.com"}));
			cbEmail.setBounds(314, 407, 117, 27);
		}
		return cbEmail;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("가입시 등록한 이름과 이메일을 입력하세요.");
			lblNewLabel_6.setBounds(101, 350, 244, 16);
		}
		return lblNewLabel_6;
	}
	private JButton getBtnFindId() {
		if (btnFindId == null) {
			btnFindId = new JButton("아이디 찾기");
			btnFindId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 아이디찾기
					findId();
				}
			});
			btnFindId.setBounds(101, 232, 330, 29);
		}
		return btnFindId;
	}
	private JButton getBtnFindPwd() {
		if (btnFindPwd == null) {
			btnFindPwd = new JButton("비밀번호 찾기");
			btnFindPwd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					findPwd();
				}
			});
			btnFindPwd.setBounds(101, 444, 330, 29);
		}
		return btnFindPwd;
	}
	private JRadioButton getRdbtnCommon() {
		if (rdbtnCommon == null) {
			rdbtnCommon = new JRadioButton("일반회원");
			buttonGroup.add(rdbtnCommon);
			rdbtnCommon.setSelected(true);
			rdbtnCommon.setBounds(101, 65, 97, 23);
		}
		return rdbtnCommon;
	}
	private JRadioButton getRdbtnTeacher() {
		if (rdbtnTeacher == null) {
			rdbtnTeacher = new JRadioButton("강사회원");
			buttonGroup.add(rdbtnTeacher);
			rdbtnTeacher.setBounds(210, 65, 141, 23);
		}
		return rdbtnTeacher;
	}
	
	// Find ID
	private void findId() {
		String name = tfNameId.getText().trim();
		String phoneNo = cbTelNo.getSelectedItem() +tfTelNo.getText().trim();
		DbSignAction action = new DbSignAction();
		if (rdbtnCommon.isSelected()) {
			String res = action.findCommonId(name, phoneNo);
			if (res == null) {
				JOptionPane.showMessageDialog(null, name + " 님의 아이디는 존재하지 않거나 정보를 다시 입력해주세요.");
			} else {
				JOptionPane.showMessageDialog(null, name + " 님의 아이디는 "+ res + " 입니다.");
			}
		} else {
			String res = action.findTeacherId(name, phoneNo);
			if (res == null) {
				JOptionPane.showMessageDialog(null, name + " 님의 아이디는 존재하지 않거나 정보를 다시 입력해주세요.");
			}else {
				JOptionPane.showMessageDialog(null, name + " 님의 아이디는 "+ res + " 입니다.");
			}
		}
	}
	
	// Find PWD
	private void findPwd() {
		String name = tfNamePwd.getText().trim();
		String email = tfEmail.getText().trim() + "@" + cbEmail.getSelectedItem();
		String newPwd = "";
		for (int i=1; i<=7; i++) {
			Random rand = new Random();
			int random = rand.nextInt(10);
			String str = Integer.toString(random);
			newPwd += str;
		}
		DbSignAction action = new DbSignAction();
		if (rdbtnCommon.isSelected()) {
			if (action.checkStudentInfo(name, email) == true) {
				action.findCommonPwd(name, email, newPwd);
				JOptionPane.showMessageDialog(null, "임시 비밀번호는 ' " + newPwd + " ' 입니다. \n로그인 후 비밀번호를 재설정 해주세요.");
			} else {
				JOptionPane.showMessageDialog(null, "등록된 계정이 아닙니다. 이름과 이메일을 확인해주세요.");
			}
		} else {
			if(action.checkTeacherInfo(name, email) == true) {
				action.findTeacherPwd(name, email, newPwd);
				JOptionPane.showMessageDialog(null, "임시 비밀번호는 ' " + newPwd + " ' 입니다. \n로그인 후 비밀번호를 재설정 해주세요.");
			} else {
				JOptionPane.showMessageDialog(null, "등록된 계정이 아닙니다. 이름과 이메일을 확인해주세요.");
			}
		}
		
	}
	
	
	
	public void setVisible_FindView(boolean b) {
		frame.setVisible(b);
	}
	private JButton getBtnSignIn() {
		if (btnSignIn == null) {
			btnSignIn = new JButton("로그인");
			btnSignIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignIn signIn = new SignIn();
					signIn.setVisible_SignIn(true);
					frame.dispose();
				}
			});
			btnSignIn.setBounds(396, 532, 117, 29);
		}
		return btnSignIn;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("아이디 찾기");
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_5.setBounds(101, 110, 80, 16);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_5_1() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("비밀번호 찾기");
			lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_5_1.setBounds(101, 322, 80, 16);
		}
		return lblNewLabel_5_1;
	}
}
