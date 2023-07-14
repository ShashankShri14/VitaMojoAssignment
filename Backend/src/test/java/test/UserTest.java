package test;



import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Core;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payload.CreateUserPayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.*;
import  static io.restassured.RestAssured.*;


public class UserTest {
//Getting endpoints from properties files
	String endpoint=Core.getHost()+"user/v1/user";
	String login_endpoint=Core.getHost()+"user/v1/auth";
	String tenant="695a1486-80e7-4ee6-bc55-f4911944ef2a";
	
	@Test()
	public void userFlow() {
		
		RestAssured.baseURI=Core.getHost();
// getting response of create user API		
		String response= given().log().all().header("Content-Type","application/json").header("Tenant",tenant)
		.body(CreateUserPayload.createUser()).when()
		.post(endpoint).then().assertThat().statusCode(201).extract().response().asString();
		
		JsonPath js= new JsonPath(response);
		String tenantUUID= js.getString("payload.user.tenantUUID");
		boolean is_active=js.getBoolean("payload.user.active");
		String locale=js.getString("payload.user.locale");
		String email=js.getString("payload.user.email");
	// Asserting create User API response	
		Assert.assertEquals(tenantUUID, tenant);
		Assert.assertEquals(is_active, true);
		Assert.assertEquals(locale, "en-GB");
// getting response of login API by using same email by which user createde		
		String login_response=given().log().all().header("Content-Type","application/json").body("{\n"
				+ "  \"email\": \""+email+"\",\n"
				+ "  \"password\": \"Test@123\"\n"
				+ "}").when().post(login_endpoint).then().assertThat().statusCode(201).extract().response().asString();		
		
		JsonPath js_login=new JsonPath(login_response);
		
		boolean login_is_active=js_login.getBoolean("payload.user.active");
		String login_email=js_login.getString("payload.user.email");
		String login_locale=js_login.getString("payload.user.locale");
	// Asserting login API response	
		Assert.assertEquals(is_active, true);
		Assert.assertEquals(locale, "en-GB");
		Assert.assertEquals(login_email,email);
	
	}
	

}
