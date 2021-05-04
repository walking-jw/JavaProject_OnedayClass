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
import java.awt.Font;

public class HomeView {

	private JFrame frmCopyright;
	private JLabel lblNewLabel_1;
	private JButton btnShowClass;
	private JLabel lblNewLabel_2;
	private JButton btnRecOne;
	private JButton btnShowSearch;
	private JButton btnShowMyClass;
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
		frmCopyright = new JFrame();
		frmCopyright.setTitle("금손양성소 © Copyright 권효은, 박재원, 이도영, 조혜지");
		frmCopyright.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				//applyFirstRecommnd();
				//applySecondRecommnd();
				applyRecommend();
			}
		});
		frmCopyright.setBounds(100, 100, 560, 625);
		frmCopyright.setLocationRelativeTo(frmCopyright);
		frmCopyright.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCopyright.getContentPane().setLayout(null);
		frmCopyright.getContentPane().add(getBtnShowClass());
		frmCopyright.getContentPane().add(getLblNewLabel_2());
		frmCopyright.getContentPane().add(getBtnRecOne());
		frmCopyright.getContentPane().add(getBtnShowSearch());
		frmCopyright.getContentPane().add(getBtnShowMyClass());
		frmCopyright.getContentPane().add(getBtnNewButton_9_2());
		frmCopyright.getContentPane().add(getLblFirstRecClassName());
		frmCopyright.getContentPane().add(getLblSecondRecClassName());
		frmCopyright.getContentPane().add(getBtnRecTwo());
		frmCopyright.getContentPane().add(getLblNewLabel_1());
		frmCopyright.getContentPane().add(getLblNewLabel());
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("/Users/ido/Desktop/Project_source_img/Artboard – 1-2.png"));
			lblNewLabel_1.setBounds(0, 50, 560, 170);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnShowClass() {
		if (btnShowClass == null) {
			btnShowClass = new JButton("All Class");
			btnShowClass.setFont(new Font("SF Pro", Font.PLAIN, 13));
			btnShowClass.setIcon(null);
			btnShowClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ClassList classlist = new ClassList();
					classlist.setVisible_Classinfo(true);
					frmCopyright.dispose();
					
					//수강목
				}
			});
			btnShowClass.setBounds(174, 8, 95, 29);
		}
		return btnShowClass;
	}
	
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("이 강의는 어떤가요?");
			lblNewLabel_2.setFont(new Font("SF Pro Text", Font.BOLD, 15));
			lblNewLabel_2.setBounds(30, 229, 159, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnRecOne() {
		if (btnRecOne == null) {
			btnRecOne = new JButton("");
			btnRecOne.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//추천1
					ShareVar.cId = firstRecommendClassId;
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frmCopyright.dispose();
				}
			});
			btnRecOne.setBounds(30, 257, 500, 135);
		}
		return btnRecOne;
	}
	private JButton getBtnShowSearch() {
		if (btnShowSearch == null) {
			btnShowSearch = new JButton("Search");
			btnShowSearch.setFont(new Font("SF Pro", Font.PLAIN, 13));
			btnShowSearch.setIcon(null);
			btnShowSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//search 
					segueToSearch();
				}
			});
			btnShowSearch.setBounds(269, 8, 95, 29);
		}
		return btnShowSearch;
	}
	
	private JButton getBtnShowMyClass() {
		if (btnShowMyClass == null) {
			btnShowMyClass = new JButton("My Class");
			btnShowMyClass.setFont(new Font("SF Pro", Font.PLAIN, 13));
			btnShowMyClass.setIcon(null);
			btnShowMyClass.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					StudentMyClass stumyclass = new StudentMyClass();
					stumyclass.setVisible_StudentMyClass(true);
					frmCopyright.dispose();
				}
			});
			btnShowMyClass.setBounds(364, 7, 95, 30);
		}
		return btnShowMyClass;
	}
	
	private JButton getBtnNewButton_9_2() {
		if (btnNewButton_9_2 == null) {
			btnNewButton_9_2 = new JButton("My Profile");
			btnNewButton_9_2.setFont(new Font("SF Pro", Font.PLAIN, 13));
			btnNewButton_9_2.setIcon(null);
			btnNewButton_9_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//프로필
					StudentProfile profile = new StudentProfile();
					profile.setVisible_StudentProfile(true);
					frmCopyright.dispose();
				}
			});
			btnNewButton_9_2.setBounds(459, 8, 95, 30);
		}
		return btnNewButton_9_2;
	}
	
	private JLabel getLblFirstRecClassName() {
		if (lblFirstRecClassName == null) {
			lblFirstRecClassName = new JLabel("New label");
			lblFirstRecClassName.setFont(new Font("SF Pro", Font.PLAIN, 14));
			lblFirstRecClassName.setBounds(35, 394, 320, 16);
		}
		return lblFirstRecClassName;
	}
	private JLabel getLblSecondRecClassName() {
		if (lblSecondRecClassName == null) {
			lblSecondRecClassName = new JLabel("New label");
			lblSecondRecClassName.setFont(new Font("SF Pro", Font.PLAIN, 14));
			lblSecondRecClassName.setBounds(35, 564, 341, 16);
		}
		return lblSecondRecClassName;
	}
	private JButton getBtnRecTwo() {
		if (btnRecTwo == null) {
			btnRecTwo = new JButton("");
			btnRecTwo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//
					ShareVar.cId = secondRecommendClassId;
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frmCopyright.dispose();
				}
			});
			btnRecTwo.setBounds(30, 424, 500, 135);
		}
		return btnRecTwo;
	}
	//Method
	int firstRecommendClassId;
	int secondRecommendClassId;
	private JButton btnRecTwo;
	private JLabel lblNewLabel;
	
//	public void applyFirstRecommnd() {
//		DbHomeAction dbHomeAction = new DbHomeAction();
//		HomeBean bean = dbHomeAction.recommandClassOne();
//		
//		firstRecommendClassId = bean.getId();
//		lblFirstRecClassName.setText(bean.getName());
//		
//		String filePath = Integer.toString(ShareVar.filename);
//		btnRecOne.setIcon(new ImageIcon(filePath));;
//		btnRecOne.setHorizontalAlignment(SwingConstants.CENTER);
//		File file = new File(filePath);
//		file.delete();
//	}
	
//	public void applySecondRecommnd() {
//		DbHomeAction dbHomeAction = new DbHomeAction();
//		HomeBean bean = dbHomeAction.recommandClassOne();
//		
//		secondRecommendClassId = bean.getId();
//		lblSecondRecClassName.setText(bean.getName());
//		
//		String filePath = Integer.toString(ShareVar.filename);
//		btnRecTwo.setIcon(new ImageIcon(filePath));;
//		btnRecTwo.setHorizontalAlignment(SwingConstants.CENTER);
//		File file = new File(filePath);
//		file.delete();
//	}
		
	public void applyRecommend() {
		DbHomeAction dbHomeAction = new DbHomeAction();
		ArrayList<HomeBean> beanList = dbHomeAction.recommendClass();
		firstRecommendClassId = beanList.get(0).getId();
		secondRecommendClassId = beanList.get(1).getId();
		
		lblFirstRecClassName.setText(beanList.get(0).getName());
		lblSecondRecClassName.setText(beanList.get(1).getName());
		
		String filePath1 = Integer.toString(ShareVar.filename - 1);
		btnRecOne.setIcon(new ImageIcon(filePath1));;
		btnRecOne.setHorizontalAlignment(SwingConstants.CENTER);
		File file1 = new File(filePath1);
		file1.delete();
		
		String filePath2 = Integer.toString(ShareVar.filename);
		btnRecTwo.setIcon(new ImageIcon(filePath2));;
		btnRecTwo.setHorizontalAlignment(SwingConstants.CENTER);
		File file2 = new File(filePath2);
		file2.delete();
	}
	public void setVisible_HomeView(boolean b) {
		frmCopyright.setVisible(b);
	}
	
	public void segueToSearch() {
		SearchView searchView = new SearchView();
		searchView.setVisible_SearchView(true);
		frmCopyright.dispose();
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("금손양성소");
			lblNewLabel.setFont(new Font("SF Pro", Font.BOLD, 13));
			lblNewLabel.setBounds(30, 16, 95, 16);
		}
		return lblNewLabel;
	}
}
