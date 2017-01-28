package Domain;

import java.util.ArrayList;

public class Tuple extends Rule{
	private String name = "tuple";
	private String tabelName;
	private ArrayList<String> attributes;
	private ArrayList<String> tableNameList;
	
	public Tuple(String tabelName){
		super();
		this.tabelName = tabelName;
		this.attributes = new ArrayList();
	}
	
	public String getName(){
		return name;
	}
	
	public String getTabelName(){
		return tabelName;
	}
	
	public ArrayList<String> getAttributeList(){
		return attributes;
	}
	public void addAttributesArray(String waarde){
		attributes.add(waarde);
	}
	public void addTableNameListArray(String waarde){
		tableNameList.add(waarde);
	}

}
