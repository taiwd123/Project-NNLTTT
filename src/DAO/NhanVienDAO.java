package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BEAN.NhanVien;
import DBConnection.DBConnection;

public class NhanVienDAO {
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
}
