package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db {
	
	private static Connection conn = null;
	
	public static Connection openConnection() {
		if (conn == null) {
			try {
				Properties properties = loadProperties("db.properties");
				String url = properties.getProperty("dburl");
				conn = DriverManager.getConnection(url, properties);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	private static Properties loadProperties(String path) {
		try (FileInputStream file = new FileInputStream(path)) {
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

}
