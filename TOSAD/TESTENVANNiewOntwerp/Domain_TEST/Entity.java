package Domain_TEST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Entity {

	protected String script = "";
	protected ArrayList<String> columns = new ArrayList<String>();
	protected ArrayList<String> tables = new ArrayList<String>();
	protected HashMap<String, String> columnCheckwaarde = new HashMap<String, String>();

	public abstract String generateScript(String triggerName, String operator, String errormessage);

	public void addListTables(String waarde) {
		tables.add(waarde);
	}

	public void addColumns(String waarde) {
		columns.add(waarde);
	}

	public void setColumnCheckWaarde(String column, String checkWaarde) {
		columnCheckwaarde.put(column, checkWaarde);
	}

	public String columnCheckwaarde(String key) {
		return columnCheckwaarde.get(key);
	}

	public List<String> getTables() {
		return tables;
	}

	public List<String> getColumns() {
		return columns;
	}
}
