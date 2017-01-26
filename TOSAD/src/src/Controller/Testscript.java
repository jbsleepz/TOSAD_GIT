package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Domain.RangeRule;

public class Testscript extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String attribute = req.getParameter("attribute");
		if(attribute.equals("attribute")){
			int rangemin = Integer.parseInt(req.getParameter("rangemin"));
			int rangemax = Integer.parseInt(req.getParameter("rangemax"));
			
			String triggername = req.getParameter("test");
					RangeRule r = new RangeRule(rangemin, rangemax);
					String testScript = r.CreateRangeRuleScript(attribute, triggername, r.getMinValue(), r.getMaxValue());
					out.print(testScript);
		}else{
			out.print("rule not found");
		}
		
			
	}
}