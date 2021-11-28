package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.SanPham;
import DBConnection.DBConnection;

public class SanPhamDAO {
	
	public static boolean insertSP(SanPham sanpham) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into sanpham(masp,tensp,loaisp,hangsx,gianhap,giaban,soluong,trangthai,chuthich) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			String ma=sanpham.getMaSP();
			String ten=sanpham.getTenSP();
			String loai=sanpham.getMaloaiSP();
			String hang=sanpham.getHangSX();
			double gnhap=sanpham.getGianhap();
			double gban=sanpham.getGiaban();
			int sl=sanpham.getSoluong();
			String tt=sanpham.getTrangthai();
			String ct=sanpham.getChuthich();
			
			ps.setString(1,ma);
			ps.setString(2,ten);
			ps.setString(3,loai);
			ps.setString(4,hang);
			ps.setDouble(5,gnhap);
			ps.setDouble(6,gban);
			ps.setInt(7,sl);
			ps.setString(8,tt);
			ps.setString(9,ct);
			
			
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
	public static boolean updateSP(SanPham sanpham) {
		Connection con = DBConnection.CreateConnection();

		String sql = "update sanpham set tensp=?,hangsx=?,giaban=?,soluong=?,trangthai=?,chuthich=?,gianhap=? where masp=?";
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(sql);		
			
			
			String ten=sanpham.getTenSP();		
			String hang=sanpham.getHangSX();
			double gnhap=sanpham.getGianhap();
			double gban=sanpham.getGiaban();
			int sl=sanpham.getSoluong();
			String tt=sanpham.getTrangthai();
			String ct=sanpham.getChuthich();
			String masp=sanpham.getMaSP();
						
			ps.setString(1,ten);		
			ps.setString(2,hang);		
			ps.setDouble(3,gban);
			ps.setInt(4,sl);
			ps.setString(5,tt);
			ps.setString(6,ct);
			ps.setDouble(7,gnhap);
			ps.setString(8,masp);
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
	
	public static boolean updateSoluong(String masp, int sl) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update sanpham set soluong=soluong +(?) where masp=?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, sl);
			ps.setString(2, masp);
			
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
	
	public static boolean updateTrangThai(String masp, String th) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update sanpham set trangthai = ? where masp=?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, th);
			ps.setString(2, masp);
			
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
	
	public static boolean deleteSP(String masp) {
		Connection con = DBConnection.CreateConnection();

		String sql = "delete from sanpham where masp=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,masp);
				
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
	public static boolean deleteSPbyMaloai(String maloaisp) {
		Connection con = DBConnection.CreateConnection();

		String sql = "delete from sanpham where loaisp=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,maloaisp);
				
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
	
	public static int getSoluong(String masp) {
		int sl = 0;
		Connection con = DBConnection.CreateConnection();
		String sql = "select soluong from sanpham where masp = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, masp);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sl = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sl;
	}
		
	
	public static SanPham getSanPham(String maSP) {
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from sanpham where masp=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,maSP);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String masp = rs.getString(1);
				String tensp = rs.getString(2);
				String loaisp = rs.getString(3);
				String hangsx = rs.getString(4);
				double gianhap = rs.getDouble(5);
				double giaban = rs.getDouble(6);
				int soluong = rs.getInt(7);
				String trangthai = rs.getString(8);
				String chuthich = rs.getString(9);
				SanPham sp = new SanPham(masp, tensp, loaisp, hangsx, gianhap, giaban, soluong, trangthai, chuthich);
				return sp;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public static List<SanPham> getAllSP() {
		Connection con = DBConnection.CreateConnection();
		
		List<SanPham> list = new ArrayList<SanPham>();
		String sql = "select * from sanpham";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String masp = rs.getString(1);
				String tensp = rs.getString(2);
				String loaisp = rs.getString(3);
				String hangsx = rs.getString(4);
				double gianhap = rs.getDouble(5);
				double giaban = rs.getDouble(6);
				int soluong = rs.getInt(7);
				String trangthai = rs.getString(8);
				String chuthich = rs.getString(9);
				SanPham sp = new SanPham(masp, tensp, loaisp, hangsx, gianhap, giaban, soluong, trangthai, chuthich);
				list.add(sp);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
public static List<SanPham> getListSPbySapXep(String dauvao) {
		
		List<SanPham> list = new ArrayList<SanPham>();
		
		Connection con = DBConnection.CreateConnection();
		String sql =null;
		if(dauvao=="Mã Loại Sản Phẩm")
		{
			sql = "select * from sanpham order by loaisp ";
		}
		else if(dauvao=="Tên Sản Phẩm") {
			sql = "select * from sanpham order by tensp ";
		}
		else if(dauvao=="Giá Bán") {
			sql = "select * from sanpham order by giaban";
		}
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String ma=rs.getString("masp");
				String ten=rs.getString("tensp");
				String maloai=rs.getString("loaisp");
				String hang=rs.getString("hangsx");
				Double gianhap=rs.getDouble("gianhap");
				Double giaban=rs.getDouble("giaban");
				int soluong=rs.getInt("soluong");
				String tt=rs.getString("trangthai");
				String ct=rs.getString("chuthich");			
				SanPham sp=new SanPham(ma, ten, maloai, hang, gianhap, giaban, soluong,tt, ct);							
				list.add(sp);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static boolean checkExistMaSP(String masp,String loaisp) {	
		
		Connection con = DBConnection.CreateConnection();	
		String sql = "select * from sanpham where masp=? and loaiSP = ?";
		PreparedStatement ps = null;
		List<String> count=new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,masp);
			ps.setString(2,loaisp);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String ml=rs.getString("masp");
				count.add(ml);
			}
			if(count.size()==0)
			{
				return true;
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
public static boolean checkExistTenSP(String tensp) {	
		
		Connection con = DBConnection.CreateConnection();	
		String sql = "select * from sanpham where  tensp=?";
		PreparedStatement ps = null;
		List<String> count=new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
		
			ps.setString(1,tensp);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String ml=rs.getString("tensp");
				count.add(ml);
			}
			if(count.size()==0)
			{
				return true;
			}
			
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
