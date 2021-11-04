package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
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

@WebServlet("/SetContactOrNot") // Annotation
public class SetContactOrNot extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		ContactOrNot contactOrNot = objectMapper.readValue(req.getInputStream(), ContactOrNot.class);
		//System.out.println(req.getInputStream());
		Date date = new Date();

		String fullPath = getServletContext().getRealPath("/WEB-INF/config/" + "porfolioContactMessages.json");
		File file = new File(fullPath);
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			MessageWrapper messageWrapper = objectMapper.readValue(file, MessageWrapper.class);

			messageWrapper.setCan_contact(contactOrNot.getContact());
			//System.out.println(contactOrNot.getContact());
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, messageWrapper);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
