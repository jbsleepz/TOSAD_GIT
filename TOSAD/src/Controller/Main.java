package Controller;

import Domain.Operator;
import Domain.RangeRule;

public class Main {
	public static void main(String[] args){
		
		System.out.println("Doet iets");
		
		//dit is een test van scriptoutput
		RangeRule r = new RangeRule(123, 234);
		String testScript = r.CreateRangeRuleScript("ATTRIBUTERANGERULE", "TEST", r.getMinValue(), r.getMaxValue());
		System.out.println(testScript);
				
	}

}
