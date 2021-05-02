package com.javaproject.classinfo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaproject.base.ShareVar;
import com.javaproject.classlist.DbAction;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class ClassReview {
	
	//--------------------------------------Field
		//강의에 대한 후기!
		
		private JFrame frame;
		private JLabel lblNewLabel;
		private JTextField tfrCount;
		private JScrollPane scrollPane;
		private JButton btnNewButton;
		private JTable Inner_Table;

	   /*/
	    * 2021-04-28 
	    * 강의 후기 테이블을 위한 작업	
	    */
		private final DefaultTableModel Outer_Table = new DefaultTableModel();
		private JLabel lblCount;

		
		//--------------------------------------Constructor
		

		/**
		 * Create the application.
		 */
		public ClassReview() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.addWindowListener(new WindowAdapter() {
				
				//윈도우 오픈시 : 테이블 초기값 불러오기, 강의후기 및 후기갯수 불러오기
				@Override
				public void windowOpened(WindowEvent e) {
					TableInit();
					ClassReviewInfo();
					ValueCountReview();
				}
			});
			frame.setTitle("강의후기");
			frame.setBounds(100, 100, 560, 625);
			frame.setLocationRelativeTo(frame);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().add(getLblNewLabel());
			frame.getContentPane().add(getTfrCount());
			frame.getContentPane().add(getScrollPane());
			frame.getContentPane().add(getBtnNewButton());
			frame.getContentPane().add(getLblCount());
		}

		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("강의후기");
				lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
				lblNewLabel.setBounds(33, 25, 88, 34);
			}
			return lblNewLabel;
		}
		private JTextField getTfrCount() {
			if (tfrCount == null) {
				tfrCount = new JTextField();
				tfrCount.setEditable(false);
				tfrCount.setHorizontalAlignment(SwingConstants.TRAILING);
				tfrCount.setBounds(116, 25, 28, 35);
				tfrCount.setColumns(10);
			}
			return tfrCount;
		}
		private JScrollPane getScrollPane() {
			if (scrollPane == null) {
				scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 72, 496, 444);
				scrollPane.setViewportView(getInner_Table());
			}
			return scrollPane;
		}
		
		private JButton getBtnNewButton() {
			if (btnNewButton == null) {
				btnNewButton = new JButton("닫기");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//닫기버튼 클릭시 강의 정보 란으로 돌아가기
						Classinfo classinfo = new Classinfo();
						classinfo.setVisible_Classinfo(true);
						frame.dispose();
						
					}
				});
				btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
				btnNewButton.setBounds(413, 540, 116, 34);
			}
			return btnNewButton;
		}
		
		private JTable getInner_Table() {
			if (Inner_Table == null) {
				Inner_Table = new JTable();
				Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				Inner_Table.setModel(Outer_Table);// ******** 설정 꼭 해주기!
			}
			return Inner_Table;
		}
		
		private JLabel getLblCount() {
			if (lblCount == null) {
				lblCount = new JLabel("개");
				lblCount.setBounds(142, 38, 18, 16);
			}
			return lblCount;
		}
		
		//--------------------------------------Method
		
		// Frame 보이게 안보이게 설정
		public void setVisible_ClassReview(boolean h) {
			frame.setVisible(h);
			
		}
		
		
		
		//후기 Table init 설정
			@SuppressWarnings("static-access")   
		public void TableInit(){
			int i = Outer_Table.getRowCount();
	        
	        //작성자, 내용 , 평점으로 테이블 열 이름 설정
			
			
			Outer_Table.addColumn("No.");   //강의 Id
			Outer_Table.addColumn("작성자");
	        Outer_Table.addColumn("내용");
	        Outer_Table.addColumn("평점");
	   
	        Outer_Table.setColumnCount(4);

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
	        width = 100;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 2;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 200;
	        col.setPreferredWidth(width);
	        
	        vColIndex = 3;
	        col = Inner_Table.getColumnModel().getColumn(vColIndex);
	        width = 100;
	        col.setPreferredWidth(width);
	        
		        
			}//Table Init End
	

	
		//강의 아이디를 통한 강의 후기 불러오기
		public void ClassReviewInfo() {
			int cid = ShareVar.cId;
			
			DbActionInfo dbActionInfo = new DbActionInfo(cid);
			ArrayList<Bean2>  beanList =  dbActionInfo.ClassReview();

			int listCount = beanList.size();
			
			for(int i=0; i<listCount; i++) {
				
				
			String[] qTxt = { Integer.toString(beanList.get(i).getcId()),beanList.get(i).getsName(), beanList.get(i).getcReview(),Integer.toString(beanList.get(i).getcScore())};
			Outer_Table.addRow(qTxt);
			
			}
	
		} // ClassReviewInfo End
		
	
		//해당 강의 후기 갯수 구하기
		public void ValueCountReview() {
			int cid = ShareVar.cId;
			
			DbActionInfo dbActionInfo = new DbActionInfo(cid);
			Bean2 valCountReview = dbActionInfo.CountReview();
			
			tfrCount.setText(Integer.toString(valCountReview.getrCount()));
			
		}//ValueCountReview End


}//end
