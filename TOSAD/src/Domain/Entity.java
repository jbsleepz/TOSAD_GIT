package Domain;

public class Entity extends Rule{
	private RuleType ruleType = new RuleType();
	
	public Entity (){
		
	}
	
	public RuleType getRuleType(){
		return ruleType;
	}
}
