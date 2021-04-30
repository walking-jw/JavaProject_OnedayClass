package com.javaproject.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.javaproject.base.ShareVar;
import com.javaproject.classinfo.Classinfo;
import com.javaproject.classlist.ClassList;
import com.javaproject.myclass.StudentMyClass;
import com.javaproject.searchpage.SearchView;
import com.javaproject.studentpage.StudentProfile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class HomeView {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JButton btnShowClass;
	private JLabel lblNewLabel_2;
	private JButton btnRecOne;
	private JButton btnNewButton_9;
	private JButton btnNewButton_9_1;
	private JButton btnNewButton_9_2;
	private JLabel lblFirstRecClassName;
	private JLabel lblSecondRecClassName;

	

	/**
	 * Create the application.
	 */
	public HomeView() {
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
				applyFirstRecommnd();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnShowClass());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnRecOne());
		frame.getContentPane().add(getBtnNewButton_9());
		frame.getContentPane().add(getBtnNewButton_9_1());
		frame.getContentPane().add(getBtnNewButton_9_2());
		frame.getContentPane().add(getLblFirstRecClassName());
		frame.getContentPane().add(getLblSecondRecClassName());
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("금손양성소");
			lblNewLabel_1.setBounds(232, 20, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnShowClass() {
		if (btnShowClass == null) {
			btnShowClass = new JButton("강의리스트");
			btnShowClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ClassList classlist = new ClassList();
					classlist.setVisible_Classinfo(true);
					frame.dispose();
					
					//수강목
				}
			});
			btnShowClass.setBounds(49, 497, 222, 35);
		}
		return btnShowClass;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("첫번째 추천!");
			lblNewLabel_2.setBounds(49, 75, 86, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnRecOne() {
		if (btnRecOne == null) {
			btnRecOne = new JButton("");
			btnRecOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//추천1
					ShareVar.cId = firstRecommndClassId;
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frame.dispose();
				}
			});
			btnRecOne.setBounds(49, 103, 456, 137);
		}
		return btnRecOne;
	}
	private JButton getBtnNewButton_9() {
		if (btnNewButton_9 == null) {
			btnNewButton_9 = new JButton("검색");
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//search 
					segueToSearch();
				}
			});
			btnNewButton_9.setBounds(290, 497, 215, 35);
		}
		return btnNewButton_9;
	}
	private JButton getBtnNewButton_9_1() {
		if (btnNewButton_9_1 == null) {
			btnNewButton_9_1 = new JButton("My class");
			btnNewButton_9_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentMyClass stumyclass = new StudentMyClass();
					stumyclass.setVisible_StudentMyClass(true);
					frame.dispose();
					
					//My class
				}
			});
			btnNewButton_9_1.setBounds(49, 544, 222, 35);
		}
		return btnNewButton_9_1;
	}
	private JButton getBtnNewButton_9_2() {
		if (btnNewButton_9_2 == null) {
			btnNewButton_9_2 = new JButton("Profile");
			btnNewButton_9_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//프로필
					StudentProfile profile = new StudentProfile();
					profile.setVisible_StudentProfile(true);
					frame.dispose();
				}
			});
			btnNewButton_9_2.setBounds(289, 544, 216, 35);
		}
		return btnNewButton_9_2;
	}
	
	//Method
	int firstRecommndClassId;
	int secondRecommandClassId;
	
	public void applyFirstRecommnd() {
		DbHomeAction dbHomeAction = new DbHomeAction();
		HomeBean bean = dbHomeAction.recommandClassOne();
		
		firstRecommndClassId = bean.getId();
		lblFirstRecClassName.setText(bean.getName());
		
		String filePath = Integer.toString(ShareVar.filename);
		btnRecOne.setIcon(new ImageIcon(filePath));;
		btnRecOne.setHorizontalAlignment(SwingConstants.CENTER);
		File file = new File(filePath);
		file.delete();
	}
	
//	public void applyTwoRecommnd() {
//		DbHomeAction dbHomeAction = new DbHomeAction();
//		HomeBean bean = dbHomeAction.recommandClassTwo();
//		secondRecommandClassId = bean.getId();
//		lblSecondRecClassName.setText(bean.getName());
//		String filePath = Integer.toString(ShareVar.filename);
//		btnRecTwo.setIcon(new ImageIcon(filePath));;
//		btnRecTwo.setHorizontalAlignment(SwingConstants.CENTER);
//		File file = new File(filePath);
//		file.delete();
//	}
	
	public void setVisible_HomeView(boolean b) {
		frame.setVisible(b);
	}
	
	public void segueToSearch() {
		SearchView searchView = new SearchView();
		searchView.setVisible_SearchView(true);
		frame.dispose();
	}
//	public void segueMyClass() {
//		SearchView searchView = new SearchView();
//		searchView.setVisible_SearchView(true);
//		frame.dispose();
//	}
	
//	public void segueToProfile() {
//		SearchView searchView = new SearchView();
//		searchView.setVisible_SearchView(true);
//		frame.dispose();
//	}
	
	private JLabel getLblFirstRecClassName() {
		if (lblFirstRecClassName == null) {
			lblFirstRecClassName = new JLabel("New label");
			lblFirstRecClassName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblFirstRecClassName.setBounds(49, 252, 456, 16);
		}
		return lblFirstRecClassName;
	}
	private JLabel getLblSecondRecClassName() {
		if (lblSecondRecClassName == null) {
			lblSecondRecClassName = new JLabel("New label");
			lblSecondRecClassName.setHorizontalAlignment(SwingConstants.TRAILING);
			lblSecondRecClassName.setBounds(59, 430, 446, 16);
		}
		return lblSecondRecClassName;
	}
}
