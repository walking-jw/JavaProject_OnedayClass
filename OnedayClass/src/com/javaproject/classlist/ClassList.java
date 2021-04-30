package com.javaproject.classlist;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaproject.classinfo.Classinfo;
import com.javaproject.home.HomeView;

import javax.swing.ListSelectionModel;

public class ClassList {

	private JFrame frame;
	private JComboBox cbSelection;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnNewButton;
	private JButton btnClose;


	/**
	 * Create the application.
	 */
	public ClassList() {
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
				TableInit();
				ComboxClick();
			}
		});
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);  //  --------------- 가운데로 보내기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getCbSelection());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getBtnNewButton());
		frame.getContentPane().add(getBtnClose());
	}

	private JComboBox getCbSelection() {
		if (cbSelection == null) {
			cbSelection = new JComboBox();
			cbSelection.addActionListener(new ActionListener() {
				
		 
				public void actionPerformed(ActionEvent e) {
					ComboxClick();
					
				}
			});
			cbSelection.setModel(new DefaultComboBoxModel(new String[] {"요리", "베이킹", "수공예", "프로그래밍", "사진", "플라워", "뷰티", "미술"}));
			cbSelection.setBounds(6, 6, 95, 27);
		}
		return cbSelection;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(16, 45, 525, 446);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.addMouseListener(new MouseAdapter() {

			});
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);// ******** 설정 꼭 해주기!
			

		}
		return Inner_Table;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("자세히 보기");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/*/
					 * 자세히보기
					 */
					DbAction.classid = ClassId();
					
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frame.dispose();
					
					
				}
			});
			btnNewButton.setBounds(424, 518, 117, 29);
		}
		return btnNewButton;
	}
	
	/*
	 * 2021-04-26 권효은 : 첫번째 페이지 작업 
	 */
	
	//frame이 보이게 하는 메소드 만들기 (열고 닫기위해 boolean으로 타입을 정한다!)
	public void setVisible_Classinfo (boolean l) {
		frame.setVisible(l);
	}
	
	
	//1. Table Init 설정
		@SuppressWarnings("static-access")    // warning Message 안보이게
	public void TableInit(){
			int i = Outer_Table.getRowCount();
	        
	        //강의명, 강사, 장소, 날짜 이름으로 테이블 열 이름 설정
			Outer_Table.addColumn("No.");
	        Outer_Table.addColumn("강의명");
	        Outer_Table.addColumn("강사");
	        Outer_Table.addColumn("장소");
	        Outer_Table.addColumn("날짜");
	        Outer_Table.setColumnCount(5);

	        for(int j = 0 ; j < i ; j++){
	            Outer_Table.removeRow(0);
	        }
	        
	        //Table 안쪽 Size 바꾸지 못하게 하기
	        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
	        

	        int vColIndex = 0;
	        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        int width = 50;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 1;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 150;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 2;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 100;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 3;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 100;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 4;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 150;
	        col.setPreferredWidth(width);
	        
	        
		}//Table Init End

		
		
		
		//콤보박스 인덱스 이름 설정
		// ConditionQuery column name
		public void ComboxClick() {
			
			int i = cbSelection.getSelectedIndex();
			
			String ComboxColumn = "";
			
			switch (i) {
			case 0:
				ComboxColumn = "요리";
				break;
			case 1:
				ComboxColumn = "베이킹";
				break;
			case 2:
				ComboxColumn = "수공예";
				break;
			case 3:
				ComboxColumn = "프로그래밍";
				break;
			case 4:
				ComboxColumn = "사진";
				break;
			case 5:
				ComboxColumn = "플라워";
				break;
			case 6:
				ComboxColumn = "뷰티";
				break;
			case 7:
				ComboxColumn = "미술";
				break;
			default:
				break;
			}
			
		TableInit();
		searchAction(ComboxColumn);
		}//comboxClick End

	
		
		//SearchAction ----- 콤보박스 카테고리별 해당 정보 불러오기
		public void searchAction(String ComboxColumn) {
			
			DbAction dbAction = new DbAction(ComboxColumn);  
			ArrayList<Bean>  beanList =  dbAction.selectList();

			int listCount = beanList.size();
			
			for(int i=0; i<listCount; i++) {
				
				
				
			String[] qTxt = { Integer.toString(beanList.get(i).getcId()),beanList.get(i).getcName(), beanList.get(i).gettName(), beanList.get(i).getcLocation(),beanList.get(i).getcDate()};
				
			Outer_Table.addRow(qTxt);
					
			}
		}//searchAction End
	
	
	// 아이디 전달
	public int ClassId() {
		
		 int i = Inner_Table.getSelectedRow();
		 String tmpSequence = (String)Inner_Table.getValueAt(i, 0);      
		 int wkSequence = Integer.parseInt(tmpSequence); 
		
		 return wkSequence;
	}

	
	
	private JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton("닫기");
			btnClose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomeView homeView = new HomeView();
					homeView.setVisible_HomeView(true);
					frame.dispose();
				}
			});
			btnClose.setBounds(302, 518, 117, 29);
		}
		return btnClose;
	}
}//end
