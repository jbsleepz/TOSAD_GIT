package Domain;

import java.util.ArrayList;

public class InterEntity extends Rule{
	private String name = "interEntity";
	private String table1;
	private String table2;
	private ArrayList attributesTable1;
	private ArrayList attributesTable2;
	private RuleType ruleType = new RuleType();
	
	public InterEntity(){
		
	}

	public InterEntity(String table1, String table2, ArrayList attributesTable1, ArrayList attributesTable2){
		this.table1 = table1;
		this.table2 = table2;
		this.attributesTable1 = attributesTable1;
		this.attributesTable2 = attributesTable2;
	}
	
	public String getName(){
		return name;
	}
	
	public String getTable1Name(){
		return table1;
	}
	
	public String getTable2Name(){
		return table2;
	}
	
	public ArrayList getAttributesTable1(){
		return attributesTable1;
	}
	
	public ArrayList getAttributesTable2(){
		return attributesTable2;
	}
	
	public RuleType getRuleType(){
		return ruleType;
	}
}
