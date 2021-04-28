package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeacherMypage {

	private JFrame frame;
	private JLabel lbl_Name;
	private JTextField tf_Name;
	private JLabel lbl_Name_1;
	private JTextField tf_NickName;
	private JTextField tf_Email;
	private JLabel lbl_Email;
	private JLabel lbl_Email_1;
	private JTextField tf_Telno;
	private JLabel lbl_Email_1_1;
	private JTextField tf_Password;
	private JTextField tf_PasswordConfirm;
	private JLabel lbl_QnA;
	private JLabel lbl_Average;
	private JTextField tf_AveragePoint;
	private JLabel lbl_Myclass;
	private JLabel lbl_Average_1_1;
	private JButton btn_TeacherMyclass;
	private JButton btn_QnA;
	private JButton btn_Out;
	private JButton btn_Out_1;
	private JLabel lbl_Logout;

	public void setVisible_TeacherMypage(boolean i){
		   	frame.setVisible(i);
	}
	/**
	 * Create the application.
	 */
	public TeacherMypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override()
			public void windowOpened(WindowEvent e) {
				DBtoClass();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLbl_Name());
		frame.getContentPane().add(getTf_Name());
		frame.getContentPane().add(getLbl_Name_1());
		frame.getContentPane().add(getTf_NickName());
		frame.getContentPane().add(getTf_Email());
		frame.getContentPane().add(getLbl_Email());
		frame.getContentPane().add(getLbl_Email_1());
		frame.getContentPane().add(getTf_Telno());
		frame.getContentPane().add(getLbl_Email_1_1());
		frame.getContentPane().add(getTf_Password());
		frame.getContentPane().add(getTf_PasswordConfirm());
		frame.getContentPane().add(getLbl_QnA());
		frame.getContentPane().add(getLbl_Average());
		frame.getContentPane().add(getTf_AveragePoint());
		frame.getContentPane().add(getLbl_Myclass());
		frame.getContentPane().add(getLbl_Average_1_1());
		frame.getContentPane().add(getBtn_TeacherMyclass());
		frame.getContentPane().add(getBtn_QnA());
		frame.getContentPane().add(getBtn_Out());
		frame.getContentPane().add(getBtn_Out_1());
		frame.getContentPane().add(getLbl_Logout());
	}
	private JLabel getLbl_Name() {
		if (lbl_Name == null) {
			lbl_Name = new JLabel("이     름");
			lbl_Name.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Name.setBounds(187, 95, 61, 16);
		}
		return lbl_Name;
	}
	private JTextField getTf_Name() {
		if (tf_Name == null) {
			tf_Name = new JTextField();
			tf_Name.setBounds(267, 88, 206, 32);
			tf_Name.setColumns(10);
		}
		return tf_Name;
	}
	private JLabel getLbl_Name_1() {
		if (lbl_Name_1 == null) {
			lbl_Name_1 = new JLabel("닉 네 임");
			lbl_Name_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Name_1.setBounds(187, 139, 61, 16);
		}
		return lbl_Name_1;
	}
	private JTextField getTf_NickName() {
		if (tf_NickName == null) {
			tf_NickName = new JTextField();
			tf_NickName.setColumns(10);
			tf_NickName.setBounds(267, 132, 206, 32);
		}
		return tf_NickName;
	}
	private JTextField getTf_Email() {
		if (tf_Email == null) {
			tf_Email = new JTextField();
			tf_Email.setColumns(10);
			tf_Email.setBounds(267, 176, 206, 32);
		}
		return tf_Email;
	}
	private JLabel getLbl_Email() {
		if (lbl_Email == null) {
			lbl_Email = new JLabel("E-mail");
			lbl_Email.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email.setBounds(187, 183, 61, 16);
		}
		return lbl_Email;
	}
	private JLabel getLbl_Email_1() {
		if (lbl_Email_1 == null) {
			lbl_Email_1 = new JLabel("전화번호");
			lbl_Email_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email_1.setBounds(187, 227, 61, 16);
		}
		return lbl_Email_1;
	}
	private JTextField getTf_Telno() {
		if (tf_Telno == null) {
			tf_Telno = new JTextField();
			tf_Telno.setColumns(10);
			tf_Telno.setBounds(267, 220, 206, 32);
		}
		return tf_Telno;
	}
	private JLabel getLbl_Email_1_1() {
		if (lbl_Email_1_1 == null) {
			lbl_Email_1_1 = new JLabel("비밀번호");
			lbl_Email_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email_1_1.setBounds(187, 288, 61, 16);
		}
		return lbl_Email_1_1;
	}
	private JTextField getTf_Password() {
		if (tf_Password == null) {
			tf_Password = new JTextField();
			tf_Password.setColumns(10);
			tf_Password.setBounds(267, 281, 206, 32);
		}
		return tf_Password;
	}
	private JTextField getTf_PasswordConfirm() {
		if (tf_PasswordConfirm == null) {
			tf_PasswordConfirm = new JTextField();
			tf_PasswordConfirm.setColumns(10);
			tf_PasswordConfirm.setBounds(267, 325, 206, 32);
		}
		return tf_PasswordConfirm;
	}
	private JLabel getLbl_QnA() {
		if (lbl_QnA == null) {
			lbl_QnA = new JLabel("비밀번호확인");
			lbl_QnA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_QnA.setBounds(187, 332, 84, 16);
		}
		return lbl_QnA;
	}
	private JLabel getLbl_Average() {
		if (lbl_Average == null) {
			lbl_Average = new JLabel("평    점");
			lbl_Average.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Average.setBounds(71, 376, 61, 16);
		}
		return lbl_Average;
	}
	private JTextField getTf_AveragePoint() {
		if (tf_AveragePoint == null) {
			tf_AveragePoint = new JTextField();
			tf_AveragePoint.setColumns(10);
			tf_AveragePoint.setBounds(151, 369, 49, 32);
		}
		return tf_AveragePoint;
	}
	private JLabel getLbl_Myclass() {
		if (lbl_Myclass == null) {
			lbl_Myclass = new JLabel("내 강의");
			lbl_Myclass.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Myclass.setBounds(71, 418, 61, 16);
		}
		return lbl_Myclass;
	}
	private JLabel getLbl_Average_1_1() {
		if (lbl_Average_1_1 == null) {
			lbl_Average_1_1 = new JLabel("Q & A");
			lbl_Average_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Average_1_1.setBounds(71, 461, 61, 16);
		}
		return lbl_Average_1_1;
	}
	private JButton getBtn_TeacherMyclass() {
		if (btn_TeacherMyclass == null) {
			btn_TeacherMyclass = new JButton("0개");
			btn_TeacherMyclass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 내 강의 Button :TeacherMypage -> TeacherMyClass  [2021.04.26, 11:34]
					TeacherMyClass myclass = new TeacherMyClass();
					myclass.setVisible_TeacherMyClass(true);
					frame.dispose();		
					
					
				}
			});
			btn_TeacherMyclass.setBounds(151, 413, 117, 29);
		}
		return btn_TeacherMyclass;
	}
	private JButton getBtn_QnA() {
		if (btn_QnA == null) {
			btn_QnA = new JButton("0개");
			btn_QnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Mypage --> QnA 
					TeacherQnA_List qna = new TeacherQnA_List();    // * * * * * * * * * * * * * *  
					qna.setVisible_TeacherQnA_List(true);
					frame.dispose();		
					
					
				}
			});
			btn_QnA.setBounds(151, 457, 117, 29);
		}
		return btn_QnA;
	}
	private JButton getBtn_Out() {
		if (btn_Out == null) {
			btn_Out = new JButton("탈퇴");
			btn_Out.setBounds(386, 527, 140, 29);
		}
		return btn_Out;
	}
	private JButton getBtn_Out_1() {
		if (btn_Out_1 == null) {
			btn_Out_1 = new JButton("정보변경");
			btn_Out_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btn_Out_1.setBounds(234, 527, 140, 29);
		}
		return btn_Out_1;
	}
	private JLabel getLbl_Logout() {
		if (lbl_Logout == null) {
			lbl_Logout = new JLabel("로그아웃");
			lbl_Logout.setBounds(71, 228, 61, 16);
		}
		return lbl_Logout;
	}
	
	public void DBtoClass() {
		
		DbAction db = new DbAction();
		Bean_TeacherClass bean = db.DBtoMypage();
		
		tf_Name.setText(bean.gettName());
		tf_NickName.setText(bean.gettNickName());
		tf_Email.setText(bean.gettEmail());
		tf_Telno.setText(bean.gettTelNo());
		
	}
	
	
	
	
	
	
	
	
	
	
}
