package Domain;

public class RangeRule extends Type{
	
	int minimumValue = 0;
	int maximumValue = 0;
	
	Operator operator;
	
	
	public RangeRule(int min, int max){  // creating the rangerule-object
		this.minimumValue = min;
		this.maximumValue = max;
	}
	
	public int getMinValue(){  //return the minimum value of the rangerule
		return minimumValue;
	}
	
	public int getMaxValue(){  // returning the maximum value of the rangerule
		return maximumValue;
	}
	
	public String CreateRangeRuleScript(String tableName,String name, int min, int max){
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + name + 
						" BEFORE INSERT OR UPDATE ON " + tableName + 
						" DECLARE"+ 
						" MINVALUE NUMBER(10) = " + min + ";" + 
						" MAXVALUE NUMBER(10) = " + max + ";" + 
						" BEGIN"+ 
						" IF :NEW.MINIMUMVALUE BETWEEN MINVALUE AND MAXVALUE";
					
		
	
		
		return script;
	}

}
