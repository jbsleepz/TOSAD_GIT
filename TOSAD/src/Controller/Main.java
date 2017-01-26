package Controller;

import java.util.ArrayList;

import Domain.Attribute;
import Domain.CompareRule;
import Domain.ListRule;
import Domain.Operator;
import Domain.RangeRule;

public class Main {
	public static void main(String[] args){
		

		
		ArrayList<String> al = new ArrayList<String>();
		al.add("een");
		al.add("twee");
		
		CompareRule c = new CompareRule();
		String testScript1 = c.createAttributeCompareScript("test_name", "test_table", "test_value", ">");
		//System.out.println(testScript1);
		
		String s = c.createTupleComparesScript("test_name", "test_table", al, ">");
		System.out.println(s);
		
		
		
/*		//testing listrule parser
		String test  = "bla asd nogeen string";
		ListRule l = new ListRule(test);
		ArrayList<String> listValues = l.stringToListParser(test);	
		String script = l.createAttributeListRuleScript("ListRule", "Some_table", "Some_Column", listValues);
		System.out.println(script);*/
		
		
		
	}

}
