package Domain;

import java.util.ArrayList;

public class Tuple extends Rule{
	private String name = "tuple";
	private String tabelName;
	private ArrayList attributes;
	private ArrayList tableNameList;
	private RuleType ruleTyp;
	
	public Tuple(){
		
	}
	
	public Tuple(String tabelName){
		this.tabelName = tabelName;
		this.attributes = new ArrayList();
	}
	
	public String getName(){
		return name;
	}
	
	public String getTabelName(){
		return tabelName;
	}
	
	public ArrayList getAttributeList(){
		return attributes;
	}
	
	public RuleType getRuleType(){
		return ruleType;
	}
}
