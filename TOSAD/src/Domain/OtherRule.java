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
				" \nIF (VALUE " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, 'value not accepted');" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	}
	
	public String createTupleOtherScript(String tableName, String triggerName, String column1, String column2, String operator, String sql) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nVALUE1 VARCHAR2" +
				" \nVALUE2 VARCHAR2" +
				" \nBEGIN" +
				" \nVALUE1 := :NEW." + column1 + ";" +
				" \nVALUE2 := :NEW." + column2 + ";" +
				" \nFOR o in (SELECT " + column1 + " FROM " + tableName + ")" +
				" \nIF (o = VALUE1)" +
				" \nTHEN " +
				" \nIF (VALUE2 " + operator + " " + sql + ") = FALSE" +
				" \nRaise_Application_Error(-20000, 'value not accepted');" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	
	}
	
	public String createEntityOtherRule(String tableName, String triggerName, String columnName, String operator, String sql) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nBEGIN" +
				" \nIF (" + columnName + " " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, 'value not accepted');" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	}
}
