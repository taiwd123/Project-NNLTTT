package BEAN;

import java.util.Date;

public class HoanDon {


	private int manv;
	private String tenkh;
	private String sodt;
	private String diachi;
	private Date ngaylaphoadon;
	private double tongtien;
	private String ghichu;
	
	public HoanDon() {
		
	}
	public HoanDon(int manv, String tenkh, String sodt, String diachi, Date ngaylaphoadon, double tongtien,
			String ghichu) {
		super();
		this.manv = manv;
		this.tenkh = tenkh;
		this.sodt = sodt;
		this.diachi = diachi;
		this.ngaylaphoadon = ngaylaphoadon;
		this.tongtien = tongtien;
		this.ghichu = ghichu;
	}

	public int getManv() {
		return manv;
	}

	public void setManv(int manv) {
		this.manv = manv;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getSodt() {
		return sodt;
	}

	public void setSodt(String sodt) {
		this.sodt = sodt;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaylaphoadon() {
		return ngaylaphoadon;
	}

	public void setNgaylaphoadon(Date ngaylaphoadon) {
		this.ngaylaphoadon = ngaylaphoadon;
	}

	public double getTongtien() {
		return tongtien;
	}

	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
}
