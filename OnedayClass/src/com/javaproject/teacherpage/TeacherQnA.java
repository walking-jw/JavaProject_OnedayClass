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

public class TeacherQnA {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2_1;
	private JTextField tf_QnA_qContents;
	private JLabel lblNewLabel_2_1_1;
	private JButton btn_Answer;
	private JTextField tf_QnA_aContents;
	private JTextField tf_QnA_sEmail;
	private JTextField tf_QnA_qDate;
	private JLabel lblNewLabel_1;

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
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				ClassInfo();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_2_1());
		frame.getContentPane().add(getTf_QnA_qContents());
		frame.getContentPane().add(getLblNewLabel_2_1_1());
		frame.getContentPane().add(getBtn_Answer());
		frame.getContentPane().add(getTf_QnA_aContents());
		frame.getContentPane().add(getTextField_2());
		frame.getContentPane().add(getTextField_1_1());
		frame.getContentPane().add(getLblNewLabel_1_2());
		
		JButton btn_Close = new JButton("닫기");
		btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherQnA_List qna = new TeacherQnA_List();    // * * * * * * * * * * * * * *  
				qna.setVisible_TeacherQnA_List(true);
				frame.dispose();	
				
			}
		});
		btn_Close.setBounds(262, 530, 117, 29);
		frame.getContentPane().add(btn_Close);
	}

	
	
	
	
	
	
	
	// 해당 화면 보이게 하기
	public void setVisible_TeacherQnA(boolean a) {
		frame.setVisible(true);
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("질문자");
			lblNewLabel.setBounds(42, 42, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("질문내용");
			lblNewLabel_2_1.setBounds(42, 108, 61, 16);
		}
		return lblNewLabel_2_1;
	}
	private JTextField getTf_QnA_qContents() {
		if (tf_QnA_qContents == null) {
			tf_QnA_qContents = new JTextField();
			tf_QnA_qContents.setEditable(false);
			tf_QnA_qContents.setBounds(42, 136, 466, 104);
			tf_QnA_qContents.setColumns(10);
		}
		return tf_QnA_qContents;
	}
	private JLabel getLblNewLabel_2_1_1() {
		if (lblNewLabel_2_1_1 == null) {
			lblNewLabel_2_1_1 = new JLabel("답변");
			lblNewLabel_2_1_1.setBounds(42, 256, 61, 16);
		}
		return lblNewLabel_2_1_1;
	}
	private JButton getBtn_Answer() {
		if (btn_Answer == null) {
			btn_Answer = new JButton("답변하기");
			btn_Answer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				UpdateAction_QnA();
					
				TeacherQnA_List qna = new TeacherQnA_List();    // * * * * * * * * * * * * * *  
				qna.setVisible_TeacherQnA_List(true);
				frame.dispose();		
				
				}
			});
			btn_Answer.setBounds(391, 530, 117, 29);
		}
		return btn_Answer;
	}
	private JTextField getTf_QnA_aContents() {
		if (tf_QnA_aContents == null) {
			tf_QnA_aContents = new JTextField();
			tf_QnA_aContents.setBounds(42, 284, 466, 234);
			tf_QnA_aContents.setColumns(10);
		}
		return tf_QnA_aContents;
	}
	private JTextField getTextField_2() {
		if (tf_QnA_sEmail == null) {
			tf_QnA_sEmail = new JTextField();
			tf_QnA_sEmail.setEditable(false);
			tf_QnA_sEmail.setBounds(92, 37, 179, 26);
			tf_QnA_sEmail.setColumns(10);
		}
		return tf_QnA_sEmail;
	}
	private JTextField getTextField_1_1() {
		if (tf_QnA_qDate == null) {
			tf_QnA_qDate = new JTextField();
			tf_QnA_qDate.setEditable(false);
			tf_QnA_qDate.setColumns(10);
			tf_QnA_qDate.setBounds(92, 70, 179, 26);
		}
		return tf_QnA_qDate;
	}
	private JLabel getLblNewLabel_1_2() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("질문일자");
			lblNewLabel_1.setBounds(42, 75, 61, 16);
		}
		return lblNewLabel_1;
	}
	
	// * * * * * * MeThod * * * * * * //
	
	// 해당 창 띄우게 하기
	public void setVisible_QnA(boolean i) {
		frame.setVisible(true);
		
	}
	
	//
	public void ClassInfo() {
		
		String cid = DbAction_List.sName;
		
		DbAction_List dbAction = new DbAction_List(cid);
		
		Bean_QnA bean2 = dbAction.selectList_QnA_Detail();
		
		tf_QnA_sEmail.setText(bean2.getsEmail());
		tf_QnA_qDate.setText(bean2.getqDate());
		tf_QnA_qContents.setText(bean2.getqContents());
		tf_QnA_aContents.setText(bean2.getaContents());
		
		
	}
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
