package DAO;

public class ConnectionConfigurationTool {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@ondora02.hu.nl:8521/cursus02.hu.nl";
	private static final String DB_USER = "tosad_2016_2c_team3";
	private static final String DB_PASS = "tosad_2016_2c_team3";
	
	public static String getDbDriv() {
		return DB_DRIV;
	}
	public static String getDbUrl() {
		return DB_URL;
	}
	public static String getDbUser() {
		return DB_USER;
	}
	public static String getDbPass() {
		return DB_PASS;
	}
	
	
}
