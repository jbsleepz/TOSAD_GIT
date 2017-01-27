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

    public void setAttributesOfAttribute(String tableName, String columnName){
    	Businessrule.getBusinessRuleType().getRule().setAttributes(tableName, columnName);


    }
    public void setAttributesOfRangeRule (int rangeMin, int rangeMax, String operator){
    	Businessrule.getBusinessRuleType().getRule().getRuleType().getType().setRangeRuleAttributes(rangeMin, rangeMax, operator);
    }
    
    public Type getRuleType(){
    	return this.Businessrule.getBusinessRuleType().getRule().getRuleType().getType();
    	
    }
    

    public String createAttributeRangeRuleScript(){
    	String script = "";
    	
    	return script;
    }

}

