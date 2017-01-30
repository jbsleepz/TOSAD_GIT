package Domain;

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
				" \nl_passed boolean := true;" +
				" \nBEGIN" + 
				" \nl_passed := :new."+ columns.get(0) + " in (";
				for (String waarde : waardesListValues){
					script+= " '"+ waarde + "'," ;
				}
		script += ");" +
				" \nif l_passed = false" +
				" \nTHEN " +
				" \nRaise_Application_Error(-20000, '" + errorMessage + "');" +
				" \nEND IF;" +
				" \nEND;";
		return script;
	}
}
