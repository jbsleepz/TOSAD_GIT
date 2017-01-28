package Domain;

import java.util.ArrayList;

public class ListRule extends Businessrule {

	private String stringValues;
	private ArrayList<String> listValues = new ArrayList<String>();

	public ListRule(String stringValues, String businessRuleName) {
		super(businessRuleName);
		this.stringValues = stringValues;
	}

	public ArrayList<String> stringToListParser(String stringValues) {
		String delimmiter = "[ ]+";
		String[] tokens = stringValues.split(delimmiter);

		for (String s : tokens) {
			listValues.add(s); // place string items as separate value in a list
		}
		return listValues;
	}

	// nodig:
	// lijst met values (string)
	// tabelnaam
	// kolomnaam

	public String createAttributeListRuleScript(String triggerName, String tableName, String columnName,
			ArrayList<String> listValues) {
		String list = "";
		int length = listValues.size();
		int counter = 1;
		for (String s : listValues) {
			if (counter == length) {
				list += "'" + s + "'"; // there is not an extra "," needed if it
										// is the last item from the list
				break;
			} else {
				list += "'" + s + "', ";
				counter += 1;
			}

		}

		String script = "CREATE OR REPLACE TRIGGER trigger_" + triggerName + "\nBEFORE INSERT OR UPDATE ON " + tableName
				+ "\nFOR EACH ROW" + "\nDECLARE" + "\nCOLUMNVALUE VARCHAR2" + "\nBEGIN" + "\nCOLUMNVALUE := NEW."
				+ columnName + // the new value will be stored in here
				"\nIF INSTR(" + list + ", COLUMNVALUE) < 1" + // if given value
																// IS NOT part
																// of the list
				"\nTHEN" + "\nRAISE_APPLICATION_ERROR(20003,'the given value must be one of the following: " + list
				+ "  )" + "\nEND IF" + "\nEND";

		// waarde van de kolom moet gelijk zijn aan 1 van die van de lijst

		return script;
	}
}
