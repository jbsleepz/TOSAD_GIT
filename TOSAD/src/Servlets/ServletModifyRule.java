package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FacadeDomain;

public class ServletModifyRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Modify";
		String rulename = req.getParameter("BusinessruleName");
		String errormessage = req.getParameter("ErrorMessage");
		String tablename1 = req.getParameter("TargetTableName_1");
		String tablename2 = req.getParameter("TargetTableName_2");
		String targetcolumn_1 = req.getParameter("TargetColumn_1");
		String targetcolumn_2 = req.getParameter("TargetColumn_2");
		String operator = req.getParameter("Operator");
		String checkwaarde = req.getParameter("CheckWaarde");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.maakScriptVoorModifyRule(ruletype, operator, rulename, tablename1, tablename2, targetcolumn_1, targetcolumn_2, checkwaarde, errormessage));
	}

}