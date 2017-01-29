package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain_TEST.FacadeDomain;

public class ServletTupleOtherRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Other";
		String rulename = req.getParameter("RuleName");
		String sqlquery = req.getParameter("SqlQuery");
		String operator = req.getParameter("Operator");
		String column1 = req.getParameter("Column1");
		String column2 = req.getParameter("Column2");
		String table = req.getParameter("Table");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.maakScriptTupleOther(ruletype, sqlquery, rulename, operator, column1, column2, table, error));
	}

}
