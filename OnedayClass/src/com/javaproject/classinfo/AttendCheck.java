package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class AttendCheck {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JButton btnCancel;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendCheck window = new AttendCheck();
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
	public AttendCheck() {
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
					 *취소 버튼 누를시 ------> 홈으로 돌아가기 (도영님 부분)
					 */
					//일단은 강의 정보로 가게끔 
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
					 * 
					 */
					
					AttendOk attendOk = new AttendOk();
					attendOk.setVisible_AttendOk(true);
					frame.dispose();
					
					
				}
			});
			btnOk.setBounds(244, 176, 117, 29);
		}
		return btnOk;
	}
	
	
	/*/
	 * 
	 */
	public void setVisible_AttendCheck(boolean h) {
		frame.setVisible(h);
		
	}

}
