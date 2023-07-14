package payload;

import Base.Core;

public class CreateUserPayload {
	
	public static String createUser() {
		String f_name= Core.getName();
		String email=Core.getEmail();
		
		String user="{\n"
				+ "    \"profile\": {\n"
				+ "        \"firstName\": \""+f_name+"\"\n"
				+ "    },\n"
				+ "    \"email\": \""+email+"\",\n"
				+ "    \"password\": \"Test@123\",\n"
				+ "    \"storeUUID\": \"\",\n"
				+ "    \"locale\": \"en-GB\"\n"
				+ "}";
		return user;
		
	}
	

}
