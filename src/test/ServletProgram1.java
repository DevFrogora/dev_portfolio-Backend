package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;



import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/pqr") //Annotation
public class ServletProgram1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		
//		GetPersonalData getPersonalData = new GetPersonalData();
//		MyPersonalData	myPersonalData = getPersonalData.getObjectFromJsonFile(getServletContext(),
//				"myPersonalData.json");
		
//		resp.addHeader("Access-Control-Allow-Origin","http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Origin","*");
//		resp.getWriter().print(getPersonalData.getJsonSringFromFile(getServletContext(), 
//				"myPersonalData.json"));
		resp.getWriter().print("hi");
		
		
	}
}
      