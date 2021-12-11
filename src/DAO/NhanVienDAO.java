package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import BEAN.BanHang;
import BEAN.NhanVien;
import BEAN.QuanLi;
import DBConnection.DBConnection;


public class NhanVienDAO {
	
	public static boolean insertNhanVien(NhanVien NhanVien) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into nhanvien(tenNV,ngaySinh,gioiTinh,diaChi,soDT,ghiChu,chucVu,luongcb) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			String ten = NhanVien.getTennv();
			Date ns =  NhanVien.getNgaysinh();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String nsinh=sdf.format(ns);
			String gtinh = NhanVien.getGioitinh();
			String dchi = NhanVien.getDiachi();
			String sdt = NhanVien.getSodt();
			String gchu = NhanVien.getGhichu();
			String cvu= NhanVien.getChucvu();
			double luongcb = NhanVien.getluongcb();
			
			ps.setString(1,ten);
			ps.setString(2, nsinh);
			ps.setString(3, gtinh);
			ps.setString(4,dchi);
			ps.setString(5, sdt);
			ps.setString(6, gchu);
			ps.setString(7, cvu);
			ps.setDouble(8, luongcb);
			
			if(ps.executeUpdate() != 0) {
				return true;
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static boolean updateNhanVien(NhanVien NhanVien) {
		Connection con = DBConnection.CreateConnection();

		String sql = "update nhanvien set tenNV=?, ngaySinh=?, gioiTinh=?, diaChi=?,soDT=?,ghiChu=?,chucVu=? where idNV=?";
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(sql);
			String ten = NhanVien.getTennv();
			Date ns =  NhanVien.getNgaysinh();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String nsinh=sdf.format(ns);
			String gtinh = NhanVien.getGioitinh();
			String dchi = NhanVien.getDiachi();
			String sdt = NhanVien.getSodt();
			String gchu = NhanVien.getGhichu();
			String cvu= NhanVien.getChucvu();
			
			ps.setString(1,ten);
			ps.setString(2, nsinh);
			ps.setString(3, gtinh);
			ps.setString(4,dchi);
			ps.setString(5, sdt);
			ps.setString(6, gchu);
			ps.setString(7, cvu);
			ps.setInt(8, NhanVien.getIdnv());
			if(ps.executeUpdate() != 0) {
				return true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean deleteNhanVien(int id) {
		Connection con = DBConnection.CreateConnection();

		String sql = "delete from nhanvien where idNV=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			if(ps.executeUpdate() != 0) {
				return true;
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return false;
	}
	
	public static List<NhanVien> searchNhanVienByID(String ttSearch) {
		Connection con = DBConnection.CreateConnection();
		List<NhanVien> list = new ArrayList<NhanVien>();
		
		String sql = "select * from nhanvien "
				+ "where idNV like '%"+ttSearch+"%'";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idNV");
				String name = rs.getString("tenNV");
				Date ns = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String dc = rs.getString("diaChi");
				String phone = rs.getString("soDT");
				String gchu = rs.getString("ghiChu");
				String cvu = rs.getString("chucVu");
				double luongcb = rs.getDouble("luongcb");
				
				NhanVien cs = new NhanVien(id,name,ns,gt,dc,phone,gchu,cvu,luongcb);
				list.add(cs);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<NhanVien> searchNhanVienByTen(String ttSearch) {
		Connection con = DBConnection.CreateConnection();
		List<NhanVien> list = new ArrayList<NhanVien>();
		
		String sql = "select * from nhanvien "
				+ "where  tenNV like '%"+ttSearch+"%'";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idNV");
				String name = rs.getString("tenNV");
				Date ns = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String dc = rs.getString("diaChi");
				String phone = rs.getString("soDT");
				String gchu = rs.getString("ghiChu");
				String cvu = rs.getString("chucVu");
				double luongcb = rs.getDouble("luongcb");
				
				NhanVien cs = new NhanVien(id,name,ns,gt,dc,phone,gchu,cvu,luongcb);
				list.add(cs);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<NhanVien> getListNhanVien() {
		
		List<NhanVien> list = new ArrayList<NhanVien>();
		
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from nhanvien";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idNV");
				String name = rs.getString("tenNV");
				Date ns = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String dc = rs.getString("diaChi");
				String phone = rs.getString("soDT");
				String gchu = rs.getString("ghiChu");
				String cvu = rs.getString("chucVu");
				double luongcb = rs.getDouble("luongcb");
				
				if(cvu.equals("Admin")) {
					NhanVien cs = new QuanLi(id,name,ns,gt,dc,phone,gchu,cvu,luongcb);
					list.add(cs);
				}
				else {
					NhanVien cs = new BanHang(id,name,ns,gt,dc,phone,gchu,cvu,luongcb);
					list.add(cs);
				}
				
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static NhanVien getNhanVien(int manv) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "select * from nhanvien where idNV = ?";
		PreparedStatement ps = null;
		NhanVien nv = new NhanVien();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, manv);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nv.setIdnv(rs.getInt(1));
				nv.setTennv(rs.getString(2));
				nv.setNgaysinh(rs.getDate(3));
				nv.setGioitinh(rs.getString(4));
				nv.setDiachi(rs.getString(5));
				nv.setSodt(rs.getString(6));
				nv.setGhichu(rs.getString(7));
				nv.setChucvu(rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nv;
	}
	public static List<NhanVien> getListNhanVienSapXep(String dauvao) {
		
		List<NhanVien> list = new ArrayList<NhanVien>();
		
		Connection con = DBConnection.CreateConnection();
		String sql=null;
		if(dauvao=="Mã Nhân Viên")
		{
			 sql = "select * from nhanvien where order by idnv";
		}
		else if(dauvao=="Tên Nhân Viên") {
			sql = "select * from nhanvien wher order by tennv";
		}
	
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idNV");
				String name = rs.getString("tenNV");
				Date ns = rs.getDate("ngaySinh");
				String gt = rs.getString("gioiTinh");
				String dc = rs.getString("diaChi");
				String phone = rs.getString("soDT");
				String gchu = rs.getString("ghiChu");
				String cvu = rs.getString("chucVu");
				double luongcb = rs.getDouble("luongcb");
				
				NhanVien cs = new NhanVien(id,name,ns,gt,dc,phone,gchu,cvu,luongcb);
				list.add(cs);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
