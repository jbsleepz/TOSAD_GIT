package Domain;

import Domain.BusinessruleType;

public abstract class Businessrule {
	protected String businessRuleName;
	protected BusinessruleType businessruleType = new BusinessruleType();

	public Businessrule(String businessRuleName) {
		this.businessRuleName = businessRuleName;
	}

	public String getbusinessRuleName() {
		return businessRuleName;
	}

	public void setBusinessRuleType(String rule) {
		businessruleType.setTypeToBusinessruleType(businessRuleName);

	}

	public BusinessruleType getBusinessRuleType() {
		return businessruleType;
	}

	public BusinessruleType getBusinessruleType() {
		return businessruleType;
	}

	public void setBusinessruleType(BusinessruleType businessruleType) {
		this.businessruleType = businessruleType;
	}

	public void setbusinessRuleName(String businessRuleName) {
		this.businessRuleName = businessRuleName;
	}

}
