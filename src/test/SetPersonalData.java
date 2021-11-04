package test;

import java.io.File;

import javax.servlet.ServletContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SetPersonalData {

	public void writeIntoJson(ServletContext context , String fileName,MyPersonalData myPersonalData) {
		//ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/WEB-INF/config/"+fileName);
//		ClassLoader classLoader = getClass().getClassLoader();
//		String fileName ="myPersonalData.json";
		File file = new File(fullPath);
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			
//			MyPersonalData myPersonalData = new MyPersonalData(
//					"Froggora",
//					"frogoraSuppor@gmail.com",
//					"nothing"
//					);
			
			objectMapper.writeValue(file, myPersonalData);
			System.out.println("\n\n\n ----------XXX--"+file.getAbsolutePath());
		
			// E:\CodingHub\java\Eclipse\WorkSpace\.metadata\.plugins\org.eclipse.wst.server.core\tmp2\wtpwebapps\FirstServlet\WEB-INF\config\myPersonalData.json
		
		}catch(final Exception e){e.printStackTrace();}
	}
	
	
}
