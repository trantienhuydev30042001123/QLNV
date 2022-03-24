package connJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.dean;

public class connJDBCda extends dean{
	static String url = "jdbc:mysql://localhost:3306/qlnhanvien";
	static String user = "root";
	static String password = "";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("ket noi mysql thanh cong");
		} else {
			System.out.println("ket noi mysql khong thanh cong");

		}
		return conn;
	}
	public static List<dean>findAll(){
		List<dean>deanList = new ArrayList<>();
		String query = "select * from dean";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				dean da = new dean(rs.getString("MADA"),rs.getString("TENDA"),rs.getString("DIADIEMDA"),rs.getString("MAPB"));
				deanList.add(da);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return deanList;
		
	}
	public static void insert(dean da) {
		String query ="insert into dean(MADA,TENDA,DIADIEMDA,MAPB) values(?,?,?,?)";
		try {
			Connection conn =getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, da.getMADA());
			pstmt.setString(2, da.getTENDA());
			pstmt.setString(3, da.getDIADIEMDA());
			pstmt.setString(4, da.getMAPB());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(dean da) {
		String query ="update dean set MADA = ?,TENDA = ?,DIADIEMDA = ?,MAPB = ? where MADA = '"+da.getMADA()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, da.getMADA());
			pstmt.setString(2, da.getTENDA());
			pstmt.setString(3, da.getDIADIEMDA());
			pstmt.setString(4, da.getMAPB());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(dean da) {
		String query = "delete from dean Where MADA = '"+da.getMADA()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
