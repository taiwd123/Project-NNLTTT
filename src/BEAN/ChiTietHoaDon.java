package BEAN;

public class ChiTietHoaDon {
	private int mahoadon;
	private String masanpham;
	private int soluong;
	private double tongtien;
	private String ghichu;
	
	public ChiTietHoaDon() {
		
	}

	public int getMahoadon() {
		return mahoadon;
	}

	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}

	public String getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(String masanpham) {
		this.masanpham = masanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
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

	public ChiTietHoaDon(int mahoadon, String masanpham, int soluong, double tongtien, String ghichu) {
		super();
		this.mahoadon = mahoadon;
		this.masanpham = masanpham;
		this.soluong = soluong;
		this.tongtien = tongtien;
		this.ghichu = ghichu;
	}
}
