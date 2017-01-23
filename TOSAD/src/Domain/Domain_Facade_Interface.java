package Domain;

public interface Domain_Facade_Interface {

	public RuleType ReturnBusinessruleObject(int rule_id, String tableName);
	public void GenerateBusinessrule(RuleType rT);
	
	
	
}

