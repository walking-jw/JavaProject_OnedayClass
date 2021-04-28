package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;

public class TeacherLectureDetail {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1_1_1;
	private JTextField textField_3;
	private JLabel lblNewLabel_1_1_1_1;
	private JTextField textField_4;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_2;
	private JTable Inner_Table;
	private JButton btn_ViewDetail;

	/**
	 * Create the application.
	 */
	public TeacherLectureDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblNewLabel_1_1());
		frame.getContentPane().add(getTextField_2());
		frame.getContentPane().add(getLblNewLabel_1_1_1());
		frame.getContentPane().add(getTextField_3());
		frame.getContentPane().add(getLblNewLabel_1_1_1_1());
		frame.getContentPane().add(getTextField_4());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtn_ViewDetail());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setBounds(91, 122, 61, 16);
		}
		return lblNewLabel;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(164, 117, 224, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강의명");
			lblNewLabel_1.setBounds(91, 165, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(164, 160, 224, 26);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("강의명");
			lblNewLabel_1_1.setBounds(91, 215, 61, 16);
		}
		return lblNewLabel_1_1;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(164, 210, 224, 26);
		}
		return textField_2;
	}
	private JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1_1 == null) {
			lblNewLabel_1_1_1 = new JLabel("강의명");
			lblNewLabel_1_1_1.setBounds(91, 269, 61, 16);
		}
		return lblNewLabel_1_1_1;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(164, 264, 224, 26);
		}
		return textField_3;
	}
	private JLabel getLblNewLabel_1_1_1_1() {
		if (lblNewLabel_1_1_1_1 == null) {
			lblNewLabel_1_1_1_1 = new JLabel("강의명");
			lblNewLabel_1_1_1_1.setBounds(91, 320, 61, 16);
		}
		return lblNewLabel_1_1_1_1;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(164, 315, 224, 26);
		}
		return textField_4;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(43, 395, 469, 145);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("후기");
			lblNewLabel_2.setBounds(43, 367, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return Inner_Table;
	}
	private JButton getBtn_ViewDetail() {
		if (btn_ViewDetail == null) {
			btn_ViewDetail = new JButton("자세히보기");
			btn_ViewDetail.setBounds(395, 552, 117, 29);
		}
		return btn_ViewDetail;
	}
}
