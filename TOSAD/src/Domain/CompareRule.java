package Domain;

public class CompareRule extends RuleType {
	private String script;
	Operator operator;
	Object o; // type of businessrule ( because there is no super class )
	//String attribute;
	//String compareAttribute;

	
	
	
	//compare rules om rekening mee te houden : 
	// - attribute
	// -- heeft 2 gelijkwaardige types nodig
	//
	//
	// - tuple
	// -- 2 tuples met minimaal 2 waardes.
	// -- zelf de operator bepalen
	// -- kunnen meerdere tabellen zijn
	//
	//
	// - inter-entity
	// 
	
	
	/*public CompareRule(String attribute, String compareAttribute){ // for attributeCompareRule
		this.attribute = attribute;
		this.compareAttribute = compareAttribute;
	}*/
	
/*	public String CreateCompareruleScript(String ruleName, String operator ){
		
		String script = "";
		
		if (ruleName.equals("attribute")){
			//1 tabel
			//1 kolom
			//1 inputwaarde van gebruiker

			
		}
		else if(ruleName.equals("tuple")){
			//1 tabel
			//minimaal 2 kolommen
			//  vergelijken met inputwaardes
			
		}
		else if (ruleName.equals("interEntity")){
			//2 of meer tabellen ( bijv foreignkey constraint
			
			
		}
		return script;
	}*/

	public String createAttributeCompareScript(String triggerName, String tableName, String checkValue,  String operator ){ //attribute
		script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" +
				" \nDECLARE" + 
				" \nCOLUMNNAME VARCHAR2" + //columnName (value of an attribute of a new record)
				" \nCHECKVALUE VARCHAR2" + //check record input value with THIS VALUE.
				" \nBEGIN" +
				" \nCOLUMNNAME := :NEW.COMPAREVALUE" +  
				" \nCHECKVALUE := "+ checkValue + 
				" \nIF (COLUMNNAME " + operator + " CHECKVALUE)= FALSE"  +  
				" \nTHEN" +
				" \nRAISE_APPLICATION_ERROR(20002, 'The given value is not valid')"+
				" \nEND;";
		
		
		
		return script;
	}
	
	public String createTupleComparesScript(){ //tuple
		script = "";
		
		return script;
	}
	
	public String createInterEntityCompareScript(){
		script = "";
		
		
		return script;
	}
	
	
	
}
