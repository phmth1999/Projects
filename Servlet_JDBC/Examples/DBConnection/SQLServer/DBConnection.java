package SQLServer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=database";
			String user = "sa";
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
