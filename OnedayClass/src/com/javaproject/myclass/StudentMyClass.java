package com.javaproject.myclass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaproject.teacherpage.RUDDbAction;
import com.javaproject.teacherpage.TeacherClassRegister;
import com.javaproject.teacherpage.TeacherClassUpdateDelete;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class StudentMyClass { // 2021.04.26 조혜지 view - 수강 예정과 수강 이력 데이터 테이블표에 불러오기 & 수강 예정 강의 수강 신청 취소하기
	
		private JFrame frame;
		private JLabel lblNewLabel;
		private JScrollPane scrollPane;
		private JTable Inner_Table_After;
		private JButton btnCancle;
		private JLabel lblNewLabel_1;
		private JScrollPane scrollPane_1;
		private JButton btnReview;
		private JTable Inner_Table_Before;
		// OuterTable 초기 설정
		private final DefaultTableModel Outer_Table_After = new DefaultTableModel();
		private final DefaultTableModel Outer_Table_Before = new DefaultTableModel();
		private JButton btnClose;

	
	
		/**
		 * Create the application.
		 */
		public StudentMyClass() {
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
					// 창 뜨자마자 불러온 데이터를 보이게 하기 위해 아래의 4개 메소드 삽입
					TableInitAfter();
					TableInitBefore();
					SearchActionAfter();
					SearchActionBefore();
				}
			});
			frame.setTitle("수강관리");
			frame.setBounds(100, 100, 560, 625);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getScrollPane());
			frame.getContentPane().add(getBtnCancle());
			frame.getContentPane().add(getLblNewLabel_1());
			frame.getContentPane().add(getScrollPane_1());
			frame.getContentPane().add(getBtnReview());
			frame.getContentPane().add(getBtnClose());
		}
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("수강 예정");
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel.setBounds(30, 25, 86, 16);
			}
			return lblNewLabel;
		}
		private JScrollPane getScrollPane() {
			if (scrollPane == null) {
				scrollPane = new JScrollPane();
				scrollPane.setBounds(30, 53, 501, 202);
				scrollPane.setViewportView(getInner_Table_After());
			}
			return scrollPane;
		}
		private JTable getInner_Table_After() {
			if (Inner_Table_After == null) {
				Inner_Table_After = new JTable();
				Inner_Table_After.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				Inner_Table_After.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// InnerTable과 OuterTable연결 (수강 예정)
				Inner_Table_After.setModel(Outer_Table_After);
				
			}
			return Inner_Table_After;
		}
		private JButton getBtnCancle() {
			if (btnCancle == null) {
				btnCancle = new JButton("수강 취소");
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CancleClick();
					}
				});
				btnCancle.setBounds(445, 267, 86, 29);
			}
			return btnCancle;
		}
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("수강 이력");
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(30, 306, 86, 16);
			}
			return lblNewLabel_1;
		}
		private JScrollPane getScrollPane_1() {
			if (scrollPane_1 == null) {
				scrollPane_1 = new JScrollPane();
				scrollPane_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

					}
				});
				scrollPane_1.setBounds(30, 334, 501, 202);
				scrollPane_1.setViewportView(getInner_Table_Before());
			}
			return scrollPane_1;
		}
		private JButton getBtnReview() {
			if (btnReview == null) {
				btnReview = new JButton("후기 관리");
				btnReview.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
//						ReviewManagement management = new ReviewManagement();
//						management.setVisible_ReviewManagement(true);
//						frame.dispose();
						
						// 아래 7줄은 재원님꺼와 연결 시 바로 삭제하기
						RUDDbAction.ccId = ReviewSub();
//						
						TeacherClassUpdateDelete delete = new TeacherClassUpdateDelete();
						delete.setVisible_TeacherClassUpdateDelete(true);
						frame.dispose();

//						TeacherClassRegister register = new TeacherClassRegister();
//						register.setVisible_TeacherClassRegister(true);
//						frame.dispose();
						
					}
				});
				btnReview.setBounds(347, 548, 86, 29);
			}
			return btnReview;
		}
		private JTable getInner_Table_Before() {
			if (Inner_Table_Before == null) {
				Inner_Table_Before = new JTable();
				Inner_Table_Before.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				Inner_Table_Before.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// InnerTable과 OuterTable연결 (수강 이력)
				Inner_Table_Before.setModel(Outer_Table_Before);
			}
	
			return Inner_Table_Before;
		}
		
		private JButton getBtnClose() {
			if (btnClose == null) {
				btnClose = new JButton("닫기");
				btnClose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 도영님과 연결하기
					}
				});
				btnClose.setBounds(445, 548, 86, 29);
			}
			return btnClose;
		}
		
		// 메소드 시작 ***************************************************************
		
		// 메인과 해당 창을 연결하는 메소드
		public void setVisible_StudentMyClass(boolean j) {
			frame.setVisible(j);
		}
		
		// 수강 예정 테이블 초기화
		private void TableInitAfter(){
		       int i = Outer_Table_After.getRowCount();
		       
		       Outer_Table_After.addColumn("강의ID");
		       Outer_Table_After.addColumn("신청날짜");
		       Outer_Table_After.addColumn("강의명");
		       Outer_Table_After.addColumn("수강날짜");
		       Outer_Table_After.addColumn("장소");
		       Outer_Table_After.addColumn("가격");
		       Outer_Table_After.setColumnCount(6);
	
		       for(int j = 0 ; j < i ; j++){
		           Outer_Table_After.removeRow(0);
		       }
	
		       Inner_Table_After.setAutoResizeMode(Inner_Table_After.AUTO_RESIZE_OFF);
		       
	
		       int vColIndex = 0;
		       TableColumn col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       int width = 40;
		       col.setPreferredWidth(width);
	
		       vColIndex = 1;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 100;
		       col.setPreferredWidth(width);
		       
		       vColIndex = 2;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 120;
		       col.setPreferredWidth(width);
	
		       vColIndex = 3;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 100;
		       col.setPreferredWidth(width);
		       
		       vColIndex = 4;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 70;
		       col.setPreferredWidth(width);
		     
		       vColIndex = 5;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 65;
		       col.setPreferredWidth(width);

		 }
		
		// 수강 이력 테이블 초기화
		 private void TableInitBefore(){
	
		     int k = Outer_Table_Before.getRowCount();
		     
		     Outer_Table_Before.addColumn("강의ID");
		     Outer_Table_Before.addColumn("신청날짜");
		     Outer_Table_Before.addColumn("강의명");
		     Outer_Table_Before.addColumn("수강날짜");
		     Outer_Table_Before.addColumn("장소");
		     Outer_Table_Before.addColumn("가격");
		     Outer_Table_Before.setColumnCount(6);
		     
		     for(int j = 0 ; j < k ; j++){
		       Outer_Table_Before.removeRow(0);
		       }
	
		     Inner_Table_Before.setAutoResizeMode(Inner_Table_Before.AUTO_RESIZE_OFF);
	
		     int vColIndex = 0;
		     TableColumn col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     int width = 40;
		     col.setPreferredWidth(width);
		 
		     vColIndex = 1;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 100;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 2;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 120;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 3;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 100;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 4;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 70;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 5;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 65;
		     col.setPreferredWidth(width);
		     
		 }
	
		 // 수강 예정 데이터 불러오기
		 private void SearchActionAfter(){

		     MyClassDbAction dbAction = new MyClassDbAction();
		     ArrayList<MyClassBean> beanList = dbAction.selectListAfter();
		     
		     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String temp1 = Integer.toString(beanList.get(i).getcId());
		       String temp2 = NumberFormat.getInstance().format(beanList.get(i).getcPrice()) + "원";
		       
		       String[] qTxt = {temp1, beanList.get(i).getcAttendDate(), beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation(), temp2};
		       Outer_Table_After.addRow(qTxt);

		     }

		 }
		 
		 // 수강 이력 데이터 불러오기
		 private void SearchActionBefore(){
		     
		     MyClassDbAction dbAction = new MyClassDbAction();
		     ArrayList<MyClassBean> beanList = dbAction.selectListBefore();
		     
		     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String temp1 = Integer.toString(beanList.get(i).getcId());
		       String temp2 = NumberFormat.getInstance().format(beanList.get(i).getcPrice()) + "원";
		       
		       String[] qTxt = {temp1, beanList.get(i).getcAttendDate(), beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation(), temp2};
		       Outer_Table_Before.addRow(qTxt);

		     }


		 }
		
		 // 수강 신청 취소하기
		 private void CancleClick() {
			 int result = JOptionPane.showConfirmDialog(null, "수강을 취소하시겠습니까?", "수강 취소", JOptionPane.YES_NO_OPTION);
			  if(result==JOptionPane.YES_OPTION) {
				  try {

						  Date date = new Date();
						  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						  String today = sdf.format(date);
						  int row = Inner_Table_After.getSelectedRow();
						  String classDate = (String)Inner_Table_After.getValueAt(row, 3);
						  
						  Date currentDate = sdf.parse(today);
						  Date afterDate = sdf.parse(classDate);
						  
						  long diffDay = (afterDate.getTime() - currentDate.getTime()) / (24*60*60*1000);
						  
						  if(diffDay<=1) {
							  JOptionPane.showMessageDialog(null, "강의가 시작하기 1일 전부터는 취소할 수 없습니다.\n강사님께 직접 문의 바랍니다.",
			                           "취소 불가!", 
			                           JOptionPane.ERROR_MESSAGE); 
						  }else {
							  int i = Inner_Table_After.getSelectedRow();
							  String wkSequence = (String)Inner_Table_After.getValueAt(i, 0);
							  int inSequence = Integer.parseInt(wkSequence);
							  
							  MyClassDbAction dbAction = new MyClassDbAction(inSequence);
							  boolean msg = dbAction.Delete();
							  if(msg == true) {
								  JOptionPane.showMessageDialog(null, "수강 취소 되었습니다.",
										  "취소 완료!", 
										  JOptionPane.INFORMATION_MESSAGE);
								  TableInitAfter();
								  SearchActionAfter();
							  }
						  }
						  
					    
				  
			  }catch (Exception e) {
				// TODO: handle exception
		            JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!",
                           "Critical Error!", 
                           JOptionPane.ERROR_MESSAGE); 
		            e.printStackTrace();
			}

		}	
			  
			  		  
    	}
		 
		 // 재원님꺼랑 연결 시 바로 삭제하기
		 private int ReviewSub() {
			 int i = Inner_Table_Before.getSelectedRow();
			 String wkSequence = (String)Inner_Table_Before.getValueAt(i, 0);
			 int inSequence = Integer.parseInt(wkSequence);
			 return inSequence;

		 }

	} // -------