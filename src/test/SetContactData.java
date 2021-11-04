package test;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SequenceWriter;


public class SetContactData {

	
	public void writeIntoJson(ServletContext context , String fileName,Message message) {
		//ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/config/"+fileName);
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
			messages.add(message);
			messageWrapper.setMessages(messages);
			messages.forEach(System.out::println);
			objectMapper.writerWithDefaultPrettyPrinter().writeValue(
				    file, messageWrapper);

		
		}catch(final Exception e){e.printStackTrace();}
	}
	
}
