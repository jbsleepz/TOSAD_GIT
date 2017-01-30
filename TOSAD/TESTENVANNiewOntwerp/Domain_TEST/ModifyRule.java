package Domain_TEST;

public class ModifyRule extends Modify {
	
	public ModifyRule(){
		super();
	}
	
	public String generateScript(String triggerName , String operator, String errorMessage){
		script = 
				"CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				"DECLARE" 
				+ "COLUMNVALUE_1 VARCHAR2;"
				+ "COLUMNVALUE_2 VARCHAR2;"
				+ "BEGIN"
				+ "SELECT " + columns.get(1) + " FROM "+ tables.get(1) + " INTO COLUMNVALUE_1;"
				+ "SELECT :NEW."+ columns.get(0)+ " INTO COLUMNVALUE_2;"
				+ "IF(COLUMNVALUE_1 " + operator + " " + columnCheckwaarde(columns.get(1)) + ") = TRUE "
				+ " \nTHEN" +
			     " \nRAISE_APPLICATION_ERROR(20000, '" + errorMessage + "'); " +
				 " \nEND IF;" +
				 "END";
		return script;
	}

}
