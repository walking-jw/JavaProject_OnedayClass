package com.javaproject.searchpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchView {

	private JFrame frame;
	private JComboBox comboBox;
	private JTextField textField;
	private JButton btnSearch;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private JTable table;

	

	/**
	 * Create the application.
	 */
	public SearchView() {
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
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getTextField());
		frame.getContentPane().add(getBtnSearch());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getScrollPane());
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(28, 39, 100, 27);
		}
		return comboBox;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(137, 38, 234, 26);
			textField.setColumns(10);
		}
		return textField;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//검색
				}
			});
			btnSearch.setBounds(383, 38, 117, 29);
		}
		return btnSearch;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("닫기");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//닫기
				}
			});
			btnCancel.setBounds(396, 538, 117, 29);
		}
		return btnCancel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 83, 463, 423);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//Click
				}
			});
		}
		return table;
	}
}
