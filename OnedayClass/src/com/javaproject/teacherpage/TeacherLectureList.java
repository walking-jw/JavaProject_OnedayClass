package com.javaproject.teacherpage;

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

import com.javaproject.myclass.ReviewRegister;
import com.javaproject.teacherpage.TeacherClassRegister;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class TeacherLectureList { // 혜지 view - 수강 예정과 수강 이력 데이터 테이블표에 불러오기 & 수강 예정 강의 수강 신청 취소하기
	
		private JFrame frame;
		private JLabel lblNewLabel;
		private JScrollPane scrollPane;
		private JTable Inner_Table_After;
		private JButton btnCancle;
		private JLabel lblNewLabel_1;
		private JScrollPane scrollPane_1;
		private JButton btnRegister;
		private JTable Inner_Table_Before;
		// OuterTable 초기 설정
		private final DefaultTableModel Outer_Table_After = new DefaultTableModel();
		private final DefaultTableModel Outer_Table_Before = new DefaultTableModel();
		private JButton btnDetail;
		private JButton btn_Update_n_Delete;


		
		public void setVisible_LectureList(boolean i) {
			frame.setVisible(true);
			
		}
		
		
	
		/**
		 * Create the application.
		 */
		public TeacherLectureList() {
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
			frame.setTitle("강의관리");
			frame.setBounds(100, 100, 560, 625);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getScrollPane());
			frame.getContentPane().add(getLblNewLabel_1());
			frame.getContentPane().add(getScrollPane_1());
			frame.getContentPane().add(getBtnRegister());
			frame.getContentPane().add(getBtnDetail());
			frame.getContentPane().add(getBtn_Update_n_Delete());
		}
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("강의 예정");
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
		
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("강의 이력");
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
//						DbAction.i = ReviewSub();
//						System.out.println(DbAction.i);
					}
				});
				scrollPane_1.setBounds(30, 334, 501, 202);
				scrollPane_1.setViewportView(getInner_Table_Before());
			}
			return scrollPane_1;
		}
		private JButton getBtnRegister() {
			if (btnRegister == null) {
				btnRegister = new JButton("신규 강의 등록");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						TeacherClassRegister register = new TeacherClassRegister();
						register.setVisible_TeacherClassRegister(true);
						frame.dispose();
					}
				});
				btnRegister.setBounds(414, 546, 117, 29);
			}
			return btnRegister;
		}
		private JTable getInner_Table_Before() {
			if (Inner_Table_Before == null) {
				Inner_Table_Before = new JTable();
				Inner_Table_Before.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
//						TableClick();
					}
				});
				Inner_Table_Before.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				// InnerTable과 OuterTable연결 (수강 이력)
				Inner_Table_Before.setModel(Outer_Table_Before);
			}
	
			return Inner_Table_Before;
		}
		
		private JButton getBtnDetail() {
			if (btnDetail == null) {
				btnDetail = new JButton("상세내용");
				btnDetail.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						DbAction_List.classid = ReviewSub();
						
						TeacherLectureDetail go = new TeacherLectureDetail();
						go.setVisible_LectureListDetail(true);
						frame.dispose();
						
						
					}
				});
				btnDetail.setBounds(290, 546, 117, 29);
			}
			return btnDetail;
		}
		private JButton getBtn_Update_n_Delete() {
			if (btn_Update_n_Delete == null) {
				btn_Update_n_Delete = new JButton("수정 / 삭제");
				btn_Update_n_Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						// 혜지님 파트로 넘기기!! --> 강의 
						TeacherClassUpdateDelete teUnD = new TeacherClassUpdateDelete();
						teUnD.setVisible_TeacherClassUpdateDelete(true);
						frame.dispose();
						
					}
				});
				btn_Update_n_Delete.setBounds(414, 267, 117, 29);
			}
			return btn_Update_n_Delete;
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
		       Outer_Table_After.addColumn("강의명");
		       Outer_Table_After.addColumn("수강날짜");
		       Outer_Table_After.addColumn("장소");
		       Outer_Table_After.setColumnCount(4);
	
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
		       width = 200;
		       col.setPreferredWidth(width);
		       
		       vColIndex = 2;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 120;
		       col.setPreferredWidth(width);
	
		       vColIndex = 3;
		       col = Inner_Table_After.getColumnModel().getColumn(vColIndex);
		       width = 150;
		       col.setPreferredWidth(width);

		 }
		
		// 수강 이력 테이블 초기화
		 private void TableInitBefore(){
	
		     int k = Outer_Table_Before.getRowCount();
		     
		     Outer_Table_Before.addColumn("강의ID");
		     Outer_Table_Before.addColumn("강의명");
		     Outer_Table_Before.addColumn("수강날짜");
		     Outer_Table_Before.addColumn("장소");
		     Outer_Table_Before.setColumnCount(4);
		     
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
		     width = 200;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 2;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 120;
		     col.setPreferredWidth(width);
		     
		     vColIndex = 3;
		     col = Inner_Table_Before.getColumnModel().getColumn(vColIndex);
		     width = 150;
		     col.setPreferredWidth(width);
		     
		 }
	
		 // 수강 예정 데이터 불러오기
		 private void SearchActionAfter(){
		     
		     DbAction_List dbAction = new DbAction_List();
		     ArrayList<Bean_TeacherClass> beanList = dbAction.selectListAfter();
		     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String temp1 = Integer.toString(beanList.get(i).getcId());
		       String[] qTxt = {temp1, beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation()};
		       Outer_Table_After.addRow(qTxt);
		     }

		 }
		 
		 // 수강 이력 데이터 불러오기
		 private void SearchActionBefore(){
		     
		     DbAction_List dbAction = new DbAction_List();
		     ArrayList<Bean_TeacherClass> beanList = dbAction.selectListBefore();
		     int listCount = beanList.size();
		     for(int i=0; i<listCount; i++) {
		       String temp1 = Integer.toString(beanList.get(i).getcId());
		       String[] qTxt = {temp1, beanList.get(i).getcName(), beanList.get(i).getcDate(), beanList.get(i).getcLocation()};
		       Outer_Table_Before.addRow(qTxt);
		     }

		 }
		
		// Table Click 해서 ShareVar에 cId 남겨두기
		
//		private void TableClick() {
//			
//			int i = Inner_Table_After.getSelectedRow();
//			String tmp = (String)Inner_Table_After.getValueAt(i, 0);
//			
//			DbAction_List db = new DbAction_List(tmp);
//			Bean_TeacherClass bean = db.TableClick();
//			 
//			ShareVarTest.cId = Integer.toString(bean.getcId());
//			
//			
//			
//		}
		 // 강의 아이디 불러오기
		  public int ReviewSub() {
				int i = Inner_Table_Before.getSelectedRow();
				String wkSequence = (String)Inner_Table_Before.getValueAt(i, 0);
				int inSequence = Integer.parseInt(wkSequence);
				return inSequence;
		  }
		
		
		
	} //