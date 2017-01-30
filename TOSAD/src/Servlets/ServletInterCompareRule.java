package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FacadeDomain;

public class ServletInterCompareRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Compare";
		String rulename = req.getParameter("RuleName");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String columnwaarde2 = req.getParameter("ColumnWaarde2");
		String tablewaarde1 = req.getParameter("TableWaarde1");
		String tablewaarde2 = req.getParameter("TableWaarde2");
		String operator = req.getParameter("Operator");
		String vergelijkingswaarde1 = req.getParameter("Vergelijkingswaarde1");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.maakScriptVoorInterEntityCompare(ruletype, rulename, vergelijkingswaarde1, operator, columnwaarde1, columnwaarde2, tablewaarde1, tablewaarde2, error));
	}

}
