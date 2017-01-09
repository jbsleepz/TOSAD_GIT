package Tests;

import Domain.Operator;

public class TestOperators {
	public static void main(String[] args){
		
		//testen voor operator klasse
		System.out.println("Test Operator klassen.");
		Operator o = new Operator();
		
		int waardeA = 10;
		int waardeB = 20;
		int waardeTeChecken = 19;
		String type = ">";
		String StringWaardeA = "bla";
		String StringWaardeB = "blabla";
	
		// in between test
		System.out.println("De waarde ligt tussen" + waardeA + " en " + waardeB + " in? " + o.inBetween(waardeA, waardeB, waardeTeChecken));
		
		//biggerThen test
		//type = ">=";
		System.out.println("is de waarde " + waardeTeChecken + " groter dan " + waardeB + " = " + o.biggerThen(waardeTeChecken, waardeB, type));
		
		//lowerThen test
		//type = "<";
		type = "<=";
		System.out.println("is de waarde " + waardeTeChecken + " kleiner dan " + waardeB + " = " + o.lowerThen(waardeTeChecken, waardeB, type));
	
		//StringwaardeA = "blabla";
		//equals test
		System.out.println("is de waarde gelijk? " + o.equalsTo(StringWaardeA, StringWaardeB));
		
		// StringWaardeA = "test"; StringWaardeB = "test";
		//equals test
		System.out.println("is de waarde gelijk? " + o.notEqualsTo(StringWaardeA, StringWaardeB));
				
	}

}
