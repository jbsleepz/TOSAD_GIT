package Tests;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ConnectionConfiguration;

public class TestDatabase extends ConnectionConfiguration {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
	private static final String DB_USER = "tosad_2016_2c_team3";
	private static final String DB_PASS = "tosad_2016_2c_team3";
	//private static final String connectieString = "jdbc:oralce:thin:tosad_2016_2c_team3/tosad_2016_2c_team3@//ondora02.hu.nl:8521/cursus02.hu.nl";
	  

	// De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
	public static void main(String[] args) {
		try {
			Class.forName(DB_DRIV).newInstance();
			Connection conn;
			conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASS);
		
			Statement stmt = conn.createStatement();		
			String queryText = "SELECT 1 FROM dual";
			ResultSet rs = stmt.executeQuery(queryText);
			String naam;
			while (rs.next()) {   
				naam = rs.getString("1");
				System.out.println(naam + ", " + naam);
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
}
