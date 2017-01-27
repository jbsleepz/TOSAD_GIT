package Domain;

public class RangeRule extends Type{
	
	int minimumValue = 0;
	int maximumValue = 0;
	

	
	
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
	
	public String CreateRangeRuleScript(String tableName,String triggerName, String columnname, int minimumValue, int maximumValue){
		String script1 = ""/*"CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
						" \nBEFORE INSERT OR UPDATE ON " + tableName + 
						" \nFOR EACH ROW" +
						" \nDECLARE"+ 
						" \nMINVALUE NUMBER := " + min + ";" + 
						" \nMAXVALUE NUMBER := " + max + ";" + 
						" \nMINIMUMVALUE NUMBER;" +
						" \nMAXIMUMVALUE NUMBER;" +
						" \nBEGIN"+ 
						" \nMINIMUMVALUE := :NEW.MINIMUMVALUE;" +
						" \nMAXIMUMVALUE := :NEW.MAXIMUMVALUE;" +
						" \nIF (MINIMUMVALUE < MINVALUE OR MINIMUMVALUE > MAXVALUE)" + 
						" \nTHEN " + 
						" \nRaise_Application_Error(-20000, 'minimum value is not a valid number');" + //exceptionmessage
						" \nELSIF (MAXIMUMVALUE < MINVALUE OR MAXIMUMVALUE > MAXVALUE)" +
						" \nTHEN " + 
						" \nRaise_Application_Error(-20001, 'maximum value is not a valid number');" + //exceptionmessage
						" \nEND IF;" +
						" \nEND;"*/;
		
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tableName + 
				" \nFOR EACH ROW" +
				" \nDECLARE"+ 
				" \nVALUE NUMBER" +
				" \nBEGIN"+ 
				" \nVALUE := :NEW." + columnname + ";" +
				" \nIF (VALUE NOT BETWEEN " + minimumValue + " AND " + maximumValue + ")" + 
				" \nTHEN " + 
				" \nRaise_Application_Error(-20000, 'minimum value is not a valid number');" +
				" \nEND IF;" +
				" \nEND;";

		return script;
	}

}
