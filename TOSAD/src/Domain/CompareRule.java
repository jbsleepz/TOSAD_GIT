package Domain;


import java.util.ArrayList;


public class CompareRule extends RuleType {
	private String script;
	Operator operator;
	int i = 1;



	// this method only works if the values to be compared are "Strings"
	public String createAttributeCompareScript(String triggerName, String tableName, String columnName,  String checkValue,String operator) { // attribute
		// 1 table
		// 1 column
		// 1 value from user input
		script = "CREATE OR REPLACE TRIGGER " + "TRIGGER_" + triggerName + 
				 " \nBEFORE INSERT OR UPDATE ON " + tableName +  
				 " \nFOR EACH ROW" + 
				 " \nDECLARE" + 
				 " \nCOLUMNNAME VARCHAR2" + // columnName (Value of an attribute of a new record)
				 " \nCHECKVALUE VARCHAR2" + // check record input value with THIS VALUE
				 " \nBEGIN" + 
				 " \nCOLUMNNAME := :NEW."+ columnName + 
				 " \nCHECKVALUE := " + checkValue + 
				 " \nIF (COLUMNNAME " + operator + " CHECKVALUE)= FALSE" + 
				 " \nTHEN"+ 
				 " \nRAISE_APPLICATION_ERROR(20002, 'The given value is not valid')" + // error message
				 " \nEND;";

		return script;
	}

	public String createTupleComparesScript(String triggerName, String tableName, ArrayList<String> columnNames, String operator) { // tuple
		// 1 table
		// 2 columns
		// compare with user input
		script = "CREATE OR REPLACE TRIGGER " + "Trigger" + triggerName +
				 " \nBEFORE INSERT OR UPDATE ON " +tableName + 
				 " \nFOR EACH ROW" +
				 " \nDECLARE";
		for(String name : columnNames){

			script += " \nSTRING" + name + " := "+ name + " VARCHAR2";
		}
		script += " \nBEGIN";
		
		for(String name : columnNames){
			script += " \nSTRING" + name + " := :NEW." + name;

		}
		
		script += "\nIF (STRING"+ columnNames.get(0) + " " + operator + " STRING" + columnNames.get(1)+") = FALSE" +
				"\nTHEN" +
			    "\nRAISE_APPLICATION_ERROR(20003, 'The given values are not valid') " +
				"\nEND IF" +
			    "\nEND";
		
		

		return script;
	}

	

	public String createInterEntityCompareScript(String triggerName,String tableName, String column, String tableName2, String column2, String operator ) {// Inter-Entity
		// kies tabel voor de trigger
		// kies de kolom van die tabel
		// kies targetkolom
		// kies target kolom van tabel
		//vergelijk niewwaarde tabel met target kolom van target tabel
		// anders...exceptions

		

		
		script = "CREATE OR REPLACE TRIGGER trigger_" + triggerName +  
				 "\nBEFORE INSERT OR UPDATE ON " + tableName + 
				 "\nFOR EACH ROW" +
				 "\nDECLARE" +
				 "\nCOLUMNVALUE VARCHAR2" + //value of item in tableName
				 "\nTARGETCOLUMN VARCHAR2" + 
				 "\nBEGIN" +
				 "\nCOLUMNVALUE := NEW." + column +  // new value to be compared with.. column of target tablecolumn
				 "\nSELECT :NEW." + column2 + " FROM " + tableName2 + " INTO TARGETCOLUMN" +
				 "\nIF (COLUMNVALUE " + operator + " TARGETCOLUMN ) = FALSE" +
				 "\nTHEN" +
				 "\nRAISE_APPLICATION_ERROR(20004, 'The given value is not valid')"+
				 "\nEND IF" +
				 "\nEND";

		return script;
	}

}
