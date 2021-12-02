package BEAN;

import java.sql.Date;

public class ChamCong {
	private int manv;
	private Date ngaycong;
	
	private int songaycong;
	private int thang;
	public int getSongaycong() {
		return songaycong;
	}
	public void setSongaycong(int songaycong) {
		this.songaycong = songaycong;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public Date getNgaycong() {
		return ngaycong;
	}
	public void setNgaycong(Date ngaycong) {
		this.ngaycong = ngaycong;
	}
	public ChamCong(int manv, Date ngaycong) {
		super();
		this.manv = manv;
		this.ngaycong = ngaycong;
	}
	
	public ChamCong(int manv, int thang, int songaycong) {
		super();
		this.manv = manv;
		this.thang = thang;
		this.songaycong = songaycong;
	}
}
