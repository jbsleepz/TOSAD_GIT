package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletTupleCompareRule extends HttpServlet {
	
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String buttonWaarde = req.getParameter("Button");
		if(buttonWaarde.equals("Execute")){
			facadeDAO = new FacadeDAO();
			String script = req.getParameter("Code");
			facadeDAO.DAOTupleCompareRuleExecuteScript(script);
		}else{
		PrintWriter out = resp.getWriter();
		String ruletype = "Compare";
		String rulename = req.getParameter("RuleName");
		String operator = req.getParameter("Operator");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String columnwaarde2 = req.getParameter("ColumnWaarde2");
		String tabelwaarde = req.getParameter("TabelWaarde");
		String error = req.getParameter("Error");
		facadeDomain = new FacadeDomain();
		out.print(facadeDomain.maakScriptVoorTupleCompare(ruletype, rulename, operator, columnwaarde1, columnwaarde2, tabelwaarde, error));
	}
	}
}
