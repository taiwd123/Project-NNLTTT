package NhanVienForm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.toedter.calendar.JDateChooser;

import AdminForm.AdminJFrame;
import BEAN.ChiTietHoaDon;
import BEAN.HoaDon;
import BEAN.LoaiSanPhan;
import BEAN.NhanVien;
import BEAN.SanPham;
import BEAN.TaiKhoan;
import BEAN.ThongKeNam;
import BEAN.ThongKeThang;
import DAO.ChiTietHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.LoaiSanPhamDAO;
import DAO.NhanVienDAO;
import DAO.SanPhamDAO;
import DAO.TaiKhoanDAO;
import Login.LoginJDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;

public class NhanVienJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textMaLSP;
	private JTextField textTenLoaiSP;
	private JTable table_3;
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
	private JComboBox cb_Maloai;
	private JComboBox cbMaSP;
	private JComboBox cbMaHDCTHD;
	private String maspCurr;
	private int slCurr;

	
	//get ID từ form đăng nhập
		private int maNV;
		private JTextField textMaNVHD;
		private JTextField textTenLSPSP;
		
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
		panelThongTin.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				loadListHD();
				loadListCTHD();
			}
		});
		tabbedPane.addTab("Hóa Đơn", new ImageIcon(NhanVienJFrame.class.getResource("/images/hoadon Icon.jpg")), panelThongTin, null);
		
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
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				textMaCTHD.setText(table_1.getModel().getValueAt(index, 1).toString().trim());
				cbMaHDCTHD.setSelectedItem(Integer.parseInt(table_1.getModel().getValueAt(index, 2).toString().trim()));
				String masp = table_1.getModel().getValueAt(index, 3).toString().trim();
				cbMaSP.setSelectedItem(masp);
				textTenSPCTHD.setText(SanPhamDAO.getSanPham(masp).getTenSP());
				textSoLuongCTHD.setText(table_1.getModel().getValueAt(index, 4).toString().trim());
				textTongTienCTHD.setText(table_1.getModel().getValueAt(index, 5).toString().trim());
				textGhiChuCTHD.setText(table_1.getModel().getValueAt(index, 6).toString().trim());
				
				maspCurr = table_1.getModel().getValueAt(index, 3).toString().trim();
				slCurr = Integer.parseInt(table_1.getModel().getValueAt(index, 4).toString().trim());
				
				cbMaHDCTHD.disable();
			}
		});
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
				if(dateChooserNgLapHD.getDate() != null) {
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
					loadCbMaSP();
					loadCbMaHDCTHD();
				}else {
					JOptionPane.showMessageDialog(null, "Thêm hóa đơn thất bại!",
	                        "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThemHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD.setBounds(10, 323, 90, 35);
		panel_6.add(btnThemHD);
		
		JButton btnCapNhatHD = new JButton("Cập Nhật");
		btnCapNhatHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Cập Nhật Hóa Đơn Này?", "Hóa Đơn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
			}
		});
		btnCapNhatHD.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatHD.setBounds(210, 323, 90, 35);
		panel_6.add(btnCapNhatHD);
		
		JButton btnXoaHD = new JButton("Xóa");
		btnXoaHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Xóa Hóa Đơn Này?", "Hóa Đơn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					if(textMaHD.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Chọn hóa đơn cần xóa trong bảng Hóa Đơn",
		                        "Hóa Đơn", JOptionPane.WARNING_MESSAGE);
					}
					else {
						int mahd = Integer.parseInt(textMaHD.getText().trim());
						if(ChiTietHoaDonDAO.deleteCTHDByMaHD(mahd)) {
							HoaDonDAO.deleteHoaDon(mahd);
							JOptionPane.showMessageDialog(null, "Xóa hóa đơn thành công!", "Hóa Đơn",
			                        JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Xóa hóa đơn thất bại!",
			                        "Hóa Đơn", JOptionPane.ERROR_MESSAGE);
						}
						loadListHD();
						loadCbMaSP();
						loadCbMaHDCTHD();
						loadListCTHD();
					}
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
				loadListHD();
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
		textSoLuongCTHD.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String masp = String.valueOf(cbMaSP.getSelectedItem());
				if(!textSoLuongCTHD.getText().trim().equals("")) {
					SanPham sp = SanPhamDAO.getSanPham(masp);
					int sl = Integer.parseInt(textSoLuongCTHD.getText().trim());
					double tongtien = sp.getGiaban() * sl;
					textTongTienCTHD.setText(tongtien+"");
				}
				else {
					textTongTienCTHD.setText(0+"");
				}
			}
		});
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
		
		cbMaSP = new JComboBox();
		cbMaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbMaSP.getSelectedItem()!= null) {
					String masp = String.valueOf(cbMaSP.getSelectedItem());
					SanPham sp = SanPhamDAO.getSanPham(masp);
					textTenSPCTHD.setText(sp.getTenSP());
					double gia = sp.getGiaban();
					if(!textSoLuongCTHD.getText().trim().equals("")) {
						int sl = Integer.parseInt(textSoLuongCTHD.getText().trim());
						textTongTienCTHD.setText((gia * sl)+"");
					}
				}
			}
		});
		cbMaSP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaSP.setBounds(148, 79, 129, 28);
		panel_7.add(cbMaSP);
		
		JButton btnThemHD_1 = new JButton("Thêm");
		btnThemHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sl;
				if(textSoLuongCTHD.getText().trim().equals("")) {
					sl = 0;
				}
				else {
					sl = Integer.parseInt(textSoLuongCTHD.getText().trim());
				}
				int mahd = Integer.parseInt(String.valueOf(cbMaHDCTHD.getSelectedItem()));
				String masp = String.valueOf(cbMaSP.getSelectedItem());
				int slTrongCH = SanPhamDAO.getSoluong(masp);
				if(sl > slTrongCH) {
					JOptionPane.showMessageDialog(null, "Số lượng sản phẩm này trong của hàng không đủ!!", "Chi Tiết Hóa Đơn",
	                        JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					double tongtien;
					if(sl == 0) {
						tongtien = 0;
					}
					else {
						tongtien = Double.parseDouble(textTongTienCTHD.getText().trim());
					}
					if(sl == slTrongCH) {
						SanPhamDAO.updateTrangThai(masp, "Hết hàng");
					}
					String ghichu = textGhiChuCTHD.getText().trim();
					ChiTietHoaDon cthd = new ChiTietHoaDon(mahd, masp,sl,tongtien,ghichu);
					if(ChiTietHoaDonDAO.insertChiTietHD(cthd)) {
						HoaDonDAO.updateTongTien(mahd, tongtien);
						SanPhamDAO.updateSoluong(masp, -sl);
						JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thành công!", "Chi Tiết Hóa Đơn",
		                        JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thất bại!", "Chi Tiết Hóa Đơn",
		                        JOptionPane.ERROR_MESSAGE);
					}
				}
				
				loadListHD();
				loadListCTHD();
			}
		});
		btnThemHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemHD_1.setBounds(10, 268, 90, 35);
		panel_7.add(btnThemHD_1);
		
		JButton btnXoaHD_1 = new JButton("Xóa");
		btnXoaHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Chắc Chắn Xóa Chi Tiết Hóa Đơn Này?", "Chi Tiết Hóa Đơn",
                        JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					if(textMaCTHD.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Chọn chi tiết hóa đơn cần xóa trong bảng Chi Tiết Hóa Đơn!", "Chi Tiết Hóa Đơn",
		                        JOptionPane.WARNING_MESSAGE);
					}
					else {
						int maCTHD = Integer.parseInt(textMaCTHD.getText().trim());
						int maHD = Integer.parseInt(String.valueOf(cbMaHDCTHD.getSelectedItem()));
						double tongtien =0 - Double.parseDouble(textTongTienCTHD.getText().trim());
						int slTrongKho =  SanPhamDAO.getSoluong(maspCurr);
						if(slTrongKho == 0 && slCurr !=0) {
							SanPhamDAO.updateTrangThai(maspCurr, "Còn Hàng");
						}
						if(ChiTietHoaDonDAO.deleteChiTietHD(maCTHD)) {
							HoaDonDAO.updateTongTien(maHD, tongtien);
							SanPhamDAO.updateSoluong(maspCurr, slCurr);
							JOptionPane.showMessageDialog(null, "Xóa chi tiết hóa đơn thành công!", "Chi Tiết Hóa Đơn",
			                        JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thất bại!", "Chi Tiết Hóa Đơn",
			                        JOptionPane.ERROR_MESSAGE);
						}
					}
					loadListHD();
					loadListCTHD();
				}
			}
		});
		btnXoaHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaHD_1.setBounds(110, 268, 90, 35);
		panel_7.add(btnXoaHD_1);
		
		JButton btnResetHD_1 = new JButton("Reset");
		btnResetHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetCTHoaDon();
				loadListCTHD();
			}
		});
		btnResetHD_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetHD_1.setBounds(310, 268, 90, 35);
		panel_7.add(btnResetHD_1);
		
		JButton btnCapNhatHD_1 = new JButton("Cập Nhật");
		btnCapNhatHD_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Cập Nhật Chi Tiết Hóa Đơn Này?", "Chi Tiết Hóa Đơn", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					if(textMaCTHD.getText().equals("") || cbMaSP.getSelectedItem() == null || cbMaHDCTHD.getSelectedItem()==null) {
						JOptionPane.showMessageDialog(null, "Cập Nhật Không Thành Công", "Chi Tiết Hóa Đơn", JOptionPane.WARNING_MESSAGE);
					}
					else {
						int idcthd =Integer.parseInt(textMaCTHD.getText()) ;
						int idhd = Integer.parseInt(String.valueOf(cbMaHDCTHD.getSelectedItem()));
						String masp = String.valueOf(cbMaSP.getSelectedItem());
						int sl = Integer.parseInt(textSoLuongCTHD.getText());
						double tong = Double.parseDouble(textTongTienCTHD.getText());
						String gchu = textGhiChuCTHD.getText();
						ChiTietHoaDon cthd = new ChiTietHoaDon(idcthd, idhd, masp, sl, tong, gchu);
						double ttCurr = ChiTietHoaDonDAO.getTongTien(idcthd);
						double ttchange = ttCurr - tong;
						if(masp.equals(maspCurr)) {
							int slChange = sl - slCurr;
							int slTrongKho = SanPhamDAO.getSoluong(masp);
							if((slTrongKho - slChange) < 0) {
								JOptionPane.showMessageDialog(null, "Số lượng sản phẩm này trong của hàng không đủ!!", "Chi Tiết Hóa Đơn",
				                        JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								if(slTrongKho == 0 && (slTrongKho - slChange) >0) {
									SanPhamDAO.updateTrangThai(masp, "Còn hàng");
								}
								if(ChiTietHoaDonDAO.updateChiTietHD(cthd)) {
									HoaDonDAO.updateTongTien(idhd, -ttchange);
									SanPhamDAO.updateSoluong(masp, -slChange);
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công", "Chi Tiết Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Không Thành Công", "Chi Tiết Hóa Đơn", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						else {
							int slCurrTrongKho = SanPhamDAO.getSoluong(maspCurr);
							int slTrongKho = SanPhamDAO.getSoluong(masp);
							if(slTrongKho < sl) {
								JOptionPane.showMessageDialog(null, "Số lượng sản phẩm này trong của hàng không đủ!!", "Chi Tiết Hóa Đơn",
				                        JOptionPane.INFORMATION_MESSAGE);
							}
							else {
								if(slCurrTrongKho == 0 && slCurr !=0 ) {
									SanPhamDAO.updateTrangThai(maspCurr, "Còn Hàng");
								}
								if(slTrongKho == sl) {
									SanPhamDAO.updateTrangThai(masp, "Hết hàng");
								}
								if(ChiTietHoaDonDAO.updateChiTietHD(cthd)) {
									HoaDonDAO.updateTongTien(idhd, -ttchange);
									SanPhamDAO.updateSoluong(masp, -sl);
									SanPhamDAO.updateSoluong(maspCurr, slCurr);
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công", "Chi Tiết Hóa Đơn", JOptionPane.INFORMATION_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Không Thành Công", "Chi Tiết Hóa Đơn", JOptionPane.ERROR_MESSAGE);
								}
							}
						}
						loadListCTHDByMaHD(idhd);
						loadListHD();
					}
					
				}
			}
		});
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
		
		cbMaHDCTHD = new JComboBox();
		cbMaHDCTHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbMaHDCTHD.setBounds(148, 45, 129, 28);
		panel_7.add(cbMaHDCTHD);
		
		JButton btnLoc = new JButton("Tìm");
		btnLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbMaHDCTHD.getSelectedItem()!=null) {
					int mahd = Integer.parseInt(String.valueOf(cbMaHDCTHD.getSelectedItem()));
					loadListCTHDByMaHD(mahd);
				}
			}
		});
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoc.setBounds(310, 45, 90, 28);
		panel_7.add(btnLoc);
		
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
		tabbedSanPham.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				loadTableLSP();
				loadTableSP();
			}
		});
		tabbedSanPham.setFont(new Font("Tahoma", Font.BOLD, 14));
		tabbedPane.addTab("Sản Phẩm", new ImageIcon(NhanVienJFrame.class.getResource("/images/sanpham Icon.png")), tabbedSanPham, null);
		
		JPanel panel_8 = new JPanel();
		tabbedSanPham.addTab("Sản Phẩm", null, panel_8, null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		String[] columnNamesSP = {"STT","Mã Sản Phẩm","Tên Sản Phẩm", "Mã Loại Sản Phẩm","Hãng Sản Xuất","Giá Nhập","Giá Bán","Số Lượng","Trại Thái","Chú Thích"}; 
		Object[][] dataSP= {};
		DefaultTableModel modelSP = new DefaultTableModel(dataSP, columnNamesSP);
		
		
		table_3 = new JTable(modelSP)
		{
			@Override
			   public boolean isCellEditable(int row, int column) {
			    // set table column uneditable
			    return false;
			   }
		};
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_3.getSelectedRow();
				textMaSP.setText(table_3.getModel().getValueAt(index,1).toString());
				textTenSP.setText(table_3.getModel().getValueAt(index,2).toString());
				cb_Maloai.setSelectedItem(table_3.getModel().getValueAt(index,3).toString());
				cb_Maloai.disable();
				textMaSP.setEditable(false);
				textHangSX.setText(table_3.getModel().getValueAt(index,4).toString());
				textGiaNhap.setText(table_3.getModel().getValueAt(index,5).toString());
				textGiaBan.setText(table_3.getModel().getValueAt(index,6).toString());
				textSoLuongSP.setText(table_3.getModel().getValueAt(index,7).toString());
				textTrangThai.setText(table_3.getModel().getValueAt(index,8).toString());
				if(table_3.getModel().getValueAt(index,9)!=null){
					textChuThichSP.setText(table_3.getModel().getValueAt(index,9).toString());
				}
				else {
					textChuThichSP.setText("");
				}
				
				textTrangThai.setEditable(false);
			}
		});
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
		btnThemSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textMaSP.getText().equals("") || textTenSP.getText().equals("") || cb_Maloai.getSelectedItem()==null 
						|| textGiaBan.getText().equals("") || textGiaBan.getText().equals("") || textHangSX.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btnThemSP, "Nhập Đủ Thông Tin Sản Phẩm !!", "Sản Phẩm", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						String masp=textMaSP.getText();
						String tensp=textTenSP.getText();
						String loaisp=(String) cb_Maloai.getSelectedItem();
						String hang=textHangSX.getText();
						Double gnhap=Double.valueOf(textGiaNhap.getText());
						Double gban=Double.valueOf(textGiaBan.getText());
						int sl=Integer.valueOf(textSoLuongSP.getText());
						String tt=textTrangThai.getText();
						String ct=textChuThichSP.getText();
						SanPham sp=new SanPham(masp, tensp, loaisp, hang, gnhap, gban, sl, tt, ct);
						if(SanPhamDAO.checkExistMaSP(masp, loaisp))
						{
							if(SanPhamDAO.insertSP(sp)) {
								JOptionPane.showMessageDialog(btnThemSP, "Thêm Sản Phẩm Thành Công", "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
								loadTableSP();
								clearTBSP();
								loadCbMaSP();
							}
							else {
								JOptionPane.showMessageDialog(btnThemSP, "Thêm Sản Phẩm Thành Công", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(btnThemSP, "Mã sản phẩm hoặc sản phẩm đã tồn tại", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);	
						}				
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(btnThemSP, ex.getMessage().toString(), "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemSP.setBounds(274, 162, 109, 33);
		panel_11.add(btnThemSP);
		
		JButton btnXoaSP = new JButton("Xóa");
		btnXoaSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Xóa Sản Phẩm Này?", "Sản Phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					if(!textTenSP.getText().equals("")) 
					{
						try {
							String masp=textMaSP.getText();
							if(SanPhamDAO.deleteSP(masp)) {
								JOptionPane.showMessageDialog(btnXoaSP, "Xóa Sản Phẩm Thành Công", "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
								loadTableSP();
								clearTBSP();
							}
							else {
								JOptionPane.showMessageDialog(btnXoaSP, "Xóa Sản Phẩm Không Thành Công", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);
							}
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(btnXoaSP, ex.getMessage().toString(), "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else {
						JOptionPane.showMessageDialog(btnXoaSP, "Chọn Sản Phẩm Để Xóa !!", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaSP.setBounds(416, 162, 109, 33);
		panel_11.add(btnXoaSP);
		
		JButton btnCapNhatSP = new JButton("Cập Nhật");
		btnCapNhatSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Cập Nhật Sản Phẩm Này?", "Sản Phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					if(!textTenSP.getText().equals("")) 
					{
						try {
							String masp=textMaSP.getText();
							String tensp=textTenSP.getText();
							String loaisp=(String) cb_Maloai.getSelectedItem();
							String hang=textHangSX.getText();
							Double gnhap=Double.valueOf(textGiaNhap.getText());
							Double gban=Double.valueOf(textGiaBan.getText());
							int sl=Integer.valueOf(textSoLuongSP.getText());
							String tt=textTrangThai.getText();
							String ct=textChuThichSP.getText();
							
							int slTrongCH = SanPhamDAO.getSoluong(masp);
							if(slTrongCH == 0 && sl != 0) {
								tt = "Còn hàng";
								SanPhamDAO.updateTrangThai(masp, tt);
							}
							SanPham sp=new SanPham(masp, tensp, loaisp, hang, gnhap, gban, sl, tt, ct);
							if(SanPhamDAO.updateSP(sp)) {
								JOptionPane.showMessageDialog(btnCapNhatSP, "Cập Nhật Sản Phẩm Thành Công", "Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
								loadTableSP();
							}
							else {
								JOptionPane.showMessageDialog(btnCapNhatSP, "Cập Nhật Sản Phẩm Không Thành Công", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);
							}
												
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(btnCapNhatSP, ex.getMessage().toString(), "Update", JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else {
						JOptionPane.showMessageDialog(btnCapNhatSP, "Chọn Sản Phẩm Để Cập Nhật!!", "Sản Phẩm", JOptionPane.ERROR_MESSAGE);
					}
				}		
				
			}
		});
		btnCapNhatSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatSP.setBounds(559, 162, 109, 33);
		panel_11.add(btnCapNhatSP);
		
		JButton btnResetSP = new JButton("Reset");
		btnResetSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTBSP();
				cb_Maloai.enable();
				textMaSP.setEditable(true);		
				textTrangThai.setEditable(true);
			}
		});
		btnResetSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetSP.setBounds(697, 162, 109, 33);
		panel_11.add(btnResetSP);
		
		cb_Maloai = new JComboBox();
		cb_Maloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String malsp = String.valueOf(cb_Maloai.getSelectedItem());
				LoaiSanPhan lsp = LoaiSanPhamDAO.getLoaiSP(malsp);
				textTenLSPSP.setText(lsp.getTenloaiSP());
			}
		});
		cb_Maloai.setBounds(172, 78, 92, 28);
		panel_11.add(cb_Maloai);
		
		textTenLSPSP = new JTextField();
		textTenLSPSP.setEditable(false);
		textTenLSPSP.setColumns(10);
		textTenLSPSP.setBounds(267, 78, 92, 28);
		panel_11.add(textTenLSPSP);
		
		JComboBox cb_Maloai_1 = new JComboBox();
		cb_Maloai_1.setBounds(172, 78, 92, 28);
		panel_11.add(cb_Maloai_1);
		
		Label label_SapXep = new Label("Sắp Xếp");
		label_SapXep.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_SapXep.setAlignment(Label.CENTER);
		label_SapXep.setBounds(813, 162, 102, 33);
		panel_11.add(label_SapXep);
		
		JComboBox cb_SapXepSP = new JComboBox(new Object[]{});
		cb_SapXepSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTBTSapXepSP(SanPhamDAO.getListSPbySapXep(cb_SapXepSP.getSelectedItem().toString()));
			}
		});
		cb_SapXepSP.setModel(new DefaultComboBoxModel(new String[] {"Tên Sản Phẩm", "Mã Loại Sản Phẩm", "Giá Bán"}));
		cb_SapXepSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		cb_SapXepSP.setBounds(943, 162, 187, 33);
		panel_11.add(cb_SapXepSP);
		panel_8.setLayout(gl_panel_8);
		
		JPanel panel_9 = new JPanel();
		tabbedSanPham.addTab("Loại Sản Phẩm", null, panel_9, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		String[] columnNamesLSP = {"STT", "Mã Loại Sản Phẩm","Tên Loại Sản Phẩm"}; 
		Object[][] dataLSP= {};
		DefaultTableModel modeLSP = new DefaultTableModel(dataLSP, columnNamesLSP);
		
		table_2 = new JTable(modeLSP)
		{
			 @Override
			   public boolean isCellEditable(int row, int column) {
			    // set table column uneditable
			    return false;
			   }
		};
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table_2.getSelectedRow();
				textMaLSP.setText(table_2.getModel().getValueAt(index,1).toString());
				textMaLSP.disable();
				textTenLoaiSP.setText(table_2.getModel().getValueAt(index, 2).toString());
			}
		});
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
		btnThemLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textTenLoaiSP.getText().equals("")||textMaLSP.getText().equals(""))
				{
					JOptionPane.showMessageDialog(btnThemLSP, "Nhập Đủ Thông Tin Loại Sản Phẩm", "Loại Sản Phẩm", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						String maloaiSP=textMaLSP.getText();
						String tenloaisp=textTenLoaiSP.getText();
						LoaiSanPhan lsp=new LoaiSanPhan(maloaiSP, tenloaisp);
						if(LoaiSanPhamDAO.checkExistMaLSP(maloaiSP,tenloaisp))
						{										
							if(LoaiSanPhamDAO.insertLoaiSP(lsp)) {
								JOptionPane.showMessageDialog(btnThemLSP, "Thêm Loại Sản Phẩm Thành Công", "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
								loadTableLSP();
								loadcbMaLSP();
								
							}
							else {
								JOptionPane.showMessageDialog(btnThemLSP, "Thêm Loại Sản Phẩm Không Thành Công", "Loại Sản Phẩm", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {						
							JOptionPane.showMessageDialog(btnThemLSP, "Mã loại sản phẩm hoặc loại sản phẩm đã tồn tại", "Loại Sản Phẩm", JOptionPane.ERROR_MESSAGE);					
						}
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(btnThemLSP, ex.getMessage().toString(), "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
					}	
				}
			}
		});
		btnThemLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThemLSP.setBounds(10, 136, 94, 32);
		panel_10.add(btnThemLSP);
		
		JButton btnResetLSP = new JButton("Reset");
		btnResetLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTBLSP();
				textMaLSP.enable();
			}
		});
		btnResetLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnResetLSP.setBounds(353, 136, 94, 32);
		panel_10.add(btnResetLSP);
		
		JButton btnCapNhatLSP = new JButton("Cập Nhật");
		btnCapNhatLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Cập Nhật Loại Sản Phẩm Này?", "Loại Sản Phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					if(!textTenLoaiSP.getText().equals("")) 
					{
						try {
							String maloaiSP=textMaLSP.getText();
							String tenloaisp=textTenLoaiSP.getText();
							LoaiSanPhan lsp=new LoaiSanPhan(maloaiSP, tenloaisp);
							if(LoaiSanPhamDAO.updateLoaiSP(lsp)) {
								JOptionPane.showMessageDialog(btnCapNhatLSP, "Cập Nhật Loại Sản Phẩm Thành Công", "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
								loadTableLSP();
							}
							else {
								JOptionPane.showMessageDialog(btnCapNhatLSP, "Cập Nhật Loại Sản Phẩm Không Thành Công", "Loại Sản Phẩm", JOptionPane.ERROR_MESSAGE);
							}
								
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(btnCapNhatLSP, ex.getMessage().toString(), "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
						}	
					}
					else {
						JOptionPane.showMessageDialog(btnCapNhatLSP, "Chọn Loại Sản Phẩm Để Cập Nhật !!", "Loại Sản Phẩm", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnCapNhatLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCapNhatLSP.setBounds(237, 136, 94, 32);
		panel_10.add(btnCapNhatLSP);
		
		JButton btnXoaLSP = new JButton("Xóa");
		btnXoaLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Chắc Chắn Xóa Loại Sản Phẩm Này?", "Loại Sản Phẩm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					if(!textTenLoaiSP.getText().equals("")) 
					{
						try {
								String maloaisp=textMaLSP.getText();
								SanPhamDAO.deleteSPbyMaloai(maloaisp);								
								if(LoaiSanPhamDAO.deleteLoaiSP(maloaisp)) {
									JOptionPane.showMessageDialog(btnXoaLSP, "Xóa Lọa Sản Phẩm Thành Công", "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
									loadTableLSP();
									loadTableSP();
									loadcbMaLSP();
									
								}
								else {
									JOptionPane.showMessageDialog(btnXoaLSP, "Xóa Lọa Sản Phẩm Không Thành Công", "Loại Sản Phẩm", JOptionPane.ERROR_MESSAGE);
								}
							
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(btnXoaLSP, ex.getMessage().toString(), "Loại Sản Phẩm", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(btnXoaLSP, "Chọn Loại Sản Phẩm Để Xóa!!", "Thêm", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnXoaLSP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoaLSP.setBounds(125, 136, 94, 32);
		panel_10.add(btnXoaLSP);
		panel_9.setLayout(gl_panel_9);
		
		JPanel panel_12 = new JPanel();
		tabbedPane.addTab("Thống Kê", new ImageIcon(NhanVienJFrame.class.getResource("/images/thongke Icon.png")), panel_12, null);
		
		JPanel panel_14 = new JPanel();
		
		Label label_14 = new Label("Thống Kê Doanh Số Bán");
		label_14.setFont(new Font("Dialog", Font.BOLD, 28));
		label_14.setAlignment(Label.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		
		Label label_15 = new Label("Năm:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15.setBounds(75, 41, 78, 31);
		panel_15.add(label_15);
		
		Label label_15_1 = new Label("Tháng:");
		label_15_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_15_1.setBounds(408, 41, 78, 31);
		panel_15.add(label_15_1);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 16));
		yearChooser.setBounds(159, 41, 106, 31);
		panel_15.add(yearChooser);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(492, 41, 132, 31);
		panel_15.add(monthChooser);
		
		JButton btnNewButton = new JButton("Thống Kê Năm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = 12;
				int nam = yearChooser.getValue();
				List<ThongKeNam> list = HoaDonDAO.getThongKeNam(nam);
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				
				for(int i = 1; i <= n; i++) {
					for(int j = 0; j < list.size(); j++) {
						int ngay = list.get(j).getThang();
						if(i == ngay) {
							dataset.setValue(list.get(j).getTong(), "Doanh Số", i+"");
							break;
						}
						else {
							dataset.setValue(0, "Doanh Số", i+"");
						}
					}
				}
				
				JFreeChart chart = ChartFactory.createBarChart("Doanh Số Bán Trong Năm "+nam, "Tháng", "Doanh Số (Nghìn đồng)", dataset, PlotOrientation.VERTICAL, false, true, false);
				
				CategoryPlot p = chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.black);
				ChartFrame chartFrame = new ChartFrame("Doanh Số Bán Trong Năm", chart);
				chartFrame.setVisible(true);
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			    int x = (int) dimension.getWidth();
			    int y = (int) dimension.getHeight();
				chartFrame.setSize(x,y);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(75, 122, 190, 53);
		panel_15.add(btnNewButton);
		
		JButton btnThngKThng = new JButton("Thống Kê Tháng Trong Năm");
		btnThngKThng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				int nam = yearChooser.getValue();
				int thang = monthChooser.getMonth()+1;
				List<ThongKeThang> list = HoaDonDAO.getThongKeThang(nam,thang);
				int n;
				if(thang == 1 || thang == 3 || thang == 5 || thang == 7 || thang == 8 || thang == 10 || thang == 12) {
					n = 31;
				}
				else {
					if(thang == 2) {
						if(nam % 4 == 0 && nam % 4 != 0) {
							n =29;
						}
						else {
							n = 28;
						}
					}
					else {
						n = 30;
					}
				}
				for(int i = 1; i <= n; i++) {
					for(int j = 0; j < list.size(); j++) {
						int ngay = list.get(j).getNgay();
						if(i == ngay) {
							dataset.setValue(list.get(j).getTong(), "Doanh Số", i+"");
							break;
						}
						else {
							dataset.setValue(0, "Doanh Số", i+"");
						}
					}
				}
				
				JFreeChart chart = ChartFactory.createBarChart("Doanh Số Bán Trong Tháng "+thang+"/"+nam, "Ngày", "Doanh Số (Nghìn đồng)", dataset, PlotOrientation.VERTICAL, false, true, false);
				
				CategoryPlot p = chart.getCategoryPlot();
				p.setRangeGridlinePaint(Color.black);
				ChartFrame chartFrame = new ChartFrame("Doanh Số Bán Trong Tháng", chart);
				chartFrame.setVisible(true);
				Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
			    int x = (int) dimension.getWidth();
			    int y = (int) dimension.getHeight();
				chartFrame.setSize(x,y);
			}
		});
		btnThngKThng.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThngKThng.setBounds(408, 122, 216, 53);
		panel_15.add(btnThngKThng);
		GroupLayout gl_panel_14 = new GroupLayout(panel_14);
		gl_panel_14.setHorizontalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 874, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(31)
					.addComponent(label_14, GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
					.addGap(160))
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(120)
					.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
					.addGap(107))
		);
		gl_panel_14.setVerticalGroup(
			gl_panel_14.createParallelGroup(Alignment.LEADING)
				.addGap(0, 416, Short.MAX_VALUE)
				.addGroup(gl_panel_14.createSequentialGroup()
					.addGap(25)
					.addComponent(label_14, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(panel_15, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(72))
		);
		panel_14.setLayout(gl_panel_14);
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(161)
					.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(133))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(139)
					.addComponent(panel_14, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(163))
		);
		panel_12.setLayout(gl_panel_12);
		
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
		tabbedPane.addTab("Đăng Xuất", new ImageIcon(NhanVienJFrame.class.getResource("/images/logout Icon.png")), panel_13, null);
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
				
				
				if(table.getModel().getValueAt(index, 1)!=null) {
					int mahd = Integer.parseInt(table.getModel().getValueAt(index, 1).toString().trim());
					loadListCTHDByMaHD(mahd);
				}
				
				
			}
		});
		//Load dữ liệu vào table, combobox khi bắt đầu
		loadCbMaSP();
		loadCbMaHDCTHD();
		loadListHD();
		loadListCTHD();
		
		loadTableLSP();
		loadTableSP();
		loadcbMaLSP();
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
	
	private void resetCTHoaDon() {
		textMaCTHD.setText("");
		cbMaHDCTHD.setSelectedItem(null);
		cbMaSP.setSelectedItem(null);
		textSoLuongCTHD.setText("");
		textTenSPCTHD.setText("");
		textTongTienCTHD.setText("");
		textGhiChuCTHD.setText("");
		cbMaHDCTHD.enable();
	}
	private void loadCbMaSP() {
		List<SanPham> list = SanPhamDAO.getAllSP();
		cbMaSP.removeAllItems();
		for(SanPham sp : list) {
			cbMaSP.addItem(sp.getMaSP());
		}
	}
	private void loadCbMaHDCTHD() {
		List<HoaDon> list = HoaDonDAO.getAllHoaDon();
		cbMaHDCTHD.removeAllItems();
		for(HoaDon sp : list) {
			cbMaHDCTHD.addItem(sp.getIdhoadon());
		}
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
	private void loadListCTHD(){
		List<ChiTietHoaDon> list = ChiTietHoaDonDAO.getAllChiTietHD();
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		int i = 1;
		for(ChiTietHoaDon cthd : list) {
			Object[] row = new Object[] {
					i, cthd.getIdcthoadon(), cthd.getMahoadon(), cthd.getMasanpham(), cthd.getSoluong(), cthd.getTongtien(), cthd.getGhichu()
			};
			model.addRow(row);
			i++;
		}
	}
	
	private void loadListCTHDByMaHD(int mahd){
		List<ChiTietHoaDon> list = ChiTietHoaDonDAO.getListByMaHD(mahd);
		DefaultTableModel model = (DefaultTableModel)table_1.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		int i = 1;
		for(ChiTietHoaDon cthd : list) {
			Object[] row = new Object[] {
					i, cthd.getIdcthoadon(), cthd.getMahoadon(), cthd.getMasanpham(), cthd.getSoluong(), cthd.getTongtien(), cthd.getGhichu()
			};
			model.addRow(row);
			i++;
		}
	}
	
	
	private void loadcbMaLSP()
	{
		List<LoaiSanPhan> list=LoaiSanPhamDAO.getListLoaiSP();
		cb_Maloai.removeAllItems();
		for (LoaiSanPhan loaisanPham :list) {
			cb_Maloai.addItem(loaisanPham.getMaloaiSP());
		}
	}
	private void loadTBTSapXepSP(List<SanPham> list)
	{
		DefaultTableModel model = (DefaultTableModel)table_3.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		for(SanPham sp : list) {
			Object[] row = new Object[] {
					list.indexOf(sp)+1,sp.getMaSP(),sp.getTenSP(),sp.getMaloaiSP(),sp.getHangSX(),sp.getGianhap(),sp.getGiaban(),sp.getSoluong(),sp.getTrangthai(),sp.getChuthich()
			};		
			model.addRow(row);
		}
	}
	private void loadTableLSP()
	{
		List<LoaiSanPhan> list = LoaiSanPhamDAO.getListLoaiSP();
		DefaultTableModel model = (DefaultTableModel)table_2.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		for(LoaiSanPhan lsp : list) {
			Object[] row = new Object[] {
					list.indexOf(lsp)+1,lsp.getMaloaiSP(),lsp.getTenloaiSP()
			};		
			model.addRow(row);
		}
	}
	private void clearTBLSP()
	{
		textMaLSP.setText("");
		textTenLoaiSP.setText("");
	}
	private void loadTableSP()
	{
		List<SanPham> list = SanPhamDAO.getAllSP();
		DefaultTableModel model = (DefaultTableModel)table_3.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		for(SanPham sp : list) {
			Object[] row = new Object[] {
					list.indexOf(sp)+1,sp.getMaSP(),sp.getTenSP(),sp.getMaloaiSP(),sp.getHangSX(),sp.getGianhap(),sp.getGiaban(),sp.getSoluong(),sp.getTrangthai(),sp.getChuthich()
			};		
			model.addRow(row);
		}
	}
	private void clearTBSP()
	{
		textMaSP.setText("");
		textTenSP.setText("");
		textHangSX.setText("");
		textGiaNhap.setText("");
		textGiaBan.setText("");
		textSoLuongSP.setText("");
		textTrangThai.setText("");
		textChuThichSP.setText("");
		cb_Maloai.setSelectedItem(null);
		
	}
}
