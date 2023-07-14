package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.github.javafaker.Faker;

public class Core {
	
	static String host;
	static String Authorization;
	static Properties props = new Properties();
	static String path = System.getProperty("user.dir") + "/env.properties";
	static Faker fake = new Faker();

	public static String getHost() {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String host = props.getProperty("HOST");
		return host;
	}
	public static String getName() {
		String Name = fake.name().fullName();
		return Name;

	}

	public static String getEmail() {
		String email = fake.internet().emailAddress();
		return email;
	}


}
