package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//zet de databaseConnectie op met de locale database.
// moet nog worden gewijzigd naar de database die wij gaan gebruiken voor project.
public class ConnectionConfiguration {
	public static String dbSchemeName = "tosad_2016_2C_team3", 
			connectionURL = "ondora02.hu.nl" + dbSchemeName,
			username = "tosad_2016_2C_team3", password = "pizza";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oralce.jdbc.driver.OracleDriver").newInstance();
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
