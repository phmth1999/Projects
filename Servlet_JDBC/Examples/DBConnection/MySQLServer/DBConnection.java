package MySQLServer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/database";
			String user = "root";
			String pass = "admin1234";
			conn = DriverManager.getConnection(dbURL, user, pass);
			System.out.println("connect successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connect failure!");
		} finally {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		}
	}
}
