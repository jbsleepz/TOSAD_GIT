package Domain_TEST;

import Domain_TEST.Attribute;

public class AttributeOtherRule extends Attribute{

	private String sql;
	
	public AttributeOtherRule(){
		super();
	}
	
	@Override
	public String generateScript(String triggerName, String operator, String errormessage) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nVALUE VARCHAR2" +
				" \nBEGIN" +
				" \nVALUE := :NEW." + columns.get(0) + ";" +
				" \nIF (VALUE " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, 'value not accepted');" +
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
