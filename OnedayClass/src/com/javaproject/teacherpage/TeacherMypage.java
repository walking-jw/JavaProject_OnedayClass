package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.javaproject.base.ShareVar;
import com.javaproject.login.SignIn;
import com.javaproject.studentpage.DbProfileAction;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

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
	private JLabel lbl_QnA;
	private JLabel lbl_Average;
	private JTextField tf_AveragePoint;
	private JLabel lbl_Myclass;
	private JLabel lbl_Average_1_1;
	private JButton btn_TeacherMyclass;
	private JButton btn_QnA;
	private JButton btn_Out;
	private JButton btn_Out_1;
	private JLabel lbl_PassCheck;
	private JPasswordField tf_Password;
	private JPasswordField tf_PasswordConfirm;
	private JLabel lblNewLabel;
	private JButton btn_Logout;
	private JLabel lblNewLabel_1;

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
		frame.setTitle("마이페이지");
		frame.addWindowListener(new WindowAdapter() {
			@Override()
			public void windowOpened(WindowEvent e) {
				DBtoClass();
				Average();
				CountOfClass();
				CounfOfQnA();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
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
		frame.getContentPane().add(getLbl_QnA());
		frame.getContentPane().add(getLbl_Average());
		frame.getContentPane().add(getTf_AveragePoint());
		frame.getContentPane().add(getLbl_Myclass());
		frame.getContentPane().add(getLbl_Average_1_1());
		frame.getContentPane().add(getBtn_TeacherMyclass());
		frame.getContentPane().add(getBtn_QnA());
		frame.getContentPane().add(getBtn_Out());
		frame.getContentPane().add(getBtn_Out_1());
		frame.getContentPane().add(getLbl_PassCheck());
		frame.getContentPane().add(getTf_Password());
		frame.getContentPane().add(getTf_PasswordConfirm());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtn_Logout());
		frame.getContentPane().add(getLblNewLabel_1());
	}
	private JLabel getLbl_Name() {
		if (lbl_Name == null) {
			lbl_Name = new JLabel("이름");
			lbl_Name.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Name.setBounds(196, 94, 61, 16);
		}
		return lbl_Name;
	}
	private JTextField getTf_Name() {
		if (tf_Name == null) {
			tf_Name = new JTextField();
			tf_Name.setBounds(295, 90, 206, 26);
			tf_Name.setColumns(10);
		}
		return tf_Name;
	}
	private JLabel getLbl_Name_1() {
		if (lbl_Name_1 == null) {
			lbl_Name_1 = new JLabel("닉네임");
			lbl_Name_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Name_1.setBounds(196, 132, 61, 16);
		}
		return lbl_Name_1;
	}
	private JTextField getTf_NickName() {
		if (tf_NickName == null) {
			tf_NickName = new JTextField();
			tf_NickName.setColumns(10);
			tf_NickName.setBounds(295, 128, 206, 26);
		}
		return tf_NickName;
	}
	private JTextField getTf_Email() {
		if (tf_Email == null) {
			tf_Email = new JTextField();
			tf_Email.setEditable(false);
			tf_Email.setColumns(10);
			tf_Email.setBounds(295, 166, 206, 26);
		}
		return tf_Email;
	}
	private JLabel getLbl_Email() {
		if (lbl_Email == null) {
			lbl_Email = new JLabel("이메일");
			lbl_Email.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email.setBounds(196, 170, 61, 16);
		}
		return lbl_Email;
	}
	private JLabel getLbl_Email_1() {
		if (lbl_Email_1 == null) {
			lbl_Email_1 = new JLabel("전화번호");
			lbl_Email_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email_1.setBounds(196, 210, 61, 16);
		}
		return lbl_Email_1;
	}
	private JTextField getTf_Telno() {
		if (tf_Telno == null) {
			tf_Telno = new JTextField();
			tf_Telno.setColumns(10);
			tf_Telno.setBounds(295, 206, 206, 26);
		}
		return tf_Telno;
	}
	private JLabel getLbl_Email_1_1() {
		if (lbl_Email_1_1 == null) {
			lbl_Email_1_1 = new JLabel("비밀번호");
			lbl_Email_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Email_1_1.setBounds(196, 248, 61, 16);
		}
		return lbl_Email_1_1;
	}
	private JLabel getLbl_QnA() {
		if (lbl_QnA == null) {
			lbl_QnA = new JLabel("비밀번호확인");
			lbl_QnA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_QnA.setBounds(196, 287, 84, 16);
		}
		return lbl_QnA;
	}
	private JLabel getLbl_Average() {
		if (lbl_Average == null) {
			lbl_Average = new JLabel("평점");
			lbl_Average.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Average.setBounds(40, 370, 42, 16);
		}
		return lbl_Average;
	}
	private JTextField getTf_AveragePoint() {
		if (tf_AveragePoint == null) {
			tf_AveragePoint = new JTextField();
			tf_AveragePoint.setEditable(false);
			tf_AveragePoint.setHorizontalAlignment(SwingConstants.CENTER);
			tf_AveragePoint.setColumns(10);
			tf_AveragePoint.setBounds(151, 366, 49, 26);
		}
		return tf_AveragePoint;
	}
	private JLabel getLbl_Myclass() {
		if (lbl_Myclass == null) {
			lbl_Myclass = new JLabel("나의 강의");
			lbl_Myclass.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Myclass.setBounds(40, 410, 61, 16);
		}
		return lbl_Myclass;
	}
	private JLabel getLbl_Average_1_1() {
		if (lbl_Average_1_1 == null) {
			lbl_Average_1_1 = new JLabel("Q & A");
			lbl_Average_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbl_Average_1_1.setBounds(40, 444, 61, 16);
		}
		return lbl_Average_1_1;
	}
	private JButton getBtn_TeacherMyclass() {
		if (btn_TeacherMyclass == null) {
			btn_TeacherMyclass = new JButton("0개");
			btn_TeacherMyclass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 내 강의 Button :TeacherMypage -> TeacherMyClass  [2021.04.26, 11:34]
					TeacherLectureList myclass = new TeacherLectureList();
					myclass.setVisible_LectureList(true);
					frame.dispose();		
					
				}
			});
			btn_TeacherMyclass.setBounds(141, 406, 159, 29);
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
			btn_QnA.setBounds(141, 440, 159, 29);
		}
		return btn_QnA;
	}
	private JButton getBtn_Out() {
		if (btn_Out == null) {
			btn_Out = new JButton("탈퇴");
			btn_Out.setForeground(Color.RED);
			btn_Out.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					withdrawAction();
					
				}
			});
			btn_Out.setBounds(108, 515, 140, 29);
		}
		return btn_Out;
	}
	private JPasswordField getTf_Password() {
		if (tf_Password == null) {
			tf_Password = new JPasswordField();
			tf_Password.setBounds(295, 244, 206, 26);
		}
		return tf_Password;
	}
	private JPasswordField getTf_PasswordConfirm() {
		if (tf_PasswordConfirm == null) {
			tf_PasswordConfirm = new JPasswordField();
			tf_PasswordConfirm.setBounds(295, 283, 206, 26);
		}
		return tf_PasswordConfirm;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon("/Users/ido/Desktop/Project_source_img/KakaoTalk_Photo_2021-05-02-16-09-28.png"));
			lblNewLabel.setBounds(20, 83, 155, 131);
		}
		return lblNewLabel;
	}
	private JButton getBtn_Logout() {
		if (btn_Logout == null) {
			btn_Logout = new JButton("로그아웃");
			btn_Logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ShareVar.currentuser = "";
					JOptionPane.showMessageDialog(null, "로그아웃 되었습니다");
					SignIn signin = new SignIn();
					signin.setVisible_SignIn(true);
					frame.dispose();
				}
			});
			btn_Logout.setForeground(Color.BLUE);
			btn_Logout.setBounds(251, 515, 117, 29);
		}
		return btn_Logout;
	}
	private JLabel getLbl_PassCheck() {
		if (lbl_PassCheck == null) {
			lbl_PassCheck = new JLabel("");
			lbl_PassCheck.setForeground(Color.RED);
			lbl_PassCheck.setBounds(295, 321, 196, 16);
		}
		return lbl_PassCheck;
	}
	private JButton getBtn_Out_1() {
		if (btn_Out_1 == null) {
			btn_Out_1 = new JButton("정보수정");
			btn_Out_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					int trigger = EmptyCheck();
					
					if(strPwdCheck().equals(strPwdCheck_Confirm()) && trigger == 0 ) {
						UpdateAction_Mypage();
						ClearColumn();
						DBtoClass();
						lbl_PassCheck.setText("");
					}else if(trigger>=1) {
						lbl_PassCheck.setText("정보를 확인해주세요");
					}
					else{
						lbl_PassCheck.setText("비밀번호가 일치하지 않습니다");
					}
				}
			});
			btn_Out_1.setBounds(373, 515, 140, 29);
		}
		return btn_Out_1;
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("점");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(202, 370, 61, 16);
		}
		return lblNewLabel_1;
	}
	
	// Method * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 

	// 마이페이지로 최초 정보 가져오기
	public void DBtoClass() {
		
		DbAction db = new DbAction();
		Bean_TeacherClass bean = db.DBtoMypage();
		
		tf_Name.setText(bean.gettName());
		tf_NickName.setText(bean.gettNickName());
		tf_Email.setText(bean.gettEmail());
		tf_Telno.setText(bean.gettTelNo());
		
	}
	
	// 비밀번호 칸 세팅
	private String strPwdCheck() {
		char[] str = tf_Password.getPassword();
		String passString = new String(str);
		return passString;
	}
	
	// 비밀번호 확인칸 세팅
	private String strPwdCheck_Confirm() {
		char[] str = tf_PasswordConfirm.getPassword();
		String passString = new String(str);
		return passString;
	}
	
	// 마이페이지 강사 평점 메소드
	public void Average() {
			
			DbAction db = new DbAction();
			Bean_TeacherClass bean = db.AverageScore();
			
			tf_AveragePoint.setText(Integer.toString(bean.getcId()));
		}
		
	// 마이페이지 문의 갯수 확인 메소드
	public void CounfOfQnA() {
		
		DbAction db = new DbAction();
		Bean_QnA bean = db.CountOfQnA();
		
		btn_QnA.setText(Integer.toString(bean.getCountOfQnA()) + " 개의 문의 확인");
	}
	
	// 마이페이지 내 강의 갯수 확인 메소드
	public void CountOfClass() {
		
		DbAction db = new DbAction();
		Bean_TeacherClass bean2 = db.CountOfClass();
		btn_TeacherMyclass.setText(Integer.toString(bean2.getcId()) + " 개의 강의 확인");
	}
	
	// * * * * * * * * * * * * * * *마이페이지 필드값 초기화 [2021.04.28, 00:31]
	private void ClearColumn() {
		tf_Name.setText("");
		tf_NickName.setText("");
		tf_Email.setText("");
		tf_Telno.setText("");
		tf_Password.setText("");
		tf_PasswordConfirm.setText("");
	}
	
	// * * * * * * * * * * * * * * *마이페이지 수정 메소드 [2021.04.28, 00:44]
	private void UpdateAction_Mypage() {
		
		String name = tf_Name.getText().trim();
		String nickname = tf_NickName.getText().trim();
		String email = tf_Email.getText().trim();
		String telno = tf_Telno.getText().trim();
		String password = strPwdCheck_Confirm();
		
		DbAction db = new DbAction(name, nickname, email, telno, password);
		boolean msg = db.UpdateAction();
		if (msg==true) {
			JOptionPane.showMessageDialog(null, "정보가 수정되었습니다");
		}else {
			JOptionPane.showMessageDialog(null,"자료 수정 중 에러가 발생하였습니다");
		}
	}
	
	// 마이페이지 정보 수정 중, 공란이 있으며 수정이 되지않게 하기 위한 메소드
	private int EmptyCheck() {
		
			int trigger = 0;
			
			String message = "를 확인해주세요!";
			if(tf_Password.getText().trim().isEmpty()) {
				message = "'비밀번호' " + message;
				trigger++;
				tf_Password.requestFocus();
			}	
			if(tf_Telno.getText().trim().isEmpty()) {
				message = "'전화번호' " + message;
				trigger++;
				tf_Telno.requestFocus();
			}	
			if(tf_NickName.getText().trim().isEmpty()) {
				message = "'닉네임' " + message;
				trigger++;
				tf_NickName.requestFocus();
			}
			if(tf_Name.getText().trim().isEmpty()) {
				message = "'이름' " + message;
				trigger++;
				tf_Name.requestFocus();
			}
			
			if(trigger>0) {
				JOptionPane.showMessageDialog(null, message);
			}
			return trigger;
	}
	
	//탈퇴하기
	private void withdrawAction() {
		int result = JOptionPane.showConfirmDialog(null, "탈퇴하시겠습니까?\n탈퇴시 등록한 강좌가 없는지 확인바랍니다.", "예 아니오", JOptionPane.YES_NO_OPTION);
		if(result==JOptionPane.YES_OPTION) {
			try {
				DbAction db = new DbAction();
				db.applySignOut();
				JOptionPane.showMessageDialog(null, "회원 탈퇴가 되었습니다.");
				ShareVar.currentuser = "";
				SignIn signIn = new SignIn();
				signIn.setVisible_SignIn(true);
				frame.dispose();
			} catch (Exception e) {
				System.out.println("error!");
			}
		}
	}
	
}
