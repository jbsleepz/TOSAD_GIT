package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOTupleOtherRule extends ConnectionConfiguration {

	ConnectionConfigurationTarget target = new ConnectionConfigurationTarget();
	ConnectionConfigurationTool tool = new ConnectionConfigurationTool();
	public DAOTupleOtherRule(){
		super();
	}
	public void wijzigOtherRule(String script, int ruleID) {
		String query = "update TUPLEOTHERRULE set GENERATEDCODE = ? where RULEID = ?";

		try (Connection conn = super.getConnection(tool.getDbDriv(), tool.getDbUrl(), tool.getDbUser(),
				tool.getDbPass())) {
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, script);
			ps.setInt(2, ruleID);

			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ExecuteScriptNaarTarget(String script) {
		String query = "?";
		//String DB_DRIV,String DB_URL,String DB_USER,String DB_PASS 
		try (Connection conn = super.getConnection(target.getDbDriv(), target.getDbUrl(), target.getDbUser(), target.getDbPass())){
			System.out.println(conn);
			System.out.println(query);
			System.out.println(target.getDbDriv());
			System.out.println(target.getDbPass());
			System.out.println(target.getDbUrl());
			System.out.println(target.getDbUser());
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, script);

			ps.executeQuery();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
