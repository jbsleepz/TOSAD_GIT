package Domain_TEST;

public class ModifyRule extends Modify {
	
	private String plSQLquery;

	public ModifyRule(){
		super();
	}
	
	public String generateScript(String triggerName, String operator, String checkwaarde,  String errorMessage) {
		script = 
				"CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				"DECLARE" 
				+ "COLUMNVALUE_1 VARCHAR2;"
				+ "COLUMNVALUE_2 VARCHAR2;"
				+ "BEGIN"
				+ "SELECT " + columns.get(1) + " FROM "+ tables.get(1) + " INTO COLUMNVALUE_1;"
				+ "SELECT :NEW."+ columns.get(0)+ " INTO COLUMNVALUE_2;"
				+ "IF(COLUMNVALUE_1 " + operator + " " + checkwaarde + ") = TRUE "
				+ "THEN"
				+ "l_error_stack := l_error_stack || '" + errorMessage + "';"
				+ "END IF;"
				+ "END";
		
		
		//als 
		
		
		
		/*declare
		 l_passed boolean := true;
		 begin
		 -- de prijs van een boek mag niet verhoogd worden
		 if :new.product_type = 'BOE' and
		 l_oper = 'UPD'
		 then
		 l_passed := :new.prijs <= :old.prijs;
		 end if;
		 if not l_passed
		 then
		 l_error_stack := l_error_stack || 'De prijs van een boek mag
		niet verhoogd worden.';
		 end if;
		 end;*/
		
	/*	 cursor lc_bst is
		 select bst.status
		 from bestellingen bst
		 where bst_id = p_bsr_row.new_bst_id;
		 l_status bestelling.status%type;
		begin
		 if p_bsr_row.brg_oper = 'INS' then
		 open lc_bst;
		 fetch lc_bst into l_status;
		 close lc_bst;
		 l_passed := l_status != 'goedgekeurd';
		 end if;*/
		
		return null;
	}

	public String getSqlQuery() {
		return plSQLquery;
	}

	public void setSqlQuery(String pl_sqlQuery) {
		this.plSQLquery = pl_sqlQuery;
	}

	@Override
	public String generateScript(String triggerName, String operator, String errormessage) {
		// TODO Auto-generated method stub
		return null;
	}

}
