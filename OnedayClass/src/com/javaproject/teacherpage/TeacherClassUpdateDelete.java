package com.javaproject.teacherpage;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TeacherClassUpdateDelete { // 2021.04.28 조혜지 view - 강사가 등록한 강의 수정 / 삭제하기

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JScrollPane scrollPane;
	private JTextPane tContents;
	private JTextField textField_1;
	private JLabel lblNewLabel_6;
	private JButton btnRegister;
	private JButton btnCancle;
	private JTextField tfCname;
	private JTextField tfTname;
	private JTextField tfLocation;
	private JComboBox tfHour;
	private JComboBox cbYear;
	private JComboBox cbMonth;
	private JComboBox cbDay;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_6_1_1;
	private JLabel lblNewLabel_6_1_2;
	private JButton btnRegister_1;
	private JComboBox cbLocation;
	private JLabel lblImage;
	private JLabel lblNewLabel_7;
	private JTextField tfFilePath;
	private JButton btnFilePath;


	/**
	 * Create the application.
	 */
	public TeacherClassUpdateDelete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("강의 수정 / 삭제");
		frame.setBounds(100, 100, 560, 625);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getLblNewLabel());
		frame.getContentPane().add(getLblNewLabel_1());
		frame.getContentPane().add(getLblNewLabel_2());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
		frame.getContentPane().add(getLblNewLabel_5());
		frame.getContentPane().add(getScrollPane());
		frame.getContentPane().add(getTextField_1());
		frame.getContentPane().add(getLblNewLabel_6());
		frame.getContentPane().add(getBtnRegister());
		frame.getContentPane().add(getBtnCancle());
		frame.getContentPane().add(getTfCname());
		frame.getContentPane().add(getTfTname());
		frame.getContentPane().add(getTfLocation());
		frame.getContentPane().add(getTfHour());
		frame.getContentPane().add(getCbYear());
		frame.getContentPane().add(getCbMonth());
		frame.getContentPane().add(getCbDay());
		frame.getContentPane().add(getLblNewLabel_6_1());
		frame.getContentPane().add(getLblNewLabel_6_1_1());
		frame.getContentPane().add(getLblNewLabel_6_1_2());
		frame.getContentPane().add(getBtnRegister_1());
		frame.getContentPane().add(getCbLocation());
		frame.getContentPane().add(getLblImage());
		frame.getContentPane().add(getLblNewLabel_7());
		frame.getContentPane().add(getTfFilePath());
		frame.getContentPane().add(getBtnFilePath());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("강의명");
			lblNewLabel.setBounds(47, 212, 61, 16);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("강사");
			lblNewLabel_1.setBounds(47, 242, 61, 16);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("장소");
			lblNewLabel_2.setBounds(47, 272, 61, 16);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("소요 시간");
			lblNewLabel_3.setBounds(47, 302, 61, 16);
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("강의 날짜");
			lblNewLabel_4.setBounds(47, 332, 61, 16);
			lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("강의 소개");
			lblNewLabel_5.setBounds(47, 360, 61, 16);
			lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
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
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(364, 505, 124, 26);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("원");
			lblNewLabel_6.setBounds(491, 509, 38, 16);
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_6;
	}
	private JButton getBtnRegister() {
		if (btnRegister == null) {
			btnRegister = new JButton("삭제");
			btnRegister.setBounds(374, 543, 76, 29);
		}
		return btnRegister;
	}
	private JButton getBtnCancle() {
		if (btnCancle == null) {
			btnCancle = new JButton("닫기");
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
	private JTextField getTfTname() {
		if (tfTname == null) {
			tfTname = new JTextField();
			tfTname.setBounds(140, 238, 112, 26);
			tfTname.setColumns(10);
		}
		return tfTname;
	}
	private JTextField getTfLocation() {
		if (tfLocation == null) {
			tfLocation = new JTextField();
			tfLocation.setBounds(300, 268, 112, 26);
			tfLocation.setColumns(10);
		}
		return tfLocation;
	}
	private JComboBox getTfHour() {
		if (tfHour == null) {
			tfHour = new JComboBox();
			tfHour.setBounds(140, 299, 99, 27);
			tfHour.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10"}));
		}
		return tfHour;
	}
	private JComboBox getCbYear() {
		if (cbYear == null) {
			cbYear = new JComboBox();
			cbYear.setBounds(140, 329, 99, 27);
			cbYear.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024"}));
		}
		return cbYear;
	}
	private JComboBox getCbMonth() {
		if (cbMonth == null) {
			cbMonth = new JComboBox();
			cbMonth.setBounds(262, 329, 76, 27);
			cbMonth.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		}
		return cbMonth;
	}
	private JComboBox getCbDay() {
		if (cbDay == null) {
			cbDay = new JComboBox();
			cbDay.setBounds(364, 329, 76, 27);
			cbDay.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		}
		return cbDay;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel("년");
			lblNewLabel_6_1.setBounds(236, 333, 38, 16);
			lblNewLabel_6_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_6_1;
	}
	private JLabel getLblNewLabel_6_1_1() {
		if (lblNewLabel_6_1_1 == null) {
			lblNewLabel_6_1_1 = new JLabel("월");
			lblNewLabel_6_1_1.setBounds(338, 333, 38, 16);
			lblNewLabel_6_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_6_1_1;
	}
	private JLabel getLblNewLabel_6_1_2() {
		if (lblNewLabel_6_1_2 == null) {
			lblNewLabel_6_1_2 = new JLabel("일");
			lblNewLabel_6_1_2.setBounds(439, 332, 38, 16);
			lblNewLabel_6_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		}
		return lblNewLabel_6_1_2;
	}
	private JButton getBtnRegister_1() {
		if (btnRegister_1 == null) {
			btnRegister_1 = new JButton("수정");
			btnRegister_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnRegister_1.setBounds(294, 543, 76, 29);
		}
		return btnRegister_1;
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
			lblImage.setIcon(new ImageIcon("/Users/parksunghun/Documents/스크린샷 2021-04-05 오전 10.38.06.png"));
			lblImage.setBounds(37, 20, 478, 152);
		}
		return lblImage;
	}
	
	// 메소드 시작 ***************************************************************
	
	// 메인과 해당 창을 연결하는 메소드
	public void setVisible_TeacherClassUpdateDelete(boolean j) {
		frame.setVisible(j);
	}
	
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

