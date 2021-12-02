package BEAN;

import java.util.Date;
import java.util.List;

import DAO.NhanVienDAO;

public class BanHang extends NhanVien {
	@Override
	public double TinhLuong(int socong) {
		return super.getluongcb() * socong * 1.2;
	}
	
	public BanHang(int idnv, String tennv, Date ngaysinh, String gioitinh, String diachi, String sodt, String ghichu,
			String chucvu, double luongcb) {
		super(idnv, tennv, ngaysinh, gioitinh, diachi, sodt, ghichu, chucvu, luongcb);
	}
	
	public BanHang() {
		
	}
	
	public static void main(String[] agrs) {
		List<NhanVien> list = NhanVienDAO.getListNhanVien();
		for(NhanVien nv : list) {
			System.out.println(nv.TinhLuong(10));
		}
	}
}
