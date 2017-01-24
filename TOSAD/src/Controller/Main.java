package Controller;

import java.util.ArrayList;

import Domain.Attribute;
import Domain.CompareRule;
import Domain.Operator;
import Domain.RangeRule;

public class Main {
	public static void main(String[] args){
		

		
		ArrayList<String> al = new ArrayList<String>();
		al.add("een");
		al.add("twee");
		
		CompareRule c = new CompareRule();
		String testScript1 = c.createAttributeCompareScript("test_name", "test_table", "test_value", ">");
		System.out.println(testScript1);
		
		
				
	}

}
