package Domain;

import Domain.Businessrule;
import Domain.RuleType;

public class Domain_Facade_Interface_Impl implements Domain_Facade_Interface{

	private Businessrule Businessrule;
	private BusinessruleType BusinessRuleType;
	
	
	public void createBusinessRule(String name){
		Businessrule = new Businessrule(name);
	}
	
	public void getBusinessRuleType(){
		BusinessRuleType = Businessrule.getBusinessRuleType();	
	}

/*	public Domain_Facade_Interface_Impl(){
		Businessrule = new Businessrule();
	}
	
	@Override
	public Businessrule ReturnBusinessruleObject() { // gives the BusinessRUle Object
		 return Businessrule;
	}
	
	public void setRuleToBusinessRuleType(String type){ // set type Like : Attribute, Tuple, Enity, Inter-Entity, Modify
		BusinessRuleType = Businessrule.getBusinessRuleType();
		rule = BusinessRuleType.setTypeToBusinessruleType(type);
		System.out.println(rule);
	}
	
	public Object getRule(){
		return rule.toString();
	}
	
	public void setTypeToRuleType(String typeName){
		Businessrule.getBusinessRuleType().setTypeToBusinessruleType(typeName);
	}
	
	

    public void setAttributesOfAttribute(Rule rule, String tableName, String columnName){
    	



    }
    public void setAttributesOfRangeRule (int rangeMin, int rangeMax, String operator){
    	Businessrule.getBusinessRuleType().getRule().getRuleType().getType().setRangeRuleAttributes(rangeMin, rangeMax, operator);
    }
    
    public Rule getBusinessRuleType (){
    	return Businessrule.getBusinessRuleType().getRule();
    }
    
    public Type getRuleType(){
    	return Businessrule.getBusinessRuleType().getRule().getRuleType().getType();
    	
    }
    

    public String createAttributeRangeRuleScript(String ruleName){
    	Rule r = getBusinessRuleType();
    	Type t = getRuleType();
    	System.out.println(r.toString());;
    	
    	//t.CreateRangeRuleScript(r.getName())  //r.getName(), triggerName, columnname, minimumValue, maximumValue, Operator)    	
    	
    	String script = "";
    	
    	return script;
    }

	@Override
	public String createAttributeRangeRuleScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttributesOfAttribute(String tableName, String columnName) {
		// TODO Auto-generated method stub
		
	}
*/
}

