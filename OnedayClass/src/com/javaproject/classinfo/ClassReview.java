package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ClassReview {

	private JFrame frame;
	private JLabel lblReview;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassReview window = new ClassReview();
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
	public ClassReview() {
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
		frame.getContentPane().add(getLblReview());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnNewButton());
	}
	private JLabel getLblReview() {
		if (lblReview == null) {
			lblReview = new JLabel("강의 후기");
			lblReview.setHorizontalAlignment(SwingConstants.CENTER);
			lblReview.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblReview.setBounds(21, 28, 109, 28);
		}
		return lblReview;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(31, 68, 493, 463);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
		}
		return table;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("닫기");
			btnNewButton.setBounds(407, 545, 117, 29);
		}
		return btnNewButton;
	}
}
