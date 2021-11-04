package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/setPersonalData") //Annotation
public class RecievedPersonalData extends HttpServlet{
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		MyPersonalData myPersonalData = objectMapper.readValue(req.getInputStream(), MyPersonalData.class);
		
		SetPersonalData setPersonalData= new SetPersonalData();
		setPersonalData.writeIntoJson(getServletContext(), "myPersonalData.json", myPersonalData);
	}

}
