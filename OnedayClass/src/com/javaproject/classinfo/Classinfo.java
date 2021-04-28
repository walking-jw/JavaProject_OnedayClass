package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Classinfo {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblcName;
	private JLabel lbltName;
	private JTextField tfcName;
	private JTextField tftName;
	private JTextField tfcLocation;
	private JTextField textField_1;
	private JLabel lblcTime2;
	private JLabel lblcLocation;
	private JLabel lblcTime;
	private JLabel lblcDate;
	private JTextField textField_2;
	private JLabel lblcContents;
	private JTextField textField_3;
	private JButton btnNewButton;
	private JTextField tfcPrice;
	private JButton btnAttend;

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
		frame.setTitle("금손양성소");
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getLblcName());
		frame.getContentPane().add(getLbltName());
		frame.getContentPane().add(getTfcName());
		frame.getContentPane().add(getTftName());
		frame.getContentPane().add(getTfcLocation());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblcTime2());
		frame.getContentPane().add(getLblcLocation());
		frame.getContentPane().add(getLblcTime());
		frame.getContentPane().add(getLblcDate());
		frame.getContentPane().add(getTextField_2());
		frame.getContentPane().add(getLblcContents());
		frame.getContentPane().add(getTextField_3());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getTfcPrice());
		frame.getContentPane().add(getBtnAttend());
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(24, 6, 510, 210);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblcName() {
		if (lblcName == null) {
			lblcName = new JLabel("강의명");
			lblcName.setBounds(24, 233, 61, 16);
		}
		return lblcName;
	}
	private JLabel getLbltName() {
		if (lbltName == null) {
			lbltName = new JLabel("강사명");
			lbltName.setBounds(24, 263, 61, 16);
		}
		return lbltName;
	}
	private JTextField getTfcName() {
		if (tfcName == null) {
			tfcName = new JTextField();
			tfcName.setEditable(false);
			tfcName.setBounds(127, 228, 394, 26);
			tfcName.setColumns(10);
		}
		return tfcName;
	}
	private JTextField getTftName() {
		if (tftName == null) {
			tftName = new JTextField();
			tftName.setEditable(false);
			tftName.setColumns(10);
			tftName.setBounds(127, 258, 198, 26);
		}
		return tftName;
	}
	private JTextField getTfcLocation() {
		if (tfcLocation == null) {
			tfcLocation = new JTextField();
			tfcLocation.setEditable(false);
			tfcLocation.setColumns(10);
			tfcLocation.setBounds(127, 296, 394, 26);
		}
		return tfcLocation;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(127, 334, 38, 26);
		}
		return textField_1;
	}
	private JLabel getLblcTime2() {
		if (lblcTime2 == null) {
			lblcTime2 = new JLabel("시간");
			lblcTime2.setBounds(172, 339, 29, 16);
		}
		return lblcTime2;
	}
	private JLabel getLblcLocation() {
		if (lblcLocation == null) {
			lblcLocation = new JLabel("장소");
			lblcLocation.setBounds(24, 302, 61, 16);
		}
		return lblcLocation;
	}
	private JLabel getLblcTime() {
		if (lblcTime == null) {
			lblcTime = new JLabel("강의시간");
			lblcTime.setBounds(24, 334, 61, 16);
		}
		return lblcTime;
	}
	private JLabel getLblcDate() {
		if (lblcDate == null) {
			lblcDate = new JLabel("날짜");
			lblcDate.setBounds(24, 367, 61, 16);
		}
		return lblcDate;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(127, 362, 198, 26);
		}
		return textField_2;
	}
	private JLabel getLblcContents() {
		if (lblcContents == null) {
			lblcContents = new JLabel("강의 소개");
			lblcContents.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			lblcContents.setBounds(24, 395, 61, 16);
		}
		return lblcContents;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(24, 417, 510, 70);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("후기");
			btnNewButton.setBounds(416, 499, 117, 29);
		}
		return btnNewButton;
	}
	private JTextField getTfcPrice() {
		if (tfcPrice == null) {
			tfcPrice = new JTextField();
			tfcPrice.setEditable(false);
			tfcPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfcPrice.setBounds(297, 540, 117, 26);
			tfcPrice.setColumns(10);
		}
		return tfcPrice;
	}
	private JButton getBtnAttend() {
		if (btnAttend == null) {
			btnAttend = new JButton("수강신청");
			btnAttend.setBounds(417, 540, 117, 29);
		}
		return btnAttend;
	}
}
