package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.ChiTietHoaDon;
import DBConnection.DBConnection;

public class ChiTietHoaDonDAO {
	public static boolean insertChiTietHD(ChiTietHoaDon cthd) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into chitiethoadon(idHoaDon, maSP, soLuong, tongTien, ghiChu) values(?,?,?,?,?)";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cthd.getMahoadon());
			ps.setString(2, cthd.getMasanpham());
			ps.setInt(3, cthd.getSoluong());
			ps.setDouble(4, cthd.getTongtien());
			ps.setString(5, cthd.getGhichu());
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
	public static boolean updateChiTietHD(ChiTietHoaDon cthd) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update chitiethoadon set idhoadon=?, masp=?, soluong=?, tongtien=?, ghichu=? where idchitiethoadon=?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cthd.getMahoadon());
			ps.setString(2, cthd.getMasanpham());
			ps.setInt(3, cthd.getSoluong());
			ps.setDouble(4, cthd.getTongtien());
			ps.setString(5, cthd.getGhichu());
			ps.setInt(6, cthd.getIdcthoadon());
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
	public static boolean deleteChiTietHD(int idcthd) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "delete from chitiethoadon where idchitiethoadon = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, idcthd);
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
	public static boolean deleteCTHDByMaHD(int mahd) {
Connection con = DBConnection.CreateConnection();
		
		String sql = "delete from chitiethoadon where idhoadon = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mahd);
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
	public static List<ChiTietHoaDon> getAllChiTietHD(){
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from chitiethoadon";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idCTHD = rs.getInt(1);
				int maHD = rs.getInt(2);
				String maSP = rs.getString(3);
				int sl = rs.getInt(4);
				double tongtien = rs.getDouble(5);
				String ghichu = rs.getString(6);
				ChiTietHoaDon cthd = new ChiTietHoaDon(idCTHD, maHD, maSP, sl, tongtien, ghichu);
				list.add(cthd);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<ChiTietHoaDon> getListByMaHD(int mahd){
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from chitiethoadon where idhoadon = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mahd);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idCTHD = rs.getInt(1);
				int maHD = rs.getInt(2);
				String maSP = rs.getString(3);
				int sl = rs.getInt(4);
				double tongtien = rs.getDouble(5);
				String ghichu = rs.getString(6);
				ChiTietHoaDon cthd = new ChiTietHoaDon(idCTHD, maHD, maSP, sl, tongtien, ghichu);
				list.add(cthd);
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
