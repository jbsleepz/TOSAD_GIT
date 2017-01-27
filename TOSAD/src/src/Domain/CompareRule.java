package Domain;

import java.util.ArrayList;

public class CompareRule extends Type {
	
	private String script;
	int i = 1;

	public CompareRule(){
		
	}

	// this method only works if the values to be compared are "Strings"
	public String createAttributeCompareScript(String triggerName, String tableName, String checkValue,
			String operator) { // attribute
		// 1 tabel
		// 1 kolom
		// 1 inputwaarde van gebruiker
		script = "CREATE OR REPLACE TRIGGER " + "TRIGGER_" + triggerName + 
				 " \nBEFORE INSERT OR UPDATE ON " + tableName +  
				 " \nFOR EACH ROW" + 
				 " \nDECLARE" + 
				 " \nCOLUMNNAME VARCHAR2" + // columnName (Value of an attribute of a new record)
				 " \nCHECKVALUE VARCHAR2" + // check record input value with THIS VALUE
				 " \nBEGIN" + 
				 " \nCOLUMNNAME := :NEW.COMPAREVALUE" + 
				 " \nCHECKVALUE := " + checkValue + 
				 " \nIF (COLUMNNAME " + operator + " CHECKVALUE)= FALSE" + 
				 " \nTHEN"+ 
				 " \nRAISE_APPLICATION_ERROR(20002, 'The given value is not valid')" + // error message
				 " \nEND;";

		return script;
	}

	// this method only works if the values to be compared are "Strings"
	public String createTupleComparesScript(String triggerName, String tableName, ArrayList<String> columnNames) { // tuple
		// 1 tabel
		// minimaal 2 kolommen
		// vergelijken met inputwaardes
		script = "CREATE OR REPLACE TRIGGER" + "TRIGGER_" + triggerName +
				 " \nBEFORE INSERT OR UPDATE ON " +tableName + 
				 " \nFOR EACH ROW" +
				 " \nDECLARE";
		for(String name : columnNames){

			script += " \nSTRING" + i + " := "+ name + " VARCHAR2";
			i+=1;
		}
		
		script += " \nBEGIN";
		
		for(String name : columnNames){
			script += " \nSTRING" + i + " := "+ name + " :NEW." + name;
		}

		return script;
	}

	// this method only works if the values to be compared are "Strings"
	public String createInterEntityCompareScript() {// Inter-Entity
		// 2 of meer tabellen ( bijv foreignkey constraint
		script = "";

		return script;
	}

}
