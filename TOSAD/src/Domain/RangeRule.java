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
	
	public String CreateRangeRuleScript(String tableName,String triggerName, int min, int max){
		String script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
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
						" \nRaise_Application_Error(-20000, 'maximum value is not a valid number');" + //exceptionmessage
						" \nEND IF;" +
						" \nEND;";
		/*
		create or replace TRIGGER TRIGGER_TEST 
		BEFORE INSERT OR UPDATE ON ATTRIBUTERANGERULE
		FOR EACH ROW
		DECLARE 
		MINVALUE NUMBER := 123; 
		MAXVALUE NUMBER := 234; 
		MINIMUMVALUE NUMBER;
		MAXIMUMVALUE NUMBER;
		BEGIN 
		MINIMUMVALUE := :NEW.MINIMUMVALUE;
		MAXIMUMVALUE := :NEW.MAXIMUMVALUE;
		IF (MINIMUMVALUE < MINVALUE OR MINIMUMVALUE > MAXVALUE)
		THEN 
		RAISE_APPLICATION_ERROR(-20000, 'minimum value is not a valid number');
		ELSIF (MAXIMUMVALUE < MINVALUE OR MAXIMUMVALUE > MAXVALUE)
		THEN
		RAISE_APPLICATION_ERROR(-20001, 'maximum value is not a valid number');
		END IF; 
		END;
*/
					
		
	
		
		return script;
	}

}
