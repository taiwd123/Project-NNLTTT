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

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
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
import Login.LoginJDialog;

public class NhanVienJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textSDTKH;
	private JTextField textTenKH;
	private JTextField textTenNVHD;
	private JTextField textDiaChiKH;
	private JTextField textTongTienHD;
	private JTextField textGhiChuHD;
	private JTextField textMaHDCTHD;
	private JTextField textTenSPCTHD;
	private JTextField textSoLuong;
	private JTextField textTongTienCTHD;
	private JTextField textGhiChuCTHD;
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
	private static NhanVienJFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { frame = new
		 * NhanVienJFrame(); frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } });
		 */
		try {
			frame = new NhanVienJFrame();
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
	public NhanVienJFrame() {
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
		
		JPanel panel_7 = new JPanel();
		GroupLayout gl_panelThongTin = new GroupLayout(panelThongTin);
		gl_panelThongTin.setHorizontalGroup(
			gl_panelThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTin.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_5, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelThongTin.setVerticalGroup(
			gl_panelThongTin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelThongTin.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panelThongTin.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_7.setLayout(null);
		
		Label label_10_8 = new Label("Mã HĐ:");
		label_10_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_8.setBounds(10, 10, 111, 28);
		panel_7.add(label_10_8);
		
		Label label_10_9 = new Label("Mã SP:");
		label_10_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_9.setBounds(10, 44, 111, 28);
		panel_7.add(label_10_9);
		
		Label label_10_10 = new Label("Tên SP:");
		label_10_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_10.setBounds(10, 78, 111, 28);
		panel_7.add(label_10_10);
		
		Label label_10_11 = new Label("Số Lượng:");
		label_10_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_11.setBounds(10, 112, 111, 28);
		panel_7.add(label_10_11);
		
		Label label_10_12 = new Label("Tổng Tiền:");
		label_10_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_12.setBounds(10, 146, 111, 28);
		panel_7.add(label_10_12);
		
		Label label_10_13 = new Label("Ghi Chú:");
		label_10_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_13.setBounds(10, 180, 111, 28);
		panel_7.add(label_10_13);
		
		textMaHDCTHD = new JTextField();
		textMaHDCTHD.setColumns(10);
		textMaHDCTHD.setBounds(148, 10, 257, 28);
		panel_7.add(textMaHDCTHD);
		
		textTenSPCTHD = new JTextField();
		textTenSPCTHD.setEditable(false);
		textTenSPCTHD.setColumns(10);
		textTenSPCTHD.setBounds(148, 78, 257, 28);
		panel_7.add(textTenSPCTHD);
		
		textSoLuong = new JTextField();
		textSoLuong.setColumns(10);
		textSoLuong.setBounds(148, 112, 129, 28);
		panel_7.add(textSoLuong);
		
		textTongTienCTHD = new JTextField();
		textTongTienCTHD.setColumns(10);
		textTongTienCTHD.setBounds(148, 146, 257, 28);
		panel_7.add(textTongTienCTHD);
		
		textGhiChuCTHD = new JTextField();
		textGhiChuCTHD.setColumns(10);
		textGhiChuCTHD.setBounds(148, 180, 257, 28);
		panel_7.add(textGhiChuCTHD);
		
		JComboBox cbMaSP = new JComboBox();
		cbMaSP.setBounds(148, 44, 129, 28);
		panel_7.add(cbMaSP);
		
		JButton btnThemHD_1 = new JButton("Thêm");
		btnThemHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD_1.setBounds(148, 234, 95, 35);
		panel_7.add(btnThemHD_1);
		
		JButton btnXoaHD_1 = new JButton("Xóa");
		btnXoaHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaHD_1.setBounds(148, 279, 95, 35);
		panel_7.add(btnXoaHD_1);
		
		JButton btnResetHD_1 = new JButton("Reset");
		btnResetHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetHD_1.setBounds(310, 279, 95, 35);
		panel_7.add(btnResetHD_1);
		
		JButton btnCapNhatHD_1 = new JButton("Cập Nhật");
		btnCapNhatHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatHD_1.setBounds(310, 234, 95, 35);
		panel_7.add(btnCapNhatHD_1);
		panel_6.setLayout(null);
		
		Label label_10 = new Label("Mã NV:");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(10, 12, 111, 28);
		panel_6.add(label_10);
		
		Label label_10_1 = new Label("Tên NV:");
		label_10_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_1.setBounds(10, 46, 111, 28);
		panel_6.add(label_10_1);
		
		Label label_10_2 = new Label("Tên KH:");
		label_10_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_2.setBounds(10, 80, 111, 28);
		panel_6.add(label_10_2);
		
		Label label_10_3 = new Label("Điện Thoại KH:");
		label_10_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_3.setBounds(10, 114, 127, 28);
		panel_6.add(label_10_3);
		
		Label label_10_4 = new Label("Địa Chỉ KH:");
		label_10_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_4.setBounds(10, 148, 111, 28);
		panel_6.add(label_10_4);
		
		Label label_10_5 = new Label("Ngày Lập HĐ:");
		label_10_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_5.setBounds(10, 182, 111, 28);
		panel_6.add(label_10_5);
		
		Label label_10_6 = new Label("Tổng Tiền:");
		label_10_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_6.setBounds(10, 216, 111, 28);
		panel_6.add(label_10_6);
		
		Label label_10_7 = new Label("Ghi Chú:");
		label_10_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10_7.setBounds(10, 250, 111, 28);
		panel_6.add(label_10_7);
		
		textSDTKH = new JTextField();
		textSDTKH.setBounds(143, 114, 257, 28);
		panel_6.add(textSDTKH);
		textSDTKH.setColumns(10);
		
		textTenKH = new JTextField();
		textTenKH.setColumns(10);
		textTenKH.setBounds(143, 80, 257, 28);
		panel_6.add(textTenKH);
		
		textTenNVHD = new JTextField();
		textTenNVHD.setEditable(false);
		textTenNVHD.setColumns(10);
		textTenNVHD.setBounds(143, 46, 257, 28);
		panel_6.add(textTenNVHD);
		
		textDiaChiKH = new JTextField();
		textDiaChiKH.setColumns(10);
		textDiaChiKH.setBounds(143, 148, 257, 28);
		panel_6.add(textDiaChiKH);
		
		textTongTienHD = new JTextField();
		textTongTienHD.setEditable(false);
		textTongTienHD.setColumns(10);
		textTongTienHD.setBounds(143, 216, 257, 28);
		panel_6.add(textTongTienHD);
		
		textGhiChuHD = new JTextField();
		textGhiChuHD.setColumns(10);
		textGhiChuHD.setBounds(143, 250, 257, 28);
		panel_6.add(textGhiChuHD);
		
		JDateChooser dateChooserNgLapHD = new JDateChooser();
		dateChooserNgLapHD.setBounds(143, 182, 127, 28);
		panel_6.add(dateChooserNgLapHD);
		
		JButton btnThemHD = new JButton("Thêm");
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD.setBounds(143, 288, 95, 35);
		panel_6.add(btnThemHD);
		
		JButton btnCapNhatHD = new JButton("Cập Nhật");
		btnCapNhatHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatHD.setBounds(305, 288, 95, 35);
		panel_6.add(btnCapNhatHD);
		
		JButton btnXoaHD = new JButton("Xóa");
		btnXoaHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaHD.setBounds(143, 333, 95, 35);
		panel_6.add(btnXoaHD);
		
		JButton btnResetHD = new JButton("Reset");
		btnResetHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetHD.setBounds(305, 333, 95, 35);
		panel_6.add(btnResetHD);
		
		JComboBox cbMaNVHD = new JComboBox();
		cbMaNVHD.setBounds(143, 12, 127, 28);
		panel_6.add(cbMaNVHD);
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
					.addGroup(gl_panel_8.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panel_8.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panel_8.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane_3, GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(scrollPane_3)
					.addGap(18)
					.addComponent(panel_11, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
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
		textMaLoaiSP.setBounds(172, 78, 187, 28);
		panel_11.add(textMaLoaiSP);
		textMaLoaiSP.setColumns(10);
		
		textTenSP = new JTextField();
		textTenSP.setColumns(10);
		textTenSP.setBounds(172, 44, 187, 28);
		panel_11.add(textTenSP);
		
		textMaSP = new JTextField();
		textMaSP.setColumns(10);
		textMaSP.setBounds(172, 10, 187, 28);
		panel_11.add(textMaSP);
		
		textHangSX = new JTextField();
		textHangSX.setColumns(10);
		textHangSX.setBounds(590, 10, 187, 28);
		panel_11.add(textHangSX);
		
		textGiaNhap = new JTextField();
		textGiaNhap.setColumns(10);
		textGiaNhap.setBounds(590, 44, 187, 28);
		panel_11.add(textGiaNhap);
		
		textGiaBan = new JTextField();
		textGiaBan.setColumns(10);
		textGiaBan.setBounds(590, 78, 187, 28);
		panel_11.add(textGiaBan);
		
		textSoLuongSP = new JTextField();
		textSoLuongSP.setColumns(10);
		textSoLuongSP.setBounds(943, 10, 187, 28);
		panel_11.add(textSoLuongSP);
		
		textTrangThai = new JTextField();
		textTrangThai.setColumns(10);
		textTrangThai.setBounds(943, 44, 187, 28);
		panel_11.add(textTrangThai);
		
		textChuThichSP = new JTextField();
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
		textMaLSP.setBounds(190, 10, 257, 32);
		panel_10.add(textMaLSP);
		textMaLSP.setColumns(10);
		
		textTenLoaiSP = new JTextField();
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
				frame.setVisible(false);
			}
		});
		panel_13.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				LoginJDialog login = new LoginJDialog(); 
				login.main(null);
				frame.setVisible(false);
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
	}

}
