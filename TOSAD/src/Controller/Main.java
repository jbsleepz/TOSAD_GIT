package Controller;

import Domain.Operator;

public class Main {
	public static void main(String[] args){
		System.out.println("Test");
		Operator O = new Operator();
		
		int waardeA = 10;
		int waardeB = 20;
		int waardeTeChecken = 15;
		
		O.inBetween(waardeA, waardeB, waardeTeChecken);
		System.out.println("De waarde ligt tussen" + waardeA + " en " + waardeB + " in? " + O.inBetween(waardeA, waardeB, waardeTeChecken));
		
	}

}
