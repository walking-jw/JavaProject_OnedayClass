package com.javaproject.classinfo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.javaproject.base.ShareVar;
import com.javaproject.classlist.ClassList;
import com.javaproject.classlist.DbAction;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Classinfo {


		//-----------------------------Field
		
		private JFrame frame;
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private JLabel lblNewLabel_2;
		private JLabel lblNewLabel_3;
		private JLabel lblNewLabel_4;
		private JTextField tfcName;
		private JTextField tfcLocation;
		private JTextField tfcDate;
		private JTextField tfcTime;
		private JButton btntName;
		private JLabel lblNewLabel_5;
		private JLabel lblNewLabel_3_1;
		private JButton btnReview;
		private JButton btnAttend;
		private JLabel lblImage;
		private JTextField tfcPrice;
		private JLabel tfFilePath;
		private JButton btnBackClasslist;
		private JScrollPane scrollPane;
		private JTextPane tfcContents;
		private JLabel lblNewLabel_6;
		private JLabel lblNewLabel_7;
	
		
		//-----------------------------Constructor
		
		
		
		
		/**
		 * Create the application.
		 */
		public Classinfo() {
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
					//window 시작시 정보를 불러와라!
					
					ClassInfo();
	
				}
			});
			frame.setTitle("강의정보");
			frame.setBounds(100, 100, 560, 625);
			frame.setLocationRelativeTo(frame);  //  --------------- 가운데로 보내기
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getLblNewLabel_1());
			frame.getContentPane().add(getLblNewLabel_2());
			frame.getContentPane().add(getLblNewLabel_3());
			frame.getContentPane().add(getLblNewLabel_4());
			frame.getContentPane().add(getTfcName());
			frame.getContentPane().add(getTfcLocation());
			frame.getContentPane().add(getTfcDate());
			frame.getContentPane().add(getTfcTime());
			frame.getContentPane().add(getBtntName());
			frame.getContentPane().add(getLblNewLabel_5());
			frame.getContentPane().add(getLblNewLabel_3_1());
			frame.getContentPane().add(getBtnReview());
			frame.getContentPane().add(getBtnAttend());
			frame.getContentPane().add(getLblImage());
			frame.getContentPane().add(getTfcPrice());
			frame.getContentPane().add(getBtnBackClasslist());
			frame.getContentPane().add(getScrollPane());
			frame.getContentPane().add(getLblNewLabel_6());
			frame.getContentPane().add(getLblNewLabel_7());
		}
		
		
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("강의명");
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel.setBounds(30, 192, 61, 16);
			}
			return lblNewLabel;
		}
		
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("강사");
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(30, 230, 61, 16);
			}
			return lblNewLabel_1;
		}
		
		private JLabel getLblNewLabel_2() {
			if (lblNewLabel_2 == null) {
				lblNewLabel_2 = new JLabel("장소");
				lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(30, 271, 61, 16);
			}
			return lblNewLabel_2;
		}
		
		private JLabel getLblNewLabel_3() {
			if (lblNewLabel_3 == null) {
				lblNewLabel_3 = new JLabel("강의시간");
				lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_3.setBounds(30, 309, 61, 16);
			}
			return lblNewLabel_3;
		}
		
		private JLabel getLblNewLabel_4() {
			if (lblNewLabel_4 == null) {
				lblNewLabel_4 = new JLabel("날짜");
				lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_4.setBounds(30, 346, 61, 16);
			}
			return lblNewLabel_4;
		}
		
		private JTextField getTfcName() {
			if (tfcName == null) {
				tfcName = new JTextField();
				tfcName.setEditable(false);
				tfcName.setBounds(103, 187, 367, 26);
				tfcName.setColumns(10);
			}
			return tfcName;
		}
		
		private JTextField getTfcLocation() {
			if (tfcLocation == null) {
				tfcLocation = new JTextField();
				tfcLocation.setEditable(false);
				tfcLocation.setColumns(10);
				tfcLocation.setBounds(103, 266, 196, 26);
			}
			return tfcLocation;
		}
		
		private JTextField getTfcDate() {
			if (tfcDate == null) {
				tfcDate = new JTextField();
				tfcDate.setEditable(false);
				tfcDate.setColumns(10);
				tfcDate.setBounds(101, 341, 150, 26);
			}
			return tfcDate;
		}
		
		private JTextField getTfcTime() {
			if (tfcTime == null) {
				tfcTime = new JTextField();
				tfcTime.setEditable(false);
				tfcTime.setHorizontalAlignment(SwingConstants.TRAILING);
				tfcTime.setBounds(103, 304, 49, 26);
				tfcTime.setColumns(10);
			}
			return tfcTime;
		}
		
		private JButton getBtntName() {
			if (btntName == null) {
				btntName = new JButton("");
				btntName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						///강사 정보와 QnA창이 뜨게 하기
						TeacherInfo_QnA tInfo_QnA = new TeacherInfo_QnA();
						tInfo_QnA.setVisible_tInfo_QnA(true);
						frame.dispose();
					}
				});
				btntName.setBackground(Color.BLUE);
				btntName.setBounds(103, 225, 117, 29);
			}
			return btntName;
		}
		
		private JLabel getLblNewLabel_5() {
			if (lblNewLabel_5 == null) {
				lblNewLabel_5 = new JLabel("시간");
				lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(152, 309, 30, 16);
			}
			return lblNewLabel_5;
		}
		
		private JLabel getLblNewLabel_3_1() {
			if (lblNewLabel_3_1 == null) {
				lblNewLabel_3_1 = new JLabel("강의소개");
				lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_3_1.setBounds(30, 388, 61, 16);
			}
			return lblNewLabel_3_1;
		}
		
		private JButton getBtnReview() {
			if (btnReview == null) {
				btnReview = new JButton("후기");
				btnReview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//해당 강의에 대한 후기 나오게 하기
						ClassReview classreview = new ClassReview();
						classreview.setVisible_ClassReview(true);
						frame.dispose();
					}
				});
				btnReview.setBounds(408, 384, 117, 29);
			}
			return btnReview;
		}
		
		private JButton getBtnAttend() {
			if (btnAttend == null) {
				btnAttend = new JButton("수강신청");
				btnAttend.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						/*/
						 * 2021-04-27 권효은
						 * 수강신청 버튼 누르면 '신청하겠습니까?'창 나오기
						 *  
						 */
						
						ClassAttendAction();
						
					}
				});
				btnAttend.setBackground(Color.BLUE);
				btnAttend.setBounds(408, 550, 117, 29);
			}
			return btnAttend;
		}
		
		private JLabel getLblImage() {
			if (lblImage == null) {
				lblImage = new JLabel("");
				lblImage.setIcon(new ImageIcon("/Users/hyoeunkwon/Downloads/frame전환.png"));
				lblImage.setHorizontalAlignment(SwingConstants.CENTER);
				lblImage.setBounds(30, 17, 505, 158);
			}
			return lblImage;
		}
		
		private JTextField getTfcPrice() {
			if (tfcPrice == null) {
				tfcPrice = new JTextField();
				tfcPrice.setText("0");
				tfcPrice.setHorizontalAlignment(SwingConstants.TRAILING);
				tfcPrice.setEditable(false);
				tfcPrice.setBounds(407, 512, 90, 26);
				tfcPrice.setColumns(10);
			}
			return tfcPrice;
		}
		
		private JButton getBtnBackClasslist() {
			if (btnBackClasslist == null) {
				btnBackClasslist = new JButton("다른 강의 보기");
				btnBackClasslist.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/*
						 *  2021-04-30 12:08 권효은
						 *  다른강의 리스트 보기위해 뒤로가기
						 */
						
						ClassList classList = new ClassList();
						classList.setVisible_Classinfo(true);
						frame.dispose();
						
					}
				});
				btnBackClasslist.setBounds(293, 550, 117, 29);
			}
			return btnBackClasslist;
		}
		
		private JScrollPane getScrollPane() {
			if (scrollPane == null) {
				scrollPane = new JScrollPane();
				scrollPane.setBounds(30, 416, 495, 83);
				scrollPane.setViewportView(getTfcContents());
			}
			return scrollPane;
		}
		
		private JTextPane getTfcContents() {
			if (tfcContents == null) {
				tfcContents = new JTextPane();
				tfcContents.setEditable(false);
			}
			return tfcContents;
		}
		
		private JLabel getLblNewLabel_6() {
			if (lblNewLabel_6 == null) {
				lblNewLabel_6 = new JLabel("원");
				lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_6.setBounds(498, 517, 30, 16);
			}
			return lblNewLabel_6;
		}
		
		private JLabel getLblNewLabel_7() {
			if (lblNewLabel_7 == null) {
				lblNewLabel_7 = new JLabel("<- 클릭해서 강사님께 질문을 해 보세요 :)");
				lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				lblNewLabel_7.setForeground(Color.GRAY);
				lblNewLabel_7.setBounds(238, 231, 259, 16);
			}
			return lblNewLabel_7;
		}
		
		
		
		//--------------------------------Method
		
		
		// Classinfo frame 보이기/ 감추기
		public void setVisible_Classinfo(boolean h) {
			frame.setVisible(h);
			
		}//setVisible End
	
	
		// -> 해당 강의에 대한 세부정보 가져오기
		public void ClassInfo() {
			
			int cid = ShareVar.cId;
			
			DbActionInfo dbActioninfo = new DbActionInfo(cid);
			Bean2 bean2 = dbActioninfo.ButtonClassInfo();
			
			tfcName.setText(bean2.getcName());
			btntName.setText(bean2.gettName());
			tfcLocation.setText(bean2.getcLocation());
			tfcTime.setText(bean2.getcTime());
			tfcDate.setText(bean2.getcDate());
			tfcContents.setText(bean2.getcContents());
			tfcPrice.setText(Integer.toString(bean2.getcPrice()));
			
			/*/
			 * 2021-04-29 (12:56)
			 * img 불러오기 작업
			 */
		
	        
		      String filePath = Integer.toString(ShareVar.filename);
		      
		      lblImage.setIcon(new ImageIcon(filePath));
		      lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		      
		      File file = new File(filePath);
		      file.delete();
	 
			
		}//ClassInfo End
		
		
		/*
		 * 2021-04-29 권효은
		 * 강의 수강신청 insert하는 메소드
		 */
		
		private void ClassAttendAction() {
			int result = JOptionPane.showConfirmDialog(null, "수강을 신청하시겠습니까?", "수강신청", JOptionPane.YES_NO_OPTION);
			
			if(result==JOptionPane.YES_OPTION) {
				  try {
			int cId = ShareVar.cId;
			DbActionInfo dbActioninfo = new DbActionInfo(cId);
			
			boolean msg = dbActioninfo.AttendOk(); 
			if(msg== true) {
				
				JOptionPane.showMessageDialog(null,"수강 신청되었습니다!" , 
						"신청 완료!", 
						JOptionPane.INFORMATION_MESSAGE);  
				}
				
			}catch (Exception e) {
				// TODO: handle exception
	            JOptionPane.showMessageDialog(null, "자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!",
                       "Critical Error!", 
                       JOptionPane.ERROR_MESSAGE); 
	            e.printStackTrace();
			}

			}//if문 End
		  

			
		}//ClassAttendAction End
		
		
	
	
	
}//end
