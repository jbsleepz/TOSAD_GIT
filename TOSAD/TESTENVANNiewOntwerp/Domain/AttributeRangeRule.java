package Domain;

public class AttributeRangeRule extends Attribute {
	
	private int minimumValue =0; 
	private int maximumValue =0;
	
	public AttributeRangeRule(){
		super();
	}
	
	public AttributeRangeRule(int minimumValue, int maximumValue){
		super();
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}
	
	public String generateScript(String triggerName, String operator, String errorMessage) {
		script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + /*super.getTables()*/ tables.get(0) + 
				" \nFOR EACH ROW" +
				" \nDECLARE"+ 
				" \nVALUE NUMBER" +
				" \nBEGIN"+ 
				" \nVALUE := :NEW." + /*super.getColumns()*/ columns.get(0) + ";" +
				" \nIF (VALUE NOT BETWEEN " + minimumValue + " AND " + maximumValue + ")" + 
				" \nTHEN " + 
				" \nRaise_Application_Error(-20000, '" + errorMessage + "');" +
				" \nEND IF;" +
				" \nEND;";

		return script;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}

	public int getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}


}
