package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			if (conn == null) {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				conn = DriverManager.getConnection(url, properties);
			}
			return conn;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	public static void closeConnection() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	private static Properties loadProperties() {
		try (FileInputStream file = new FileInputStream("db.properties")) {
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (FileNotFoundException e) {
			throw new DbException(e.getMessage());
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
