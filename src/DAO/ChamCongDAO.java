package DAO;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import BEAN.ChamCong;
import DBConnection.DBConnection;

public class ChamCongDAO {

	public static boolean insert(ChamCong c) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into chamcong(manv, ngaycong) values(?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, c.getManv());
			ps.setDate(2, c.getNgaycong());
			
			if(ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkExist(ChamCong c) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "select * from ChamCong where manv = ? and ngaycong = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, c.getManv());
			ps.setDate(2, c.getNgaycong());
			
			ResultSet rs = ps.executeQuery();
			if(rs.isBeforeFirst()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static List<ChamCong> getChamCongByThang(int thang){
		Connection con = DBConnection.CreateConnection();
		List<ChamCong> list = new ArrayList<ChamCong>();
		String sql = "select manv, month(ngaycong) as thang, count(month(ngaycong)) as songaycong from chamcong where month(ngaycong) = ? group by month(ngaycong), manv";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, thang);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int manv = rs.getInt(1);
				int luongthang = rs.getInt(2);
				int songaycong = rs.getInt(3);
				
				ChamCong c = new ChamCong(manv, luongthang, songaycong);
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
}
