package com.javaproject.myclass;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ReviewUpdateDelete {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JRadioButton rd1;
	private JRadioButton rd2;
	private JRadioButton rd3;
	private JRadioButton rd4;
	private JRadioButton rd5;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnCancel;
	private JButton btnRegister;
	private JTextPane tReviewContents;
	private JButton btnRegister_1;


	/**
	 * Create the application.
	 */
	public ReviewUpdateDelete() { // 2021.04.29 조혜지 view - 후기 수정 / 삭제하는 view
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
				ReviewData();
			}
		});
		frame.setTitle("후기 수정 / 삭제");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getRd1());
		frame.getContentPane().add(getRd2());
		frame.getContentPane().add(getRd3());
		frame.getContentPane().add(getRd4());
		frame.getContentPane().add(getRd5());
		frame.getContentPane().add(getBtnCancel());
		frame.getContentPane().add(getBtnRegister());
		frame.getContentPane().add(getBtnRegister_1());
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("후기 수정 / 삭제");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(30, 25, 111, 16);		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 53, 501, 390);
			scrollPane.setViewportView(getTReviewContents());
		}
		return scrollPane;
	}
	private JRadioButton getRd1() {
		if (rd1 == null) {
			rd1 = new JRadioButton("★");
			buttonGroup.add(rd1);
			rd1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			rd1.setForeground(Color.ORANGE);
			rd1.setBounds(41, 472, 86, 23);
		}
		return rd1;
	}
	private JRadioButton getRd2() {
		if (rd2 == null) {
			rd2 = new JRadioButton("★★");
			buttonGroup.add(rd2);
			rd2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			rd2.setForeground(Color.ORANGE);
			rd2.setBounds(127, 472, 86, 23);
		}
		return rd2;
	}
	private JRadioButton getRd3() {
		if (rd3 == null) {
			rd3 = new JRadioButton("★★★");
			buttonGroup.add(rd3);
			rd3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			rd3.setForeground(Color.ORANGE);
			rd3.setBounds(220, 472, 95, 23);
		}
		return rd3;
	}
	private JRadioButton getRd4() {
		if (rd4 == null) {
			rd4 = new JRadioButton("★★★★");
			buttonGroup.add(rd4);
			rd4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			rd4.setForeground(Color.ORANGE);
			rd4.setBounds(316, 472, 87, 23);
		}
		return rd4;
	}
	private JRadioButton getRd5() {
		if (rd5 == null) {
			rd5 = new JRadioButton("★★★★★");
			buttonGroup.add(rd5);
			rd5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			rd5.setForeground(Color.ORANGE);
			rd5.setBounds(426, 472, 105, 23);
		}
		return rd5;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("닫기");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReviewManagement reviewManagement = new ReviewManagement();
					reviewManagement.setVisible_ReviewManagement(true);
					frame.dispose();
				}
			});
			btnCancel.setBounds(456, 519, 75, 29);
		}
		return btnCancel;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("삭제");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReviewDeleteAction();
				}
			});
			btnRegister.setBounds(373, 519, 75, 29);
		}
		return btnRegister;
	}
	
	private JTextPane getTReviewContents() {
		if (tReviewContents == null) {
			tReviewContents = new JTextPane();
		}
		return tReviewContents;
	}

	private JButton getBtnRegister_1() {
		if (btnRegister_1 == null) {
			btnRegister_1 = new JButton("수정");
			btnRegister_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReviewUpdateAction();
				}
			});
			btnRegister_1.setBounds(286, 519, 75, 29);
		}
		return btnRegister_1;
	}
	
	
	// 메소드 시작 ***************************************************************

	
	// 수강관리 페이지와 리뷰 등록 창을 연결하는 메소드
	public void setVisible_ReviewUpdateDelete(boolean h) {
		frame.setVisible(h);
	}
	
	
	 // mysql에 있는 데이터를 view에 불러오는 메소드
	 private void ReviewData() {
			int id = MyClassDbAction.ccId;

			MyClassDbAction dbaction = new MyClassDbAction(id);
	        MyClassBean bean = dbaction.ReviewShowData();
	        
	        tReviewContents.setText(bean.getcReview());
	        if(bean.getcScore()==1) {
	        	rd1.setSelected(true);
	        }else if(bean.getcScore()==2) {
	        	rd2.setSelected(true);
	        }else if(bean.getcScore()==3) {
	        	rd3.setSelected(true);
	        }else if(bean.getcScore()==4) {
	        	rd4.setSelected(true);
	        }else {
	        	rd5.setSelected(true);
	        }

	   }
	
	 // Review를 삭제하는 메소드
	 private void ReviewDeleteAction() {
		 
		 int result = JOptionPane.showConfirmDialog(null, "후기를 삭제하시겠습니까?", "후기 삭제", JOptionPane.YES_NO_OPTION);
		 if(result==JOptionPane.YES_OPTION) {
		 int id = MyClassDbAction.ccId;

		 MyClassDbAction dbAction = new MyClassDbAction(id);
		 boolean aaa = dbAction.reviewDelete();
		 try {
			 if(aaa==true) {
				 JOptionPane.showMessageDialog(null, "후기 삭제가 완료되었습니다!", "삭제 완료!", JOptionPane.INFORMATION_MESSAGE); 
					ReviewManagement reviewManagement = new ReviewManagement();
					reviewManagement.setVisible_ReviewManagement(true);
					frame.dispose();
				 
			 }
			 
		 }catch (Exception e) {
			// TODO: handle exception
			 JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!",
					 "Critical Error!", 
					 JOptionPane.ERROR_MESSAGE); 
		}
		 
			 
		 }

		}
	 
	 // Review를 수정하는 메소드
	 private void ReviewUpdateAction() {
	        int id = MyClassDbAction.ccId;
	        int reviewscore = 0;
	        if(rd1.isSelected()==true) {
	           reviewscore = 1;
	        }else if(rd2.isSelected()==true) {
	           reviewscore = 2;
	        }else if(rd3.isSelected()==true) {
	           reviewscore = 3;
	        }else if(rd4.isSelected()==true) {
	           reviewscore = 4;
	        }else if(rd5.isSelected()==true) {
	           reviewscore = 5;
	        }
	        
	      MyClassDbAction dbAction = new MyClassDbAction(id, tReviewContents.getText().trim(), reviewscore);
	      boolean msg = dbAction.reviewUpdate();
	        try{

	           if(msg == true) {
	              
	              JOptionPane.showMessageDialog(null, "후기 수정이 완료되었습니다!","수정 완료!", JOptionPane.INFORMATION_MESSAGE);
					ReviewManagement reviewManagement = new ReviewManagement();
					reviewManagement.setVisible_ReviewManagement(true);
					frame.dispose();

	           }
	        } catch (Exception e){
	            JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!",
	                                         "Critical Error!", 
	                                         JOptionPane.ERROR_MESSAGE);                    
	            e.printStackTrace();
	        }
	      
	 }
	
}
