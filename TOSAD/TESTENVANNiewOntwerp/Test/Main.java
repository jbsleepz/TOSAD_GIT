package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain_TEST.Attribute;
import Domain_TEST.AttributeOtherRule;
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
		String type = "ATTRIBUTEOTHER";
		String RuleType = "OTHER";
		String vergelijkingswaarde = "test";
		int minimumValue = 4;
		int maxiumumValue = 8;
		String waardeColumn = "testColumn";
		String waardeColumn2 = "testColumn2";
		String waardeTable = "testTable";
		String waardeTable2 = "testTable2";
		String operator = "<";
		String sql = "SELECT LALALALA FROM LALA";
		
		
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
		
		if(type.contains("ATTRIBUTEOTHER")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			((AttributeOtherRule)attribute).setSql(sql);
			businesRule.setNaam(businesRuleName);
			System.out.println(attribute.generateScript(businesRule.getNaam(), operator , errorMessage));
		}
		
		if(type.contains("TUPLERANGE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			businesRule.setNaam(businesRuleName);
			((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
			((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
			System.out.println(attribute.generateScript(businesRule.getNaam(), "", errorMessage));
		}
		
		
		
}
}
