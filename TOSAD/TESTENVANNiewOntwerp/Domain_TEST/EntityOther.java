package Domain_TEST;


public class EntityOther extends Entity{

	public EntityOther(){
		super();
	}
	
	@Override
	public String generateScript(String triggerName, String operator, String errormessage) {
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				" \nBEGIN" +
				" \nIF (" + columns.get(0) + " " + operator + " " + sql + ") = FALSE" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, 'value not accepted');" +
				" \nEND IF;" +
				" \nEND;";
		
		return script;
	}

}
