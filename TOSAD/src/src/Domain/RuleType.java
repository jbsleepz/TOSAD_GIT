package Domain;

import java.util.ArrayList;

public class RuleType {
	private Type type;
	
	public void setType(String Type){
		if(Type.equals("RangeRule")){
			type = new RangeRule();
		}
		else if(Type.equals("CompareRule")){
			type = new CompareRule();
		}
		else if (Type.equals("ListRule")){
			type = new ListRule();
		}
		else if (Type.equals("OtherRule")){
			type = new OtherRule();
		}
		else if (Type.equals("ModifyRule")){
			type = new ModifyRule();
		}
	}
	public Type getType(){
		return type;
	}
}
