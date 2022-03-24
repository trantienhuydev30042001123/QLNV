package connJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.phongban;
public class connJDBCpb extends phongban{
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
		if(conn != null) {
			System.out.println("kết nối mysql thành công");
		}else {
			System.out.println("kết nối mysql không thành công");
		}
		return conn;

	}
	public static List<phongban>FindAll(){
		List<phongban>phongbanList = new ArrayList<>();
		String query = "select * from phongban";
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				phongban pb = new phongban(rs.getString("MAPB"),rs.getString("TENPB"));
				phongbanList.add(pb);
			}
		} catch (Exception ex) {
			// TODO: handle exception
		}
		return phongbanList;
	}
	public static void insert(phongban pb) {
		String query ="insert into phongban(MAPB,TENPB) values(?,?)";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pb.getMAPB());
			pstmt.setString(2, pb.getTENPB());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void update(phongban pb) {
		String query ="update  phongban set MAPB = ?,TENPB = ?  where MAPB = '"+pb.getMAPB()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pb.getMAPB());
			pstmt.setString(2, pb.getTENPB());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(phongban pb) {
		String query = "delete from phongban where MAPB = '"+pb.getMAPB()+"'";
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
