package Tests;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TestHashMap {

		public static void main(String[] args) throws SQLException{
		
		Map m1 = new HashMap();
		m1.put("map", "HashMap");
		m1.put("schildt", "java2");
		m1.put("mathew", "Hyden");
		m1.put("schildt", "java2s");
		
		Map m2 = new HashMap();
		m2.put("blabla", "HashMap");
		m2.put("blabla2", "java2");
		m2.put("blabla3", "Hyden");
		m2.put("blabla4", "java2s");
		
		System.out.println(m1.keySet()); 
		System.out.println(m1.values() + "\n"); 
		
	/*	
		SortedMap sm = new TreeMap();
		sm.put("map", "TreeMap");
		sm.put("schildt", "java2");
		sm.put("mathew", "Hyden");
		sm.put("schildt", "java2s");
		System.out.println(sm.keySet()); 
		System.out.println(sm.values());*/

		LinkedHashMap lm = new LinkedHashMap(m1);
/*		lm.put("map", "LinkedHashMap");
		lm.put("schildt", "java2");
		lm.put("mathew", "Hyden");
		lm.put("schildt", "java2s");*/
		System.out.println(lm.keySet()); 
		System.out.println(lm.values());
	}
}
