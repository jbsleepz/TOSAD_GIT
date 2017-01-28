package Domain_TEST;

import java.util.ArrayList;

public class TupleCompareRule extends Tuple{

	public TupleCompareRule(){
		super();
	}
	
	
	public String generateScript(String triggerName , String operator, String errorMessage) { 
		// tuple
		// 1 table
		// 2 columns
		// compare with user input
		script = "CREATE OR REPLACE TRIGGER " + "TRIGGER_" + triggerName +
				 " \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				 " \nFOR EACH ROW" +
				 " \nDECLARE";
		for(String name : columns){

			script += " \nSTRING" + name + " := "+ name + " VARCHAR2";
		}
		script += " \nBEGIN";
		
		for(String name : columns){
			script += " \nSTRING" + name + " := :NEW." + name;

		}
		
		script += "\nIF (STRING"+ columns.get(0) + " " + operator + " STRING" + columns.get(1)+") = FALSE" +
				"\nTHEN" +
			    "\nRAISE_APPLICATION_ERROR(20003, 'The given values are not valid') " +
				"\nEND IF" +
			    "\nEND";
		
		

		return script;
	}
}
