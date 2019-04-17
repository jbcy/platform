package utils;

import java.sql.*;
/**
 * Use to connect the local database
 * @author Jingbo Lin
 *
 */
public class JdbcUtils {
	private static Connection con = null;
	// Change DB_URL to your machine's port (mostly change from 3307 to 3306)
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
	/**
	 * Whenever connection is needed, call this function
	 * @author Jingbo Lin
	 * @return
	 */
	public static Connection getConnection() {
		return con;
	}
	
}
