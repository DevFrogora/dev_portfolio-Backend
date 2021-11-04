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

@WebServlet("/SetContactDone") // Annotation
public class SetContactDone extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		ContactDone contactDone = objectMapper.readValue(req.getInputStream(), ContactDone.class);
		Date date = new Date();

		String fullPath = getServletContext().getRealPath("/WEB-INF/config/" + "porfolioContactMessages.json");
		File file = new File(fullPath);
		try {
			FileWriter fileWriter = new FileWriter(file, true);
			MessageWrapper messageWrapper = objectMapper.readValue(file, MessageWrapper.class);

			String fileJson = objectMapper.writeValueAsString(messageWrapper);
			System.out.println(fileJson);
//			
			JsonNode jsonNode = objectMapper.readTree(fileJson);
//			
			JsonNode nameNode = jsonNode.get("messages");
			String messagesJson = objectMapper.writeValueAsString(nameNode);
			System.out.println(messagesJson);

			List<Message> messages = objectMapper.readValue(messagesJson, new TypeReference<List<Message>>() {
			});

			for (Iterator iterator = messages.iterator(); iterator.hasNext();) {
				Message message = (Message) iterator.next();
				if (message.getDate().equals(contactDone.getDate())) {
//					messages.remove(message);
					message.setPending(false);
				}

			}

			messageWrapper.setMessages(messages);
			messages.forEach(System.out::println);
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, messageWrapper);

		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
