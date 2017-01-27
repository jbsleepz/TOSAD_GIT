package Domain;

import Domain.BusinessruleType;
import src.Domain.RuleType;

public class Businessrule {
	private String ruleName;
	private String tableName;
	private String columnName;
	private BusinessruleType businessruleType = new BusinessruleType();

	
	public Businessrule(){
		
	}
	
	public void setRuleName(String name){
		this.ruleName = name;
	}
	
	
	public void setBusinessRuleType(String rule){
		businessruleType.setRuleToBusinessruleType(ruleName);
		
	}
	
}
