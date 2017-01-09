package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//zet de databaseConnectie op met de locale database.
// moet nog worden gewijzigd naar de database die wij gaan gebruiken voor project.
public class ConnectionConfiguration {
	public static String dbSchemeName = "TOSAD", connectionURL = "jdbc:mysql://localhost:3306/" + dbSchemeName,
			username = "root", password = "joukebouwe";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionURL, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}

}
