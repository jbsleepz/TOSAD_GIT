package Domain;

public class BusinessruleType {
	private Rule rule;

	public BusinessruleType(){
		
	}

	public void setRuleToBusinessruleType(String ruleName){
		if(ruleName.equals("Attribute")){
			rule = new Attribute();
		}
		else if (ruleName.equals("Tuple")){
			rule = new Tuple();
		}
		else if (ruleName.equals("Entity")){
			rule = new Entity();
		}
		else if(ruleName.equals("Inter-Entity")){
			rule = new InterEntity();
		}
		else if (ruleName.equals("Modify")){
			rule = new Modify();
		}
	}



}


