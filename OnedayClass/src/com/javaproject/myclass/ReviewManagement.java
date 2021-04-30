package com.javaproject.myclass;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ReviewManagement { // 2021.04.29 조혜지 view - 후기 미작성 내역과 작성 내역 데이터 테이블표에 불러오기

	private JFrame frame;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable Inner_Table_Incomplete;
	private JButton btnRegister;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane_1;
	private JButton btnUpdateDelete;
	private JTable Inner_Table_Complete;
	// OuterTable 초기 설정
	private final DefaultTableModel Outer_Table_Incomplete = new DefaultTableModel();
	private final DefaultTableModel Outer_Table_Complete = new DefaultTableModel();
	private JButton btnClose;



	/**
	 * Create the application.
	 */
	public ReviewManagement() {
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
				TableInitIncomplete();
				TableInitComplete();
				SearchActionIncomplete();
				SearchActionComplete();
			}
		});
		frame.setTitle("후기관리");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnRegister());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getScrollPane_1());
		frame.getContentPane().add(getBtnUpdateDelete());
		frame.getContentPane().add(getBtnClose());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("후기 미작성 내역");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(30, 25, 122, 16);
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 53, 501, 202);
			scrollPane.setViewportView(getInner_Table_Incomplete());
		}
		return scrollPane;
	}
	private JTable getInner_Table_Incomplete() {
		if (Inner_Table_Incomplete == null) {
			Inner_Table_Incomplete = new JTable();
			Inner_Table_Incomplete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			Inner_Table_Incomplete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// InnerTable과 OuterTable연결 (후기 미작성)
			Inner_Table_Incomplete.setModel(Outer_Table_Incomplete);
			
		}
		return Inner_Table_Incomplete;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("후기 등록");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ReviewRegister register = new ReviewRegister();
					register.setVisible_ReviewRegister(true);
					frame.dispose();
					
					MyClassDbAction.ccId = ReviewIncomplete();
				}
			});
			btnRegister.setBounds(445, 267, 86, 29);
		}
		return btnRegister;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("후기 작성 내역");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(30, 306, 109, 16);
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
			scrollPane_1.setViewportView(getInner_Table_Complete());
		}
		return scrollPane_1;
	}
	private JButton getBtnUpdateDelete() {
		if (btnUpdateDelete == null) {
			btnUpdateDelete = new JButton("수정 / 삭제");
			btnUpdateDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ReviewUpdateDelete updateDelete = new ReviewUpdateDelete();
					updateDelete.setVisible_ReviewUpdateDelete(true);
					frame.dispose();
					
					MyClassDbAction.ccId = ReviewComplete();
					
				}
			});
			btnUpdateDelete.setBounds(347, 548, 86, 29);
		}
		return btnUpdateDelete;
	}
	private JTable getInner_Table_Complete() {
		if (Inner_Table_Complete == null) {
			Inner_Table_Complete = new JTable();
			Inner_Table_Complete.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});
			Inner_Table_Complete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			// InnerTable과 OuterTable연결 (후기 작성)
			Inner_Table_Complete.setModel(Outer_Table_Complete);
		}

		return Inner_Table_Complete;
	}
	
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentMyClass myClass = new StudentMyClass();
					myClass.setVisible_StudentMyClass(true);
					frame.dispose();
				}
			});
			btnClose.setBounds(445, 548, 86, 29);
		}
		return btnClose;
	}
	
	// 메소드 시작 ***************************************************************
	
	// 메인과 해당 창을 연결하는 메소드
	public void setVisible_ReviewManagement(boolean j) {
		frame.setVisible(j);
	}
	
	// 후기 작성 미완료 테이블 초기화
	private void TableInitIncomplete(){
	       int i = Outer_Table_Incomplete.getRowCount();
	       
	       Outer_Table_Incomplete.addColumn("No.");
	       Outer_Table_Incomplete.addColumn("수강날짜");
	       Outer_Table_Incomplete.addColumn("강의명");
	       Outer_Table_Incomplete.addColumn("장소");
	       Outer_Table_Incomplete.setColumnCount(4);

	       for(int j = 0 ; j < i ; j++){
	           Outer_Table_Incomplete.removeRow(0);
	       }

	       Inner_Table_Incomplete.setAutoResizeMode(Inner_Table_Incomplete.AUTO_RESIZE_OFF);
	       

	       int vColIndex = 0;
	       TableColumn col = Inner_Table_Incomplete.getColumnModel().getColumn(vColIndex);
	       int width = 40;
	       col.setPreferredWidth(width);

	       vColIndex = 1;
	       col = Inner_Table_Incomplete.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);
	       
	       vColIndex = 2;
	       col = Inner_Table_Incomplete.getColumnModel().getColumn(vColIndex);
	       width = 200;
	       col.setPreferredWidth(width);

	       vColIndex = 3;
	       col = Inner_Table_Incomplete.getColumnModel().getColumn(vColIndex);
	       width = 100;
	       col.setPreferredWidth(width);
	}
	
	// 후기 작성 완료 테이블 초기화
	 private void TableInitComplete(){

	     int k = Outer_Table_Complete.getRowCount();
	     
	     Outer_Table_Complete.addColumn("No.");
	     Outer_Table_Complete.addColumn("수강날짜");
	     Outer_Table_Complete.addColumn("강의명");
	     Outer_Table_Complete.addColumn("장소");
	     Outer_Table_Complete.setColumnCount(4);
	     
	     for(int j = 0 ; j < k ; j++){
	       Outer_Table_Complete.removeRow(0);
	       }

	     Inner_Table_Complete.setAutoResizeMode(Inner_Table_Complete.AUTO_RESIZE_OFF);

	     int vColIndex = 0;
	     TableColumn col = Inner_Table_Complete.getColumnModel().getColumn(vColIndex);
	     int width = 40;
	     col.setPreferredWidth(width);
	 
	     vColIndex = 1;
	     col = Inner_Table_Complete.getColumnModel().getColumn(vColIndex);
	     width = 100;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 2;
	     col = Inner_Table_Complete.getColumnModel().getColumn(vColIndex);
	     width = 200;
	     col.setPreferredWidth(width);
	     
	     vColIndex = 3;
	     col = Inner_Table_Complete.getColumnModel().getColumn(vColIndex);
	     width = 100;
	     col.setPreferredWidth(width);
	 }
	 

	 // 후기 작성 미완료 데이터 불러오기
	 private void SearchActionIncomplete(){

	     MyClassDbAction dbAction = new MyClassDbAction();
	     ArrayList<MyClassBean> beanList = dbAction.selectListIncomplete();
	     
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String temp1 = Integer.toString(beanList.get(i).getcId());
	       String[] qTxt = {temp1, beanList.get(i).getcDate(), beanList.get(i).getcName(), beanList.get(i).getcLocation()};
	       Outer_Table_Incomplete.addRow(qTxt);

	     }

	 }
	 
	 // 후기 작성 완료 데이터 불러오기
	 private void SearchActionComplete(){
	     
	     MyClassDbAction dbAction = new MyClassDbAction();
	     ArrayList<MyClassBean> beanList = dbAction.selectListComplete();
	     
	     int listCount = beanList.size();
	     for(int i=0; i<listCount; i++) {
	       String temp1 = Integer.toString(beanList.get(i).getcId());
	       String[] qTxt = {temp1, beanList.get(i).getcDate(), beanList.get(i).getcName(), beanList.get(i).getcLocation()};
	       Outer_Table_Complete.addRow(qTxt);

	     }


	 }
	
	 // 강의 id를 리뷰 수정 / 삭제하는 클라스에서도 가져오게 하기 위해 메소드 생성
	 public int ReviewComplete() {
		 int i = Inner_Table_Complete.getSelectedRow();
		 String wkSequence = (String)Inner_Table_Complete.getValueAt(i, 0);
		 int inSequence = Integer.parseInt(wkSequence);
		 return inSequence;

	  }
	 
	 // 강의 id를 리뷰등록하는 클라스에서도 가져오게 하기 위해 메소드 생성
	 public int ReviewIncomplete() {
		 int i = Inner_Table_Incomplete.getSelectedRow();
		 String wkSequence = (String)Inner_Table_Incomplete.getValueAt(i, 0);
		 int inSequence = Integer.parseInt(wkSequence);
		 return inSequence;
		 
	 }

}
