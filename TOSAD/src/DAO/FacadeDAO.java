package DAO;

public class FacadeDAO {
	
	public void DAOAttributeRangeRuleOpslaanScript(String waarde, int ruleID){
		DAOAttributeRangeRule arng = new DAOAttributeRangeRule();
		arng.wijzigAttributeRangeRule(waarde, ruleID);
	}
	
	public void DAOAttributeCompareRuleOpslaanScript(String waarde, int ruleID){
		DAOAttributeCompareRule acomp = new DAOAttributeCompareRule();
		acomp.wijzigAttributeCompareRule(waarde, ruleID);
	}
	
	public void DAOAttributeListRuleOpslaanScript(String waarde, int ruleID){
		DAOAttributeListRule alis = new DAOAttributeListRule();
		alis.wijzigAttributeListRule(waarde, ruleID);
	}
	
	public void DAOAttributeOtherRuleOpslaanScript(String waarde, int ruleID){
		DAOAttributeOtherRule aotr = new DAOAttributeOtherRule();
		aotr.wijzigAttributeOtherRule(waarde, ruleID);
	}
	public void DAOTupleCompareRuleOpslaanScript(String waarde, int ruleID){
		DAOTupleCompareRule tucr = new DAOTupleCompareRule();
		tucr.wijzigTupleCompareRule(waarde, ruleID);
	}
	public void DAOTupleOtherRuleOpslaanScript(String waarde, int ruleID){
		DAOTupleOtherRule totr = new DAOTupleOtherRule();
		totr.wijzigOtherRule(waarde, ruleID);
	}
	public void DAOEntityOtherRuleOpslaanScript(String waarde, int ruleID){
		DAOEntityOtherRule enor = new DAOEntityOtherRule();
		enor.wijzigEntityOtherRule(waarde, ruleID);
	}
	public void DAOInterEntityCompareRuleOpslaanScript(String waarde, int ruleID){
		DAOInterEntityCompareRule iecr = new DAOInterEntityCompareRule();
		iecr.wijzigInterEntityCompareRule(waarde, ruleID);
	}
	//-----------------------------
	
	public void DAOAttributeRangeRuleExecuteScript(String script){
		DAOAttributeRangeRule arng = new DAOAttributeRangeRule();
		arng.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeCompareRuleExecuteScript(String script){
		DAOAttributeCompareRule acomp = new DAOAttributeCompareRule();
		acomp.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeListRuleExecuteScript(String script){
		DAOAttributeListRule alis = new DAOAttributeListRule();
		alis.ExecuteScriptNaarTarget(script);
	}
	
	public void DAOAttributeOtherRuleExecuteScript(String script){
		DAOAttributeOtherRule aotr = new DAOAttributeOtherRule();
		aotr.ExecuteScriptNaarTarget(script);
	}
	public void DAOTupleCompareRuleOpslaanScript(String script){
		DAOTupleCompareRule tucr = new DAOTupleCompareRule();
		tucr.ExecuteScriptNaarTarget(script);
	}
	public void DAOTupleOtherRuleOpslaanScript(String script){
		DAOTupleOtherRule totr = new DAOTupleOtherRule();
		totr.ExecuteScriptNaarTarget(script);
	}
	public void DAOEntityOtherRuleOpslaanScript(String script){
		DAOEntityOtherRule enor = new DAOEntityOtherRule();
		enor.ExecuteScriptNaarTarget(script);
	}
	public void DAOInterEntityCompareRuleOpslaanScript(String script){
		DAOInterEntityCompareRule iecr = new DAOInterEntityCompareRule();
		iecr.ExecuteScriptNaarTarget(script);
	}
	

}
