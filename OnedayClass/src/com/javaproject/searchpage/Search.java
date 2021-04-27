package com.javaproject.searchpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search {

	private JFrame frame;
	private JTextField tfSearch;
	private JTable table;

	/**
	 * Create the application.
	 */
	public Search() {
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
		
		JComboBox cbSearch = new JComboBox();
		cbSearch.setBounds(29, 41, 118, 27);
		frame.getContentPane().add(cbSearch);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(164, 40, 249, 26);
		frame.getContentPane().add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnSearch = new JButton("New button");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Search
				
			}
		});
		btnSearch.setBounds(425, 40, 117, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton btnCancel = new JButton("New button");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Cancel
				
			}
		});
		btnCancel.setBounds(405, 544, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 90, 484, 431);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
}
