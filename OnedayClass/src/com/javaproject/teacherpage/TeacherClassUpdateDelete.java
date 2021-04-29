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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.javaproject.myclass.StudentMyClass;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

	public class TeacherClassUpdateDelete { // 2021.04.28 조혜지 view - 강사가 등록한 강의 수정 / 삭제 버튼 눌렀을 때 상황
	
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
		private JButton btnDelete;
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
		private JButton btnUpdate;
		private JComboBox cbLocation;
		private JLabel lblImage;
		private JLabel lblNewLabel_7;
		private JTextField tfFilePath;
		private JButton btnFilePath;
		private JComboBox cbCategory;
		private JTextField tfCount;
		private JLabel lblNewLabel_8;
	
	
	
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
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowOpened(WindowEvent e) {
					ShowData();
				}
			});
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
			frame.getContentPane().add(getTfPrice());
			frame.getContentPane().add(getLblNewLabel_6());
			frame.getContentPane().add(getBtnDelete());
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
			frame.getContentPane().add(getBtnUpdate());
			frame.getContentPane().add(getCbLocation());
			frame.getContentPane().add(getLblImage());
			frame.getContentPane().add(getLblNewLabel_7());
			frame.getContentPane().add(getTfFilePath());
			frame.getContentPane().add(getBtnFilePath());
			frame.getContentPane().add(getCbCategory());
			frame.getContentPane().add(getTfCount());
			frame.getContentPane().add(getLblNewLabel_8());
	
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
				lblNewLabel_1 = new JLabel("강의 카테고리");
				lblNewLabel_1.setBounds(47, 242, 99, 16);
				lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			}
			return lblNewLabel_1;
		}
		private JLabel getLblNewLabel_2() {
			if (lblNewLabel_2 == null) {
				lblNewLabel_2 = new JLabel("강의 장소");
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
				lblNewLabel_6.setBounds(491, 509, 38, 16);
				lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			}
			return lblNewLabel_6;
		}
		private JButton getBtnDelete() {
			if (btnDelete == null) {
				btnDelete = new JButton("삭제");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DeleteAction();
					}
				});
				btnDelete.setBounds(374, 543, 76, 29);
			}
			return btnDelete;
		}
		private JButton getBtnCancle() {
			if (btnCancle == null) {
				btnCancle = new JButton("닫기");
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// 여기에서 재원님이랑 연결
						StudentMyClass myClass = new StudentMyClass();
						myClass.setVisible_StudentMyClass(true);
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
				cbHour.setBounds(140, 299, 99, 27);
				cbHour.setModel(new DefaultComboBoxModel(new String[] {"0.5", "1", "1.5", "2", "2.5", "3", "3.5", "4", "4.5", "5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9", "9.5", "10"}));
			}
			return cbHour;
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
		private JButton getBtnUpdate() {
			if (btnUpdate == null) {
				btnUpdate = new JButton("수정");
				btnUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int check_i = check();
						if(check_i==0) {
							UpdateAction();
							// 여기에서 재원님이랑 연결
							StudentMyClass myClass = new StudentMyClass();
							myClass.setVisible_StudentMyClass(true);
							frame.dispose();
						}
					}
				});
				btnUpdate.setBounds(294, 543, 76, 29);
			}
			return btnUpdate;
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
				lblImage.setIcon(new ImageIcon("/Users/parksunghun/Desktop/KakaoTalk_Photo_2021-04-30-00-20-58.png"));
				lblImage.setBounds(37, 20, 478, 152);
			}
			return lblImage;
		}
		
		private JComboBox getCbCategory() {
			if (cbCategory == null) {
				cbCategory = new JComboBox();
				cbCategory.setModel(new DefaultComboBoxModel(new String[] {"요리", "베이킹", "미술", "코딩", "사진", "어학", "상식", "공예"}));
				cbCategory.setBounds(140, 239, 148, 27);
			}
			return cbCategory;
		}
		
		private JTextField getTfCount() {
			if (tfCount == null) {
				tfCount = new JTextField();
				tfCount.setHorizontalAlignment(SwingConstants.TRAILING);
				tfCount.setBounds(37, 505, 43, 26);
				tfCount.setColumns(10);
			}
			return tfCount;
		}
		private JLabel getLblNewLabel_8() {
			if (lblNewLabel_8 == null) {
				lblNewLabel_8 = new JLabel("명 신청");
				lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblNewLabel_8.setBounds(85, 510, 61, 16);
			}
			return lblNewLabel_8;
		}
	
		
		// 메소드 시작 ***************************************************************
		
		// 메인과 해당 창을 연결하는 메소드
		public void setVisible_TeacherClassUpdateDelete(boolean j) {
			frame.setVisible(j);
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
		
		// 강의 등록 취소하는 메소드
		private void DeleteAction() {
			int id = RUDDbAction.ccId;

			RUDDbAction dbaction = new RUDDbAction(id);
	        RUDBean bean = dbaction.TableClick();

	        try{
	        	
		        if(bean.getcCount()>0) {
		        	JOptionPane.showMessageDialog(null, "수강 인원이 1명 이상이기 때문에 폐강할 수 없습니다!\n폐강을 원하시면 강의를 신청한 수강생에게 연락해\n수강 취소를 요청한 후, 다시 시도해주세요!" ,"폐강 불가!", 
	        				   JOptionPane.INFORMATION_MESSAGE);
		        }else {
		        	int result = JOptionPane.showConfirmDialog(null, "강의를 폐강하시겠습니까?\nYes버튼 클릭 시 강의가 폐강됩니다.", "강의 폐강", JOptionPane.YES_NO_OPTION);
					if(result==JOptionPane.YES_OPTION) {
		        	boolean aaa = dbaction.DeleteAction();
				    if(aaa == true) {
				    	JOptionPane.showMessageDialog(null, "강의 폐강이 완료되었습니다!","폐강 완료!", 
		        				   JOptionPane.INFORMATION_MESSAGE);
						// 여기에서 재원님이랑 연결
				    	StudentMyClass myClass = new StudentMyClass();
						myClass.setVisible_StudentMyClass(true);
						frame.dispose();
				    }
				    
		        	}
		           }
		        } catch (Exception e){
		            JOptionPane.showMessageDialog(null, "DB에 자료 입력중 에러가 발생했습니다!\n시스템관리자에 문의하세요!",
		                                         "Critical Error!", 
		                                         JOptionPane.ERROR_MESSAGE);                    
		            e.printStackTrace();
		        }
			
		}
		
		// 강의 등록 수정하는 메소드
		 private void UpdateAction() {
		      
				int id = RUDDbAction.ccId;

		        // Image File
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
				
				RUDDbAction dbaction = new RUDDbAction(input, cName, cCategory, cLocation1, cLocation2, cTime, cDate, cContents, cPrice, id);
				boolean aaa = dbaction.UpdateAction();
				if(aaa == true){
			          JOptionPane.showMessageDialog(null, "강의 수정이 완료되었습니다!");                    
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

		 // mysql에 있는 데이터를 view에 불러오는 메소드
		 private void ShowData() {
				int id = RUDDbAction.ccId;

				RUDDbAction dbaction = new RUDDbAction(id);
		        RUDBean bean = dbaction.TableClick();
		        
		        tfCname.setText(bean.getcName());
		        cbCategory.setSelectedItem(bean.getcCategory());
		        cbLocation.setSelectedItem(bean.getcLocation1());
		        tfLocation.setText(bean.getcLocation2());
		        cbHour.setSelectedItem(bean.getcTime());
		        String str = bean.getcDate();
		        cbYear.setSelectedItem(str.substring(0,4));
		        cbMonth.setSelectedItem(str.substring(5,7));
		        cbDay.setSelectedItem(str.substring(8,10));
		        tContents.setText(bean.getcContents());
		        tfPrice.setText(Integer.toString(bean.getcPrice()));
		        tfCount.setText(Integer.toString(bean.getcCount()));
		        
		        // Image처리
		        // File name이 틀려야 즉각 보여주기가 가능하여   
		        // ShareVar에서 int값으로 정의하여 계속 증가하게 하여 file name으로 사용후 삭제
		        
		      String filePath = Integer.toString(dbaction.filename);
//		      String filePath = Integer.toString(ShareVar.filename);
		      tfFilePath.setText(filePath);
		      
		      lblImage.setIcon(new ImageIcon(filePath));
		      lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		      
		      File file = new File(filePath);
		      file.delete();
		      
		      tfFilePath.setText("");
		 
		   }

	}
