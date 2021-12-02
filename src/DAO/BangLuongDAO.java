package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BEAN.BangLuong;
import DBConnection.DBConnection;

public class BangLuongDAO {
	
	public static boolean insert(BangLuong bl) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into bangluong(manv, thang, luong) values(?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bl.getManv());
			ps.setInt(2, bl.getThang());
			ps.setDouble(3,bl.getLuong());
			
			if(ps.executeUpdate() != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean checkExist(BangLuong c) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "select * from bangluong where manv = ? and thang = ?";
		
		PreparedStatement ps = null;
		
		try {
			ps= con.prepareStatement(sql);
			ps.setInt(1, c.getManv());
			ps.setInt(2, c.getThang());
			
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

}
