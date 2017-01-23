package Tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.ConnectionConfiguration;

public class TestDatabase extends ConnectionConfiguration {
	
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//";
	private static final String DB_USER = "tosad_2016_2C_team3";
	private static final String DB_HOST = "ondora02.hu.nl";
	private static final String DB_PORT = "8080";
	private static final String DB_PASS = "pizza";
	private static Connection conn;
	private static final String connectieString = "jdbc:oralce:thin:tosad_2016_2c_team3/tosad_2016_2c_team3@//ondora02.hu.nl:8521/cursus02.hu.nl";
	"jdbc:oracle:thin:tosad_2016_2C_team3/pizza@//ondora02.hu.nl:8521/cursus02.hu.nl";		  
	
/*	String dbSchemeName = "tosad_2016_2C_team3", 
			connectionURL = "ondora02.hu.nl" + dbSchemeName,
			username = "tosad_2016_2C_team3", password = "pizza";*/
	
	// De methode die met JDBC aan de slag gaat moet een SQLException opvangen of gooien
	public static void main(String[] args) throws SQLException{
		//Besluit welke driver je gaat gebruiken voor je verbinding		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} 
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		// Leg de connectie met de database
		/*conn = DriverManager.getConnection("DB_URL ,DB_USER, DB_PASS");*/
		conn = DriverManager.getConnection(connectieString);
	
		//con = DriverManager.getConnection("jdbc:oracle:thin:@//" + host + ":" + port +"/"+database+"?user="+user+"&password="+password);
        
		//System.out.println("Connection made");

		// Een eerste SQL statement maken
		Statement stmt = conn.createStatement();		
		// Een tweede statement maken dat een resultaat oplevert
		String queryText = "SELECT TESTDATA FROM TESTDATA";
		
		// Een tweede statement uitvoeren
		ResultSet rs = stmt.executeQuery(queryText);
		
		// Iets doen met de resultaten
		String naam;
		while (rs.next()) {   
			naam = rs.getString("testData");
			System.out.println(naam + ", " + naam);
		}

		// De resultset, het statement en de verbinding sluiten
		rs.close();
		stmt.close();
		conn.close();

	}
	
}
