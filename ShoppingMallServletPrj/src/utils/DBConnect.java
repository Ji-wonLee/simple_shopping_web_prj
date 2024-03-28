package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	public static Connection getConnection() {
		Connection conn = null;
		try {

			String DB_USER = "dst05";
			String DB_PASSWD = "dst05";
			String DB_URL= "jdbc:oracle:thin:@192.168.10.11:1521:DB19";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
		}catch (SQLException | ClassNotFoundException e) {
			System.out.println("오류");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("오류");
		}
		return conn;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("데이터베이스 연결이 성공적으로 종료되었습니다.");
			} catch (SQLException e) {
				System.out.println("데이터베이스 연결 종료 중 오류가 발생했습니다.");
				e.printStackTrace();
			}
		}
	}
}