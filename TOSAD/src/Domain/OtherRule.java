package Domain;

public class OtherRule implements Type {
	String sqlQuery;
	
	public OtherRule(String sqlQuery, String businessRuleName) {
		this.sqlQuery = sqlQuery;
	}
	public String generateCode(String businessruleType,String triggerName,String tableName, String column1, String column2, String operator, String sql){
		String generatedScript = "";
		if (businessruleType.equalsIgnoreCase("Attribute")){
			createAttributeOtherScript(triggerName, tableName, column1, operator, sql);
		} else if (businessruleType.equalsIgnoreCase("tuple")){
			createTupleOtherScript(triggerName, tableName, column1, column2, operator, sql);
		} else {
			createEntityOtherRule(triggerName, tableName, column1, operator, sql);
		}
		return generatedScript;
		
	}
	

	
	public String createAttributeOtherScript(String triggerName,String tableName,  String columnName, String operator, String sql) {
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
	
	public String createTupleOtherScript(String triggerName,String tableName, String column1, String column2, String operator, String sql) {
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
	
	public String createEntityOtherRule(String triggerName,String tableName, String columnName, String operator, String sql) {
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
	public String getSqlQuery() {
		return sqlQuery;
	}
}
