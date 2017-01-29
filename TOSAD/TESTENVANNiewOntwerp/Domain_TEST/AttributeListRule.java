package Domain_TEST;


public class AttributeListRule extends Attribute{
	
	public AttributeListRule(){
		super();
	}

	@Override
	public String generateScript(String triggerName, String operator, String errorMessage) {

		script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				"l_passed boolean := true;" +
				"BEGIN"
				+ "l_passed := :new."+ columns.get(0) + " in (";
				for (String waarde : waardesListValues){
					script+= " '"+ waarde + "'," ;
				}
		script += ");" +
				"if not l_passed" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, '" + errorMessage + "');" +
				" \nEND IF;" +
				" \nEND;";
		return script;
	}
}
