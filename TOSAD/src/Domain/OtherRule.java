package Domain;

public class OtherRule extends Type {
	String sqlQuery;
	
	public OtherRule() {
	
	}
	
	public String getSqlQuery() {
		return sqlQuery;
	}
	
	public String createAttributeOtherScript(String tableName, String triggerName, String columnName, String operator, String sql) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nVALUE VARCHAR2" +
				" \nBEGIN" +
				" \nVALUE := :NEW." + columnName + ";" +
				" \nIF (" + columnName + " " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, 'minimum value is not a valid number');" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	}
}
