package BEAN;

public class LoaiSanPhan {
	private String maloaiSP;
	private String tenloaiSP;
	public String getMaloaiSP() {
		return maloaiSP;
	}
	public void setMaloaiSP(String maloaiSP) {
		this.maloaiSP = maloaiSP;
	}
	public String getTenloaiSP() {
		return tenloaiSP;
	}
	public void setTenloaiSP(String tenloaiSP) {
		this.tenloaiSP = tenloaiSP;
	}
	public LoaiSanPhan(String maloaiSP, String tenloaiSP) {
		super();
		this.maloaiSP = maloaiSP;
		this.tenloaiSP = tenloaiSP;
	}
	public LoaiSanPhan() {
		
	}
}
