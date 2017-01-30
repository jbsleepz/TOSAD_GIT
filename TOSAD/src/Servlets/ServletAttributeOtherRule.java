package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FacadeDomain;

public class ServletAttributeOtherRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Other";
		String rulename = req.getParameter("RuleName");
		String sqlquery = req.getParameter("SqlQuery");
		String operator = req.getParameter("Operator");
		String column = req.getParameter("Column");
		String table = req.getParameter("Table");
		String errormessage = req.getParameter("ErrorMessage");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.MaaktScriptVoorAttributeOther(ruletype, rulename, sqlquery, operator, column, table, errormessage));
	}

}
