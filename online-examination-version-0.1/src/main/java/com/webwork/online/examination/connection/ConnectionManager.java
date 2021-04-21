package com.webwork.online.examination.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	private static Properties config = new Properties();
	
	private static Connection connection;
	
	static {
		InputStream inputStream = ConnectionManager.class.getClassLoader().getResourceAsStream("dbconfig.properties");
		
		try {
			config.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(connection == null) {
			synchronized(ConnectionManager.class) {
				String driver = config.getProperty("driver");
				String url = config.getProperty("url");
				String username = config.getProperty("username");
				String password = config.getProperty("password");
				if (null == connection) {
					Class.forName(driver);
					connection = DriverManager.getConnection(url, username, password);
					return connection;
				} else {
					return connection;
				}
			}	
		}else {
			return connection;
		}
	}

}
