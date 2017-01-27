package Domain;

import java.util.ArrayList;

public class BusinessruleType {
	private Rule rule;
	private String name;
	
	private ArrayList<Object> allRules = new ArrayList<Object>();
	

	public BusinessruleType(){
		
	}
	public String getName(){
		return name;
	}
/*	
	public void fillAllRules(){
		allRules.add(new Attribute());
		allRules.add(new Tuple());
		allRules.add(new Entity());
		allRules.add(new InterEntity());
		allRules.add(new Modify());
	}*/
	public Object setTypeToBusinessruleType(String ruleName){ //get rule object
		if(ruleName == "Attribute"){
			Attribute attribute = new Attribute();
		}
		else if (ruleName == "Tuple"){
			rule = new Tuple();
		}
		else if (ruleName == "Entity"){
			rule = new Entity();
		}
		else if(ruleName == "Inter-Entity"){
			rule = new InterEntity();
		}
		else if (ruleName == "Modify"){
			rule = new Modify();
		}
		return rule;
	}
	
	public Rule getRule(){
		return rule;
	}

	

}


