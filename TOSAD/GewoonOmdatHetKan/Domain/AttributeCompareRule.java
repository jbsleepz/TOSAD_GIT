package Domain;

public class AttributeCompareRule extends Attribute{
	
	public AttributeCompareRule(){
		super();
	}

	@Override
	public String generateScript(String triggerName , String operator, String errorMessage) {
		script = "CREATE OR REPLACE TRIGGER " + "TRIGGER_" + triggerName + 
				 " \nBEFORE INSERT OR UPDATE ON " + tables.get(0) +  
				 " \nFOR EACH ROW" + 
				 " \nDECLARE" + 
				 " \nCOLUMNNAME VARCHAR2" + // columnName (Value of an attribute of a new record)
				 " \nCHECKVALUE VARCHAR2" + // check record input value with THIS VALUE
				 " \nBEGIN" + 
				 " \nCOLUMNNAME := :NEW."+ columns.get(0) + 
				 " \nCHECKVALUE := " + columnCheckwaarde.get(columns.get(0)) + 
				 " \nIF (COLUMNNAME " + operator + " CHECKVALUE)= FALSE" + 
				 " \nTHEN"+ 
				 " \nRAISE_APPLICATION_ERROR(20002, '" + errorMessage + "')" + // error message
				 " \nEND;";

		return script;
	}

}
