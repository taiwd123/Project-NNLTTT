package BEAN;

public class TaiKhoan {
	private int idtk;
	private int manv;
	private String taikhoan;
	private String matkhau;
	
	public TaiKhoan() {
		
	}
	public TaiKhoan(int idtk,int manv, String taikhoan, String matkhau) {
		this.idtk = idtk;
		this.manv = manv;
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
	}
	public TaiKhoan(int id, String name, String pass) {
		// TODO Auto-generated constructor stub
		this.manv = id;
		this.taikhoan = name;
		this.matkhau = pass;
	}
	public int getIdtk() {
		return idtk;
	}
	public void setIdtk(int idtk) {
		this.idtk = idtk;
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
