package Domain;

import Domain.BusinessruleType;

public class Businessrule {
	private String ruleName;
	private String tableName;
	private String columnName;
	private BusinessruleType businessruleType = new BusinessruleType();

	
	public Businessrule(String ruleName){
		this.ruleName = ruleName;
	}
	
	public String getRuleName(){
		return ruleName;
	}
	

	
	
	public void setBusinessRuleType(String rule){
		businessruleType.setTypeToBusinessruleType(ruleName);
		
	}
	
	
	public BusinessruleType getBusinessRuleType(){
		return businessruleType;
	}
	
}
