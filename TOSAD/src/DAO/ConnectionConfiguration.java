package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//zet de databaseConnectie op met de locale database.
// moet nog worden gewijzigd naar de database die wij gaan gebruiken voor project.
public class ConnectionConfiguration {
	public static String connectionName = "TOSAD_Tool_Database";
	public static String username       = "tosad_2016_2c_team3";
	public static String password       = "tosad_2016_2c_team3";
	public static String Hostname       = "ondora02.hu.nl";
	public static String port	        = "8521";
	public static String serviceName   = "cursus02.hu.nl";
	public static String connectionURL	= "jdbc:oracle:thin:";	
	
			/*	dbSchemeName = "atddb",
	            connectionURL = "jdbc:mysql://localhost:3306/" + dbSchemeName,
	            username = "root",
	            password = "joukebouwe";*/
						
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oralce.jdbc.driver.OracleDriver").newInstance();
			connection = DriverManager.getConnection(connectionURL, username, "/", password, );
			//jdbc:oralce:thin:tosad_2016_2c_team3/tosad_2016_2c_team3@//ondora02.hu.nl:8521/cursus02.hu.nl
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return connection;
		}
	}
	
	public static void main(String[] args) {
        String url = "jdbc:oracle://127.0.0.1:8080";
        String username = "HR";
        String password = "samplepass";

        String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE LAST_NAME='King'";
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            System.out.println(statement.execute(sql));
            connection.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

}
