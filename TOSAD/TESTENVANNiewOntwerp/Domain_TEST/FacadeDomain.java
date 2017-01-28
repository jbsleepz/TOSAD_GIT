package Domain_TEST;

public class FacadeDomain {
	RuleGeneratorFactory factory = new RuleGeneratorFactory();
	BusinessRule businesRule = new BusinessRule();
	Attribute attribute = null;
	Tuple tuple = null;
	Entity entity = null;
	InterEntity inter = null;

	// Roept de ruleFactory aan om voor het type Attribute Range Rule een script
	// te generaten.
	public void MaakScriptVoorAttributeRange(String ruleType, String businesRuleName, String columnWaarde,
			String tableWaarde, int minimumValue, int maxiumumValue, String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
		((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
		attribute.generateScript(businesRule.getNaam(), "", businesRule.getError());
	}

	// Roept de ruleFactory aan om voor het type Attribute Other Rule een script
	// te generaten.
	public String MaaktScriptVoorAttributeOther(String ruleType, String businesRuleName, String sql, String operator,
			String columnWaarde, String tableWaarde, String errorMessage) {
		attribute = factory.makeAttributeScript(ruleType);
		attribute.addColumns(columnWaarde);
		attribute.addListTables(tableWaarde);
		((AttributeOtherRule) attribute).setSql(sql);
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

	// Roept de ruleFactory aan om voor het type Attribute List Rule een script te generaten.
	public String MaaktScriptVoorAttributeList() {

		return "";
	}

	// Roept de ruleFactory aan om voor het type Tuple Compare Rule een script te generaten.
	public String maakScriptVoorTupleCompare(String ruleType, String businesRuleName, String vergelijkingswaarde1,
			String vergelijkingswaarde2, String operator, String columnWaarde1, String columnWaarde2,
			String tableWaarde1, String errorMessage) {
		tuple = factory.makeTupleScript(ruleType);
		tuple.addColumns(columnWaarde1);
		tuple.addColumns(columnWaarde2);
		tuple.addListTables(tableWaarde1);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		tuple.setColumnCheckWaarde(columnWaarde1, vergelijkingswaarde1);
		tuple.setColumnCheckWaarde(columnWaarde2, vergelijkingswaarde2);
		return tuple.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}

	public String maakScriptTupleOther() {

		return "";
	}

	// Roept de ruleFactory aan om voor het type InterEntity Rules te generaten.
	public String maakScriptVoorEntity(String ruleType) {

		return "";
	}

	// Roept de ruleFactory aan om voor het type Entity Rules te generaten.
	public String maakScriptVoorInterEntity(String ruleType, String businesRuleName, String vergelijkingswaarde1,
			String vergelijkingswaarde2, String operator, String columnWaarde1, String columnWaarde2,
			String tableWaarde1, String tableWaarde2, String errorMessage) {
		entity = factory.makeEntityScript(ruleType);
		entity.addColumns(columnWaarde1);
		entity.addColumns(columnWaarde2);
		entity.addListTables(tableWaarde1);
		entity.addListTables(tableWaarde2);
		entity.setColumnCheckWaarde(columnWaarde1, vergelijkingswaarde1);
		entity.setColumnCheckWaarde(columnWaarde2, vergelijkingswaarde2);
		businesRule.setNaam(businesRuleName);
		businesRule.setError(errorMessage);
		return entity.generateScript(businesRule.getNaam(), operator, businesRule.getError());
	}
}
