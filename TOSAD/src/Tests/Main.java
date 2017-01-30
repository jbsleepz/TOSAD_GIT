package Tests;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain_TEST.Attribute;
import Domain_TEST.AttributeOtherRule;
import Domain_TEST.AttributeRangeRule;
import Domain_TEST.BusinessRule;
import Domain_TEST.FacadeDomain;
import Domain_TEST.RuleGeneratorFactory;
import Domain_TEST.Tuple;

public class Main {

public static void main(String[] args) throws SQLException{
		//Relaties.
		RuleGeneratorFactory factory = new RuleGeneratorFactory();
		BusinessRule businesRule = new BusinessRule();
		Tuple tuple = null;
		Attribute attribute = null;
		
		//moet hij ophalen van de servlet.
		String businesRuleName = "NaampjeTest";
		String errorMessage = "Error error Biep biep";
		String type = "ATTRIBUTERANGE";
		String RuleType = "OTHER";
		String vergelijkingswaarde = "test";
		String vergelijkingswaarde2 = "Blijkbaar zo";
		int minimumValue = 4;
		int maxiumumValue = 8;
		String waardeColumn = "testColumn";
		String waardeColumn2 = "testColumn2";
		String waardeTable = "testTable";
		String waardeTable2 = "testTable2";
		String operator = "==";
		String sql = "SELECT LALALALA FROM LALA";
		FacadeDomain fac = new FacadeDomain();
		
		
		if(type.contains("ATTRIBUTERANGE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waardeColumn);
			attribute.addListTables(waardeTable);
			businesRule.setNaam(businesRuleName);
			((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
			((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
			System.out.println(fac.MaakScriptVoorAttributeRange(type, businesRuleName, waardeColumn, waardeTable, minimumValue, maxiumumValue, errorMessage));
			//System.out.println(attribute.generateScript(businesRule.getNaam(), "", errorMessage));
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
		
		if(type.contains("TUPLECOMPARE")){
			tuple = factory.makeTupleScript(RuleType);
			tuple.addColumns(waardeColumn);
			tuple.addColumns(waardeColumn2);
			tuple.addListTables(waardeTable);
			businesRule.setNaam(businesRuleName);
			tuple.setColumnCheckWaarde(waardeColumn, vergelijkingswaarde);
			tuple.setColumnCheckWaarde(waardeColumn2, vergelijkingswaarde2);
			System.out.println(tuple.generateScript(businesRule.getNaam(), operator, errorMessage));
		}
		
		
		
}
}
