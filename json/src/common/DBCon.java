package common;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBCon {
	private static String url;
	private static String user;
	private static String pwd;
	private static String driver;
	private static Connection con;
	
	public static void load(String path) {
		InputStream is = 
				DBCon.class.getResourceAsStream(path);
		Properties prop = new Properties();
		try {
			prop.load(is);
			is.close();
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			pwd = prop.getProperty("pwd");
			driver = prop.getProperty("driver");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void openCon() {
		load("/config/db.properties");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			con.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static Connection getCon() {
		if(con==null) {
			openCon();
		}
		return con;
	}
	
	public static void close() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		con = null;
	}
	
	public static void commit() {
		try {
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback() {
		try {
			con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
