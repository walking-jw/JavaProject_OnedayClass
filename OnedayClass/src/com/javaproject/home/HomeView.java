package com.javaproject.home;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeView {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnCook;
	private JButton btnBake;
	private JButton btnHandMade;
	private JButton btnArt;
	private JButton btnPhoto;
	private JButton btnProg;
	private JButton btnFlower;
	private JButton btnBeauty;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_8;
	private JButton btnNewButton_8_1;
	private JButton btnNewButton_9;
	private JButton btnNewButton_9_1;
	private JButton btnNewButton_9_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView window = new HomeView();
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
	public HomeView() {
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
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getBtnCook());
		frame.getContentPane().add(getBtnBake());
		frame.getContentPane().add(getBtnHandMade());
		frame.getContentPane().add(getBtnArt());
		frame.getContentPane().add(getBtnPhoto());
		frame.getContentPane().add(getBtnProg());
		frame.getContentPane().add(getBtnFlower());
		frame.getContentPane().add(getBtnBeauty());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getBtnNewButton_8());
		frame.getContentPane().add(getBtnNewButton_8_1());
		frame.getContentPane().add(getBtnNewButton_9());
		frame.getContentPane().add(getBtnNewButton_9_1());
		frame.getContentPane().add(getBtnNewButton_9_2());
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("카테고리");
			lblNewLabel.setBounds(49, 84, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("금손양성소");
			lblNewLabel_1.setBounds(232, 20, 61, 16);
		}
		return lblNewLabel_1;
	}
	private JButton getBtnCook() {
		if (btnCook == null) {
			btnCook = new JButton("요리");
			btnCook.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//요리
				}
			});
			btnCook.setBounds(59, 112, 100, 108);
		}
		return btnCook;
	}
	private JButton getBtnBake() {
		if (btnBake == null) {
			btnBake = new JButton("베이킹");
			btnBake.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//베이킹
				}
			});
			btnBake.setBounds(171, 112, 100, 100);
		}
		return btnBake;
	}
	private JButton getBtnHandMade() {
		if (btnHandMade == null) {
			btnHandMade = new JButton("수공예");
			btnHandMade.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//수공예
				}
			});
			btnHandMade.setBounds(283, 112, 100, 100);
		}
		return btnHandMade;
	}
	private JButton getBtnArt() {
		if (btnArt == null) {
			btnArt = new JButton("미술");
			btnArt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//미술
				}
			});
			btnArt.setBounds(391, 112, 100, 100);
		}
		return btnArt;
	}
	private JButton getBtnPhoto() {
		if (btnPhoto == null) {
			btnPhoto = new JButton("사진");
			btnPhoto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//사진
				}
			});
			btnPhoto.setBounds(59, 232, 100, 108);
		}
		return btnPhoto;
	}
	private JButton getBtnProg() {
		if (btnProg == null) {
			btnProg = new JButton("프로그래밍");
			btnProg.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//프로그래밍
				}
			});
			btnProg.setBounds(171, 232, 100, 108);
		}
		return btnProg;
	}
	private JButton getBtnFlower() {
		if (btnFlower == null) {
			btnFlower = new JButton("플라워");
			btnFlower.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//플라워
				}
			});
			btnFlower.setBounds(283, 232, 100, 108);
		}
		return btnFlower;
	}
	private JButton getBtnBeauty() {
		if (btnBeauty == null) {
			btnBeauty = new JButton("뷰티");
			btnBeauty.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//뷰티
				}
			});
			btnBeauty.setBounds(391, 232, 100, 108);
		}
		return btnBeauty;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("추천");
			lblNewLabel_2.setBounds(49, 387, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JButton getBtnNewButton_8() {
		if (btnNewButton_8 == null) {
			btnNewButton_8 = new JButton("추천1");
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//추천1
				}
			});
			btnNewButton_8.setBounds(49, 415, 222, 87);
		}
		return btnNewButton_8;
	}
	private JButton getBtnNewButton_8_1() {
		if (btnNewButton_8_1 == null) {
			btnNewButton_8_1 = new JButton("추천2");
			btnNewButton_8_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//추천2
				}
			});
			btnNewButton_8_1.setBounds(283, 415, 222, 87);
		}
		return btnNewButton_8_1;
	}
	private JButton getBtnNewButton_9() {
		if (btnNewButton_9 == null) {
			btnNewButton_9 = new JButton("Search");
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//search 
				}
			});
			btnNewButton_9.setBounds(82, 533, 117, 29);
		}
		return btnNewButton_9;
	}
	private JButton getBtnNewButton_9_1() {
		if (btnNewButton_9_1 == null) {
			btnNewButton_9_1 = new JButton("My class");
			btnNewButton_9_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//My class
				}
			});
			btnNewButton_9_1.setBounds(221, 533, 117, 29);
		}
		return btnNewButton_9_1;
	}
	private JButton getBtnNewButton_9_2() {
		if (btnNewButton_9_2 == null) {
			btnNewButton_9_2 = new JButton("Profile");
			btnNewButton_9_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//프로필
				}
			});
			btnNewButton_9_2.setBounds(355, 533, 117, 29);
		}
		return btnNewButton_9_2;
	}
}
