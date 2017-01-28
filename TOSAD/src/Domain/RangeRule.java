package Domain;

public class RangeRule extends Businessrule{
	
	int minimumValue = 0;
	int maximumValue = 0;
	
	public RangeRule(String businessRuleName, int minimumValue, int maximumValue) {
		super(businessRuleName);
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}
	
	public int getMinValue(){  //return the minimum value of the rangerule
		return minimumValue;
	}
	
	public int getMaxValue(){  // returning the maximum value of the rangerule
		return maximumValue;
	}
	
	public String CreateRangeRuleScript(String triggerName, String tableName, String columnname, int minimumValue, int maximumValue, String errormessage){
		
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" +
				" \nDECLARE"+ 
				" \nVALUE NUMBER" +
				" \nBEGIN"+ 
				" \nVALUE := :NEW." + columnname + ";" +
				" \nIF (VALUE NOT BETWEEN " + minimumValue + " AND " + maximumValue + ")" + 
				" \nTHEN " + 
				" \nRaise_Application_Error(-20000, '" + errormessage + "');" +
				" \nEND IF;" +
				" \nEND;";

		return script;
	}

}
