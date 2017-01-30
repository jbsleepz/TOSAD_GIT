package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionConfiguration {
						
	public static Connection getConnection(String DB_DRIV,String DB_URL,String DB_USER,String DB_PASS ) {
		Connection connection = null;
		try {
			Class.forName(DB_DRIV).newInstance();
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
}
