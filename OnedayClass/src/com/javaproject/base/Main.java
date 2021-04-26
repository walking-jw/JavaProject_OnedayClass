package com.javaproject.base;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javaproject.classlist.Category;
import com.javaproject.login.SignInView;
import com.javaproject.myclass.StudentMyClass;
import com.javaproject.teacherpage.TeacherMypage;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JButton btnStart;
	private JLabel lblNewLabel;
	private JButton btnDoyoung;
	private JButton btnHyeji;
	private JButton btnHyoeun;
	private JButton btnJaewon;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getBtnStart());
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getBtnDoyoung());
		frame.getContentPane().add(getBtnHyeji());
		frame.getContentPane().add(getBtnHyoeun());
		frame.getContentPane().add(getBtnJaewon());
	}
	private JButton getBtnStart() {
		if (btnStart == null) {
			btnStart = new JButton("START");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			btnStart.setBounds(216, 355, 117, 29);
		}
		return btnStart;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("금손양성소");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 38));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(133, 215, 277, 67);
		}
		return lblNewLabel;
	}
	private JButton getBtnDoyoung() {
		if (btnDoyoung == null) {
			btnDoyoung = new JButton("Doyoung Start");
			btnDoyoung.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					SignInView category = new SignInView();
					category.setVisible_SigninView(true);
					frame.dispose();
					
				}
			});
			btnDoyoung.setBounds(51, 407, 117, 29);
		}
		return btnDoyoung;
	}
	private JButton getBtnHyeji() {
		if (btnHyeji == null) {
			btnHyeji = new JButton("Hyeji Start");
			btnHyeji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentMyClass category = new StudentMyClass();
					category.setVisible_StudentMyClass(true);
					frame.dispose();
		
				}
			});
			btnHyeji.setBounds(182, 407, 117, 29);
		}
		return btnHyeji;
	}
	private JButton getBtnHyoeun() {
		if (btnHyoeun == null) {
			btnHyoeun = new JButton("Hyoeun Start");
			btnHyoeun.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Category category = new Category();
					category.setVisible_Category(true);
					frame.dispose();
					
					
				}
			});
			btnHyoeun.setBounds(311, 407, 117, 29);
		}
		return btnHyoeun;
	}
	private JButton getBtnJaewon() {
		if (btnJaewon == null) {
			btnJaewon = new JButton("Jaewon Start");
			btnJaewon.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TeacherMypage category = new TeacherMypage();
					category.setVisible_TeacherMypage(true);
					frame.dispose();
					
				}
			});
			btnJaewon.setBounds(437, 407, 117, 29);
		}
		return btnJaewon;
	}
}
