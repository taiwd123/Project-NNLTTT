package BEAN;

import java.util.Date;

public class QuanLi extends NhanVien{
	@Override
	public double TinhLuong(int socong) {
		return super.getluongcb() * socong*1.5;
	}
	
	public QuanLi(int idnv, String tennv, Date ngaysinh, String gioitinh, String diachi, String sodt, String ghichu,
			String chucvu, double luongcb) {
		super(idnv, tennv, ngaysinh, gioitinh, diachi, sodt, ghichu, chucvu, luongcb);
	}
	
	public QuanLi() {
		
	}
}
