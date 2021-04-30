package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import com.javaproject.classlist.DbAction;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AttendCheck {

	//-------------------------------------------Field
		private JFrame frame;
		private JLabel lblNewLabel;
		private JButton btnCancel;
		private JButton btnOk;
		
		//-------------------------------------------Constructor


		/**
		 * Create the application.
		 */
		public AttendCheck() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 450, 300);
			frame.setLocationRelativeTo(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getBtnCancel());
			frame.getContentPane().add(getBtnOk());
		}

		
		
		
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("참석하시겠습니까");
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(98, 81, 223, 37);
			}
			return lblNewLabel;
		}
		private JButton getBtnCancel() {
			if (btnCancel == null) {
				btnCancel = new JButton("취소");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*
						 *취소 버튼 누를시 강의 정보부분으로 돌아가기
						 */
						
						Classinfo classinfo = new Classinfo();
						classinfo.setVisible_Classinfo(true);
						frame.dispose();
					}
				});
				btnCancel.setBounds(57, 176, 117, 29);
			}
			return btnCancel;
		}
		private JButton getBtnOk() {
			if (btnOk == null) {
				btnOk = new JButton("확인");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/*/
						 * 2021-04-29 권효은
						 * 버튼 클릭시, 강의 참석일과 학생의 키값인 이메일 , 해당 강의 id(키값) 이 DB에 들어가고 확인창 띄우기
						 */
						
						ClassAttendAction();
						//확인창 
						AttendOk attendOk = new AttendOk();
						attendOk.setVisible_AttendOk(true);
						frame.dispose();
						
						
					}
				});
				btnOk.setBounds(244, 176, 117, 29);
			}
			return btnOk;
		}
		
		//---------------------------------------------Method
		/*/
		 *  프레임 창 보이게 하는 메소드 (창 내릴때 사용)
		 */
		public void setVisible_AttendCheck(boolean h) {
			frame.setVisible(h);
			
		}//setVisible_AttendCheck End
		
		/*
		 * 2021-04-29 권효은
		 * 강의 수강신청 insert하는 메소드
		 */
		
			private void ClassAttendAction() {
				int cId = DbAction.classid;  // 화면을 계속 연결하기 위해 cid값 가져오기
				DbActionInfo dbActioninfo = new DbActionInfo(cId);
				
				boolean msg = dbActioninfo.AttendOk(); 
				if(msg== true) {
					
					JOptionPane.showMessageDialog(null,"수강 등록되었습니다!" , 
							"입력 완료!", 
							JOptionPane.INFORMATION_MESSAGE);  
					
				}else {
					JOptionPane.showMessageDialog(null,  "에러가 발생했습니다! \n 시스템관리자에 문의하세요!",
							"Critical Error!", 
							JOptionPane.ERROR_MESSAGE); 
					
				}
				
				
			}//ClassAttendAction End


}
