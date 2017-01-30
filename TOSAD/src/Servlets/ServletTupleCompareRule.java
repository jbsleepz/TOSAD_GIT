package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FacadeDomain;

public class ServletTupleCompareRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Compare";
		String rulename = req.getParameter("RuleName");
		String operator = req.getParameter("Operator");
		String columnwaarde1 = req.getParameter("ColumnWaarde1");
		String columnwaarde2 = req.getParameter("ColumnWaarde2");
		String tabelwaarde = req.getParameter("TabelWaarde");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.maakScriptVoorTupleCompare(ruletype, rulename, operator, columnwaarde1, columnwaarde2, tabelwaarde, error));
	}

}
