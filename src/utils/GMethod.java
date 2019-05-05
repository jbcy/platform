package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.UUID;


/**
 * For General method
 * @author Jingbo Lin
 *
 */
public class GMethod {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "claudiam";

	/**
	 * Whenever need to insert new item to database, use this function to generate id
	 * @author Jingbo Lin
	 * @return
	 */
	public static String makeID(){
		return UUID.randomUUID().toString();
	}
	
	public static void createDatabase(String name, String file) throws ClassNotFoundException, SQLException, IOException {
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");

	    System.out.println("Connecting to database...");
	    conn = DriverManager.getConnection(URL, USER, PASSWORD);

	    System.out.println("Creating database...");
	    stmt = conn.createStatement();
		String sql = "create DATABASE " + name;
		stmt.executeUpdate(sql);
		System.out.println("Database created successfully...");
		sql = "use " + name;
		stmt.executeUpdate(sql);
		String s = new String();
     StringBuffer sb = new StringBuffer();
     FileReader fr = new FileReader(new File(file));
     BufferedReader br = new BufferedReader(fr);
		
     while((s = br.readLine()) != null)
     {
         sb.append(s);
     }
     br.close();

     String[] inst = sb.toString().split(";");
     
     for(int i = 0; i<inst.length; i++)
     {
         // we ensure that there is no spaces before or after the request string
         // in order to not execute empty statements
         if(!inst[i].trim().equals(""))
         {
             stmt.executeUpdate(inst[i]);
             
             System.out.println(">>"+inst[i]);
         }
     }
	}  
}



