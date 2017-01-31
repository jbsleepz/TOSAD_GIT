package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletEntityOtherRule extends HttpServlet {
	
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String buttonWaarde = req.getParameter("Button");
		if(buttonWaarde.equals("Execute")){
			facadeDAO = new FacadeDAO();
			String script = req.getParameter("Code");
			facadeDAO.DAOEntityOtherRuleExecuteScript(script);
		}else{
		PrintWriter out = resp.getWriter();
		String ruletype = "Other";
		String rulename = req.getParameter("RuleName");
		String sqlquery = req.getParameter("SqlQuery");
		String operator = req.getParameter("Operator");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String tablewaarde1 = req.getParameter("TableWaarde1");
		String error = req.getParameter("Error");
		facadeDomain = new FacadeDomain();
		out.print(facadeDomain.maakScriptVoorEntityOther(ruletype, sqlquery, rulename, operator, columnwaarde1, tablewaarde1, error));
	}
	}
}
