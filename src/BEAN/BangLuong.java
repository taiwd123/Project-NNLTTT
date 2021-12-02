package BEAN;

public class BangLuong {
	private int manv;
	private int thang;
	private double luong;
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}
	public BangLuong(int manv, int thang, double luong) {
		super();
		this.manv = manv;
		this.thang = thang;
		this.luong = luong;
	}
	
}
