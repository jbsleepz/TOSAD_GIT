package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Domain.FacadeDomain;

public class ServletAttributeRangeRule extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String ruletype = "Range";
		int minvalue = Integer.parseInt(req.getParameter("MinValue"));
		int maxvalue = Integer.parseInt(req.getParameter("MaxValue"));
		String rulename = req.getParameter("RuleName");
		String tablename = req.getParameter("TableName");
		String columnname = req.getParameter("ColumnName");
		String error = req.getParameter("Error");
		FacadeDomain facade = new FacadeDomain();
		String yay = facade.MaakScriptVoorAttributeRange(ruletype, rulename, columnname, tablename, minvalue, maxvalue, error);
		out.print(yay);
		
	}

}
