package com.javaproject.classlist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class Category {

	private JFrame frame;
	private JComboBox comboBox;
	private JScrollPane scrollPane;
	private JTable Inner_Table;
	private final DefaultTableModel Outer_Table = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Category window = new Category();
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
	public Category() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("금손양성소");
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getComboBox());
		frame.getContentPane().add(getScrollPane());
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"요리", "베이킹", "수공예", "미술", "사진", "프로그래밍", "플라워", "뷰티"}));
			comboBox.setBounds(6, 18, 87, 27);
		}
		return comboBox;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(16, 58, 524, 513);
			scrollPane.setViewportView(getInner_Table());
		}
		return scrollPane;
	}
	private JTable getInner_Table() {
		if (Inner_Table == null) {
			Inner_Table = new JTable();
			Inner_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			Inner_Table.setModel(Outer_Table);
		}
		return Inner_Table;
	}
	
	/*
	 * 2021.04.26 
	 * 권 효 은 
	 * Category Frame 보이는 메소드 작성
	 */
	
	public void setVisible_Category(boolean c) {
		frame.setVisible(c);
	}
	
	//
	@SuppressWarnings("static-access")    // warning Message 안보이게
	private void TableInit(){
        int i = Outer_Table.getRowCount();
        
        //강의명, 강사, 장소, 날짜 이름으로 테이블 열 이름 설정
        Outer_Table.addColumn("강의명");
        Outer_Table.addColumn("강사");
        Outer_Table.addColumn("장소");
        Outer_Table.addColumn("날짜");
        Outer_Table.setColumnCount(4);

        for(int j = 0 ; j < i ; j++){
            Outer_Table.removeRow(0);
        }
        Inner_Table.setAutoResizeMode(Inner_Table.AUTO_RESIZE_OFF);
        

        int vColIndex = 0;
        TableColumn col = Inner_Table.getColumnModel().getColumn(vColIndex);
        int width = 100;
        col.setPreferredWidth(width);
        
        vColIndex = 1;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
        
        vColIndex = 2;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 50;
        col.setPreferredWidth(width);
        
        vColIndex = 3;
        col = Inner_Table.getColumnModel().getColumn(vColIndex);
        width = 100;
        col.setPreferredWidth(width);
        
	}//Table Init End

	
	
	
	
}//end
