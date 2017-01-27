package Domain;

import Domain.Businessrule;
import Domain.RuleType;

public class Domain_Facade_Interface_Impl implements Domain_Facade_Interface{

	private Businessrule Businessrule;

	public Domain_Facade_Interface_Impl(){
		Businessrule = new Businessrule();
	}
	
	@Override
	public Businessrule ReturnBusinessruleObject() {
		 return Businessrule;
	}
	
	public void setRuleToBusinessRuleType(String type){
		this.Businessrule.setBusinessRuleType(type);
	}
	
	public void setTypeToRuleType(String typeName){
		Businessrule.getBusinessRuleType().setTypeToBusinessruleType(typeName);
	}



}

