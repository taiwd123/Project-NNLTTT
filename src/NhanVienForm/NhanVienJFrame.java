package NhanVienForm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import AdminForm.AdminJFrame;
import BEAN.HoaDon;
import BEAN.NhanVien;
import DAO.HoaDonDAO;
import DAO.NhanVienDAO;
import Login.LoginJDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVienJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textMaLSP;
	private JTextField textTenLoaiSP;
	private JTable table_3;
	private JTextField textMaLoaiSP;
	private JTextField textTenSP;
	private JTextField textMaSP;
	private JTextField textHangSX;
	private JTextField textGiaNhap;
	private JTextField textGiaBan;
	private JTextField textSoLuongSP;
	private JTextField textTrangThai;
	private JTextField textChuThichSP;
	private JTextField textSDTKH;
	private JTextField textTenKH;
	private JTextField textTenNVHD;
	private JTextField textDiaChiKH;
	private JTextField textTongTienHD;
	private JTextField textGhiChuHD;
	private JTextField textMaHD;
	private JTextField textTenSPCTHD;
	private JTextField textSoLuongCTHD;
	private JTextField textTongTienCTHD;
	private JTextField textGhiChuCTHD;
	private JTextField textMaCTHD;
	private JDateChooser dateChooserNgLapHD;

	
	//get ID từ form đăng nhập
		private int maNV;
		private JTextField textMaNVHD;
		
		public void setMaNV(int manv) {
			this.maNV = manv;
		}
		public int getManv() {
			return this.maNV;
		}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		/*
//		 * EventQueue.invokeLater(new Runnable() { public void run() { try { frame = new
//		 * NhanVienJFrame(); frame.setVisible(true); } catch (Exception e) {
//		 * e.printStackTrace(); } } });
//		 */
//		try {
//			frame = new NhanVienJFrame();
//			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			frame.setVisible(true);
//			frame.addWindowListener(new java.awt.event.WindowAdapter() {
//		        @Override
//		        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		        	System.exit(0);
//		        }
//		    });
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	public void display() {
		try {
			NhanVienJFrame frame = new NhanVienJFrame(this.maNV);
			frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			frame.addWindowListener(new java.awt.event.WindowAdapter() {
		        @Override
		        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        	System.exit(0);
		        }
		    });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public NhanVienJFrame(int id) {
		this.maNV = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		
		JPanel panelThongTin = new JPanel();
		tabbedPane.addTab("Hóa Đơn", new ImageIcon(AdminJFrame.class.getResource("/images/hoadon.png")), panelThongTin, null);
		
		JPanel panel_4 = new JPanel();
		
		Label label_9 = new Label("Bảng Hóa Đơn");
		label_9.setAlignment(Label.CENTER);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		
		String[] columnNamesHD = {"STT", "Mã HĐ","Mã NV","Tên KH", "Điện Thoại KH", "Dịa Chỉ KH","Ngày Lập HĐ", "Tổng Tiền", "Ghi Chú"}; 
		Object[][] dataHD= {};
		DefaultTableModel modeHD = new DefaultTableModel(dataHD, columnNamesHD);
		
		table = new JTable(modeHD);
		
		scrollPane.setViewportView(table);
		JTableHeader headerHD = table.getTableHeader();
		headerHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_5 = new JPanel();
		
		Label label_9_1 = new Label("Bảng Chi Tiết Hóa Đơn");
		label_9_1.setAlignment(Label.CENTER);
		label_9_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		String[] columnNamesCTHD = {"STT", "Mã Chi Tiết HĐ","Mã HĐ","Mã Sản Phẩm","Số Lượng", "Tổng Tiền", "Ghi Chú"}; 
		Object[][] dataCTHD= {};
		DefaultTableModel modeCTHD = new DefaultTableModel(dataCTHD, columnNamesCTHD);
		
		table_1 = new JTable(modeCTHD);
		scrollPane_1.setViewportView(table_1);
		JTableHeader headerCTHD = table_1.getTableHeader();
		headerCTHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		
		Label label_10 = new Label("Mã NV:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(10, 47, 111, 28);
		panel_6.add(label_10);
		
		Label label_10_1 = new Label("Tên NV:");
		label_10_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_1.setBounds(10, 81, 111, 28);
		panel_6.add(label_10_1);
		
		Label label_10_2 = new Label("Tên KH:");
		label_10_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_2.setBounds(10, 115, 111, 28);
		panel_6.add(label_10_2);
		
		Label label_10_3 = new Label("Điện Thoại KH:");
		label_10_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_3.setBounds(10, 149, 127, 28);
		panel_6.add(label_10_3);
		
		Label label_10_4 = new Label("Địa Chỉ KH:");
		label_10_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_4.setBounds(10, 183, 111, 28);
		panel_6.add(label_10_4);
		
		Label label_10_5 = new Label("Ngày Lập HĐ:");
		label_10_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_5.setBounds(10, 217, 111, 28);
		panel_6.add(label_10_5);
		
		Label label_10_6 = new Label("Tổng Tiền:");
		label_10_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_6.setBounds(10, 251, 111, 28);
		panel_6.add(label_10_6);
		
		Label label_10_7 = new Label("Ghi Chú:");
		label_10_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_7.setBounds(10, 285, 111, 28);
		panel_6.add(label_10_7);
		
		textSDTKH = new JTextField();
		textSDTKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSDTKH.setColumns(10);
		textSDTKH.setBounds(143, 149, 257, 28);
		panel_6.add(textSDTKH);
		
		textTenKH = new JTextField();
		textTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTenKH.setColumns(10);
		textTenKH.setBounds(143, 115, 257, 28);
		panel_6.add(textTenKH);
		
		textTenNVHD = new JTextField();
		textTenNVHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTenNVHD.setEditable(false);
		textTenNVHD.setColumns(10);
		textTenNVHD.setBounds(143, 81, 257, 28);
		panel_6.add(textTenNVHD);
		
		textDiaChiKH = new JTextField();
		textDiaChiKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textDiaChiKH.setColumns(10);
		textDiaChiKH.setBounds(143, 183, 257, 28);
		panel_6.add(textDiaChiKH);
		
		textTongTienHD = new JTextField();
		textTongTienHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTongTienHD.setEditable(false);
		textTongTienHD.setColumns(10);
		textTongTienHD.setBounds(143, 251, 257, 28);
		panel_6.add(textTongTienHD);
		
		textGhiChuHD = new JTextField();
		textGhiChuHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGhiChuHD.setColumns(10);
		textGhiChuHD.setBounds(143, 285, 257, 28);
		panel_6.add(textGhiChuHD);
		
		dateChooserNgLapHD = new JDateChooser();
		dateChooserNgLapHD.setBounds(143, 217, 127, 28);
		panel_6.add(dateChooserNgLapHD);
		
		JButton btnThemHD = new JButton("Thêm");
		btnThemHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idNV = Integer.parseInt(textMaNVHD.getText().trim());
				String tenKH = textTenKH.getText().trim();
				String sdtKH = textSDTKH.getText().trim();
				String dcKH = textDiaChiKH.getText().trim();
				Date nglapHD = new Date(dateChooserNgLapHD.getDate().getTime());
				double tongtien = 0;
				String ghichu = textGhiChuHD.getText().trim();
				HoaDon hd = new HoaDon(idNV, tenKH, sdtKH, dcKH, nglapHD, tongtien, ghichu);
				
				if(HoaDonDAO.insertHoaDon(hd)){
					JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công!", "Hóa Đơn",
	                        JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Thêm hóa đơn thất bại!",
	                        "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
				}
				loadListHD();
			}
		});
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD.setBounds(10, 323, 90, 35);
		panel_6.add(btnThemHD);
		
		JButton btnCapNhatHD = new JButton("Cập Nhật");
		btnCapNhatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textMaHD.getText().trim().equals("")) {
					
					int idhoadon = Integer.parseInt(textMaHD.getText().trim());
					int idNV = Integer.parseInt(textMaNVHD.getText().trim());
					String tenKH = textTenKH.getText().trim();
					String sdtKH = textSDTKH.getText().trim();
					String dcKH = textDiaChiKH.getText().trim();
					Date nglapHD = new Date(dateChooserNgLapHD.getDate().getTime());
					double tongtien = Double.parseDouble(textTongTienHD.getText().trim());
					String ghichu = textGhiChuHD.getText().trim();
					HoaDon hd = new HoaDon(idhoadon,idNV, tenKH, sdtKH, dcKH, nglapHD, tongtien, ghichu);
					if(HoaDonDAO.updateHoaDon(hd)){
						JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thành công!", "Hóa Đơn",
	                        JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Cập nhật hóa đơn thất bại!",
		                        "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
					}
					loadListHD();
				}
				else {
					JOptionPane.showMessageDialog(null, "Chọn hóa đơn trong bảng Hóa Đơn để cập nhật!", "Hóa Đơn",
	                        JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCapNhatHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatHD.setBounds(210, 323, 90, 35);
		panel_6.add(btnCapNhatHD);
		
		JButton btnXoaHD = new JButton("Xóa");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textMaHD.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Chọn hóa đơn cần xóa trong bảng Hóa Đơn",
	                        "Hóa Đơn", JOptionPane.WARNING_MESSAGE);
				}
				else {
					int mahd = Integer.parseInt(textMaHD.getText().trim());
					if(HoaDonDAO.deleteHoaDon(mahd)) {
						JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!", "Hóa Đơn",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại!",
		                        "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
					}
					loadListHD();
				}
			}
		});
		btnXoaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaHD.setBounds(110, 323, 90, 35);
		panel_6.add(btnXoaHD);
		
		JButton btnResetHD = new JButton("Reset");
		btnResetHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restHoaDon();
			}
		});
		btnResetHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetHD.setBounds(310, 323, 90, 35);
		panel_6.add(btnResetHD);
		
		Label label_10_1_1 = new Label("Mã HĐ:");
		label_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_1_1.setBounds(10, 13, 111, 28);
		panel_6.add(label_10_1_1);
		
		textMaHD = new JTextField();
		textMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaHD.setEditable(false);
		textMaHD.setColumns(10);
		textMaHD.setBounds(143, 13, 127, 28);
		panel_6.add(textMaHD);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		
		Label label_10_8 = new Label("Mã HĐ:");
		label_10_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_8.setBounds(10, 45, 111, 28);
		panel_7.add(label_10_8);
		
		Label label_10_9 = new Label("Mã SP:");
		label_10_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_9.setBounds(10, 79, 111, 28);
		panel_7.add(label_10_9);
		
		Label label_10_10 = new Label("Tên SP:");
		label_10_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_10.setBounds(10, 113, 111, 28);
		panel_7.add(label_10_10);
		
		Label label_10_11 = new Label("Số Lượng:");
		label_10_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_11.setBounds(10, 147, 111, 28);
		panel_7.add(label_10_11);
		
		Label label_10_12 = new Label("Tổng Tiền:");
		label_10_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_12.setBounds(10, 181, 111, 28);
		panel_7.add(label_10_12);
		
		Label label_10_13 = new Label("Ghi Chú:");
		label_10_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_13.setBounds(10, 215, 111, 28);
		panel_7.add(label_10_13);
		
		textTenSPCTHD = new JTextField();
		textTenSPCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTenSPCTHD.setEditable(false);
		textTenSPCTHD.setColumns(10);
		textTenSPCTHD.setBounds(148, 113, 257, 28);
		panel_7.add(textTenSPCTHD);
		
		textSoLuongCTHD = new JTextField();
		textSoLuongCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSoLuongCTHD.setColumns(10);
		textSoLuongCTHD.setBounds(148, 147, 129, 28);
		panel_7.add(textSoLuongCTHD);
		
		textTongTienCTHD = new JTextField();
		textTongTienCTHD.setEditable(false);
		textTongTienCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTongTienCTHD.setColumns(10);
		textTongTienCTHD.setBounds(148, 181, 257, 28);
		panel_7.add(textTongTienCTHD);
		
		textGhiChuCTHD = new JTextField();
		textGhiChuCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGhiChuCTHD.setColumns(10);
		textGhiChuCTHD.setBounds(148, 215, 257, 28);
		panel_7.add(textGhiChuCTHD);
		
		JComboBox cbMaSP = new JComboBox();
		cbMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaSP.setBounds(148, 79, 129, 28);
		panel_7.add(cbMaSP);
		
		JButton btnThemHD_1 = new JButton("Thêm");
		btnThemHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD_1.setBounds(10, 268, 90, 35);
		panel_7.add(btnThemHD_1);
		
		JButton btnXoaHD_1 = new JButton("Xóa");
		btnXoaHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaHD_1.setBounds(110, 268, 90, 35);
		panel_7.add(btnXoaHD_1);
		
		JButton btnResetHD_1 = new JButton("Reset");
		btnResetHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetHD_1.setBounds(310, 268, 90, 35);
		panel_7.add(btnResetHD_1);
		
		JButton btnCapNhatHD_1 = new JButton("Cập Nhật");
		btnCapNhatHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatHD_1.setBounds(210, 268, 90, 35);
		panel_7.add(btnCapNhatHD_1);
		
		Label label_10_10_1 = new Label("Mã CT HĐ:");
		label_10_10_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_10_1.setBounds(10, 10, 111, 28);
		panel_7.add(label_10_10_1);
		
		textMaCTHD = new JTextField();
		textMaCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaCTHD.setEditable(false);
		textMaCTHD.setColumns(10);
		textMaCTHD.setBounds(148, 10, 129, 28);
		panel_7.add(textMaCTHD);
		GroupLayout gl_panelThongTin = new GroupLayout(panelThongTin);
		gl_panelThongTin.setHorizontalGroup(
			gl_panelThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTin.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelThongTin.setVerticalGroup(
			gl_panelThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTin.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JComboBox cbMaHDCTHD = new JComboBox();
		cbMaHDCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaHDCTHD.setBounds(148, 45, 129, 28);
		panel_7.add(cbMaHDCTHD);
		
		textMaNVHD = new JTextField();
		textMaNVHD.setText(id+"");
		textMaNVHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaNVHD.setEditable(false);
		textMaNVHD.setColumns(10);
		textMaNVHD.setBounds(143, 47, 127, 28);
		panel_6.add(textMaNVHD);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(269)
					.addComponent(label_9, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addGap(321))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(9)
					.addComponent(label_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(192)
					.addComponent(label_9_1, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
					.addGap(261))
				.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(9)
					.addComponent(label_9_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		panelThongTin.setLayout(gl_panelThongTin);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane)
		);
		
		JTabbedPane tabbedSanPham = new JTabbedPane(JTabbedPane.TOP);
		tabbedSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabbedPane.addTab("Sản Phẩm", new ImageIcon(AdminJFrame.class.getResource("/images/sanpham.png")), tabbedSanPham, null);
		
		JPanel panel_8 = new JPanel();
		tabbedSanPham.addTab("Sản Phẩm", null, panel_8, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		String[] columnNamesSP = {"STT","Mã Sản Phẩm","Tên Sản Phẩm", "Mã Loại Sản Phẩm","Hãng Sản Xuất","Giá Nhập","Giá Bán","Số Lượng","Trại Thái","Chú Thích"}; 
		Object[][] dataSP= {};
		DefaultTableModel modelSP = new DefaultTableModel(dataSP, columnNamesSP);
		
		
		table_3 = new JTable(modelSP);
		scrollPane_3.setViewportView(table_3);
		
		JTableHeader headerSP = table_3.getTableHeader();
		headerSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_11 = new JPanel();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGroup(gl_panel_8.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_8.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE))
						.addGroup(gl_panel_8.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_11.setLayout(null);
		
		Label label_12 = new Label("Mã Sản Phẩm:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(10, 10, 130, 28);
		panel_11.add(label_12);
		
		Label label_12_1 = new Label("Tên Sản Phẩm:");
		label_12_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_1.setBounds(10, 44, 130, 28);
		panel_11.add(label_12_1);
		
		Label label_12_2 = new Label("Mã Loại Sản Phẩm:");
		label_12_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_2.setBounds(10, 78, 156, 28);
		panel_11.add(label_12_2);
		
		Label label_12_3 = new Label("Hãng Sản Xuất:");
		label_12_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_3.setBounds(454, 10, 130, 28);
		panel_11.add(label_12_3);
		
		Label label_12_4 = new Label("Giá Nhập:");
		label_12_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_4.setBounds(454, 44, 130, 28);
		panel_11.add(label_12_4);
		
		Label label_12_5 = new Label("Giá Bán:");
		label_12_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_5.setBounds(454, 78, 130, 28);
		panel_11.add(label_12_5);
		
		Label label_12_6 = new Label("Số Lượng:");
		label_12_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_6.setBounds(807, 10, 130, 28);
		panel_11.add(label_12_6);
		
		Label label_12_7 = new Label("Trạng Thái:");
		label_12_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_7.setBounds(807, 44, 130, 28);
		panel_11.add(label_12_7);
		
		Label label_12_7_1 = new Label("Chú Thích:");
		label_12_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12_7_1.setBounds(807, 78, 130, 28);
		panel_11.add(label_12_7_1);
		
		textMaLoaiSP = new JTextField();
		textMaLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaLoaiSP.setBounds(172, 78, 187, 28);
		panel_11.add(textMaLoaiSP);
		textMaLoaiSP.setColumns(10);
		
		textTenSP = new JTextField();
		textTenSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTenSP.setColumns(10);
		textTenSP.setBounds(172, 44, 187, 28);
		panel_11.add(textTenSP);
		
		textMaSP = new JTextField();
		textMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaSP.setColumns(10);
		textMaSP.setBounds(172, 10, 187, 28);
		panel_11.add(textMaSP);
		
		textHangSX = new JTextField();
		textHangSX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textHangSX.setColumns(10);
		textHangSX.setBounds(590, 10, 187, 28);
		panel_11.add(textHangSX);
		
		textGiaNhap = new JTextField();
		textGiaNhap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGiaNhap.setColumns(10);
		textGiaNhap.setBounds(590, 44, 187, 28);
		panel_11.add(textGiaNhap);
		
		textGiaBan = new JTextField();
		textGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textGiaBan.setColumns(10);
		textGiaBan.setBounds(590, 78, 187, 28);
		panel_11.add(textGiaBan);
		
		textSoLuongSP = new JTextField();
		textSoLuongSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSoLuongSP.setColumns(10);
		textSoLuongSP.setBounds(943, 10, 187, 28);
		panel_11.add(textSoLuongSP);
		
		textTrangThai = new JTextField();
		textTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTrangThai.setColumns(10);
		textTrangThai.setBounds(943, 44, 187, 28);
		panel_11.add(textTrangThai);
		
		textChuThichSP = new JTextField();
		textChuThichSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textChuThichSP.setColumns(10);
		textChuThichSP.setBounds(943, 78, 187, 28);
		panel_11.add(textChuThichSP);
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemSP.setBounds(274, 162, 109, 33);
		panel_11.add(btnThemSP);
		
		JButton btnXoaSP = new JButton("Xóa");
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaSP.setBounds(416, 162, 109, 33);
		panel_11.add(btnXoaSP);
		
		JButton btnCapNhatSP = new JButton("Cập Nhật");
		btnCapNhatSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatSP.setBounds(559, 162, 109, 33);
		panel_11.add(btnCapNhatSP);
		
		JButton btnResetSP = new JButton("Reset");
		btnResetSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetSP.setBounds(697, 162, 109, 33);
		panel_11.add(btnResetSP);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_9 = new JPanel();
		tabbedSanPham.addTab("Loại Sản Phẩm", null, panel_9, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		String[] columnNamesLSP = {"STT", "Mã Loại Sản Phẩm","Tên Loại Sản Phẩm"}; 
		Object[][] dataLSP= {};
		DefaultTableModel modeLSP = new DefaultTableModel(dataLSP, columnNamesLSP);
		
		table_2 = new JTable(modeLSP);
		scrollPane_2.setViewportView(table_2);
		JTableHeader headerLSP = table_2.getTableHeader();
		headerLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_10 = new JPanel();
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_9.createSequentialGroup()
					.addGap(234)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
					.addGap(242))
				.addGroup(Alignment.LEADING, gl_panel_9.createSequentialGroup()
					.addGap(351)
					.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(361))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(35)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
					.addGap(50)
					.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
					.addGap(48))
		);
		panel_10.setLayout(null);
		
		Label label_11 = new Label("Mã Loại Sản Phẩm:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(10, 10, 162, 32);
		panel_10.add(label_11);
		
		Label label_11_1 = new Label("Tên Loại Sản Phẩm:");
		label_11_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11_1.setBounds(10, 60, 162, 32);
		panel_10.add(label_11_1);
		
		textMaLSP = new JTextField();
		textMaLSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textMaLSP.setBounds(190, 10, 257, 32);
		panel_10.add(textMaLSP);
		textMaLSP.setColumns(10);
		
		textTenLoaiSP = new JTextField();
		textTenLoaiSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textTenLoaiSP.setColumns(10);
		textTenLoaiSP.setBounds(190, 60, 257, 32);
		panel_10.add(textTenLoaiSP);
		
		JButton btnThemLSP = new JButton("Thêm");
		btnThemLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemLSP.setBounds(10, 136, 94, 32);
		panel_10.add(btnThemLSP);
		
		JButton btnResetLSP = new JButton("Reset");
		btnResetLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetLSP.setBounds(353, 136, 94, 32);
		panel_10.add(btnResetLSP);
		
		JButton btnCapNhatLSP = new JButton("Cập Nhật");
		btnCapNhatLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatLSP.setBounds(237, 136, 94, 32);
		panel_10.add(btnCapNhatLSP);
		
		JButton btnXoaLSP = new JButton("Xóa");
		btnXoaLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaLSP.setBounds(125, 136, 94, 32);
		panel_10.add(btnXoaLSP);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("Thông Tin", new ImageIcon(AdminJFrame.class.getResource("/images/me.png")), panel_12, null);
		
		JPanel panel_13 = new JPanel();
		panel_13.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				LoginJDialog login = new LoginJDialog(); 
				login.main(null);
				setVisible(false);
			}
		});
		panel_13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				LoginJDialog login = new LoginJDialog(); 
				login.main(null);
				setVisible(false);
			}
		});
		panel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				LoginJDialog login = new LoginJDialog(); 
//				login.main(null);
//				frame.setVisible(false);
			}
		});
		tabbedPane.addTab("Đăng Xuất", new ImageIcon(NhanVienJFrame.class.getResource("/images/777820.png")), panel_13, null);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int manv = Integer.parseInt(table.getModel().getValueAt(index, 2).toString().trim());
				NhanVien nv = NhanVienDAO.getNhanVien(manv);
				textMaHD.setText(table.getModel().getValueAt(index, 1).toString().trim());
				textMaNVHD.setText(table.getModel().getValueAt(index, 2).toString().trim());
				textTenNVHD.setText(nv.getTennv());
				textTenKH.setText(table.getModel().getValueAt(index, 3).toString().trim());
				textSDTKH.setText(table.getModel().getValueAt(index, 4).toString().trim());
				textDiaChiKH.setText(table.getModel().getValueAt(index, 5).toString().trim());
				String date =table.getModel().getValueAt(index, 6).toString().trim();
				Date dateHD = Date.valueOf(date);
				dateChooserNgLapHD.setDate(dateHD);
				textTongTienHD.setText(table.getModel().getValueAt(index, 7).toString().trim());
				textGhiChuHD.setText(table.getModel().getValueAt(index, 8).toString().trim());
				
				
			}
		});
		
		loadListHD();
	}
	
	private void restHoaDon() {
		textTenNVHD.setText(NhanVienDAO.getNhanVien(maNV).getTennv());
		textMaNVHD.setText(this.maNV+"");
		textMaHD.setText("");
		textTenKH.setText("");
		textSDTKH.setText("");
		textDiaChiKH.setText("");
		dateChooserNgLapHD.setDate(null);
		textTongTienHD.setText("");
		textGhiChuHD.setText("");
	}
	
	private void loadListHD(){
		List<HoaDon> list = HoaDonDAO.getAllHoaDon();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		int i = 1;
		for(HoaDon hd : list) {
			Object[] row = new Object[] {
					i, hd.getIdhoadon(), hd.getManv(), hd.getTenkh(), hd.getSodt(), hd.getDiachi(),hd.getNgaylaphoadon(), hd.getTongtien(), hd.getGhichu()
			};
			model.addRow(row);
			i++;
		}
	}
}
