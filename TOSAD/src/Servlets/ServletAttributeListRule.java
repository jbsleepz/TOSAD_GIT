package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.FacadeDomain;

public class ServletAttributeListRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "List";
		String rulename = req.getParameter("RuleName");
		String ColumnWaarde = req.getParameter("ColumnWaarde");
		String tablewaarde = req.getParameter("TableWaarde");
		String listvalues = req.getParameter("ListValues");
		ArrayList<String> list = new ArrayList<String>();
		list.add(listvalues);
		String errormessage = req.getParameter("ErrorMessage");
		FacadeDomain facade = new FacadeDomain();
		out.print(facade.MaaktScriptVoorAttributeList(ruletype, rulename, ColumnWaarde, tablewaarde, list, errormessage));
	}

}
