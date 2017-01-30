package Domain;

public class EntityOtherRule extends Entity{
	
	private String sql;

	public EntityOtherRule(){
		super();
	}
	
	@Override
	public String generateScript(String triggerName, String operator, String errorMessage) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nBEGIN" +
				" \nIF (" + columns.get(0) + " != " + sql + ")" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, '" + errorMessage + "');" +
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
