package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.CompareRule;
import Domain.Domain_Facade_Interface_Impl;
import Domain.ListRule;
import Domain.RangeRule;



public class Main extends HttpServlet {
	public String output;
	
	public String Ruletype;
	
	public String RuleName;
	public String Value;
	public String operator;
	public int rangeMin;
	public int rangeMax;
	public String tableName;
	public String columnName;
	Domain_Facade_Interface_Impl facade = new Domain_Facade_Interface_Impl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Ruletype = req.getParameter("RuleType");
		
		
		
		if(Ruletype.equals("AttributeRangeRule")){
			//obtain all atttributes from request
			rangeMin = Integer.parseInt(req.getParameter("MinValue"));
			rangeMax = Integer.parseInt(req.getParameter("MaxValue"));
			tableName = req.getParameter("TableName");
			columnName =  req.getParameter("ColumnName");			
			RuleName = req.getParameter("RuleName"); //trigger name
			operator = req.getParameter("Operator");
			
			
			//create object and script
			facade.setRuleToBusinessRuleType("Attribute"); //set the businessrule to Attribute
			facade.setTypeToRuleType("RangeRule"); // set type of rule to RangeRule
			facade.setAttributesOfAttribute(tableName, columnName, rangeMin, rangeMax, operator); // fill the businessrule with attributes
			
			
					
					
		}
		if(Ruletype.equals("AttributeOtherRule")){
			output = "no script avaible";
		}
		
	/*	if(Ruletype.equals("AttributeCompareRule")){
			RuleName = req.getParameter("RuleName");
			Value = req.getParameter("CheckValue");
			Operator = req.getParameter("Operator");
			
			CompareRule c = new CompareRule();
			output = c.createAttributeCompareScript(RuleName, "test_table", Value, Operator);		
		}*/
		
		if(Ruletype.equals("AttributeListRule")){
			String test  = "bla asd nogeen string";
			String ruleName = req.getParameter("RuleName");
			ListRule l = new ListRule(test);
			ArrayList<String> listValues = l.stringToListParser(test);	
			output = l.createAttributeListRuleScript(ruleName, "Some_table", "Some_Column", listValues);
		}
		
		if(Ruletype.equals("TupleOtherRule")){
			output = "no script avaible";
		}
		
		if(Ruletype.equals("TupleCompareRule")){
			
			output = "no script avaible";
		}
		
		if(Ruletype.equals("interCompareRule")){
			output = "no script avaible";
		}
		
		if(Ruletype.equals("entityOtherRule")){
			output = "no script avaible";
		}
		
		if(Ruletype.equals("ModifyRule")){
			output = "no script avaible";
		}
		out.print(output);
			
	}
}
