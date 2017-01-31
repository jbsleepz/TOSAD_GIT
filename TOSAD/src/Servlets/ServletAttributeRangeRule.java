package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletAttributeRangeRule extends HttpServlet {
	
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	String response;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String buttonWaarde = req.getParameter("Button");
		System.out.println(buttonWaarde);
		if(buttonWaarde == null){
			System.out.println(2);
			facadeDAO = new FacadeDAO();
			String script = req.getParameter("Code");
			facadeDAO.DAOAttributeRangeRuleExecuteScript(script);
			response = "yay";
		}else{
		String ruletype = "Range";
		System.out.println(3);
		int minvalue = Integer.parseInt(req.getParameter("MinValue"));
		int maxvalue = Integer.parseInt(req.getParameter("MaxValue"));
		String rulename = req.getParameter("RuleName");
		String tablename = req.getParameter("TableName");
		String columnname = req.getParameter("ColumnName");
		String error = req.getParameter("Error");
		facadeDomain = new FacadeDomain();
		response = facadeDomain.MaakScriptVoorAttributeRange(ruletype, rulename, columnname, tablename, minvalue, maxvalue, error);
		
	}
		System.out.println(4);
		out.print(response);
	}
}
