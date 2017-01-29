package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain_TEST.FacadeDomain;

public class ServletAttributeCompareRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Compare";
		String rulename = req.getParameter("RuleName");
		String vergelijkingswaarde = req.getParameter("Vergelijkingswaarde");
		String operator = req.getParameter("Operator");
		String column = req.getParameter("Column");
		String table = req.getParameter("Table");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.MaaktScriptVoorAttributeCompare(ruletype, rulename, vergelijkingswaarde, operator, column, table, error));
		
	}

}
