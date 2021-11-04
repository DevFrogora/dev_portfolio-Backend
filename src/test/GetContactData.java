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
@WebServlet("/getContactData") //Annotation
public class GetContactData extends HttpServlet{
	
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
			
			String fileJson = objectMapper.writeValueAsString(messageWrapper);
			System.out.println(fileJson);
//			
			JsonNode jsonNode = objectMapper.readTree(fileJson);
//			
			JsonNode nameNode = jsonNode.get("messages");
			String messagesJson= objectMapper.writeValueAsString(nameNode);
			System.out.println(messagesJson);
//			//JsonNode jsonNode = objectMapper.readTree(json);
//			// pass the jsonNode to objectmapper
			List<Message> messages = objectMapper.readValue(messagesJson, new TypeReference<List<Message>>(){});
			
			int trueCount=0, totalCount=0;
			for (Iterator iterator = messages.iterator(); iterator.hasNext();) {
				Message message = (Message) iterator.next();
				System.out.println(message.isPending());
				totalCount++;
				if(message.isPending()) {
					trueCount++;
				}
			}
			
			ContactPending contactPending = new ContactPending();
			contactPending.setCanContact(messageWrapper.getCan_contact());
			contactPending.setPendingCount(trueCount);
			contactPending.setTotalCount(totalCount);
			
			String responseString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(contactPending);
			resp.getWriter().print(responseString);
		
		}catch(final Exception e){e.printStackTrace();}
	}

	

}
