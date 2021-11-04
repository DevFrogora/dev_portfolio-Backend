package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/verifypassword") //Annotation
public class VerifyPassword extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.addHeader("Access-Control-Allow-Origin", "*");
		ObjectMapper objectMapper = new ObjectMapper();
		Admin admin = objectMapper.readValue(req.getInputStream(), Admin.class);
		
				String usernameString = admin.getUsername();
				String passwordString = admin.getPassword();
				
		if(usernameString != null
				&& passwordString != null) {
			
			if(usernameString.equals("ram") 
					&& passwordString.equals("sita")) {
				resp.getWriter().print("true");
			}else {
				resp.getWriter().print("false");
			}
		}else {
			resp.getWriter().print("getting input null username: "+usernameString+" password :  "+passwordString);
		}
	}

}
