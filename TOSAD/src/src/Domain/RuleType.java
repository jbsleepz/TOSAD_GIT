package Domain;

import java.util.ArrayList;

public class RuleType {
	private Type type;
	
	public void setType(String Type){
		if(Type.equals("RangeRule")){
			type = new RangeRule();
		}
	}
	public Type getType(){
		return type;
	}
}
