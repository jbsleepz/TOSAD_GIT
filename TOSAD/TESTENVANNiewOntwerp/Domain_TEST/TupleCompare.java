package Domain_TEST;

import java.util.ArrayList;

public class TupleCompare extends Tuple{

	public TupleCompare(){
		super();
	}
	
	
	public String generateScript(String triggerName , String operator, String errorMessage) { 
		// tuple
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
}
