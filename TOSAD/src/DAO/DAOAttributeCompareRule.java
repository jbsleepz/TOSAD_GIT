package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOAttributeCompareRule extends ConnectionConfiguration {

	ConnectionConfigurationTarget target = new ConnectionConfigurationTarget();
	ConnectionConfigurationTool tool = new ConnectionConfigurationTool();

	public void wijzigAttributeCompareRule(String script, int ruleID) {
		String query = "update ATTRIBUTECOMPARERULE set GENERATEDCODE = ? where RULEID = ?";
		// String DB_DRIV,String DB_URL,String DB_USER,String DB_PASS
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
		// String DB_DRIV,String DB_URL,String DB_USER,String DB_PASS
		try (Connection conn = super.getConnection(target.getDbDriv(), target.getDbUrl(), target.getDbUser(),
				target.getDbPass())) {
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
