package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BEAN.NhanVien;
import BEAN.TaiKhoan;
import DBConnection.DBConnection;

public class TaiKhoanDAO {
	public static boolean insertTaiKhoan(TaiKhoan tk) {
		TaiKhoan acc = new TaiKhoan();
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into taikhoan(idNV,username,password) values (?,?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			int idNV=tk.getManv();
			String taikhoan=tk.getTaikhoan();
			String matkhau=tk.getMatkhau();
			
			ps.setInt(1, idNV);
			ps.setString(2,taikhoan);
			ps.setString(3, matkhau);
			
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
	public static boolean deleteTaiKhoan(int idnv) {
		Connection con = DBConnection.CreateConnection();

		String sql = "delete from taikhoan where idnv=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idnv);
			
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
	public static List<TaiKhoan> getListTaikhoan() {
		
		List<TaiKhoan> list = new ArrayList<TaiKhoan>();
		
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from taikhoan";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("idNV");
				String name = rs.getString("username");
				String pass=rs.getString("password");
				
				TaiKhoan cs = new TaiKhoan(id,name,pass);
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
	public static boolean checkExistTaiKhoan(String taikhoan,String pass,int idnv) {	
		
		Connection con = DBConnection.CreateConnection();	
		String sql = "select * from taikhoan where username = ? and password=?  or idNV=?";
		PreparedStatement ps = null;
		List<String> count=new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,taikhoan);	
			ps.setString(2, pass);
			ps.setInt(3, idnv);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String user=rs.getString("username");
				count.add(user);
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
public static boolean checkExistTaiKhoanCapNhap(String taikhoan,String pass) {	
		
		Connection con = DBConnection.CreateConnection();	
		String sql = "select * from taikhoan where username = ? and password=? ";
		PreparedStatement ps = null;
		List<String> count=new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,taikhoan);	
			ps.setString(2, pass);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String user=rs.getString("username");
				count.add(user);
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
	public static boolean updateThongtinTKNV(String taikhoan, String matkhau,int idnv) {
		TaiKhoan acc = new TaiKhoan();
		Connection con = DBConnection.CreateConnection();
		
		String sql = "update taikhoan set username = ? , password = ? where idnv=?";
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, taikhoan);
			ps.setString(2, matkhau);
			ps.setInt(3, idnv);
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
