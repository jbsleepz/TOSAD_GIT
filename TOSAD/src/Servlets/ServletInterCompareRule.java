package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletInterCompareRule extends HttpServlet {
	
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String buttonWaarde = req.getParameter("waardeButton");
		if(buttonWaarde.equals("Execute")){
			facadeDAO = new FacadeDAO();
		}
		PrintWriter out = resp.getWriter();
		String ruletype = "Compare";
		String rulename = req.getParameter("RuleName");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String columnwaarde2 = req.getParameter("ColumnWaarde2");
		String tablewaarde1 = req.getParameter("TableWaarde1");
		String tablewaarde2 = req.getParameter("TableWaarde2");
		String operator = req.getParameter("Operator");
		String error = req.getParameter("Error");
		facadeDomain = new FacadeDomain();
		out.print(facadeDomain.maakScriptVoorInterEntityCompare(ruletype, rulename, operator, columnwaarde1, columnwaarde2, tablewaarde1, tablewaarde2, error));
	}

}
