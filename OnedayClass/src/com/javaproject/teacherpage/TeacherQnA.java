package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JTextPane;

public class TeacherQnA {

	private JFrame frmQna;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_2_1_1;
	private JButton btn_Answer;
	private JTextField tf_QnA_sEmail;
	private JTextField tf_QnA_qDate;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTextPane tf_QnA_qContents;
	private JScrollPane scrollPane_1;
	private JTextPane tf_QnA_aContents;

	/**
	 * Create the application.
	 */
	public TeacherQnA() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQna = new JFrame();
		frmQna.setTitle("QnA © Copyright 권효은, 박재원, 이도영, 조혜지");
		frmQna.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ClassInfo();
			}
		});
		frmQna.setBounds(100, 100, 560, 625);
		frmQna.setLocationRelativeTo(frmQna);
		frmQna.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQna.getContentPane().setLayout(null);
		frmQna.getContentPane().add(getLblNewLabel());
		frmQna.getContentPane().add(getLblNewLabel_2_1());
		frmQna.getContentPane().add(getLblNewLabel_2_1_1());
		frmQna.getContentPane().add(getBtn_Answer());
		frmQna.getContentPane().add(getTextField_2());
		frmQna.getContentPane().add(getTextField_1_1());
		frmQna.getContentPane().add(getLblNewLabel_1_2());
		
		JButton btn_Close = new JButton("닫기");
		btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherQnA_List qna = new TeacherQnA_List();    // * * * * * * * * * * * * 이전페이지로 돌아가기
				qna.setVisible_TeacherQnA_List(true);
				frmQna.dispose();	
				
			}
		});
		btn_Close.setBounds(262, 542, 117, 29);
		frmQna.getContentPane().add(btn_Close);
		frmQna.getContentPane().add(getScrollPane());
		frmQna.getContentPane().add(getScrollPane_1());
	}
	
	// 해당 화면 보이게 하기
	public void setVisible_TeacherQnA(boolean a) {
		frmQna.setVisible(true);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("질문자");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(131, 45, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("질문내용");
			lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_2_1.setBounds(42, 129, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("답변");
			lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_2_1_1.setBounds(42, 279, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JButton getBtn_Answer() {
		if (btn_Answer == null) {
			btn_Answer = new JButton("답변하기");
			btn_Answer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				UpdateAction_QnA();
					
				TeacherQnA_List qna = new TeacherQnA_List();    // * * * * * * * * * * * * * 답변달면 이전페이지로 돌아가기
				qna.setVisible_TeacherQnA_List(true);
				frmQna.dispose();		
				
				}
			});
			btn_Answer.setBounds(391, 542, 117, 29);
		}
		return btn_Answer;
	}
	private JTextField getTextField_2() {
		if (tf_QnA_sEmail == null) {
			tf_QnA_sEmail = new JTextField();
			tf_QnA_sEmail.setEditable(false);
			tf_QnA_sEmail.setBounds(190, 41, 179, 26);
			tf_QnA_sEmail.setColumns(10);
		}
		return tf_QnA_sEmail;
	}
	private JTextField getTextField_1_1() {
		if (tf_QnA_qDate == null) {
			tf_QnA_qDate = new JTextField();
			tf_QnA_qDate.setEditable(false);
			tf_QnA_qDate.setColumns(10);
			tf_QnA_qDate.setBounds(190, 73, 179, 26);
		}
		return tf_QnA_qDate;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("질문일자");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(131, 77, 61, 16);
		}
		return lblNewLabel_1;
	}
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(42, 157, 456, 100);
			scrollPane.setViewportView(getTf_QnA_qContents());
		}
		return scrollPane;
	}
	private JTextPane getTf_QnA_qContents() {
		if (tf_QnA_qContents == null) {
			tf_QnA_qContents = new JTextPane();
			tf_QnA_qContents.setEditable(false);
		}
		return tf_QnA_qContents;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(42, 307, 456, 216);
			scrollPane_1.setViewportView(getTf_QnA_aContents());
		}
		return scrollPane_1;
	}
	private JTextPane getTf_QnA_aContents() {
		if (tf_QnA_aContents == null) {
			tf_QnA_aContents = new JTextPane();
		}
		return tf_QnA_aContents;
	}
	
	// MeThod * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	
	// 해당 창 띄우게 하기
	public void setVisible_QnA(boolean i) {
		frmQna.setVisible(true);
		
	}
	
	// 질문 내용 가져오기
	public void ClassInfo() {
		
		String cid = DbAction_List.sName;
		
		DbAction_List dbAction = new DbAction_List(cid);
		
		Bean_QnA bean2 = dbAction.selectList_QnA_Detail();
		
		tf_QnA_sEmail.setText(bean2.getsEmail());
		tf_QnA_qDate.setText(bean2.getqDate());
		tf_QnA_qContents.setText(bean2.getqContents());
		tf_QnA_aContents.setText(bean2.getaContents());
		
		
	}
	
	// aContents 채우고 Update하기
	private void UpdateAction_QnA() {
		
		String sEmail = tf_QnA_sEmail.getText().trim();
		String qDate = tf_QnA_qDate.getText().trim();
		String qContents = tf_QnA_qContents.getText();
		String aContents = tf_QnA_aContents.getText();
		
		DbAction_List db = new DbAction_List(sEmail, qDate, qContents, aContents);
		boolean msg = db.UpdateAction_QnA();
		if (msg==true) {
			JOptionPane.showMessageDialog(null, "답변을 달았습니다!");
		}else {
			JOptionPane.showInputDialog(this, "답변중 오류가 발생했습니다!");
		}
		
	}
}
