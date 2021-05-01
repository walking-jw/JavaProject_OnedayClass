package com.javaproject.teacherpage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javaproject.myclass.StudentMyClass;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherClassRegister { // 2021.04.27 조혜지 view - 강사 강의 등록하기

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;
	private JTextPane tContents;
	private JTextField tfPrice;
	private JLabel lblNewLabel_6;
	private JButton btnRegister;
	private JButton btnCancle;
	private JTextField tfCname;
	private JTextField tfLocation;
	private JComboBox cbHour;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_6_1_1;
	private JLabel lblNewLabel_6_1_2;
	private JComboBox cbLocation;
	private JLabel lblImage;
	private JComboBox cbCategory;
	private JLabel lblNewLabel_7;
	private JTextField tfFilePath;
	private JButton btnFilePath;


	/**
	 * Create the application.
	 */
	public TeacherClassRegister() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("강의 등록");
		frame.setBounds(100, 100, 560, 625);
		frame.setLocationRelativeTo(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTfPrice());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getBtnRegister());
		frame.getContentPane().add(getBtnCancle());
		frame.getContentPane().add(getTfCname());
		frame.getContentPane().add(getTfLocation());
		frame.getContentPane().add(getCbHour());
		frame.getContentPane().add(getCbYear());
		frame.getContentPane().add(getCbMonth());
		frame.getContentPane().add(getCbDay());
		frame.getContentPane().add(getLblNewLabel_6_1());
		frame.getContentPane().add(getLblNewLabel_6_1_1());
		frame.getContentPane().add(getLblNewLabel_6_1_2());
		frame.getContentPane().add(getCbLocation());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getCbCategory());
		frame.getContentPane().add(getLblNewLabel_7());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getBtnFilePath());


	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel.setBounds(47, 212, 61, 16);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강의 카테고리");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(47, 242, 92, 16);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("강의 장소");
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(47, 272, 61, 16);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("소요 시간");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(47, 302, 61, 16);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("강의 날짜");
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(47, 332, 61, 16);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("강의 소개");
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_5.setBounds(47, 360, 61, 16);
		}
		return lblNewLabel_5;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(37, 388, 478, 109);
			scrollPane.setViewportView(getTContents());
		}
		return scrollPane;
	}
	private JTextPane getTContents() {
		if (tContents == null) {
			tContents = new JTextPane();
		}
		return tContents;
	}
	private JTextField getTfPrice() {
		if (tfPrice == null) {
			tfPrice = new JTextField();
			tfPrice.setHorizontalAlignment(SwingConstants.TRAILING);
			tfPrice.setBounds(364, 505, 124, 26);
			tfPrice.setColumns(10);
		}
		return tfPrice;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("원");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_6.setBounds(491, 509, 38, 16);
		}
		return lblNewLabel_6;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("등록");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int check_i = check();
					if(check_i==0) {
						RegisterAction();
						RelationRegisterAction();

						TeacherLectureList myClass = new TeacherLectureList();
						myClass.setVisible_LectureList(true);
						frame.dispose();
					}
				}
			});
			btnRegister.setBounds(374, 543, 76, 29);
		}
		return btnRegister;
	}
	private JButton getBtnCancle() {
		if (btnCancle == null) {
			btnCancle = new JButton("닫기");
			btnCancle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					TeacherLectureList myClass = new TeacherLectureList();
					myClass.setVisible_LectureList(true);
					frame.dispose();
				}
			});
			btnCancle.setBounds(453, 543, 76, 29);
		}
		return btnCancle;
	}
	private JTextField getTfCname() {
		if (tfCname == null) {
			tfCname = new JTextField();
			tfCname.setBounds(140, 208, 310, 26);
			tfCname.setColumns(10);
		}
		return tfCname;
	}
	private JTextField getTfLocation() {
		if (tfLocation == null) {
			tfLocation = new JTextField();
			tfLocation.setBounds(300, 268, 112, 26);
			tfLocation.setColumns(10);
		}
		return tfLocation;
	}
	private JComboBox getCbHour() {
		if (cbHour == null) {
			cbHour = new JComboBox();
			cbHour.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10"}));
			cbHour.setBounds(140, 299, 99, 27);
		}
		return cbHour;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			cbYear = new JComboBox();
			cbYear.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024"}));
			cbYear.setBounds(140, 329, 99, 27);
		}
		return cbYear;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
			cbMonth.setBounds(262, 329, 76, 27);
		}
		return cbMonth;
	}
	private JComboBox getCbDay() {
		if (cbDay == null) {
			cbDay = new JComboBox();
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
			cbDay.setBounds(364, 329, 76, 27);
		}
		return cbDay;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel("년");
			lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_6_1.setBounds(236, 333, 38, 16);
		}
		return lblNewLabel_6_1;
	}
	private JLabel getLblNewLabel_6_1_1() {
		if (lblNewLabel_6_1_1 == null) {
			lblNewLabel_6_1_1 = new JLabel("월");
			lblNewLabel_6_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_6_1_1.setBounds(338, 333, 38, 16);
		}
		return lblNewLabel_6_1_1;
	}
	private JLabel getLblNewLabel_6_1_2() {
		if (lblNewLabel_6_1_2 == null) {
			lblNewLabel_6_1_2 = new JLabel("일");
			lblNewLabel_6_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_6_1_2.setBounds(439, 332, 38, 16);
		}
		return lblNewLabel_6_1_2;
	}
	
	private JComboBox getCbLocation() {
		if (cbLocation == null) {
			cbLocation = new JComboBox();
			cbLocation.setModel(new DefaultComboBoxModel(new String[] {"서울특별시", "강원도", "경기도", "충청남도", "충청북도", "경상남도", "경상북도", "전라남도", "전라북도", "인천광역시", "대전광역시", "대구광역시", "부산광역시", "울산광역시", "광주광역시", "세종특별자치시", "제주특별자치도"}));
			cbLocation.setBounds(140, 269, 148, 27);
		}
		return cbLocation;
	}
	
	private JLabel getLblImage() {
		if (lblImage == null) {
			lblImage = new JLabel("");
			lblImage.setHorizontalAlignment(SwingConstants.CENTER);
			lblImage.setIcon(new ImageIcon("/Users/parksunghun/Desktop/KakaoTalk_Photo_2021-04-30-00-20-58.png"));
			lblImage.setBounds(37, 20, 478, 152);
		}
		return lblImage;
	}
	
	private JComboBox getCbCategory() {
		if (cbCategory == null) {
			cbCategory = new JComboBox();
			cbCategory.setModel(new DefaultComboBoxModel(new String[] {"요리", "베이킹", "수공예", "프로그래밍", "사진", "플라워", "뷰티", "미술"}));
			cbCategory.setBounds(140, 239, 148, 27);
		}
		return cbCategory;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("파일 경로");
			lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_7.setBounds(47, 184, 61, 16);
		}
		return lblNewLabel_7;
	}
	private JTextField getTfFilePath() {
		if (tfFilePath == null) {
			tfFilePath = new JTextField();
			tfFilePath.setBounds(140, 180, 261, 26);
			tfFilePath.setColumns(10);
		}
		return tfFilePath;
	}
	private JButton getBtnFilePath() {
		if (btnFilePath == null) {
			btnFilePath = new JButton("이미지 등록");
			btnFilePath.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FilePath();
				}
			});
			btnFilePath.setBounds(413, 180, 102, 29);
		}
		return btnFilePath;
	}
	
	// 메소드 시작 ***************************************************************
	
	// 메인과 해당 창을 연결하는 메소드
	public void setVisible_TeacherClassRegister(boolean h) {
		frame.setVisible(h);
		
	}
	
	// 사용자가 입력한 정보를 가져와 강의 등록하는 메소드
	private void RegisterAction(){
		String cName = tfCname.getText();
		String cCategory = cbCategory.getSelectedItem().toString();
		String cLocation1 = cbLocation.getSelectedItem().toString();
		String cLocation2 = tfLocation.getText();
		String cDate = cbYear.getSelectedItem().toString() + "-" + cbMonth.getSelectedItem().toString() + "-" + cbDay.getSelectedItem().toString();
		String cTime = cbHour.getSelectedItem().toString();
		int cPrice = Integer.parseInt(tfPrice.getText());
		String cContents = tContents.getText();
	
		// Image File
		FileInputStream input = null;
		File file = new File(tfFilePath.getText());
		try {
			input = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RUDDbAction dbaction = new RUDDbAction(input, cName, cCategory, cLocation1, cLocation2, cTime, cDate, cContents, cPrice);
		boolean aaa = dbaction.RegisterAction();
		if(aaa == true){
	          JOptionPane.showMessageDialog(null, "강의 등록이 완료되었습니다!");                    
		}else{
	          JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!");                    
		}
	}
	
	// 사용자가 정보 입력 시 비어있는 값이 있는지 확인하는 메소드
	private int check() {
		int check = 0;
		String message = "에 대해 추가로 입력해주세요!";
		if(tfPrice.getText().trim().isEmpty()) {
			message = "'강의 가격' " + message;
			check++;
			tfPrice.requestFocus();
		}	
		if(tContents.getText().trim().isEmpty()) {
			message = "'강의 소개' " + message;
			check++;
			tContents.requestFocus();
		}	
		if(tfLocation.getText().trim().isEmpty()) {
			message = "'장소' " + message;
			check++;
			tfLocation.requestFocus();
		}
		if(tfCname.getText().trim().isEmpty()) {
			message = "'강의명' " + message;
			check++;
			tfCname.requestFocus();
		}
		if(tfFilePath.getText().trim().isEmpty()) {
			message = "'이미지' " + message;
			check++;
			tfFilePath.requestFocus();
		}
		
		if(check>0) {
			JOptionPane.showMessageDialog(null, message);
		}
		
		return check;
	}
	
	
	// 강의 등록일자 insert하는 메소드
	private void RelationRegisterAction() {
		RUDDbAction action = new RUDDbAction();
		int cccId = action.getClassId();
		try {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RUDDbAction dbaction = new RUDDbAction(cccId);
		boolean aaa = dbaction.RegisterDateAction();
		if(aaa == true){
		}else{
			JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!");                    
		}
		
		
	}
	
	// 이미지 등록하는 메소드
	private void FilePath() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, PNG, BMP", "jpg","png","bmp");
		chooser.setFileFilter(filter);
		
		int ret = chooser.showOpenDialog(null);
		if(ret != JFileChooser.APPROVE_OPTION) {
			JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다!", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String filePath = chooser.getSelectedFile().getPath();
		tfFilePath.setText(filePath);
		lblImage.setIcon(new ImageIcon(filePath));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	
}
