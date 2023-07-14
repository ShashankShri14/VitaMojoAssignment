/*
Author: Shashank Shrivastava
Date: 14. Jul. 2023
*/
package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.google.common.io.Files;

public class Core {

	static Faker fake = new Faker();
	static String path = System.getProperty("user.dir");
	static Properties prop;
	protected static ChromeDriver driver = null;

	static String pathofFile = path + "/src/test/resources/testData/email.txt";
// Method to read the fileData
	public static Properties propertyReader(String fileName) throws FileNotFoundException, IOException {

		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String xpathConfig = path + "/" + fileName;

		Properties xpathProps = new Properties();
		xpathProps.load(new FileInputStream(xpathConfig));

		return xpathProps;

	}

	public static String getURL() {

		String url = "https://fego.vmos-demo.com";
		return url;
	}

	@SuppressWarnings("deprecation")
	public static ChromeDriver setUp() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(getURL());
		return driver;
	}

	public static String getName() {
		String Name = fake.name().fullName();
		return Name;

	}

	public static String getEmail() {
		String email = fake.internet().emailAddress();
		return email;
	}

	public static String getPhone() {
		String email = fake.phoneNumber().subscriberNumber(10);
		return email;
	}

// Method to get data from file
	public static String getData() throws IOException {
		Path path = Paths.get(pathofFile);
		Scanner scanner = new Scanner(path);
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
		}
		{
			scanner.close();
		}
		return line;
	}
	
}