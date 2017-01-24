package Domain;

public class Attribute {
	private String name = "attribute";
	private String tableName;
	private String attributeName;
	private RuleType ruleType;
	
	
	public Attribute (String tableName, String attributeName){
		this.tableName = tableName;
		this.attributeName = attributeName;
	}
	
	public String getName(){
		return name;
	}
	
	public String  getTableName(){
		return tableName;
	}
	
	public String getAttributeName(){
		return attributeName;
	}
	
	
}

