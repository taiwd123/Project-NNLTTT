package Form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import BEAN.BangLuong;
import BEAN.ChamCong;
import BEAN.NhanVien;
import DAO.NhanVienDAO;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.itextpdf.*;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;



public class BangLuongJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<BangLuong> list;
	private List<ChamCong> listCC;
	private int thang;

	public List<ChamCong> getListCC() {
		return listCC;
	}

	public void setListCC(List<ChamCong> listCC) {
		this.listCC = listCC;
	}

	public List<BangLuong> getList() {
		return list;
	}

	public void setList(List<BangLuong> list) {
		this.list = list;
	}

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { BangLuongJFrame frame = new
	 * BangLuongJFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public BangLuongJFrame(List<ChamCong> listcc, int thang) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			}
		});
		this.thang = thang;
		this.listCC = listcc;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1165, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		
		String[] columnsName = {"Mã Nhân Viên", "Tên Nhân Viên", "Ngày Sinh", " Giới Tính", "Điện Thoại", "Lương Cơ Bản", "Số Ngày Công", "Tổng Lương"};
		Object[][] data = {};
		DefaultTableModel model = new DefaultTableModel(data, columnsName);
		
		
		table = new JTable(model) {
			@Override
			   public boolean isCellEditable(int row, int column) {
			    // set table column uneditable
			    return false;
			   }
		};
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Tohama", Font.BOLD, 14));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		
		JButton btnNewButton = new JButton("Xu\u1EA5t File PDF");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportPDF();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnXutFileExecl = new JButton("Xu\u1EA5t File Excel");
		btnXutFileExecl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exportExcel();
			}
		});
		btnXutFileExecl.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
					.addGap(21)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(172)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addGap(359)
					.addComponent(btnXutFileExecl, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
					.addGap(229))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXutFileExecl, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		LoadBangLuong();
	}
	
	public void LoadBangLuong() {
		List<NhanVien> listnv = NhanVienDAO.getListNhanVien();
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		
		for(NhanVien nv : listnv) {
			int manv = nv.getIdnv();
			for(int i = 0; i < listCC.size(); i++) {
				if(manv == this.listCC.get(i).getManv()) {
					Object[] row =new Object[] {
							manv, nv.getTennv(), nv.getNgaysinh(), nv.getGioitinh(), nv.getSodt(), nv.getluongcb(), listCC.get(i).getSongaycong(), nv.TinhLuong(listCC.get(i).getSongaycong())
					};
					model.addRow(row);
				}
			}
		}
	}
	
	public void exportExcel() {
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {
				FileWriter out = new FileWriter(file + ".xlsx");
				BufferedWriter bwrite = new BufferedWriter(out);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				// ten Cot
				for (int j = 0; j < table.getColumnCount(); j++) {
					bwrite.write(model.getColumnName(j) + "\t");
				}
				bwrite.write("\n");
				// Lay du lieu dong
				for (int j = 0; j < table.getRowCount(); j++) {
					for (int k = 0; k < table.getColumnCount(); k++) {
						bwrite.write(model.getValueAt(j, k) + "\t");
					}
					bwrite.write("\n");
				}
				bwrite.close();
				JOptionPane.showMessageDialog(null, "Lưu file thành công!");
			} 
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
			}
		}
	}
	
	public void exportPDF() {
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			Document document = new Document(PageSize.A4.rotate());
		    try {
		    	String path = file.getPath();
		    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
		    	document.open();
		    	String title = "Bang Luong Thang: " + thang;
		    	Paragraph title1 = new Paragraph(title,
						FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD,new CMYKColor(0, 255, 255, 17)));
				//Chapter chapter1 = new Chapter(title1, 1);
				document.add(title1);
				/*
				 * document.add(chapter1);
				 * 
				 * chapter1.setNumberDepth(0);
				 */
				PdfPTable t = new PdfPTable(8);
				t.setSpacingBefore(25);
				t.setSpacingAfter(25);
				
				PdfPCell c1 = new PdfPCell(new Phrase("Ma Nhan Vien"));
				t.addCell(c1);
				PdfPCell c2 = new PdfPCell(new Phrase("Ten Nhan Vien"));
				t.addCell(c2);
				PdfPCell c3 = new PdfPCell(new Phrase("Ngay Sinh"));
				t.addCell(c3);
				PdfPCell c4 = new PdfPCell(new Phrase("Gioi Tinh"));
				t.addCell(c4);
				PdfPCell c5 = new PdfPCell(new Phrase("Dien Thoai"));
				t.addCell(c5);
				PdfPCell c6 = new PdfPCell(new Phrase("Luong Co Ban"));
				t.addCell(c6);
				PdfPCell c7 = new PdfPCell(new Phrase("So Ngay Cong"));
				t.addCell(c7);
				PdfPCell c8 = new PdfPCell(new Phrase("Tong Luong"));
				t.addCell(c8);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				for(int a = 0; a< table.getRowCount(); a++) {
					for(int j = 0; j < table.getColumnCount(); j++) {
						t.addCell(model.getValueAt(a, j).toString());
					}
				}
				document.add(t);
				
				
		    	JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		    } catch (Exception e) {
		    	JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
		    }
		    document.close();
		}
		
	}
}
