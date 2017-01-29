package Domain_TEST;


public class AttributeListRule extends Attribute{
	
	public AttributeListRule(){
		super();
	}

	@Override
	public String generateScript(String triggerName, String operator, String errormessage) {

		script = "CREATE OR REPLACE TRIGGER " +"TRIGGER_" + triggerName + 
				" \nBEFORE INSERT OR UPDATE ON " + tables.get(0) + 
				" \nFOR EACH ROW" + 
				" \nDECLARE" +
				"l_passed boolean := true;" +
				"BEGIN"
				+ "l_passed := :new."+ columns.get(0) + " in (";
				for (String waarde : waardesListValues){
					script+= " '"+ waarde + "'," ;
				}
		script += ");" +
				""
		
		
		/*declare
		 l_passed boolean := true;
		 begin
		 -- het producttype moet BOE, CD of KLE zijn
		 if l_oper in ( 'INS', 'UPD' )
		 then
		 l_passed := :new.product_type in ( 'BOE', 'CD', 'KLE' );
		 if not l_passed
		 then
		 l_error_stack :=
		 l_error_stack ||
		 'Product type ' ||
		 :new.product_type ||
		 ' is onbekend. Toegestane waarden zijn BOE, CD en KLE.';
		 end if;
		 end if;
		 end;*/

		return null;
	}

}
