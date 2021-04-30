package com.javaproject.base;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javaproject.login.SignIn;
//import com.javaproject.classlist.Category;
import com.javaproject.myclass.StudentMyClass;
import com.javaproject.teacherpage.TeacherMypage;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JButton btnStart;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnStart());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("START");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SignIn signin = new SignIn();
					signin.setVisible_SignIn(true);
					frame.dispose();
				}
			});
			btnStart.setBounds(205, 473, 117, 29);
		}
		return btnStart;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("금손양성소");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(139, 393, 277, 67);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setIcon(new ImageIcon("/Users/hyoeunkwon/Desktop/Hand.png"));
			lblNewLabel_1.setBounds(53, 114, 445, 283);
		}
		return lblNewLabel_1;
	}
}
