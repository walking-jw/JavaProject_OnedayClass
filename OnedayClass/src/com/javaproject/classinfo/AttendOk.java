package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AttendOk {

	//------------------------------------Field
	private JFrame frame;
	private JButton btnClose;
	private JLabel lblNewLabel;

	
	
	//------------------------------------Constructor

	/**
	 * Create the application.
	 */
	public AttendOk() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnClose());
		frame.getContentPane().add(getLblNewLabel());
	}

	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				
		
				public void actionPerformed(ActionEvent e) {
					
					/*
					 * 닫기 -> 홈으로 가야함!!
					 */
//					Classinfo classinfo = new Classinfo();
//					classinfo.setVisible_Classinfo(true);
//					frame.dispose();
					
				}
			});
			btnClose.setBounds(288, 194, 117, 29);
		}
		return btnClose;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("수강신청이 완료되었습니다.");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(118, 89, 224, 45);
		}
		return lblNewLabel;
	}
	
	
	//------------------------------------Method
	/*/
	 * 2021-04-27 권효은
	 * 확인 프레임 나오게 하기 
	 */
	
	public void setVisible_AttendOk(boolean h) {
		frame.setVisible(h);
		
	}//setVisible_AttendOk End
	
}//end
