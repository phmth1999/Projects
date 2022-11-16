package com.servlet.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() throws Exception {
		Connection conn = null;
		try {
			Class.forName(Constant.DRIVER);
			String dbURL = Constant.URL;
			String user = Constant.USERNAME;
			String pass = Constant.PASSWORD;
			conn = DriverManager.getConnection(dbURL, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void getCloseDBConnection(Connection conn) throws Exception {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getRollbackTransaction(Connection conn) throws Exception {
		try {
			if (conn != null) {
				conn.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
