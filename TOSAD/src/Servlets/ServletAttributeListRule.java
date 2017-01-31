package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FacadeDAO;
import Domain.FacadeDomain;

public class ServletAttributeListRule extends HttpServlet {
	FacadeDomain facadeDomain = null;
	FacadeDAO facadeDAO = null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		String buttonWaarde = req.getParameter("Button");
		if(buttonWaarde.equals("Execute")){
			facadeDAO = new FacadeDAO();
			String script = req.getParameter("Code");
			facadeDAO.DAOAttributeListRuleExecuteScript(script);
		}else{
		PrintWriter out = resp.getWriter();
		String ruletype = "List";
		String rulename = req.getParameter("RuleName");
		String ColumnWaarde = req.getParameter("ColumnWaarde");
		String tablewaarde = req.getParameter("TableWaarde");
		String listvalues = req.getParameter("ListValues");
		ArrayList<String> list = new ArrayList<String>();
		list.add(listvalues);
		String errormessage = req.getParameter("ErrorMessage");
		facadeDomain = new FacadeDomain();
		out.print(facadeDomain.MaaktScriptVoorAttributeList(ruletype, rulename, ColumnWaarde, tablewaarde, list, errormessage));
	}
	}
}
