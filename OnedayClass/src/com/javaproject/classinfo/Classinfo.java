package com.javaproject.classinfo;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import com.javaproject.classlist.DbAction;

public class Classinfo {

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
	private JTextField tfcContents;
	private JButton btnReview;
	private JButton btnAttend;
	private JLabel lblNewLabel_6;
	private JTextField tfcPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classinfo window = new Classinfo();
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
		frame.setTitle("금손양성소");
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
		frame.getContentPane().add(getTfcContents());
		frame.getContentPane().add(getBtnReview());
		frame.getContentPane().add(getBtnAttend());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getTfcPrice());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setBounds(30, 206, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강사");
			lblNewLabel_1.setBounds(30, 243, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("장소");
			lblNewLabel_2.setBounds(30, 284, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("강의시간");
			lblNewLabel_3.setBounds(30, 324, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("날짜");
			lblNewLabel_4.setBounds(30, 358, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JTextField getTfcName() {
		if (tfcName == null) {
			tfcName = new JTextField();
			tfcName.setEditable(false);
			tfcName.setBounds(103, 201, 394, 26);
			tfcName.setColumns(10);
		}
		return tfcName;
	}
	private JTextField getTfcLocation() {
		if (tfcLocation == null) {
			tfcLocation = new JTextField();
			tfcLocation.setEditable(false);
			tfcLocation.setColumns(10);
			tfcLocation.setBounds(103, 274, 394, 26);
		}
		return tfcLocation;
	}
	private JTextField getTfcDate() {
		if (tfcDate == null) {
			tfcDate = new JTextField();
			tfcDate.setEditable(false);
			tfcDate.setColumns(10);
			tfcDate.setBounds(103, 353, 394, 26);
		}
		return tfcDate;
	}
	private JTextField getTfcTime() {
		if (tfcTime == null) {
			tfcTime = new JTextField();
			tfcTime.setBounds(103, 319, 39, 26);
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
			btntName.setBackground(new Color(240, 230, 140));
			btntName.setBounds(102, 238, 117, 29);
		}
		return btntName;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("시간");
			lblNewLabel_5.setBounds(145, 324, 30, 16);
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("강의소개");
			lblNewLabel_3_1.setBounds(30, 395, 61, 16);
		}
		return lblNewLabel_3_1;
	}
	private JTextField getTfcContents() {
		if (tfcContents == null) {
			tfcContents = new JTextField();
			tfcContents.setEditable(false);
			tfcContents.setBounds(30, 423, 505, 82);
			tfcContents.setColumns(10);
		}
		return tfcContents;
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
			btnReview.setBounds(418, 517, 117, 29);
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
					
					AttendCheck attendCheck = new AttendCheck();
					attendCheck.setVisible_AttendCheck(true);
					frame.dispose();
					
				}
			});
			btnAttend.setBackground(Color.BLUE);
			btnAttend.setBounds(418, 558, 117, 29);
		}
		return btnAttend;
	}
	
	
	/*/
	 * 
	 */
	public void setVisible_Classinfo(boolean h) {
		frame.setVisible(h);
		
	}


	// -> 해당 강의에 대한 세부정보 가져오기
	public void ClassInfo() {
		
		int cid = DbAction.classid;
		
		DbActionInfo dbActioninfo = new DbActionInfo(cid);
		Bean2 bean2 = dbActioninfo.ButtonClassInfo();
		
		tfcName.setText(bean2.getcName());
		btntName.setText(bean2.gettName());
		tfcLocation.setText(bean2.getcLocation());
		tfcTime.setText(bean2.getcTime());
		tfcDate.setText(bean2.getcDate());
		tfcContents.setText(bean2.getcContents());
		tfcPrice.setText(Integer.toString(bean2.getcPrice()));
		
		
	}//ClassInfo End
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_6.setBounds(30, 17, 505, 158);
		}
		return lblNewLabel_6;
	}
	private JTextField getTfcPrice() {
		if (tfcPrice == null) {
			tfcPrice = new JTextField();
			tfcPrice.setText("0");
			tfcPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfcPrice.setEditable(false);
			tfcPrice.setBounds(286, 558, 130, 26);
			tfcPrice.setColumns(10);
		}
		return tfcPrice;
	}
	
	// ------- 이미지 test

}
