package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BEAN.TaiKhoan;
import DBConnection.DBConnection;

public class TaiKhoanDAO {
	public static TaiKhoan checkTaiKhoan(String taikhoan, String matkhau) {
		TaiKhoan acc = new TaiKhoan();
		Connection con = DBConnection.CreateConnection();
		
		String sql = "select * from taikhoan where username = ? and password = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,taikhoan);
			ps.setString(2, matkhau);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int manv = rs.getInt("idNV");
				String user = rs.getString("username");
				String pass = rs.getString("password");
				acc.setManv(manv);
				acc.setMatkhau(pass);
				acc.setTaikhoan(user);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return acc;
	}
	public static boolean updatePass(String user, String pass) {
		Connection con = DBConnection.CreateConnection();
		String sql = "update taikhoan set password = ? where username = ?";
		
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, user);
			if(ps.executeUpdate() != 0) {
				return true;
			}
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
