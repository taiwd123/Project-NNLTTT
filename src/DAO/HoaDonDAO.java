package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BEAN.HoaDon;
import DBConnection.DBConnection;

public class HoaDonDAO {
	public static boolean insertHoaDon(HoaDon hd) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into hoadon(idNV, tenKH, sdtKH, diachiKH, ngaylapHD, tongTien, ghiChu) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, hd.getManv());
			ps.setString(2,hd.getTenkh());
			ps.setString(3,hd.getSodt());
			ps.setString(4,hd.getDiachi());
			ps.setDate(5, hd.getNgaylaphoadon());
			ps.setDouble(6, hd.getTongtien());
			ps.setString(7,hd.getGhichu());
			
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
	
	public static boolean updateTongTien(int mahoadon, double tien) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update hoadon set tongtien=tongtien+(?) where idhoadon=?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setDouble(1, tien);
			ps.setInt(2, mahoadon);
			
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
	
	public static boolean updateHoaDon(HoaDon hd){
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update hoadon set idnv=?, tenkh=?, sdtkh=?, diachikh=?, ngaylaphd=?, tongtien=?, ghichu=? where idhoadon=?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, hd.getManv());
			ps.setString(2,hd.getTenkh());
			ps.setString(3,hd.getSodt());
			ps.setString(4,hd.getDiachi());
			ps.setDate(5, hd.getNgaylaphoadon());
			ps.setDouble(6, hd.getTongtien());
			ps.setString(7,hd.getGhichu());
			
			ps.setInt(8, hd.getIdhoadon());
			
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

	public static boolean deleteHoaDon(int mahoadon) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "delete from hoadon where idhoadon = ?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, mahoadon);
			
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
 	public static List<HoaDon> getAllHoaDon(){
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from hoadon";
		List<HoaDon> list = new ArrayList<HoaDon>();
		PreparedStatement ps =null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int idhd = rs.getInt(1);
				int idnv = rs.getInt(2);
				String tenkh = rs.getString(3);
				String sdtkh = rs.getString(4);
				String diachikh = rs.getString(5);
				Date nglaphd = rs.getDate(6);
				double tongtien = rs.getDouble(7);
				String ghichu = rs.getString(8);
				
				HoaDon hd = new HoaDon(idhd, idnv, tenkh, sdtkh, diachikh, nglaphd, tongtien, ghichu);
				list.add(hd);
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
