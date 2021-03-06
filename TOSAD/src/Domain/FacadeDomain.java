package Domain;

import java.util.ArrayList;

public class FacadeDomain {
	RuleGeneratorFactory factory = new RuleGeneratorFactory();
	BusinessRule businesRule = new BusinessRule();
	Attribute attribute = null;
	Tuple tuple = null;
	Entity entity = null;
	InterEntity inter = null;
	Modify modify = null;

	// Roept de ruleFactory aan om voor het type Attribute Range Rule een script
	// te generaten.
	public String MaakScriptVoorAttributeRange(String ruleType, String businesRuleName, String columnWaarde,
			String tableWaarde, int minimumValue, int maxiumumValue, String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
		((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
		return attribute.generateScript(businesRule.getNaam(), "", businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Attribute Other Rule een script
	// te generaten.
	public String MaaktScriptVoorAttributeOther(String ruleType, String businesRuleName, String sqlQuery,
			String operator, String columnWaarde, String tableWaarde, String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		((AttributeOtherRule) attribute).setSql(sqlQuery);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return attribute.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Attribute Compare Rule een
	// script te generaten.
	public String MaaktScriptVoorAttributeCompare(String ruleType, String businesRuleName, String vergelijkingswaarde,
			String operator, String columnWaarde, String tableWaarde, String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		attribute.setColumnCheckWaarde(columnWaarde, vergelijkingswaarde);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return attribute.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Attribute List Rule een script
	// te generaten.
	public String MaaktScriptVoorAttributeList(String ruleType, String businesRuleName,
			String columnWaarde, String tableWaarde, ArrayList<String> listValues , String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		for(String s : listValues){
			attribute.addListTables(s);
		}
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return attribute.generateScript(businesRule.getNaam(), "", businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Tuple Compare Rule een script
	// te generaten.
	public String maakScriptVoorTupleCompare(String ruleType, String businesRuleName, String operator, String columnWaarde1, String columnWaarde2,
			String tableWaarde1, String errorMessage) {
		tuple = factory.makeTupleScript(ruleType);
		tuple.addColumns(columnWaarde1);
		tuple.addColumns(columnWaarde2);
		tuple.addListTables(tableWaarde1);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return tuple.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Tuple Other Rule een script
	// te generaten.
	public String maakScriptTupleOther(String ruleType, String sqlQuery, String businesRuleName,String operator, String columnWaarde1, String columnWaarde2, String tableWaarde1,String errorMessage) {
		tuple = factory.makeTupleScript(ruleType);
		tuple.addColumns(columnWaarde1);
		tuple.addColumns(columnWaarde2);
		tuple.addListTables(tableWaarde1);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		((TupleOtherRule) tuple).setSql(sqlQuery);
		return tuple.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Entity OtherRule Rule een script
	// te generaten.
	public String maakScriptVoorEntityOther(String ruleType, String sqlQuery, String businesRuleName,
			String operator, String columnWaarde1,
			String tableWaarde1, String errorMessage) {
		entity = factory.makeEntityScript(ruleType);
		((EntityOtherRule) entity).setSql(sqlQuery);
		entity.addColumns(columnWaarde1);
		entity.addListTables(tableWaarde1);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return entity.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Inter-Entity Compare Rule een script
	// te generaten.
	public String maakScriptVoorInterEntityCompare(String ruleType, String businesRuleName
			, String operator, String columnWaarde1,
			String columnWaarde2, String tableWaarde1, String tableWaarde2, String errorMessage) {
		inter = factory.makeInterEntityScript(ruleType);
		inter.addColumns(columnWaarde1);
		inter.addColumns(columnWaarde2);
		inter.addListTables(tableWaarde1);
		inter.addListTables(tableWaarde2);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return inter.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}
	public String maakScriptVoorModifyRule(String ruleType, String operator, String businesRuleName,
			String tableWaarde1, String tableWaarde2, String columnWaarde1, String columnWaarde2,String checkwaarde1, String errorMessage){
		modify = factory.makeModifyScript(ruleType);
		modify.addListTables(tableWaarde1);
		modify.addListTables(tableWaarde2);
		modify.addColumns(columnWaarde1);
		modify.addColumns(columnWaarde2);
		modify.setColumnCheckWaarde(columnWaarde2, checkwaarde1);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return modify.generateScript(businesRule.getNaam(), "" , businesRule.getError());
	}
	
}
