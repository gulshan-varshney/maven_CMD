package cmd.contactTest;

import org.testng.annotations.Test;

public class ContactTest {

	
	@Test
	public void createContact() {
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		System.out.println("createContact");
	}
	
	@Test
	public void modifyContact() {
		System.out.println("modifyContact");
	}
}
