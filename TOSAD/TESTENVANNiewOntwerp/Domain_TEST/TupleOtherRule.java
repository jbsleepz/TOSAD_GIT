package Domain_TEST;


public class TupleOtherRule extends Tuple{

	private String sql = "";

	public TupleOtherRule(){
		super();
	}
	
	@Override
	public String generateScript(String triggerName, String operator, String errorMessage) {
		script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nVALUE1 VARCHAR2;" +
				" \nVALUE2 VARCHAR2;" +
				" \nBEGIN" +
				" \nVALUE1 := :NEW." + columns.get(0) + ";" +
				" \nVALUE2 := :NEW." + columns.get(1) + ";" +
				" \nFOR i in (SELECT COUNT(" + columns.get(0) + ") FROM " + tables.get(0) + ")" +
				" \nIF (i = VALUE1)" +
				" \nTHEN " +
				" \nIF (VALUE2 " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, '" + errorMessage + "');" +
				" \nEND IF;" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

}