package Domain;

public class Attribute extends Rule{
	private String name = "attribute";
	private String tableName;
	private String attributeName;
	
	public Attribute (String tableName, String attributeName){
		super();
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
	
	public void setAttributes(String tableName, String attributeName){
		this.tableName = tableName;
		this.attributeName = attributeName;
	}
	
}
