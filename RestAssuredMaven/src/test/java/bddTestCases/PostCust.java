package bddTestCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utilities.PostRandomData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostCust {
	public static HashMap map = new HashMap();
	@BeforeClass
	void postData()
	{
		map.put("FirstName",PostRandomData.getFirstName());
		map.put("LastName",PostRandomData.getLastName());
		map.put("UserName",PostRandomData.getUserName());
		map.put("Password",PostRandomData.getPassword());
		map.put("Email",PostRandomData.getEmail());
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
		
	}

	@Test
	void registerCustomer()
	{
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201)
		.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
		.header("Content-Type", equalTo("application/json"))
		.log().body();
	

}
}
