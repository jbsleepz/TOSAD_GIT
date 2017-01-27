package Domain;

public abstract class Rule {
	private String name;
	private RuleType ruleType;
	
	/*public void setAttributes(String tableName, String attributeName){
	
	}*/
	public Rule(){
		
	}
	
	public RuleType getRuleType(){
		return ruleType;
	}
	

}
