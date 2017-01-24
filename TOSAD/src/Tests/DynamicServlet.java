package Tests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("input");
			if(name.equals("yolo")){
				out.print("CREATE OR REPLACE TRIGGER " +"TRIGGER_" + 
						" \nBEFORE INSERT OR UPDATE ON " + "tableName " +
						" \nMINVALUE NUMBER :=  "+
						" \nMAXVALUE NUMBER := "+
						" \nMINIMUMVALUE NUMBER;" +
						" \nMAXIMUMVALUE NUMBER;" +
						" \nBEGIN"+ 
						" \nMINIMUMVALUE := :NEW.MINIMUMVALUE;" +
						" \nMAXIMUMVALUE := :NEW.MAXIMUMVALUE;" +
						" \nIF (MINIMUMVALUE < MINVALUE OR MINIMUMVALUE > MAXVALUE)" + 
						" \nTHEN " + 
						" \nRaise_Application_Error(-20000, 'minimum value is not a valid number');" + //exceptionmessage
						" \nELSIF (MAXIMUMVALUE < MINVALUE OR MAXIMUMVALUE > MAXVALUE)" +
						" \nTHEN " + 
						" \nRaise_Application_Error(-20000, 'maximum value is not a valid number');" + //exceptionmessage
						" \nEND IF;" +
						" \nEND;");
			}else{
			if(name.startsWith("calculate")){
				int first = name.length();
				String text = name.substring(10, first);
				if(name.contains("+")){
					String[] data = text.split("\\+");
					double aa = Double.parseDouble(data[0]);
					double ba = Double.parseDouble(data[1]);
					double ca = aa+ba;
					out.println(ca);
				}
				if(name.contains("-")){
					String[] data = text.split("\\-");
					double aa = Double.parseDouble(data[0]);
					double ba = Double.parseDouble(data[1]);
					double ca = aa-ba;
					out.println(ca);
				}
				if(name.contains("*")){
					String[] data = text.split("\\*");
					double aa = Double.parseDouble(data[0]);
					double ba = Double.parseDouble(data[1]);
					double ca = aa*ba;
					out.println(ca);
				}
				if(name.contains("/")){
					String[] data = text.split("\\/");
					double aa = Double.parseDouble(data[0]);
					double ba = Double.parseDouble(data[1]);
					double ca = aa/ba;
					out.println(ca);
				}
			}else{
				out.print(name);
			}
			
			
			}
	

			}
}
