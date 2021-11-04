package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/getContactOrNot") //Annotation
public class GetContactOrNOt extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		String fullPath = getServletContext().getRealPath("/WEB-INF/config/"+"porfolioContactMessages.json");
		File file = new File(fullPath);
		try {
	        FileWriter fileWriter = new FileWriter(file, true);
			ObjectMapper objectMapper = new ObjectMapper();
			MessageWrapper messageWrapper = objectMapper.readValue(file, MessageWrapper.class);
			

			String responseString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(messageWrapper.getCan_contact());
			resp.getWriter().print(responseString);
		
		}catch(final Exception e){e.printStackTrace();}
}
}
