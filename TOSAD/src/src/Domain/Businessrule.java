package Domain;

public class Businessrule {
	private String RuleName;
	private String TableName;
	private String ColumnName;
	private BusinessruleType Businesstype;
	private RuleType Ruletype;
	
	public Businessrule(){
		
	}
	
	
	public void setBusinessRuleType(String rule){
		if(rule.equals("Attribute")){
			
		}
		else if (rule.equals("Tuple")){
			
		}
		else if (rule.equals("Entity")){
			
		}
		else if(rule.equals("Inter-Entity")){
			
		}
		else if (rule.equals("Modify")){
			
		}
		
	}
	
}
