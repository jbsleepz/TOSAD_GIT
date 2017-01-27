package Domain;

public class Type {
	String name;
	private int min;
	private int max;
	private String operator;
	
	public void setRangeRuleAttributes(int min, int max, String operator){
		this.min = min;
		this.max = max;
		this.operator = operator;
	}
	public String CreateRangeRuleScript(String tableName,String triggerName, String columnname, int minimumValue, int maximumValue, String Operator){
		
	}

}
