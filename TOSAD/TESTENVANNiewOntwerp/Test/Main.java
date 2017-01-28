package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain_TEST.Attribute;
import Domain_TEST.AttributeRangeRule;
import Domain_TEST.BusinessRule;
import Domain_TEST.RuleGeneratorFactory;

public class Main {

public static void main(String[] args) throws SQLException{
		//Relaties.
		RuleGeneratorFactory factory = new RuleGeneratorFactory();
		BusinessRule businesRule = new BusinessRule();
		Attribute attribute = null;
		
		//moet hij ophalen van de servlet.
		String businesRuleName = "NaampjeTest";
		String errorMessage = "Error error Biep biep";
		String type = "ATTRIBUTECOMPARE";
		String RuleType = "COMPARE";
		String vergelijkingswaarde = "test";
		int minimumValue = 4;
		int maxiumumValue = 8;
		String waardeColumn = "testColumn";
		String waardeTable = "testTable";
		String operator = "<";
		
		
		if(type.contains("ATTRIBUTERANGE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			businesRule.setNaam(businesRuleName);
			((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
			((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
			System.out.println(attribute.generateScript(businesRule.getNaam(), "", errorMessage));
		}
		
		if(type.contains("ATTRIBUTECOMPARE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			attribute.setColumnCheckWaarde(waardeColumn, vergelijkingswaarde);
			businesRule.setNaam(businesRuleName);
			System.out.println(attribute.generateScript(businesRule.getNaam(), operator , errorMessage));
		}
		
		if(type.contains("ATTRIBUTECOMPARE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			attribute.setColumnCheckWaarde(waardeColumn, vergelijkingswaarde);
			businesRule.setNaam(businesRuleName);
			System.out.println(attribute.generateScript(businesRule.getNaam(), operator , errorMessage));
		}
		
		
		
		

}
}
