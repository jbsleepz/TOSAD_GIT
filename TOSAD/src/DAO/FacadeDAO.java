package DAO;

public class FacadeDAO {
	DAOAttributeRangeRule arng = null;
	DAOAttributeCompareRule acomp = null;
	DAOAttributeListRule alis = null;
	DAOAttributeOtherRule aotr = null;
	DAOTupleCompareRule tucr = null;
	DAOTupleOtherRule totr = null;
	DAOEntityOtherRule enor = null;
	DAOInterEntityCompareRule iecr = null;
	DAOModify mod = null;
	
	
	public void DAOAttributeRangeRuleOpslaanScript(String waarde, int ruleID){
		arng = new DAOAttributeRangeRule();
		arng.wijzigAttributeRangeRule(waarde, ruleID);
	}
	
	public void DAOAttributeCompareRuleOpslaanScript(String waarde, int ruleID){
		acomp = new DAOAttributeCompareRule();
		acomp.wijzigAttributeCompareRule(waarde, ruleID);
	}
	
	public void DAOAttributeListRuleOpslaanScript(String waarde, int ruleID){
		alis = new DAOAttributeListRule();
		alis.wijzigAttributeListRule(waarde, ruleID);
	}
	
	public void DAOAttributeOtherRuleOpslaanScript(String waarde, int ruleID){
		aotr = new DAOAttributeOtherRule();
		aotr.wijzigAttributeOtherRule(waarde, ruleID);
	}
	public void DAOTupleCompareRuleOpslaanScript(String waarde, int ruleID){
		tucr = new DAOTupleCompareRule();
		tucr.wijzigTupleCompareRule(waarde, ruleID);
	}
	public void DAOTupleOtherRuleOpslaanScript(String waarde, int ruleID){
		totr = new DAOTupleOtherRule();
		totr.wijzigOtherRule(waarde, ruleID);
	}
	public void DAOEntityOtherRuleOpslaanScript(String waarde, int ruleID){
		enor = new DAOEntityOtherRule();
		enor.wijzigEntityOtherRule(waarde, ruleID);
	}
	public void DAOInterEntityCompareRuleOpslaanScript(String waarde, int ruleID){
		iecr = new DAOInterEntityCompareRule();
		iecr.wijzigInterEntityCompareRule(waarde, ruleID);
	}
	public void DAOInterEntityCompareRuleOpslaanScript(String waarde, int ruleID){
		iecr = new DAOInterEntityCompareRule();
		iecr.wijzigInterEntityCompareRule(waarde, ruleID);
	}
	public void DAOModifyRuleOpslaanScript(String script){
		mod = new DAOModify();
		mod.wijzigModifyRule(script);
	}
	
	public void DAOAttributeRangeRuleExecuteScript(String script){
		arng = new DAOAttributeRangeRule();
		arng.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeCompareRuleExecuteScript(String script){
		acomp = new DAOAttributeCompareRule();
		acomp.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeListRuleExecuteScript(String script){
		alis = new DAOAttributeListRule();
		alis.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeOtherRuleExecuteScript(String script){
		aotr = new DAOAttributeOtherRule();
		aotr.ExecuteScriptNaarTarget(script);
	}
	public void DAOTupleCompareRuleExecuteScript(String script){
		tucr = new DAOTupleCompareRule();
		tucr.ExecuteScriptNaarTarget(script);
	}
	public void DAOTupleOtherRuleExecuteScript(String script){
		totr = new DAOTupleOtherRule();
		totr.ExecuteScriptNaarTarget(script);
	}
	public void DAOEntityOtherRuleExecuteScript(String script){
		enor = new DAOEntityOtherRule();
		enor.ExecuteScriptNaarTarget(script);
	}
	public void DAOInterEntityCompareRuleExecuteScript(String script){
		iecr = new DAOInterEntityCompareRule();
		iecr.ExecuteScriptNaarTarget(script);
	}
	public void DAOModifyRuleExecuteScript(String script){
		mod = new DAOModify();
		mod.ExecuteScriptNaarTarget(script);
	}
	

}
