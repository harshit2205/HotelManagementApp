package com.cg.DBUtil;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	
	static String driver = null;
	static String url = null;
	static String unm = null;
	static String pwd = null;
	
	

	public static Connection getConn() throws SQLException, IOException
	{
		Connection conn = null;
		
			Properties prop = loadDBInfo();
			
			driver= prop.getProperty("dbDriver");
			url = prop.getProperty("dbUrl");
			unm = prop.getProperty("dbUser");
			pwd = prop.getProperty("dbPassword");
		
			conn = DriverManager.getConnection(url, unm, pwd);
		return conn;
	}
	
	public static Properties loadDBInfo() throws IOException{
		FileInputStream inStream = new FileInputStream("D:/HotelManagementApp/HotelManagementSystem/dbInfo.properties");
		Properties prop = new Properties();
		prop.load(inStream);
			return prop;
		}	
}
