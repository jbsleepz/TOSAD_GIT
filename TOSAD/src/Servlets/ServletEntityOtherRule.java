package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Domain.FacadeDomain;

public class ServletEntityOtherRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Other";
		String rulename = req.getParameter("RuleName");
		String sqlquery = req.getParameter("SqlQuery");
		String vergelijkingswaarde1 = req.getParameter("Vergelijkingswaarde1");
		String vergelijkingswaarde2 = req.getParameter("Vergelijkingswaarde2");
		String operator = req.getParameter("Operator");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String tablewaarde1 = req.getParameter("TableWaarde1");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.maakScriptVoorEntityOther(ruletype, sqlquery, rulename, operator, columnwaarde1, tablewaarde1, error));
	}

}
