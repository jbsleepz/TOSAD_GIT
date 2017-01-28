package Domain;

public class RuleGeneratorFactory {

	// Aanmaken van scrips met het type van Attribute
	public Attribute makeAttributeScript(String ruleType) {
		Attribute attribute = null;

		if (ruleType.equalsIgnoreCase("RANGE")) {
			attribute = new AttributeRangeRule();
		} else if (ruleType.equalsIgnoreCase("COMPARE")) {
			attribute = new AttributeCompareRule();
		} else if (ruleType.equals("OTHER")) {
			attribute = new AttributeOtherRule();
		} else if (ruleType.equals("LIST")) {
			attribute = new AttributeListRule();
		}
		return attribute;
	}

	// Aanmaken van scrips met het type van Tuple
	public Tuple makeTupleScript(String ruleType) {
		Tuple tuple = null;

		if (ruleType.equalsIgnoreCase("COMPARE")) {
			tuple = new TupleCompare();
		} else if (ruleType.equalsIgnoreCase("OTHER")) {
			tuple = new TupleOther();
		}
		return tuple;
	}
	
	// Aanmaken van scrips met het type van Inter-Entity
	public InterEntity makeInterEntityScript(String ruleType){
		InterEntity interEntity = null;
		if (ruleType.equalsIgnoreCase("COMPARE")){
			interEntity = new InterEntityCompare();
		}
		return interEntity;
	}
	
	//Aanmaken van scrips met het type van Entity
	public Entity makeEntityScript(String ruleType){
		Entity entity = null;
		
		if(ruleType.equalsIgnoreCase("OTHER")){
			entity = new EntityOther();
		}
		return entity;		
	}

}
