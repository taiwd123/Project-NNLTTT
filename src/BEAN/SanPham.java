package BEAN;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String maloaiSP;
	private String hangSX;
	private double gianhap;
	private double giaban;
	private int soluong;
	private String trangthai;
	private String chuthich;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getMaloaiSP() {
		return maloaiSP;
	}
	public void setMaloaiSP(String maloaiSP) {
		this.maloaiSP = maloaiSP;
	}
	public String getHangSX() {
		return hangSX;
	}
	public void setHangSX(String hangSX) {
		this.hangSX = hangSX;
	}
	public double getGianhap() {
		return gianhap;
	}
	public void setGianhap(double gianhap) {
		this.gianhap = gianhap;
	}
	public double getGiaban() {
		return giaban;
	}
	public void setGiaban(double giaban) {
		this.giaban = giaban;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getChuthich() {
		return chuthich;
	}
	public void setChuthich(String chuthich) {
		this.chuthich = chuthich;
	}
	public SanPham(String maSP, String tenSP, String maloaiSP, String hangSX, double gianhap, double giaban,
			int soluong, String trangthai, String chuthich) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.maloaiSP = maloaiSP;
		this.hangSX = hangSX;
		this.gianhap = gianhap;
		this.giaban = giaban;
		this.soluong = soluong;
		this.trangthai = trangthai;
		this.chuthich = chuthich;
	}
	public SanPham() {
		
	}
}
