package BEAN;

public class TaiKhoan {
	private int manv;
	private String taikhoan;
	private String matkhau;
	
	public TaiKhoan() {
		
	}
	public TaiKhoan(int manv, String taikhoan, String matkhau) {
		this.manv = manv;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	public String getTaikhoan() {
		return taikhoan;
	}
	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
}
