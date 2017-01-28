package Domain;

import java.util.ArrayList;

public class InterEntity extends Rule{
	private String name = "interEntity";
	private String table1;
	private String table2;
	private ArrayList<String> attributesTable1;
	private ArrayList<String> attributesTable2;

	
	public InterEntity(){
		
	}

	public InterEntity(String table1, String table2, ArrayList<String> attributesTable1, ArrayList<String> attributesTable2){
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
	
	public ArrayList<String> getAttributesTable1(){
		return attributesTable1;
	}
	
	public ArrayList<String> getAttributesTable2(){
		return attributesTable2;
	}

}
