package Domain_TEST;

public class FacadeDomain {
	RuleGeneratorFactory factory = new RuleGeneratorFactory();
	BusinessRule businesRule = new BusinessRule();
	Attribute attribute = null;
	Tuple tuple = null;
	Entity entity = null;
	InterEntity inter = null;
		
	//Roept de ruleFactory aan om voor het type Attribute Rules te generaten.
	public void MaakScriptVoorAttribute(String ruleType, String businesRuleName, String columnWaarde,String tableWaarde,int minimumValue ,int maxiumumValue, String errorMessage){
		if(ruleType.contains("ATTRIBUTERANGE")){
			attribute = factory.makeAttributeScript(ruleType);
			attribute.addColumns(columnWaarde);
			attribute.addListTables(tableWaarde);
			businesRule.setNaam(businesRuleName);
			((AttributeRangeRule) attribute).setMaximumValue(maxiumumValue);
			((AttributeRangeRule) attribute).setMinimumValue(minimumValue);
			System.out.println(attribute.generateScript(businesRule.getNaam(), "", errorMessage));
		} else  if(ruleType.contains("ATTRIBUTEOTHER")){
			
		} else if(ruleType.contains("ATTRIBUTECOMPARE")){
			
		} else if(ruleType.contains("ATTRIBUTELIST")){
			
		}
	}
	
	//Roept de ruleFactory aan om voor het type Tuple Rules te generaten.
	public void maakScriptVoorTuple(String ruleType){
		if(ruleType.contains("TUPLECOMPARE")){
			tuple = factory.makeTupleScript(ruleType);
		} else if(ruleType.contains("TUPLEOTHER")){ 
			
		}
	}
	
	//Roept de ruleFactory aan om voor het type InterEntity Rules te generaten.
	public void maakScriptVoorInterEntity(String ruleType){
		if(ruleType.contains("INTERENTITY")){
			
		} 
	}
	
	//Roept de ruleFactory aan om voor het type Entity Rules te generaten.
	public void maakScriptVoorEntity(String ruleType){
		if(ruleType.contains("ENTITYCOMPARE")){
			
		}	
	}
	
	
	
}
