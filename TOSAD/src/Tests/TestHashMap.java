package Tests;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

		public static void main(String[] args) throws SQLException{
		
		Map m1 = new HashMap();
		m1.put("map", "HashMap");
		m1.put("schildt", "java2");
		m1.put("mathew", "Hyden");
		m1.put("schildt", "java2s");
		
		System.out.println(m1.keySet()); 
		System.out.println(m1.values()); 
	}
}
