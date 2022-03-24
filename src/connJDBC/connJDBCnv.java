package connJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.nhanvien;

public class connJDBCnv extends nhanvien{
	static String url = "jdbc:mysql://localhost:3306/qlnhanvien";
	static String user = "root";
	static String password = "";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("ket noi mysql thanh cong");
		} else {
			System.out.println("ket noi mysql khoong thanh cong");
		}
		return conn;
	}
	public static List<nhanvien>finALL(){
		List<nhanvien>nhanvienList = new ArrayList<>();
		String query = "select * from nhanvien";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				nhanvien nv = new nhanvien(rs.getString("MANV"),rs.getString("TENNV"),rs.getInt("GIOITINH"),rs.getFloat("LUONG"),rs.getString("NGAYSINH"),rs.getString("DIACHI"),rs.getString("MAPB"));
				nhanvienList.add(nv);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return nhanvienList;
		
	}
	public static void insert(nhanvien nv) {
		String query = "insert into nhanvien(MANV,TENNV,GIOITINH,LUONG,NGAYSINH,DIACHI,MAPB) values(?,?,?,?,?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nv.getMANV());
			pstmt.setString(2, nv.getTENNV());
			pstmt.setInt(3, nv.getGIOITINH());
			pstmt.setFloat(4, nv.getLUONG());
			pstmt.setString(5, nv.getNGAYSINH());
			pstmt.setString(6, nv.getDIACHI());
			pstmt.setString(7, nv.getMAPB());
			pstmt.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(nhanvien nv) {
		String query = "update nhanvien set MANV=?,TENNV=?,GIOITINH=?,LUONG=?,NGAYSINH=?,DIACHI=?,MAPB=? where MANV = '"+nv.getMANV()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nv.getMANV());
			pstmt.setString(2, nv.getTENNV());
			pstmt.setInt(3, nv.getGIOITINH());
			pstmt.setFloat(4, nv.getLUONG());
			pstmt.setString(5, nv.getNGAYSINH());
			pstmt.setString(6, nv.getDIACHI());
			pstmt.setString(7, nv.getMAPB());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(nhanvien nv) {
		String query ="delete from nhanvien where MANV = '"+nv.getMANV()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
