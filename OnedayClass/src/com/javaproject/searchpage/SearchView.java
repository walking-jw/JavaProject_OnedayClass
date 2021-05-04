package com.javaproject.searchpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.javaproject.base.ShareVar;
import com.javaproject.classinfo.Classinfo;
import com.javaproject.home.HomeView;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class SearchView {

	private JFrame frmCopyright;
	private JComboBox selectBox;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JButton btnCancel;
	private JScrollPane scrollPane;
	private JTable inner_table;
	
	DefaultTableModel Outer_Table = new DefaultTableModel();
	private JButton btnDetail;
	

	/**
	 * Create the application.
	 */
	public SearchView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCopyright = new JFrame();
		frmCopyright.setTitle("검색 © Copyright 권효은, 박재원, 이도영, 조혜지");
		frmCopyright.setBounds(100, 100, 560, 625);
		frmCopyright.setLocationRelativeTo(frmCopyright);
		frmCopyright.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCopyright.getContentPane().setLayout(null);
		frmCopyright.getContentPane().add(getSelectBox());
		frmCopyright.getContentPane().add(getTfSearch());
		frmCopyright.getContentPane().add(getBtnSearch());
		frmCopyright.getContentPane().add(getBtnCancel());
		frmCopyright.getContentPane().add(getScrollPane());
		frmCopyright.getContentPane().add(getBtnDetail());
	}

	private JComboBox getSelectBox() {
		if (selectBox == null) {
			selectBox = new JComboBox();
			selectBox.setModel(new DefaultComboBoxModel(new String[] {"강의명", "카테고리", "장소", "날짜"}));
			selectBox.setBounds(28, 39, 100, 27);
		}
		return selectBox;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(137, 38, 234, 26);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("검색");
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//검색
					//classId.removeAll(classId);
					conditionQuery();
				}
			});
			btnSearch.setBounds(383, 38, 117, 29);
		}
		return btnSearch;
	}
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton("닫기");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//닫기
					HomeView homeView = new HomeView();
					homeView.setVisible_HomeView(true);
					frmCopyright.dispose();
				}
			});
			btnCancel.setBounds(396, 538, 117, 29);
		}
		return btnCancel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 83, 463, 423);
			scrollPane.setViewportView(getInner_table());
		}
		return scrollPane;
	}
	private JTable getInner_table() {
		if (inner_table == null) {
			inner_table = new JTable();
			inner_table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//Click
					System.out.println(classId.get(inner_table.getSelectedRow()));
					ShareVar.cId = classId.get(inner_table.getSelectedRow());
				}
			});
			inner_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			inner_table.setModel(Outer_Table);
		}
		return inner_table;
	}
	
	private void tableInit() {
		Outer_Table.addColumn("강의명");
		Outer_Table.addColumn("카테고리");
		Outer_Table.addColumn("장소");
		Outer_Table.addColumn("날짜");
		Outer_Table.setColumnCount(4);
		int i = Outer_Table.getRowCount();
		
		for(int j=0; j<i; j++) {
			Outer_Table.removeRow(0);
		}
		
		inner_table.setAutoResizeMode(inner_table.AUTO_RESIZE_OFF);
		
		int vColIndex = 0;
		TableColumn col = inner_table.getColumnModel().getColumn(vColIndex);
		int width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 1;
		col = inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);

		vColIndex = 2;
		col = inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);
		
		vColIndex = 3;
		col = inner_table.getColumnModel().getColumn(vColIndex);
		width = 100;
		col.setPreferredWidth(width);			
	}
	
	private void conditionQuery() {
		int i = selectBox.getSelectedIndex();
		String conditonQueryColumn = "";
		
		switch (i) {
		case 0:
			conditonQueryColumn = "cName";
			break;
		case 1:
			conditonQueryColumn = "cCategory";
			break;
		case 2:
			conditonQueryColumn = "concat(cLocation1, ' ',cLocation2)";
			break;

		case 3:
			conditonQueryColumn = "cDate";
			break;
		default:
			break;
		}

		tableInit();
		conditionQueryAction(conditonQueryColumn);
	}
	
	ArrayList<Integer> classId = new ArrayList<Integer>();
	
	private void conditionQueryAction(String ConditionQueryColumn) {
		String conditionSearch = tfSearch.getText().trim();
		
		DbSearchAction dbSearchAction = new DbSearchAction(conditionSearch, ConditionQueryColumn);
		ArrayList<SearchBean> beanList = dbSearchAction.conditionList();
		
		int listCount = beanList.size();
		for(int i=0; i<listCount; i++) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = format.format(beanList.get(i).getDate());
			
			String[] qTxt = {beanList.get(i).getName(),beanList.get(i).getCategory(), beanList.get(i).getLacation(), strDate};
			classId.add(beanList.get(i).getId());
			Outer_Table.addRow(qTxt);
		}
	}
	
	public void setVisible_SearchView(boolean b) {
		frmCopyright.setVisible(b);
	}
	private JButton getBtnDetail() {
		if (btnDetail == null) {
			btnDetail = new JButton("자세히보기");
			btnDetail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// show deail
					Classinfo classinfo = new Classinfo();
					classinfo.setVisible_Classinfo(true);
					frmCopyright.dispose();
				}
			});
			btnDetail.setBounds(272, 538, 117, 29);
		}
		return btnDetail;
	}
}
