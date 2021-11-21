package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import BEAN.LoaiSanPhan;
import BEAN.LoaiSanPhan;
import DBConnection.DBConnection;

public class LoaiSanPhamDAO {
	
	public static boolean insertLoaiSP(LoaiSanPhan LoaiSanPhan) {
		Connection con = DBConnection.CreateConnection();
		
		String sql = "insert into loaisp(maloaisp,tenloaisp) values(?,?)";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			String tenloaisp = LoaiSanPhan.getTenloaiSP();
			
			String maloaisp= LoaiSanPhan.getMaloaiSP();			
			ps.setString(1,maloaisp);
			ps.setString(2, tenloaisp);				
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
	public static boolean updateLoaiSP(LoaiSanPhan LoaiSanPhan) {
		Connection con = DBConnection.CreateConnection();

		String sql = "update loaisp set tenloaisp=? where maloaisp=?";
		PreparedStatement ps = null;
		try {
			
			ps = con.prepareStatement(sql);		
			String tenloaisp = LoaiSanPhan.getTenloaiSP();		
			String maloaisp= LoaiSanPhan.getMaloaiSP();			
			ps.setString(2,maloaisp);
			ps.setString(1, tenloaisp);		
			
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
	
	public static boolean deleteLoaiSP(String maloaisp) {
		Connection con = DBConnection.CreateConnection();

		String sql = "delete from loaisp where maloaisp=?";
		PreparedStatement ps = null;	
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, maloaisp);
			
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
			
	public static List<LoaiSanPhan> getListLoaiSP() {
		
		List<LoaiSanPhan> list = new ArrayList<LoaiSanPhan>();
		
		Connection con = DBConnection.CreateConnection();
		String sql = "select * from loaisp ";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String maloaisp = rs.getString("maloaisp");				
				String ten = rs.getString("tenloaisp");
				
				
				LoaiSanPhan lsp=new LoaiSanPhan(maloaisp, ten);
				list.add(lsp);
			}
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static LoaiSanPhan getLoaiSP(String ma) {
			
			Connection con = DBConnection.CreateConnection();
			String sql = "select * from loaisp where maloaiSP = ? ";
			LoaiSanPhan lsp=new LoaiSanPhan();
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, ma);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					
					String maloaisp = rs.getString("maloaisp");				
					String ten = rs.getString("tenloaisp");
					
					lsp.setMaloaiSP(maloaisp);
					lsp.setTenloaiSP(ten);
				}
				con.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lsp;
		}
	public static boolean checkExistMaLSP(String malsp,String tenlsp) {	
		
		Connection con = DBConnection.CreateConnection();	
		String sql = "select * from loaisp where maloaisp=? or tenloaisp=?";
		PreparedStatement ps = null;
		List<String> count=new ArrayList<String>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,malsp);
			ps.setString(2,tenlsp);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				String ml=rs.getString("maloaisp");
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
