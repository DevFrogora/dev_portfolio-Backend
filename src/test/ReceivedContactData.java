package test;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/setContactData") //Annotation
public class ReceivedContactData extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		Message message = objectMapper.readValue(req.getInputStream(), Message.class);
		Date date = new Date();
		message.setDate(date);
		message.setPending(true);
		System.out.print(objectMapper.writeValueAsString(message));
		SetContactData setContactData= new SetContactData();
		
		setContactData.writeIntoJson(getServletContext(), "porfolioContactMessages.json", message);
	}

}
