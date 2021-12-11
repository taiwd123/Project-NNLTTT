package BEAN;

import java.sql.Date;

public class NhanVien {
	private int idnv;
	private String tennv;
	private Date ngaysinh;
	private String gioitinh;
	private String diachi;
	private String sodt;
	private String ghichu;
	private String chucvu;
	private double luongcb;
	public double getluongcb() {
		return luongcb;
	}
	public void setluongcb(double luongcb) {
		this.luongcb = luongcb;
	}
	public int getIdnv() {
		return idnv;
	}
	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodt() {
		return sodt;
	}
	public void setSodt(String sodt) {
		this.sodt = sodt;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	
	public NhanVien() {
		
	}
	public NhanVien(String tennv, Date ngayinh, String gioitinh, String diachi, String sodt, String ghichu, String chucvu, double luongcb) {
		this.tennv = tennv;
		this.ngaysinh = ngayinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sodt = sodt;
		this.ghichu = ghichu;
		this.chucvu = chucvu;
		this.luongcb = luongcb;
	}
	public NhanVien(int idnv, String tennv, Date ngaysinh, String gioitinh, String diachi, String sodt, String ghichu,
			String chucvu, double luongcb) {
		super();
		this.idnv = idnv;
		this.tennv = tennv;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sodt = sodt;
		this.ghichu = ghichu;
		this.chucvu = chucvu;
		this.luongcb = luongcb;
	}
	
	public double TinhLuong(int socong) {
		return this.luongcb;
	};
}
