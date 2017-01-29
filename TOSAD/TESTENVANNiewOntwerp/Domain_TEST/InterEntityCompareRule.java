package Domain_TEST;


public class InterEntityCompareRule extends InterEntity {

	public InterEntityCompareRule(){
		super();
	}
	
	public String generateScript(String triggerName, String operator, String errorMessage) {
		
		script = "CREATE OR REPLACE TRIGGER trigger_" + triggerName +  
				 "\nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				 "\nFOR EACH ROW" +
				 "\nDECLARE" +
				 "\nCOLUMNVALUE VARCHAR2" + //value of item in tableName
				 "\nTARGETCOLUMN VARCHAR2" + 
				 "\nBEGIN" +
				 "\nCOLUMNVALUE := NEW." + columnCheckwaarde(columns.get(0)) +  // new value to be compared with.. column of target tablecolumn
				 "\nSELECT :NEW." + columns.get(1) + " FROM " + tables.get(1) + " INTO TARGETCOLUMN" +
				 "\nIF (COLUMNVALUE " + operator + " TARGETCOLUMN ) = FALSE" +
				 "\nTHEN" +
				 "\nRAISE_APPLICATION_ERROR(20004, '" + errorMessage + "')"+
				 "\nEND IF" +
				 "\nEND";

		return script;
	}
}
