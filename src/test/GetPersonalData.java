package test;

import java.io.File;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetPersonalData {

	public MyPersonalData getObjectFromJsonFile(ServletContext context , String fileName) {
		//ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/config/"+fileName);
//		ClassLoader classLoader = getClass().getClassLoader();
//		String fileName ="myPersonalData.json";
		File file = new File(fullPath);
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			MyPersonalData myPersonalData = objectMapper.readValue(file, MyPersonalData.class);
			return myPersonalData;
			// E:\CodingHub\java\Eclipse\WorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\FirstServlet\WEB-INF\config\myPersonalData.json
		
		}catch(final Exception e){e.printStackTrace();}
		
		return null;
	}
	
	public String getJsonSringFromFile(ServletContext context , String fileName) {
		String fullPath = context.getRealPath("/WEB-INF/config/"+fileName);
		File file = new File(fullPath);
		try {
			
			ObjectMapper objectMapper = new ObjectMapper();
			MyPersonalData myPersonalData = objectMapper.readValue(file, MyPersonalData.class);
			
			String jsonInString = objectMapper.writeValueAsString(myPersonalData);
			return jsonInString;
			// E:\CodingHub\java\Eclipse\WorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\FirstServlet\WEB-INF\config\myPersonalData.json
		
		}catch(final Exception e){e.printStackTrace();}
		
		return null;
	}
}
