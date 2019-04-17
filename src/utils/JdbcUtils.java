package utils;

import java.sql.*;

public class JdbcUtils {
	private static Connection con = null;
	//private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3307/jbcy";
	private static final String user = "root";
	private static final String password = "root";
	
	static {
		try {
			con = DriverManager.getConnection(DB_URL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
	
}
