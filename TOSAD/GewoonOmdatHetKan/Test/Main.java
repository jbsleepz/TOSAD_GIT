package Test;

import java.sql.SQLException;
import java.util.ArrayList;

import Domain.Attribute;
import Domain.AttributeRangeRule;
import Domain.BusinessRule;
import Domain.RuleGeneratorFactory;

public class Main {

public static void main(String[] args) throws SQLException{
		//Relaties.
		RuleGeneratorFactory factory = new RuleGeneratorFactory();
		BusinessRule businesRule = new BusinessRule();
		Attribute attribute = null;
		
		//moet hij ophalen van de servlet.
		String businesRuleName = "NaampjeTest";
		String errorMessage = "Error error Biep biep";
		String type = "ATTRIBUTERANGE";
		String RuleType = "RANGE";
		int minimumValue = 4;
		int maxiumumValue = 8;
		String waarde = "testColumn";
		
		if(type.contains("ATTRIBUTERANGE")){
			attribute = factory.makeAttributeScript(RuleType);
			attribute.addColumns(waarde);
			attribute.addListTables(waarde);
			businesRule.setNaam(businesRuleName);
			((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
			((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
			System.out.println(attribute.generateScript(businesRule.getNaam(), "", errorMessage));
		}
		

}
}
