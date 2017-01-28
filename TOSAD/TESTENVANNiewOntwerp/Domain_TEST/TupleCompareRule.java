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
				 " \nDECLARE" + " \n" + columns.get(0) + " := "+ columnCheckwaarde.get(columns.get(0)) + " VARCHAR2"+
				 " \n" + columns.get(1) + " := "+ columnCheckwaarde.get(columns.get(0)) + 
				 " VARCHAR2 \nBEGIN";
		
		
		script += " \n" +  columns.get(0) + " := :NEW." + columnCheckwaarde.get(columns.get(0));
		script += " \n" +  columns.get(1) + " := :NEW." + columnCheckwaarde.get(columns.get(1));
			
		
		script += "\nIF ( "+ columns.get(0) + " " + operator + " " + columns.get(1)+") = FALSE" +
				"\nTHEN" +
			    "\nRAISE_APPLICATION_ERROR(20003, '" + errorMessage + "') " +
				"\nEND IF" +
			    "\nEND";
		
		

		return script;
	}
}
