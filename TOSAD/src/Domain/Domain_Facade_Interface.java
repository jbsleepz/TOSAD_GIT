package Domain;

import Domain.Businessrule;
import Domain.RuleType;

public interface Domain_Facade_Interface {

	public Businessrule ReturnBusinessruleObject();
	public void setbusinessRuleTypeToBusinessRule(String type);
	public void GenerateBusinessrule(RuleType rT);
	
	
	
}

