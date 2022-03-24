package connJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.phancong;

public class connJDBCpc {
	static String url = "jdbc:mysql://localhost:3306/qlnhanvien";
	static String user = "root";
	static String password ="";
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (conn != null) {
			System.out.println("ket noi mysql thanh cong ");
		} else {
			System.out.println("ket noi mysql khong thanh cong ");
		}
		return conn;
	}
	public static List<phancong>FindAll(){
		List<phancong>phancongList = new ArrayList<>();
		String query = "select * from phancong";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				phancong pc = new phancong(rs.getString("MANV"),rs.getString("MADA"),rs.getInt("SOGIO"));
				phancongList.add(pc);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return phancongList;
	}
	public static void insert(phancong pc) {
		String query = "insert into phancong(MANV,MADA,SOGIO) values(?,?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pc.getMANV());
			pstmt.setString(2, pc.getMADA());
			pstmt.setInt(3, pc.getSOGIO());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(phancong pc) {
		String query = "update phancong set MANV=?,MADA=?,SODIO=? where MANV='"+pc.getMANV()+"' AND MADA = '"+pc.getMADA()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pc.getMANV());
			pstmt.setString(2, pc.getMADA());
			pstmt.setInt(3, pc.getSOGIO());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void delete(phancong pc) {
		String query ="delete from phancong where MANV = '"+pc.getMANV()+"'and MADA = '"+pc.getMADA()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
