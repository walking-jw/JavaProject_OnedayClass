package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

import com.javaproject.classlist.DbAction;

import javax.swing.JButton;

public class TeacherInfo_QnA {
	
	//--------------------------------Field
	
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
	private JButton btnQnA;
	private JScrollPane scrollPane;
	private JTextPane tfqContents;
	private JLabel lblNewLabel;
	private JButton btnCancel;

	
	//--------------------------------Constructor
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
		frame.addWindowListener(new WindowAdapter() {
	
			@Override
			public void windowOpened(WindowEvent e) {
				
				/*
				 * 2021-04-27 권효은
				 * 강사정보 창이 켜지면 해당 강사 정보 불러오는 메소드 적용
				 */
				teacherInfo();
				
			}
		});
		frame.setTitle("마이페이지");
		frame.getContentPane().setFont(new Font("Lucida Grande", Font.PLAIN, 15));
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
		frame.getContentPane().add(getBtnQnA());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnCancel());
	}

	
	
	private JLabel getLbltName() {
		if (lbltName == null) {
			lbltName = new JLabel("이름 :");
			lbltName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbltName.setBounds(162, 75, 51, 16);
		}
		return lbltName;
	}
	
	private JLabel getLbltNickName() {
		if (lbltNickName == null) {
			lbltNickName = new JLabel("닉네임 :");
			lbltNickName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbltNickName.setBounds(162, 116, 51, 16);
		}
		return lbltNickName;
	}
	private JLabel getLbltTelNo() {
		if (lbltTelNo == null) {
			lbltTelNo = new JLabel("전화번호 :");
			lbltTelNo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbltTelNo.setBounds(162, 155, 66, 16);
		}
		return lbltTelNo;
	}
	private JLabel getLbltEmail() {
		if (lbltEmail == null) {
			lbltEmail = new JLabel("이메일 :");
			lbltEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lbltEmail.setBounds(162, 195, 66, 16);
		}
		return lbltEmail;
	}
	
	private JTextField getTftName() {
		if (tftName == null) {
			tftName = new JTextField();
			tftName.setEditable(false);
			tftName.setBounds(225, 70, 130, 26);
			tftName.setColumns(10);
		}
		return tftName;
	}
	
	private JTextField getTftNickName() {
		if (tftNickName == null) {
			tftNickName = new JTextField();
			tftNickName.setEditable(false);
			tftNickName.setColumns(10);
			tftNickName.setBounds(225, 111, 130, 26);
		}
		return tftNickName;
	}
	private JTextField getTftTelNo() {
		if (tftTelNo == null) {
			tftTelNo = new JTextField();
			tftTelNo.setEditable(false);
			tftTelNo.setColumns(10);
			tftTelNo.setBounds(225, 150, 219, 26);
		}
		return tftTelNo;
	}
	
	private JTextField getTftEmail() {
		if (tftEmail == null) {
			tftEmail = new JTextField();
			tftEmail.setEditable(false);
			tftEmail.setColumns(10);
			tftEmail.setBounds(225, 190, 219, 26);
		}
		return tftEmail;
	}
	
	private JLabel getLblQnA() {
		if (lblQnA == null) {
			lblQnA = new JLabel("QnA");
			lblQnA.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblQnA.setBounds(40, 261, 66, 26);
		}
		return lblQnA;
	}
	
	private JButton getBtnQnA() {
		if (btnQnA == null) {
			btnQnA = new JButton("작성");
			btnQnA.addActionListener(new ActionListener() {
				
		
				public void actionPerformed(ActionEvent e) {
					/*/
					 * 2021-04-27 권효은
					 * 작성버튼을 누르면 DB cContents에 텍스트 필드에서 작성한 값이 삽입 되어야 함
					 */
			
					insertQnA();
					
					// 삽입이 된 후, 강의 정보 창으로 돌아가기
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frame.dispose();
					
					
				}
			});
			btnQnA.setBounds(397, 531, 117, 29);
		}
		return btnQnA;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(40, 298, 470, 203);
			scrollPane.setViewportView(getTfqContents());
		}
		return scrollPane;
	}
	
	private JTextPane getTfqContents() {
		if (tfqContents == null) {
			tfqContents = new JTextPane();
		}
		return tfqContents;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Img");
			lblNewLabel.setBounds(56, 128, 61, 16);
		}
		return lblNewLabel;
	}
	
	//--------------------------------Method
	
	//강사정보 및 QnA 프레임 보이기
	public void setVisible_tInfo_QnA(boolean h) {
		frame.setVisible(h);
		
	}//setVisible_tInfo_QnA End
	
	
	/*/
	 * 2021-04-28 오전 12:32 _권효은
	 * 강사정보를 받아와서 강사정보 입력!
	 */
	
	public void teacherInfo() {
		
		int cid = DbAction.classid;

		DbActionInfo dbActioninfo = new DbActionInfo(cid);
		Bean2 bean2 = dbActioninfo.teacherInfo();
		
		tftName.setText(bean2.gettName());
		tftNickName.setText(bean2.gettNickName());
		tftTelNo.setText(bean2.gettTelNo());
		tftEmail.setText(bean2.gettEmail());
	
	}//teacherInfo End
	
	
	//QnA 입력하기
	public void insertQnA() {
		
		String qcontents = tfqContents.getText().trim();
		String tEmail = tftEmail.getText();
		
		DbActionInfo dbActioninfo = new DbActionInfo(qcontents,tEmail);
		boolean msg = dbActioninfo.insertQnA(); 
		if(msg== true) {
			
			JOptionPane.showMessageDialog(null,"QnA가 등록되었습니다!" , 
					"입력 완료!", 
					JOptionPane.INFORMATION_MESSAGE);  
			
		}else {
			JOptionPane.showMessageDialog(null,  "에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
					"Critical Error!", 
					JOptionPane.ERROR_MESSAGE); 
			
		}
	}//QnA End
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("취소");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frame.dispose();
				}
			});
			btnCancel.setBounds(281, 531, 117, 29);
		}
		return btnCancel;
	}
}//end
