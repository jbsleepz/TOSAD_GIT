package Domain;

public class Domain_Facade_Interface_Impl implements Domain_Facade_Interface{
	private Businessrule Businessrule;

	public Domain_Facade_Interface_Impl(){
		Businessrule = new Businessrule();
	}
	
	@Override
	public Businessrule ReturnBusinessruleObject() {
		 return Businessrule;
	}
	
	public void setbusinessRuleTypeToBusinessRule(String type){
		this.Businessrule.
	}
	@Override
	public void GenerateBusinessrule(RuleType rT) {
		// TODO Auto-generated method stub
		
	}

}
