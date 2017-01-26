package Domain;

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
				out.print("yolo is a disease");
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
