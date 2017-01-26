package Domain;

public class Domain_Facade_Interface_Impl implements Domain_Facade_Interface{
	public Businessrule Businessrule;
	@Override
	public Businessrule ReturnBusinessruleObject() {
		 return Businessrule;
	}
	public Domain_Facade_Interface_Impl(){
		Businessrule = new Businessrule();
	}
	public void setAttributeRangeRule(String TableName,String ColumnName){
		
	}
	@Override
	public void GenerateBusinessrule(RuleType rT) {
		// TODO Auto-generated method stub
		
	}

}
