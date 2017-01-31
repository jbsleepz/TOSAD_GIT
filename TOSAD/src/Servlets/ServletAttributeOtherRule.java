package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletAttributeOtherRule extends HttpServlet {
	
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String buttonWaarde = req.getParameter("Button");
		if(buttonWaarde.equals("Execute")){
			facadeDAO = new FacadeDAO();
			String script = req.getParameter("Code");
			facadeDAO.DAOAttributeOtherRuleExecuteScript(script);
		}else{
		PrintWriter out = resp.getWriter();
		String ruletype = "Other";
		String rulename = req.getParameter("RuleName");
		String sqlquery = req.getParameter("SqlQuery");
		String operator = req.getParameter("Operator");
		String column = req.getParameter("Column");
		String table = req.getParameter("Table");
		String errormessage = req.getParameter("ErrorMessage");
		facadeDomain = new FacadeDomain();
		out.print(facadeDomain.MaaktScriptVoorAttributeOther(ruletype, rulename, sqlquery, operator, column, table, errormessage));
	}
	}
}
