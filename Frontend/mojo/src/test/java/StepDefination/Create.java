package StepDefination;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import Base.Core;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create extends Core {

	ChromeDriver driver;
	Core core = new Core();
	Properties p;
	String user_name=Core.getName();
	String email_address=Core.getEmail();
	
	


	
	public Create() throws IOException {
	 p= core.propertyReader("xpath.properties");
	}

	
	@Given("user is on application url")
	public void user_is_on_application_url() throws IOException {

		 driver=Core.setUp();
	}

	@And("user click on Login and lands on login screen")
	public void user_click_on_login() throws IOException {
		String login = p.getProperty("login");

		driver.findElement(By.xpath(login)).click();
	}

	@And("user clicks on Create Account tab")
	public void user_clicks_on_create_account_tab() {
		
		String create_account_tab = p.getProperty("create_account_tab");
		driver.findElement(By.xpath(create_account_tab)).click();

	}

	@When("user enters name, email address and password")
	public void user_enters_name_email_address_and_password() throws InterruptedException {

		String name = p.getProperty("name");
		String password = p.getProperty("password");
		String email = p.getProperty("email");
		String phone=p.getProperty("phone");
		String pass_val = p.getProperty("password_val");

		driver.findElement(By.xpath(name)).sendKeys(user_name);
		driver.findElement(By.xpath(email)).sendKeys(email_address);
		System.out.println(email_address);

		driver.findElement(By.xpath(password)).sendKeys(pass_val);
		
		
	}

	@And("clicks on create account button")
	public void clicks_on_create_account_button() {
		String create_account_button=p.getProperty("create_account_button");
		driver.findElement(By.xpath(create_account_button)).click();

	}
	
	@Given("user click on profile icon and navigate to profile page")
	public void user_click_on_profile_icon_and_navigate_to_profile_page() {
		String login_user=p.getProperty("login_user_name");
		core.driver.findElement(By.xpath(login_user)).click();;

	}

	@And("user clicks on signout")
	public void user_clicks_on_signout() {
	    String signOut=p.getProperty("sign_out");
	    core.driver.findElement(By.xpath(signOut)).click();
	}
	@When("user click on Login")
	public void user_click_on_Login_and_lands_on_login_screen() {
		String login = p.getProperty("login");

		core.driver.findElement(By.xpath(login)).click(); 
	}

	@And("user enters email address and password")
	public void user_enters_email_address_and_password() throws IOException {
		String email=p.getProperty("email");
		String pass_val = p.getProperty("password_val");
		String password = p.getProperty("password");
		String email_address= core.getData();
		
		core.driver.findElement(By.xpath(email)).sendKeys(email_address);
		core.driver.findElement(By.xpath(password)).sendKeys(pass_val);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		String login_button=p.getProperty("login_button");
		core.driver.findElement(By.xpath(login_button)).click();
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page_and_account_is_created() {
		String login_user=p.getProperty("login_user_name");
		String order_detail=p.getProperty("orders");
		core.driver.findElement(By.xpath(login_user)).click();

		String order_text=core.driver.findElement(By.xpath(order_detail)).getText();

		Assert.assertEquals(order_text,"No orders to display");
		
	}
	
}
